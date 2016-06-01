public class Flight implements Journey{
   
   String dept;
   String arrive;
   int year;
   int month;
   int day;
   String id;
   int count;
   FlightSection[] sections;
   String triptype; //type is used for super class
      
   public Flight(String dept, String arrive,
                              int year, int month, int day, String id) {
      this.dept = dept;
      this.arrive = arrive;
      this.year = year;
      this.month = month;
      this.day = day;
      this.id = id;
      this.count = 0;
      this.sections = new FlightSection[3];
      this.triptype = "Flight";
   } 
           
   public void addflightsection(int row, int col, SeatClass seatclass){
      sections[this.count] = new FlightSection(row,col,seatclass);
      this.count++;
   }
   
   public boolean checkSection(SeatClass section) { //checks if a section with that seatClass is present
      for (int i = 0; i < this.count; i++) {         
         if (sections[i].getclass() == section) {
            return true;
         }
      }
      return false;
   }
   
   public FlightSection getSection(SeatClass section) { //returns a section based on seatClass
      for (int i = 0; i < this.count; i++) {
         if (sections[i].getclass() == section) {
            return sections[i];
         }
      }
      return null;
   }
   
   public void printAttributes(){
      System.out.println("Departs from: " + this.dept + ", Arrives at: " + this.arrive + ",  On date: "
              + this.year + "/" + this.month + "/" + this.day + ", Flight ID: " + this.id);
      System.out.println("Sections: ");
            for (int i = 0; i < this.count; i++){//iterates through the flight sections for a given flight
               if (this.checkSection(SeatClass.first)){
                  System.out.println("Flight Section: first");
                  this.getSection(SeatClass.first).printseats();
               }
               if (this.checkSection(SeatClass.economy)){
                  System.out.println("Flight Section: economy");
                  this.getSection(SeatClass.economy).printseats();
               }
               if (this.checkSection(SeatClass.business)){
                  System.out.println("Flight Section: business");
                  this.getSection(SeatClass.business).printseats();
               }
             }
   }
  
   public String getId() {
      return this.id;
   }                                       
   public String get_orig(){
      return this.dept;
   } 
   public String get_dest(){
      return this.arrive;
   }
   public String get_type(){
      return this.triptype;
   }
   public int get_count(){
      return this.count;
   }
}                        
                              