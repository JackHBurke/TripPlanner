import java.util.*;


public class SystemManager {

   private Map<String, Airport> airports;
   private Map<String, Airline> airlines;
   private Map<String, Port> ports;
   private Map<String, Cruise> cruises;
   private Map<String, Ship> ships;
   
   public SystemManager() {
      this.airports = new HashMap<String, Airport>();
      this.ships = new HashMap<String, Ship>();
      this.airlines = new HashMap<String, Airline>();
      this.ports = new HashMap<String, Port>();
      this.cruises = new HashMap<String, Cruise>();
   }

    //Creates new information to be stored based on user input of a number
   public void processAdmin() {
      Scanner keyboard = new Scanner(System.in);
      if (!this.passwordCheck(keyboard)) { //Password is password
         return;
      }
      boolean valid = true;
      while(valid){
         System.out.println();
         System.out.println("Press 1 to create airport, 2 to create airline, 3 to create flight, 4 to create flight section, ");
         System.out.println("5 to create cruise company, 6 to create port, 7 to create ship, 8 to create cabin section, ");
         System.out.println("9 to create cruise trip, 10 to print airline subsystem, 11 to print cruise subsystem, and 0 to exit");
         System.out.println();
         int choice = keyboard.nextInt();
         keyboard.nextLine();
         if (choice == 1){ //create airport
            this.newAirportInfo(keyboard);
         }else if(choice == 2){//create airline
            this.newAirlineInfo(keyboard);
         }else if(choice == 3){//create flight
            this.newFlightInfo(keyboard);
         }else if(choice == 4){ //create flight section
            this.newFlightSectionInfo(keyboard);
         }else if(choice == 5){//create cruise
            this.newCruiseInfo(keyboard);
         }else if(choice == 6){//create port
            this.newPortInfo(keyboard);
         }else if(choice == 7){//create ship
            this.newShipInfo(keyboard);
         }else if(choice == 8){//create cabin section
            this.newCabinInfo(keyboard);
         }else if(choice == 9){//create trip
            this.newTripInfo(keyboard);
         }else if(choice == 10){
            this.displayAirlineDetails();
         }else if(choice == 11){
            this.displayCruiseDetails();
         }else if(choice == 0){
            valid = false;
         }else{
            System.out.println("Invalid choice, please choose again");
         }
      }
   }

    //Queries and books flights and cruises based on used input
   public void processClient() {
      System.out.println("Welcome customer");
      boolean valid = true;
      Scanner keyboard = new Scanner(System.in);
      while(valid){
         System.out.println();
         System.out.println("Press 1 to find an available flight, 2 to book a specific seat");
         System.out.println("Press 3 to find an available cruise, 4 to book a specific cabin");
         System.out.println("Press 0 to exit");
         System.out.println();
         int choice = keyboard.nextInt();
         if (choice == 1) { //find flight
            this.getFlightRequirements(keyboard);
         }else if (choice == 2){ //book seat
            this.getSeatRequest(keyboard);
         }else if (choice == 3){ //find cruise
            this.getCruiseRequirements(keyboard);
         }else if (choice == 4){ //book cabin
            this.getCabinRequest(keyboard);
         }else if (choice == 0){
            valid = false;
         }else {
            System.out.println("Invalid choice, please choose again");
         }
      }
   }

   public void createSampleSystem() {
      this.createCruise("A");
      this.createPort("POR");
      this.createPort("POT");
      this.createPort("POY");
      this.createShip("Ship");
      this.createCabinsection("Ship", CabinClass.Family, 3);
      this.createAirport("DFW");
      this.createAirport("DEN");
      this.createAirline("DELTA");
      this.createFlight("DELTA", "DEN", "DFW", 2015, 10, 10, "123");
      this.createFlightSection("DELTA","123", 2, 2, SeatClass.economy);
      this.bookSeat("DELTA", "123", SeatClass.economy, 2, 'B');
      this.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A');
   }

