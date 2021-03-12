package com.bootcamp.calculadorDeCalorias.services;

import com.bootcamp.calculadorDeCalorias.model.IngredienteDTO;
import com.bootcamp.calculadorDeCalorias.model.PlatoDTO;
import com.bootcamp.calculadorDeCalorias.model.PlatoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.calculadorDeCalorias.repositories.CaloriaPorIngredienteDTO;
import com.bootcamp.calculadorDeCalorias.repositories.CaloriasRepositorio;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculateCaloriasServiceImpl implements CalculateService {

    @Autowired
    private final CaloriasRepositorio caloriaRepositorio;


    public CalculateCaloriasServiceImpl(CaloriasRepositorio caloriasRepositorio) {
        this.caloriaRepositorio = caloriasRepositorio;
    }

    private Double calcularCaloria(Double peso, String nombre) {
        CaloriaPorIngredienteDTO caloriasPorIngrediente = caloriaRepositorio.encontraCaloriaPorIngrediente(nombre);
        return (peso * caloriasPorIngrediente.getCalories()) / 100;
    }

    @Override
    public PlatoResponseDTO calculate(PlatoDTO plato) {
        PlatoResponseDTO response = new PlatoResponseDTO();

        Map<String, Double> caloriasPorIngrediente = new HashMap<>();
        double caloriasTotales = 0.0;
        double max = 0.0;
        IngredienteDTO ingreMasCalorias = null;


        for (IngredienteDTO i : plato.getIngredientes()) {
            Double aux = calcularCaloria(i.getPeso(), i.getNombre());
            caloriasTotales += aux;
            caloriasPorIngrediente.put(i.getNombre(), aux);
            if (aux > max) {
                max = aux;
                ingreMasCalorias = i;
            }

        }

        response.setCaloriasTotales(caloriasTotales);
        response.setCaloriasXIngrediente(caloriasPorIngrediente);
        response.setMasCalorias(ingreMasCalorias);

        return response;
    }
}
