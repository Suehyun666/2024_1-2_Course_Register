package valueObject;

public class VUser extends VValueObject{
	private static final long serialVersionUID = 1L; 
	private String Id;
    private String name;
    private String department;
    private int score;
    private int maxScore;

    public VUser() throws Exception{
    	
    }
    public VUser(String Id, String name,String department, int score, int maxScore) throws Exception{
        this.Id = Id;
        this.name = name;
        this.department = department;
        this.score = score;
        this.maxScore = maxScore;
    }

    public String getUserId() {return Id; }

    public String getName() {return name;    }

    public String getDepartment() { return department;    }

    public int getScore() {return score;    }

    public int getMaxScore() {return maxScore;    }

	public void setMaxScore(int maxScore) {this.maxScore=maxScore;}

	public void setScore(int score) {this.score=score;}

	public void setId(String Id) {this.Id=Id;}

	public void setName(String name) {this.name=name;	}

	public void setDepartment(String department) {this.department=department;	}
}