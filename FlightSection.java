public class FlightSection implements Section{
   
   private SeatClass section;
   private Seat[][] seats; //must have at least 1
   
   public FlightSection(int rows, int col,
                           SeatClass section) {
      this.seats = new Seat[rows][col];
      char column; 
      for (int i = 0; i < rows; i++){
         for (int j = 0; j < col; j++) {
            column = (char)(j + 65);
            seats[i][j] = new Seat(i, column, section);
         }
      }
      this.section = section;
      
   }
   
   public boolean bookAvailableSeats(int people) {//iterates through the seats array checking for open seats
      for (int i = 0; i < this.seats.length; i++){
         for ( int j = 0; j < this.seats[i].length; j++) {
            if (!this.seats[i][j].isBooked()){
               this.seats[i][j].book();
               return true;
            }
         }
      }
      return false;
   }
   
   public void printsection(){
      System.out.println(this.section);
   }
   
   public void printseats(){
      System.out.println("Seats:");
      for (int i = 0; i < this.seats.length; i++){
         for ( int j = 0; j < this.seats[i].length; j++) {
            this.seats[i][j].print();
         }
      }   
   }
   
   public void bookSeat(int row, int col){
      this.seats[row][col].book();
   }
   
   public SeatClass getclass(){
      return this.section;
   }
   
   public int getRows() {
      return seats.length;
   }
   
   public int getCols() {
      return seats[0].length;
   }
   
   public Seat getSeat(int row, int col) {
      return seats[row][col];
   }        
   
   public ClassType getType() {
      return this.section;
   }  
}                                    