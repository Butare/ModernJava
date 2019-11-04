package chapter2;

public class RequestHandler {
 
  
  public static void main(String... arg) {
    
    /*
     * 1st request from our client:
     *  we need to get all green apples.
     * 2nd:
     *  we need to all red apples
     *  
     *  // ok, then let me allow you to filter by the color of your choice
     */
    for (Apple app : Apple.filterApplesByColor("green")) {
      System.out.println(app);
    }
    
    System.out.println("--- print red apples -----");
    for (Apple app: Apple.filterApple(a -> a.getColor().equalsIgnoreCase("red"))) {
      System.out.println(app);
    }
    
    /*
     * 3rd request:
     *  we need to differentiate heavy (>=150g) and light apples.
     */
    System.out.println("--- print heavy apples ---");
    for (Apple app : Apple.filterAppleByWeight(150.0)) {
      System.out.println(app);
    }
    
    /*
     * let's allow our customer to pass any predicate action he/she would like to perform.
     */
    for (Apple app : Apple.filterApple(a -> a.getWeight() > 150)) {
      System.out.println(app);
    }
    
    
    System.out.println();
    System.out.println(" ----- Pretty string -----");
    // let's print apple
    Apple.prettyPrintApple(a -> a.toString());
    

    
  }
}