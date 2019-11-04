package chapter1.passingcode.example;

// An interface for the Apple's predicate functions

@FunctionalInterface
public interface AppleFilter {
  
  public boolean test(Apple t);
  
}