   private boolean passwordCheck(Scanner keyboard) {
      System.out.println("Enter password: ");
      String password = keyboard.next();
      if (!(password.equals("password"))){
         System.out.println("Incorrect password");
         return false;
      }else{
         System.out.println("Administrator mode activated");
         System.out.println();
         return true;
      }
   }

   private void newAirportInfo(Scanner keyboard) {
      String airportName;
      System.out.println("Enter 3 letter airport name: ");
      airportName = keyboard.next();
      this.createAirport(airportName);
   }

   private void newAirlineInfo(Scanner keyboard) {
      String airlinename;
      System.out.println("Enter airline name: ");
      airlinename = keyboard.next();
      this.createAirline(airlinename);
   }

   private void newFlightInfo(Scanner keyboard) {
      String airline, depart, arrive, id;
      int year, month, day;
      System.out.println("Enter airline: ");
      airline = keyboard.next();
      System.out.println("Enter departing airport: ");
      depart = keyboard.next();
      System.out.println("Enter arriving airport: ");
      arrive = keyboard.next();
      System.out.println("Enter year: ");
      year = keyboard.nextInt();
      System.out.println("Enter 2 digit month: ");
      month = keyboard.nextInt();
      System.out.println("Enter 2 digit day: ");
      day = keyboard.nextInt();
      System.out.println("Enter flight id: ");
      id = keyboard.next();
      this.createFlight(airline, depart, arrive, year, month, day, id);
   }

   private void newFlightSectionInfo(Scanner keyboard) {
      String airline, flight;
      int row, col, sec;
      SeatClass section;
      System.out.println("Enter airline: ");
      airline = keyboard.next();
      System.out.println("Enter flight id: ");
      flight = keyboard.next();
      System.out.println("Enter number of rows: ");
      row = keyboard.nextInt();
      System.out.println("Enter number of columns: ");
      col = keyboard.nextInt();
      System.out.println("Enter class : 1 for economy, 2 for business, and 3 for first: ");
      sec = keyboard.nextInt();
      if (sec == 1) {
         section = SeatClass.economy;
      } else if (sec == 2) {
         section = SeatClass.business;
      } else {
         section = SeatClass.first;
      }
      this.createFlightSection(airline, flight, row, col, section);
   }

   private void newCruiseInfo (Scanner keyboard) {
      String cruiseid;
      System.out.println("Enter cruise name: ");
      cruiseid = keyboard.nextLine();
      this.createCruise(cruiseid);
   }

   private void newPortInfo (Scanner keyboard) {
      String portid;
      System.out.println("Enter port name: ");
      portid = keyboard.next();
      this.createPort(portid);
   }

   private void newShipInfo (Scanner keyboard) {
      String shipid;
      System.out.println("Enter ship name: ");
      shipid = keyboard.nextLine();
      this.createShip(shipid);
   }

   private void newCabinInfo (Scanner keyboard) {
      String id;
      int num, sec;
      CabinClass section;
      System.out.println("Enter ship name: ");
      id = keyboard.next();
      System.out.println("Enter class : 1 for Family, 2 for Couples, 3 for Deluxe Family and 4 for Deluxe Couples: ");
      sec = keyboard.nextInt();
      if (sec == 1) {
         section = CabinClass.Family;
      } else if (sec == 2) {
         section = CabinClass.Couples;
      } else if (sec == 3) {
         section = CabinClass.Deluxe_Family;
      } else {
         section = CabinClass.Deluxe_Couples;
      }
      System.out.println("Enter number of cabins in section: ");
      num = keyboard.nextInt();
      this.createCabinsection(id, section, num);
   }

