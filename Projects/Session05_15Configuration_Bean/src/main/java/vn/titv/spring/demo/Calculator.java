package vn.titv.spring.demo;

// Consider as a class from a resource that you can change to add @Component
public class Calculator {
   public double sqrt(double value){
       return Math.sqrt(value);
   }

   public double pow2(double value){
       return Math.pow(value, 2);
   }
}
