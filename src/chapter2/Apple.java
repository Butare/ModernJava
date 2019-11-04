package chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Apple {
    private String color;
    private double weight;
    
    public String getColor() {
      return this.color;
    }
    
    public double getWeight() {
      return this.weight;
    }
    
    @Override
    public String toString() {
      return String.format("Color: %s , Weight: %.2f", this.color, this.weight);
    }
    
    public static List<Apple> inventory = getDummyApples(); 
    
    public Apple(String color, double weight) {
      this.color = color;
      this.weight = weight;
    }
    
    public static List<Apple> filterApplesByColor(String color) {
      List<Apple> result = new ArrayList<>();
      
      for (Apple app : inventory) {
        if (app.getColor().equalsIgnoreCase(color)) {
          result.add(app);
        }
      }
      return result;
    }
    
    public static List<Apple> filterAppleByWeight(double weight) {
      List<Apple> result = new ArrayList<>();
      for (Apple app : inventory) {
        if (app.getWeight() >= weight) {
          result.add(app);
        }
      }
      return result;
    }
    
    /*
     * This method will accept any behavior that evaluates to a boolean value.
     */
    public static List<Apple> filterApple(AppleFilter filter){
      List<Apple> result = new ArrayList<>();
      for (Apple app : inventory) {
        if (filter.test(app)) {
          result.add(app);
        }
      }
      return result;
    }
    
    @FunctionalInterface
    interface AppleFilter {
      abstract boolean test(Apple apple);
    }
    
    public static void prettyPrintApple(PrintApple pretty) {
      for (Apple app : inventory) {
        String output = pretty.print(app);
        System.out.println(output);
      }
    }
    
    @FunctionalInterface
    interface PrintApple {
      abstract String print(Apple apple);
    }
    
    private static List<Apple> getDummyApples() {
      return Arrays.asList(
          new Apple(Color.RED.toString(), 234.0),
          new Apple(Color.GREEN.toString(), 159.0),
          new Apple(Color.BLUE.toString(), 120.0),
          new Apple(Color.RED.toString(), 110.5),
          new Apple(Color.BLUE.toString(), 200.0)
          );
    }
    
    enum Color {
      BLUE, GREEN, RED
    }
}