   private void newTripInfo (Scanner keyboard) {
      String cruise, id, ship;
      int deptYear, deptMonth, deptDay, retYear, retMonth, retDay;
      LinkedList<String> portList = new LinkedList<String>();
      System.out.println("Enter cruise id: ");
      cruise = keyboard.nextLine();
      System.out.println("Enter trip id: ");
      id = keyboard.next();
      keyboard.nextLine();
      System.out.println("Enter ship id: ");
      ship = keyboard.nextLine();
      System.out.println("Enter leave year: ");
       deptYear = keyboard.nextInt();
      System.out.println("Enter leave month: ");
       deptMonth = keyboard.nextInt();
      System.out.println("Enter leave day: ");
      deptDay = keyboard.nextInt();
      System.out.println("Enter return year: ");
      retYear = keyboard.nextInt();
      System.out.println("Enter return month: ");
      retMonth = keyboard.nextInt();
      System.out.println("Enter return day: ");
      retDay = keyboard.nextInt();
      System.out.println("Now, enter the locations of the stops on the trip, in order of starting port to end");
      System.out.println("To finish entering ports, enter in the character 'd'");
      boolean cont = true;
      while(cont) {
         System.out.println("Enter port: ");
         String port = keyboard.next();
         if (port.equals("d")) {
            cont = false;
         } else {
            portList.add(port);
         }
      }
      this.createTrip(cruise, portList.getFirst(), portList.getLast(),
              deptYear, deptMonth, deptDay,
              retYear, retMonth, retDay, id, portList, ship);
   }

   private void getFlightRequirements(Scanner keyboard) {
      System.out.println("Enter in a origin");
      String orig = keyboard.next();
      System.out.println("Enter in a destination");
      String dest = keyboard.next();
      this.findAvailableFlights(orig,dest);
   }

   private void getSeatRequest (Scanner keyboard) {
      System.out.println("Enter in an airline");
      String line = keyboard.next();
      System.out.println("Enter in a flight");
      String flight = keyboard.next();
      System.out.println("Enter class : 1 for economy, 2 for business, and 3 for first: ");
      SeatClass section;
      int sec = keyboard.nextInt();
      if (sec == 1) {
         section = SeatClass.economy;
      } else if (sec == 2) {
         section = SeatClass.business;
      } else {
         section = SeatClass.first;
      }
      System.out.println("Enter in a row (a number)");
      int row = keyboard.nextInt();
      System.out.println("Enter in a column (a letter)");
      String col = keyboard.next();
      this.bookSeat(line,flight,section,row,col.charAt(0));
   }

   private void getCruiseRequirements(Scanner keyboard) {
      System.out.println("Enter in a origin");
      String orig = keyboard.next();
      System.out.println("Enter in a destination");
      String dest = keyboard.next();
      this.findAvailableTrips(orig,dest);
   }

   private void getCabinRequest(Scanner keyboard) {
      System.out.println("Enter in a cruise id");
      String cruise = keyboard.next();
      System.out.println("Enter in a trip id");
      String trip = keyboard.next();
      System.out.println("Enter class : 1 for Family, 2 for Couples, 3 for Deluxe Family and 4 for Deluxe Couples: ");
      int sec = keyboard.nextInt();
      CabinClass section;
      if (sec == 1) {
         section = CabinClass.Family;
      } else if (sec == 2) {
         section = CabinClass.Couples;
      } else if (sec == 3) {
         section = CabinClass.Deluxe_Family;
      } else {
         section = CabinClass.Deluxe_Couples;
      }
      System.out.println("Enter in how many seats you would like to book");
      int people = keyboard.nextInt();
      this.bookCabin(cruise,trip,section,people);
   }

   private void createPort(String id) {
      if (id.length() != 3) {
         System.out.println("Could not create port: Port name " + id + " not correct length");
         
      }   
      else if (this.checkPort(id)) {
         System.out.println("Could not create port: Port name " + id + " already in use");        
      }
      else {
         Port port = new Port(id);
         ports.put(id,port);
         System.out.println("Port " + id + " created");
      }      
   }
   
