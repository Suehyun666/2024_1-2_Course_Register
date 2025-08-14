package model;

import java.sql.ResultSet;

public class MDirectory extends MModel {
	private String id;
	private String name;
	private String fileName;
	
	public MDirectory() {}
	
	public void read(ResultSet rs) throws Exception {
		this.id = rs.getString("id"); 
        this.name = rs.getString("name");
        this.fileName=rs.getString("fileName");
	}

	public String getId() {return id;}
	
	public String getName() {return name;}
	
	public String getFileName() {return fileName;}
}
