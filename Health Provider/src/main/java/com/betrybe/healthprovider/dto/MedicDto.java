package com.betrybe.healthprovider.dto;

import com.betrybe.healthprovider.entity.Medic;

public record MedicDto(Long id, String name, String specialty) {

  public static MedicDto fromEntity(Medic medic) {
    return new MedicDto(medic.getId(), medic.getName(), medic.getSpecialty());
  }
}
