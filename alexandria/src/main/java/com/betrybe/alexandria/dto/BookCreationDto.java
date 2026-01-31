package com.betrybe.alexandria.dto;

import com.betrybe.alexandria.entity.Book;

public record BookCreationDto(String title, String genre) {

  public Book toEntity() {
    return new Book(title, genre);
  }

}
