package com.betrybe.healthprovider.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Medic {
  private Long id;
  private String name;
  private String specialty;
  private String cpf;

  public Medic(Long id, String name, String specialty, String cpf) {
    this.id = id;
    this.name = name;
    this.specialty = specialty;
    this.cpf = cpf;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }
}
