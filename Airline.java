import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Airline extends Company{
   
   
   public Airline(String id) {
      this.id = id;
      this.type = "airline"; //Used for knowing type of company
      this.journeys = new HashMap<String, Journey>();
   }
   
   public void addFlight(String orig, String dest, int year, int month, int day, String id){
      Flight flight = new Flight(orig, dest, year, month, day, id);
      this.journeys.put(id, flight);
   }

   
}      