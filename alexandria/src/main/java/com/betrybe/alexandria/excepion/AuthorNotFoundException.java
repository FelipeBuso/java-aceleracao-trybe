package com.betrybe.alexandria.excepion;

public class AuthorNotFoundException extends NotFoundException {

  public AuthorNotFoundException() {
    super("Pessoa autora não encontrada!");
  }
}
