public class CabinSection implements Section{
   
    private CabinClass section;
    private Cabin[] cabins;

    public CabinSection (CabinClass section, int num){
        this.section = section;
        this.cabins = new Cabin[num];
        int cap = this.getCapacity(section);
        for (int i = 0; i < num; i++) {
            this.cabins[i] = new Cabin(cap);
        }
    }
   
    public boolean bookAvailableSeats(int people) {
         for (int i = 0; i < cabins.length; i++) {
            if (!cabins[i].isBooked(people)) {
                cabins[i].book(people);
                return true;
            }
         }
         return false;
    }
   
    public void printsection() {
      System.out.println(this.section);
   }
   
    public void printseats() {
        System.out.println("Cabins:");
        for (int i = 0; i < this.cabins.length; i++){
            this.cabins[i].print(this.section);
        }
    }
   
    public CabinClass getType() {
      return section;
   }

    //returns maximum capacity based on the enum given
    public int getCapacity(CabinClass type) {
        switch (type) {
            case Family:
                return 4;
            case Couples:
                return 2;
            case Deluxe_Family:
                return 6;
            case Deluxe_Couples:
                return 2;
            default:
                return 0;
        }
    }
}            