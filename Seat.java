public class Seat {
   
   private int row;
   private char col;
   private SeatClass type;
   private boolean booked;
   
   public Seat(int row, char col, SeatClass type) {
      this.row = row;
      this.col = col;
      this.type = type;
      this.booked = false;
   }
      
   public boolean isBooked() {
      return booked;
   }
   
   public void book(){
      this.booked = true;
   }
   public void print(){
      System.out.println(this.row + " " +this.col + " booked: " + booked);
   }
      
}      