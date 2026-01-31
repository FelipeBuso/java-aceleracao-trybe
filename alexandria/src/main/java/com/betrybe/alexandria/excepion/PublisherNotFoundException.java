package com.betrybe.alexandria.excepion;

public class PublisherNotFoundException extends NotFoundException {

  public PublisherNotFoundException() {
    super("Editora não encontrada!");
  }
}
