public class Cabin {
   
   private int capacity;
   private int numBooked;
   
   
   public Cabin (int capacity) {
      this.capacity = capacity;
      this.numBooked = 0;
   }
   
   public boolean isBooked(int people) {
      return this.capacity <= people + this.numBooked;
   }
   
   public void book(int people) {
      numBooked += people;
   }
   
   public void print(CabinClass type) {
      System.out.println(type + " booked: " + numBooked + " out of " + capacity);
   }   
   
   
}   