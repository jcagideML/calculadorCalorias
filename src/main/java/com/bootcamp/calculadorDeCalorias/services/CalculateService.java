package com.bootcamp.calculadorDeCalorias.services;

import com.bootcamp.calculadorDeCalorias.model.PlatoDTO;
import com.bootcamp.calculadorDeCalorias.model.PlatoResponseDTO;

public interface CalculateService {

    PlatoResponseDTO calculate(PlatoDTO plato);
}
