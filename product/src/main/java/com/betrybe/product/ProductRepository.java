package com.betrybe.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
  public String getMessage() {
    return "Mensagem: produto retornado!!!!!";
  }
}
