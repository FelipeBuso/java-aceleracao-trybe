package com.betrybe.healthprovider.dto;

import com.betrybe.healthprovider.entity.Medic;

public record MedicCreateDto(String name, String specialty, String cpf) {

  public  Medic toEntity() {
    return new Medic(null, name, specialty, cpf );
  }
}
