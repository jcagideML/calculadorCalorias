package com.bootcamp.calculadorDeCalorias;


import com.bootcamp.calculadorDeCalorias.model.PlatoDTO;
import com.bootcamp.calculadorDeCalorias.model.PlatoResponseDTO;
import com.bootcamp.calculadorDeCalorias.services.CalculateCaloriasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadorDeCaloriasController {

    @Autowired
    private CalculateCaloriasServiceImpl calculadorService;

    @PostMapping("/calcular")
    public PlatoResponseDTO getInfo(@RequestBody PlatoDTO plato) {

        return calculadorService.calculate(plato);
    }
}
