public enum SeatClass implements ClassType{

   business, economy, first;
   
   public String toString() {
    switch(this) {
      case business: return "Business";
      case first: return "First";
      case economy: return "Economy";
      default:       return "unspecified";
    }
  }
}  