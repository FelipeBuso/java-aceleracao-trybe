package com.betrybe.alexandria.excepion;

public class BookDetailNotFoundException extends NotFoundException {

  public BookDetailNotFoundException() {
    super("Detalhes de livro não encontrados!");
  }
}
