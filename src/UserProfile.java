
class UserProfile{
  private String id;
  private String gender;
  private String looking_for;
  private String pickup_line;
  /*private int friends_count;
  private int followers_count;
  private int favourites_count;
  private int statuses_count;*/
 /* public UserProfile(){
	  this.name = "hello";
	  this.screen_name = "hello screen";
  }*/
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getLooking_for() {
	return looking_for;
}
public void setLooking_for(String looking_for) {
	this.looking_for = looking_for;
}
public String getPickup_line() {
	return pickup_line;
}
public void setPickup_line(String pickup_line) {
	this.pickup_line = pickup_line;
}
@Override
  public String toString(){
    return 
    "Screen Gender: "+this.gender+" " + 
    "Looking For: "+ this.looking_for + " " +
    "Pickup_line: "+ this.pickup_line + " " ;
    
  }
}