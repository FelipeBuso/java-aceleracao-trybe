package com.betrybe.healthprovider;

public class Exemplo {

  public static void main(String[] args) throws Exception {
    //    metodoQueGeraExcecao();
    outroMetodoQueGeraExcecao();
  }

  public static void metodoQueGeraExcecao() {
    System.out.println("Executando método...");

    // unchcked
    throw new RuntimeException();
  }

  public static void outroMetodoQueGeraExcecao() throws Exception {
    System.out.println("Executando outro método...");

    // checked
    throw new Exception();
  }
}
