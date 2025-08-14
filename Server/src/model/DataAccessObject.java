package model;

import configuration.Configuration;

import java.io.File;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Vector;

import static configuration.Configuration.*;

public class DataAccessObject implements Dao{

	private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

   public DataAccessObject() {}
    public void connect() {
        try {Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println("connect error" + e.getMessage()); }
    }
    public void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet executeQuery(String sql, Object... params) throws Exception {
        connect();
        ps = con.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        rs = ps.executeQuery();
        return rs;
    }
    public int executeUpdate(String sql, Object... params) throws Exception {
        connect();
        ps = con.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps.executeUpdate();
    }
    public String executeToString(String query, Object... params)throws Exception {
        rs = executeQuery(query, params);
        try {
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int executeTOInt(String query, Object... params) throws Exception {
        rs = executeQuery(query, params);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return -1;
        }
    }
    public boolean isResultExists(String sql, Object... params) throws Exception {
        rs = executeQuery(sql, params);
        return rs.next();
    }

    public Vector<MLecture> getGangjwas(String sql, Object... params) throws Exception {
        Vector<MLecture> MLectures = new Vector<MLecture>();
        ResultSet rs = null;
        try {           
            rs = executeQuery(sql, params);
            while (rs.next()) {
            	MLecture mLecture = new MLecture();
                mLecture.read(rs);
                MLectures.add(mLecture);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return MLectures;
    }
	public MUser getUser(String sql, String userId) {
		MUser Muser = new MUser();
        ResultSet rs = null;
        try {           
            rs = executeQuery(sql, userId);
            while (rs.next()) {
            	Muser.read(rs); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return Muser;
	}
	public MLogin getLogin(String sql, String userId) {
		MLogin Mlogin = new MLogin();
        ResultSet rs = null;
        try {           
            rs = executeQuery(sql, userId);
            while (rs.next()) {
            	Mlogin.read(rs); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return Mlogin;
	}
    public MLecture getLectureById(String sql, String courseId) throws Exception {
        MLecture gangjwa = null;
        connect();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, courseId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                gangjwa = new MLecture();
                gangjwa.read(rs);
            }
        } finally {
            closeResources();
        }
        return gangjwa;
    }

    public Vector<MModel> getDirectory(String fileName, Class<?> clazz) {
        Vector<MModel> mModels = new Vector<MModel>();
        try {
            Scanner scanner = new Scanner(new File("data/"+ fileName+".txt"));

            while (scanner.hasNext()) {
                Constructor<?> contstructor = clazz.getConstructor();
                MModel mModel = (MModel) contstructor.newInstance();
                mModel.read(scanner);
                mModels.add(mModel);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mModels;
    }
    public Vector<String> getCourseIds(String query, String studentId) throws Exception {
        Vector<String> courseIds = new Vector<>();
        ResultSet rs = null;

        try {
            rs = executeQuery(query, studentId);
            while (rs.next()) {
                courseIds.add(rs.getString("course_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return courseIds;
    }

}
