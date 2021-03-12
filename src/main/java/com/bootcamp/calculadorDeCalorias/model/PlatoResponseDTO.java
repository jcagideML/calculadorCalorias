package com.bootcamp.calculadorDeCalorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class PlatoResponseDTO {
    private Double caloriasTotales;
    private Map<String, Double> caloriasXIngrediente;
    private IngredienteDTO masCalorias;
}
