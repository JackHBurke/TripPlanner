import java.util.*;


public class Cruise extends Company{


   public Cruise(String id) {
      this.id = id;
      this.type = "cruise";//Type used to identify from supertype
      this.journeys = new HashMap<String, Journey>();
   }
   
   public void addTrip(String dept, String arrive, int deptYear, int deptMonth, int deptDay,
                       int retYear, int retMonth, int retDay, String id, LinkedList<String> ports){
      Trip trip = new Trip(dept, arrive, deptYear, deptMonth, deptDay, retYear, retMonth, retDay, id, ports);
      this.journeys.put(id, trip);
   }
   
}