package chapter1.passingcode.example;

import java.util.ArrayList;
import java.util.List;

// extends Apple class for simplicity.
public class AppleManualPredicate extends Apple {

  public static List<Apple> filterApples(List<Apple> apples, AppleFilter filter){
    List<Apple> result = new ArrayList<>();
    for (Apple apple : apples) {
      if (filter.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }
  
  // test
  public static void main(String[] args) {
    
    List<Apple> greenApples = filterApples(inventories, 
                                  apple -> apple.getColor().equals(Color.GREEN));
    for (Apple apple : greenApples) {
      System.out.println(apple.getColor());
    }
    
    List<Apple> heavyApples = filterApples(inventories, 
                                  apple -> apple.getWeight() > HEAVY_WEIGHT);
    for (Apple apple : heavyApples) {
      System.out.println(apple.getWeight());
    }
  }
}
