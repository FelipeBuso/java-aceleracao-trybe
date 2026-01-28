package com.betrybe.healthprovider.exception;

public class MedicNotFoundException extends RuntimeException {
  public MedicNotFoundException() {
    super("Pessoa médica não encontrada");
  }
}
