import java.util.*;


public abstract class Company {

   protected String id;
   protected String type;
   protected Map<String, Journey> journeys; 
   
   public boolean containsJourney(String id) {
      return journeys.containsKey(id);
   }

   public Map<String, Journey> getJourneys(){
      return journeys;
   }
   
   public Journey getJourney(String id) {
      return journeys.get(id);
   }
   
   public String getCompany() {
      return this.id;
   }
   
   public void findAvailable(String orig, String dest){ 
      Iterator journeysIt = this.journeys.entrySet().iterator();
      while (journeysIt.hasNext()){ //iterates through all the journeys of a specific company
         Map.Entry pair = (Map.Entry)journeysIt.next();
         Journey thisJourney = (Journey)pair.getValue();
         if ((thisJourney.get_orig().equals(orig)) && (thisJourney.get_dest().equals(dest))){
            System.out.println(thisJourney.get_type() + " " + thisJourney.getId() + " with " + this.type+ " " + this.id + ": ");
            thisJourney.printAttributes();
         }
      }
   }
   
   public void printJourneys(){
      System.out.println(this.id + " has these trips:");
      Iterator journeysItr = this.journeys.entrySet().iterator();
      while (journeysItr.hasNext()){
         Map.Entry pair = (Map.Entry)journeysItr.next();
         Journey thisJourney = (Journey)pair.getValue();
         thisJourney.printAttributes();
      }
   }      
         

      
   
}
   