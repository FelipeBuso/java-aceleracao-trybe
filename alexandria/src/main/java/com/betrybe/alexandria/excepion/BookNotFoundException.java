package com.betrybe.alexandria.excepion;

public class BookNotFoundException extends NotFoundException {

  public BookNotFoundException() {
    super("Livro não encontrado!");
  }
}