   private void createShip(String id) {
      if (this.checkShip(id)) {
         System.out.println("Could not create Ship: Ship name " + id + " already in use");        
      }else{
         Ship ship = new Ship(id);
         ships.put(id, ship);
         System.out.println("Ship " + id + " created");
      }
   }
   
   private void createCabinsection(String shipId, CabinClass cabin, int num) {
      if (!(this.checkShip(shipId))) {
         System.out.println("Could not create cabin section: invalid ship " + shipId);
         return;    
      } 
      Ship ship = ships.get(shipId);
      if (ship.checkcabinsection(cabin)) {
         System.out.println("Could not create cabin section: " + cabin + " section already part of ship");
         return;
      }
      if (num < 1){
         System.out.println("Could not create cabin section: invalid number of cabins");
         return;
      }
      ship.addCabinSection(num, cabin);
      System.out.println("Cabin Section created for ship " + shipId);
   }
   
   private void createCruise(String id) {
      if (this.checkCruise(id)) {
         System.out.println("Could not create cruise: Cruise name " + id + " already in use");        
      }
      else {
         Cruise cruise = new Cruise(id);
         cruises.put(id,cruise);
         System.out.println("Cruise " + id + " created");
      }    
   }
   
   private void createTrip(String cruise, String depart, String arrive,
                              int deptYear, int deptMonth, int deptDay,
                              int retYear, int retMonth, int retDay, String id, LinkedList<String> portlist, String ship_id) {
      if (!this.checkCruise(cruise)) {
         System.out.println("Could not create trip: Invalid cruise for trip " + id);
      }
      else if (!this.checkports(portlist)) {
         System.out.println("Could not create trip: Invalid port for trip " + id);
      }
      else if ((deptYear < 2010) || (deptMonth > 12) || (deptDay > 31) || (retYear < 2010) || (retMonth > 12) || (retDay > 31)) {
         System.out.println("Could not create trip: Invalid date for trip " + id);
      }
      else if (!(this.checktriplength(deptYear, deptMonth, deptDay, retYear, retMonth, retDay))) {
         System.out.println("Could not create trip: trip longer than 21 days");
      }
      else if ((cruises.get(cruise)).containsJourney(id)) {
         System.out.println("Could not create trip: Cruise " + cruise + " already contains trip " + id);
      }
      else if (!(this.checkShip(ship_id))){
         System.out.println("Could not create trip: Invalid ship for trip " + id);
      }
      else if (!(checkOverlap(deptDay,deptMonth,deptYear, ship_id))) {
         System.out.println("Could not create trip: Dates overlap with planned trip on " + ship_id);
      }   
      else {
         Cruise cruise1 = cruises.get(cruise); 
         cruise1.addTrip(depart, arrive, deptYear, deptMonth, deptDay, retYear, retMonth, retDay, id, portlist);
         Ship ship = ships.get(ship_id);
         ship.addTrip((Trip)cruise1.getJourney(id));
         System.out.println("Trip " + id + " created");
      }                                      
   
   }
    //make sure trip being added to a ship doesn't overlap and already created trip for that ship
   private boolean checkOverlap(int deptDay, int deptMonth, int deptYear, String ship) {
      Ship currentShip = ships.get(ship);
      LinkedList<Trip> trips = currentShip.getTrips();
      ListIterator<Trip> listIterator = trips.listIterator();
      while (listIterator.hasNext()) {
         int[] tripDates = listIterator.next().getLeaveDates(); //type cast
         //Check to see what trip starts first
         if ((!(checktriplength(deptYear,deptMonth,deptDay,tripDates[0],tripDates[1],tripDates[2])))
                                           && (!(checktriplength(tripDates[0],tripDates[1],tripDates[2],deptYear,deptMonth,deptDay)))) {
            return false;
         }
      }
      return true;
   }

