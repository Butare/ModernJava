package chapter1.passingcode.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apple {

  public static final double HEAVY_WEIGHT = 150.0;
  
  protected static List<Apple> inventories = getAppleList();
  private Color color;
  private double weight;
  
  public Apple(Color color) {
    this.color = color;
  }
  
  public Apple(Color color, double weight) {
    this(color);
    this.weight = weight;
  }
  
  public Apple() {}
  
  public Color getColor() {
    return color;
  }
  
  public double getWeight() {
    return weight;
  }
  
  @Override
  public String toString() {
    return String.format("Color: %s , Weight: %.2f", this.color, this.weight);
  }
  
  
  enum Color {
    GREEN, RED
  }
  
  
  public static List<Apple> getAppleList() {
    return Arrays.asList(
        new Apple(Color.RED, 190.0), 
        new Apple(Color.GREEN, 200.0),
        new Apple(Color.RED, 100.0));
  }
  
  public static List<Apple> filterGreenApple(List<Apple> apples) {
    List<Apple> result = new ArrayList<>();
    
    for (Apple apple : apples) {
      if (apple.getColor().equals(Color.GREEN)) {
        result.add(apple);
      }
    }
    
    return result;
  }
  
  public static List<Apple> filterHeavyGreenApples(List<Apple> apples) {
    // list of heavy apples
    List<Apple> result = new ArrayList<>();
    
    // filter heavy apples (weight > 150 g)
    for (Apple apple : inventories) {
      if (apple.getWeight() > HEAVY_WEIGHT) {
        result.add(apple);
      }
    }
    return result;
  }
  
  public static List<Apple> filterApples(List<Apple> apples, AppleFilter filter){
    List<Apple> result = new ArrayList<>();
    for (Apple apple : apples) {
      if (filter.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }
  
  public boolean isGreen() {
    return this.getColor().equals(Color.GREEN);
  }
  
  public boolean isHeavy() {
    return this.getWeight() > HEAVY_WEIGHT;
  }
  
  
  // test
  public static void main(String[] args) {
    
    List<Apple> greenApples = filterGreenApple(inventories);
    for (Apple apple : greenApples) {
      System.out.println(apple.getColor());
    }
    
    List<Apple> heavyApple = filterHeavyGreenApples(inventories);
    for (Apple apple : heavyApple) {
      System.out.println(apple.getWeight());
    }
  }
}
