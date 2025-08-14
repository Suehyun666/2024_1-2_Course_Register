package model;

import java.sql.ResultSet;

public class MLectureList extends MModel {
	private String id;
	
	public MLectureList() {}

	public void read(ResultSet rs) throws Exception {
		this.id = rs.getString("course_id"); 
	}
	public String getId() {return id;}
	
}