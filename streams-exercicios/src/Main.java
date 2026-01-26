import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {
    ArrayList<Integer> numeros = new ArrayList<>();
    numeros.add(1);
    numeros.add(2);
    numeros.add(3);
    numeros.add(4);
    numeros.add(5);
    numeros.add(6);
    numeros.add(7);
    numeros.add(8);

    List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).toList();
    System.out.println(pares);

    ArrayList<String> nomes = new ArrayList<>();
    nomes.add("João");
    nomes.add("Maria");
    nomes.add("Carla");
    nomes.add("José");

    List<String> nomesUpper = nomes.stream().map(String::toUpperCase).toList();
    System.out.println(nomesUpper);

    Integer soma = numeros.stream().mapToInt(Integer::intValue).sum();
    System.out.println(soma);

    List<String> nomesGrandes = nomes.stream().filter(n -> n.length() > 4).toList();
    System.out.println(nomesGrandes);
  }
}