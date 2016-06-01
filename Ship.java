import java.util.*;

public class Ship {

   String id;
   CabinSection[] sections;
   int count; //count is the number of cabin sections
   LinkedList<Trip> trips;
   
   public Ship (String id){ 
      this.id = id;
      this.sections = new CabinSection[4];
      this.count = 0;
      this.trips = new LinkedList<Trip>();
   }
   
   public void addCabinSection(int num, CabinClass cabinclass){
      sections[this.count] = new CabinSection(cabinclass, num);
      this.count++;
   }
   
   public boolean checkcabinsection(CabinClass cabinclass) {
      for (int i = 0; i < this.count; i++) {
         if (this.sections[i].getType() == cabinclass) {
            return true;
         }
      }
      return false;
   }      
   
   public void addTrip (Trip trip) {
      trip.addSections(sections, count);
      trips.add(trip);
   }
   
   public LinkedList<Trip> getTrips() {
      return this.trips;
   }   
   
}      