package model;

import java.sql.ResultSet;

public class MUser extends MModel{
    private String userId;
    private String name;
    private String department;
    private int score;
    private int maxScore;
    
    public void read(ResultSet resultSet) throws Exception {
        this.userId = resultSet.getString("student_id");
        this.name = resultSet.getString("name");
        this.department = resultSet.getString("department");
        this.score = resultSet.getInt("Score");
        this.maxScore = resultSet.getInt("maxScore");
    }

    public String getId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }
}
