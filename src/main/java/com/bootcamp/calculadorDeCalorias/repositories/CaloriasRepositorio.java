package com.bootcamp.calculadorDeCalorias.repositories;

public interface CaloriasRepositorio {

    CaloriaPorIngredienteDTO encontraCaloriaPorIngrediente(String nombre);
}
