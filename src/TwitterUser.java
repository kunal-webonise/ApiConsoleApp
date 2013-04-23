
class TwitterUser{
  private String id;
  private String name;
  private String screen_name;
  private String url;
  private int friends_count;
  private int followers_count;
  private int favourites_count;
  private int statuses_count;
  public TwitterUser(){
	  this.name = "hello";
	  this.screen_name = "hello screen";
  }
  @Override
  public String toString(){
    return "Name: "+this.name+"n" +
    "Screen Name: "+this.screen_name+"n" +
    "Number of Friends: "+ this.friends_count + "n" +
    "Number of Followers: "+ this.followers_count +"n" +
    "Number of Status updates: "+this.statuses_count +"n" +
    "Number of favorites: "+this.favourites_count +"n";
  }
}