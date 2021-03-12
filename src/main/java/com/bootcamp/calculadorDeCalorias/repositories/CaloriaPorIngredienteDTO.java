package com.bootcamp.calculadorDeCalorias.repositories;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaloriaPorIngredienteDTO {
    private String name;
    private Double calories;
}
