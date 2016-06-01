//SeatClass Enumerated Type
//Holds the three possibilities for type of seatClass, business, economy, and first.
public enum CabinClass implements ClassType{
   Family, Couples, Deluxe_Family, Deluxe_Couples;
   
   public String toString() {
      switch(this) {
         case Family: 
            return "Family";
         case Couples: 
            return "Couples";
         case Deluxe_Family: 
            return "Deluxe Family";
         case Deluxe_Couples: 
            return "Deluxe Couples";
         default: 
            return "Unspecified";
      }
   }
}