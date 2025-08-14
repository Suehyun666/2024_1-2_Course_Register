package valueObject;

public class VLecture extends VValueObject {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String lecturer;
	private String credit;
	private String time;
	private String day;
	private int currentpeople; 
	private int wishpeople;
	private int limit;
	
	public VLecture() throws Exception{
	}	
	public String getId() {	return id;}
	public void setId(String id) {this.id = id;	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getLecturer() {return lecturer;}
	public void setLecturer(String lecturer) {this.lecturer = lecturer;}
	
	public String getCredit() {	return credit;}
	public void setCredit(String credit) {	this.credit = credit;}
	
	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
	
	public String getDay() {return day;	}
	public void setDay(String day) {this.day=day;}
	
	public int getCurrentPeople() {return currentpeople;}
	public void setCurrentPeople(int currentpeople) {this.currentpeople=currentpeople;}
	
	public int getWishPeople() {return wishpeople;}
	public void setWishPeople(int wishpeople) {this.wishpeople=wishpeople;}
	
	public int getPeopleLimit() {return limit;}
	public void setPeopleLimit(int limit) {this.limit=limit;}

}