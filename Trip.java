import java.util.*;


public class Trip implements Journey{
   
   String dept;
   String arrive;
   int deptYear;
   int deptMonth;
   int deptDay;
   int retYear;
   int retMonth;
   int retDay;
   String id;
   LinkedList<String> ports; //linked list of ports so we can dynamically add ports to the list for each trip
   String tripType;
   CabinSection[] sections;
   int count; //number of cabin sections
   
   public Trip(String dept, String arrive, int deptYear, int deptMonth, int deptDay, int retYear, int retMonth,
               int retDay, String id, LinkedList<String> ports) {
                         
      this.dept = dept;
      this.arrive = arrive;
      this.deptYear = deptYear;
      this.deptMonth = deptMonth;
      this.deptDay = deptDay;
      this.retYear = retYear;
      this.retMonth = retMonth;
      this.retDay = retDay;
      this.id = id;
      this.ports = ports;
      this.tripType = "Cruise";
      this.sections = new CabinSection[4];
      this.count = 0;
   }
   
   public void addSections (CabinSection[] sect, int count) { //gets the cabin info from the ship object and associates it with a trip
      System.arraycopy( sect, 0, this.sections, 0, sect.length); 
      this.count = count;     
   }  
   
   public CabinSection getSection(CabinClass section) { //returns a section based on seatClass
      for (int i = 0; i < this.count; i++) {
         if (sections[i].getType() == section) {
            return sections[i];
         }
      }
      return null;
   }
    
   public boolean checkSection(CabinClass section) { //checks if a section with that seatClass is present
      for (int i = 0; i < this.count; i++) {         
         if (sections[i].getType() == section) {
            return true;
         }
      }
      return false;
   }
   
   public void printAttributes(){
      System.out.println("Departs from: "+ this.dept + ", Arrives at: "+ this.arrive + ", Leaving: " +
              this.deptDay + "/" + this.deptMonth + "/" + this.deptYear +
               ",  Arriving " + this.retDay + "/" + this.retMonth + "/" + this.retYear + ", Trip number: " + this.id);
      System.out.println("Sections: ");
            for (int i = 0; i < this.get_count(); i++){//iterates through the flightsections for a given flight
               if (this.checkSection(CabinClass.Family)){
                  System.out.println("Cabin Section: Family");
                  this.getSection(CabinClass.Family).printseats();
               }
               if (this.checkSection(CabinClass.Couples)){
                  System.out.println("Cabin Section: Couples");
                  this.getSection(CabinClass.Couples).printseats();
               }
               if (this.checkSection(CabinClass.Deluxe_Family)){
                  System.out.println("Cabin Section: Deluxe Family");
                  this.getSection(CabinClass.Deluxe_Family).printseats();
               }
               if (this.checkSection(CabinClass.Deluxe_Couples)){
                  System.out.println("Cabin Section: Deluxe Couples");
                  this.getSection(CabinClass.Deluxe_Couples).printseats();
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
      return this.tripType;
   }
   
   public int get_count(){
      return this.count;
   }   
   
   public int[] getLeaveDates() {
      int[] dates = {deptDay,deptMonth,deptYear};
      return dates;
   }   
}