   //see if trip is more than 21 days
   private boolean checktriplength( int leaveyear, int leavemonth, int leaveday, 
                              int returnyear, int returnmonth, int returnday){
      if (Math.abs(returnyear - leaveyear) > 1) {
         return false;
      } else if ((leaveyear - returnyear) == 1) {
         return false;   
      } else if ((returnyear - leaveyear) == 1) {
         if (!((leavemonth == 12) && (returnmonth == 1))){
            return false;
         } else if ((leaveday < 10) || (returnday > 20)) {
            return false;
         } else if ((leaveday + 21 % 30) < returnday) {
            return false;
         }
      } else {
         if ( Math.abs(returnmonth - leavemonth) > 1) {
            return false;
         } else if (leavemonth - returnmonth == 1) {
            return false;   
         } else if (returnmonth - leavemonth == 1) {
            if ((leaveday < 10) || (returnday > 20)) {
               return false;
            } else if ((leaveday + 21 % 30) < returnday) {
               return false;
            }
         } else {
            if (returnday - leaveday > 21) {
               return false;
            } else if (returnday - leaveday < 0) {
               return false;
            }
         }   
      }
      return true;    
   }

   //iterates through linked list of ports to see if all are valid
   private boolean checkports(LinkedList<String> ports) {
      ListIterator<String> listIterator = ports.listIterator();
      if (ports.isEmpty() || ports.size() == 1) {
         return false;
      }   
      while (listIterator.hasNext()) {
         if (!checkPort(listIterator.next())){
            return false;
         }
      }
      return true;
         
   }
   
   private void createAirport(String id) {
      if (id.length() != 3) {
         System.out.println("Could not create airport: Airport name " + id + " not correct length");
         
      }   
      else if (this.checkAirport(id)) {
         System.out.println("Could not create airport: Airport name " + id + " already in use");        
      }
      else {
         Airport airport = new Airport(id);
         airports.put(id,airport);
         System.out.println("Airport " + id + " created");
      }      
   }
   
   private void createAirline(String id) {
      if (id.length() > 5) {
         System.out.println("Could not create airline: Airline name " + id + " not correct length");
         
      }   
      else if (this.checkAirline(id)) {
         System.out.println("Could not create airline: Airline name " + id + " already in use");        
      }
      else {
         Airline airline = new Airline(id);
         airlines.put(id,airline);
         System.out.println("Airline " + id + " created");
      }    
   }
       
      
   private void createFlight(String airline, String depart, String arrive,
                              int year, int month, int day, String id) {
      if (!this.checkAirline(airline)) {
         System.out.println("Could not create flight: Invalid airline for flight " + id);
      }
      else if ((!(this.checkAirport(depart)) || !(this.checkAirport(arrive)))) {
         System.out.println("Could not create flight: Invalid airport for flight " + id);
      }
      else if ((year < 2010) || (month > 12) || (day > 31)) {
         System.out.println("Could not create flight: Invalid date for flight " + id);
      }
      else if ((airlines.get(airline)).containsJourney(id)) {
         System.out.println("Could not create flight: Airline " + airline + " already contains flight " + id);
      }
      else {
         Airline line = airlines.get(airline); 
         line.addFlight(depart,arrive,year,month,day,id);
         System.out.println("Flight " + id + " created");
      }                                      
   
   }

   private void createFlightSection(String airline, String flight, int row, int col,
                               SeatClass section){ 
      if (!this.checkAirline(airline)) {  
         System.out.println("Could not create section: Invalid airline for flight " + flight);
         return;
      }
      Airline line = airlines.get(airline);
      if (!line.containsJourney(flight)) {
         System.out.println("Could not create section: Invalid flight for airline " + airline);
         return;
      }
      Flight fly = (Flight)line.getJourney(flight);
      if (fly.checkSection(section)) { 
         System.out.println("Could not create section: Flight " + flight + " already contains section " + section);
      }
      else if (row < 0 || row > 100 || col < 0 || col > 10) { 
         System.out.println("Could not create section: Improper size seats for flight " + flight);
      }
      else { 
         fly.addflightsection(row,col,section);
         System.out.println("Flight section created for flight " + flight);
      }                            
   }
   
