package model;

import java.sql.ResultSet;
import java.util.Vector;

public interface Dao {
    public void connect() ;
    public void closeResources() ;

    public ResultSet executeQuery(String sql, Object... params) throws Exception ;
    public int executeUpdate(String sql, Object... params) throws Exception;
    public String executeToString(String query, Object... params)throws Exception;
    public int executeTOInt(String getScore, Object... params)throws Exception;
    public boolean isResultExists(String sql, Object... params) throws Exception;

    public Vector<MLecture> getGangjwas(String sql, Object... params) throws Exception ;
    public MUser getUser(String sql, String userId) ;
    public MLogin getLogin(String sql, String userId) ;
    public Vector<MModel> getDirectory(String fileName, Class<?> clazz) ;

    public MLecture getLectureById(String sql, String courseId) throws Exception ;
    public Vector<String> getCourseIds(String query, String studentId) throws Exception;
}
