/**
 * In this example we use a standard functional interface called predicate interface
 *  @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html">Predicate </a>
 * */


package chapter1.passingcode.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleStandardPredicate extends Apple{
  
  // Notice: standard predicate interface saves us from writing our own 
  //          functional interface.
  public static List<Apple> filterApple(List<Apple> apples, Predicate<Apple> filter) {
    List<Apple> result = new ArrayList<>();
    
    for (Apple apple : apples) {
      if (filter.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }
 
  
//test
 public static void main(String[] args) {
   
   List<Apple> greenApples = filterApples(inventories, Apple::isGreen);
   for (Apple apple : greenApples) {
     System.out.println(apple.getColor());
   }
   
   List<Apple> heavyApples = filterApples(inventories, Apple::isHeavy);
   for (Apple apple : heavyApples) {
     System.out.println(apple.getWeight());
   }
 }

}