   private void findAvailableFlights(String orig, String dest) {
      System.out.println("All available flights from " + orig + " to " + dest + " are: ");
      for (Airline line : airlines.values()) {
         line.findAvailable(orig, dest);
      }
   }
   
   private void findAvailableTrips(String orig, String dest) {
      System.out.println("All available trips from " + orig + " to " + dest + " are: ");
      for (Cruise cruise : cruises.values()) {
         cruise.findAvailable(orig,dest);
      } 
   }
   
   private void bookCabin(String cruiseId, String tripId, CabinClass cabin, int people){
      if (!this.checkCruise(cruiseId)) {
         System.out.println("Could not book cabin: Invalid cruise for trip " + tripId);
         return;
      }
      Cruise cruise = cruises.get(cruiseId);
      if (!cruise.containsJourney(tripId)) {
         System.out.println("Could not book cabin: Invalid trip for cruise " + cruiseId);
         return;
      }
      Trip trip = (Trip)cruise.getJourney(tripId);
      if (!trip.checkSection(cabin)) { 
         System.out.println("Could not book cabin: Trip " + tripId + " does not contain cabin class " + cabin);
         return;
      }
      CabinSection section = trip.getSection(cabin);
      if (section.bookAvailableSeats(people)){
         System.out.println("Cabin booked for trip " + tripId + " of type " + cabin);
      }else{
         System.out.println("Could not book cabin for trip " + tripId + ": No availible cabins of type " + cabin);
      }
   }
              
   private void bookSeat(String airline, String flight, SeatClass section,
                            int row, char col) {
      if (!this.checkAirline(airline)) {
         System.out.println("Could not book seat: Invalid airline for flight " + flight);
         return;
      }
      Airline line = airlines.get(airline);
      if (!line.containsJourney(flight)) {
         System.out.println("Could not book seat: Invalid flight for airline " + airline);
         return;
      }
      Flight fly = (Flight)line.getJourney(flight);
      if (!fly.checkSection(section)) { 
         System.out.println("Could not book seat: Flight " + flight + " does not contain section " + section);
         return;
      }
      FlightSection sec = fly.getSection(section);
      int colNum = (int)col - 65; //Converts the character value column to a number
      if ((row > sec.getRows()) || (colNum > sec.getCols())) {
         System.out.println("Could not book seat: Row or column out of bounds for flight " + flight);
      }
      else if (sec.getSeat(row-1, colNum).isBooked()) { 
         System.out.println("Could not book seat: Seat on flight " + flight + " section " + section + " already booked");
      }
      else {
         sec.bookSeat(row-1,colNum);
         System.out.println("Seat has been booked for flight " + flight);
      }                        
   }
   
   private void displayAirlineDetails() {
      System.out.println("Airports: ");
      for (String key : airports.keySet()) {
         System.out.println(key);
      }
      for (Airline line : airlines.values()){ //iterates through the airlines
         System.out.println("Airline " + line.getCompany());
         line.printJourneys();  
      }             
      
   }
   
   private void displayCruiseDetails() {
      System.out.println("Ports: ");
      for (String key : ports.keySet()) {
         System.out.println(key);
      }
      for (Cruise cruise : cruises.values()){ //iterates through the cruises
         System.out.println("Cruise " + cruise.getCompany());
         cruise.printJourneys();  
      }             
      
   }
   
   private boolean checkAirline(String id) {
      return airlines.containsKey(id);
   }   
   
   private boolean checkShip(String id) {
      return ships.containsKey(id);
   } 

   private boolean checkAirport(String id) {
      return airports.containsKey(id);
   }
   
   private boolean checkCruise(String id) {
      return cruises.containsKey(id);
   }
   
   private boolean checkPort(String id) {
      return ports.containsKey(id);
   }
}         
        