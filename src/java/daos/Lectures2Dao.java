/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Lecture;

/**
 *
 * @author 
 */
public class Lectures2Dao extends ConnectionDao {
    
     public List<Lecture> buildLectures(int courseId) throws Exception {
        try {   
            List<Lecture> lectures = new ArrayList<>();
            Connection conn = getConnection();
            
            String sql = "SELECT l.*, c.course_name_en, c.course_name_ar " +
                         "FROM LECTURE l " +
                         "LEFT JOIN COURSE c  ON  c.course_id = l.course_id " +
                         "WHERE c.COURSE_ID = " + courseId + "  ORDER BY l.LECTURE_ID ASC";
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ResultSet rs = ps.executeQuery();           

            
            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setCourseNameEn(rs.getString("COURSE_NAME_EN"));
                lecture.setCourseNameAr(rs.getString("COURSE_NAME_AR"));
                lecture.setLectureNUM(rs.getInt("LECTURE_NUM"));
                lecture.setLectureNameEN(rs.getString("LECTURE_NAME_EN"));
                lecture.setLectureNameAR(rs.getString("LECTURE_NAME_AR"));
                lecture.setLectureURL(rs.getString("LECTURE_URL"));
               lectures.add(lecture);
           }
            

            rs.close();
            ps.close();
            
            return lectures;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
     
     
    
     
    private Lecture populateLecture(ResultSet rs)
            throws SQLException {
      
        Lecture lecture = new Lecture();
        lecture.setLectureId(rs.getInt("LECTURE_ID"));
        lecture.setCourseId(rs.getInt("COURSE_ID"));
        lecture.setLectureNUM(rs.getInt("LECTURE_NUM"));
        lecture.setLectureNameEN(rs.getString("LECTURE_NAME_EN"));
        lecture.setLectureNameAR(rs.getString("LECTURE_NAME_AR"));                    
        lecture.setLectureURL(rs.getString("LECTURE_URL"));
   
        return lecture;
    }

 public void insertLecture(Lecture lecture) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO LECTURE (LECTURE_ID,"
                    + "  COURSE_ID ,"
                    + " LECTURE_NAME_AR,"
                    + " LECTURE_NAME_EN,"
                    + " LECTURE_URL,"
                    + " LECTURE_NUM,"
                    + " VALUES ((select max(LECTURE_ID) from LECTURE)+1,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setInt(1, lecture.getCourseId());
            ps.setString(2, lecture.getLectureNameAR());
            ps.setString(3, lecture.getLectureNameEN());
            ps.setString(4, lecture.getLectureURL());
            ps.setInt(5, lecture.getLectureNUM());
           
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
 }
 public void deleteLecture(int lectureId) throws Exception {
        Connection conn = getConnection();
        
        try {
            String sql = "DELETE FROM LECTURE WHERE LECTURE_ID=?";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, lectureId);
            
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public Lecture getLecture(int LectureId) throws Exception {
        try {   
            Lecture lecture = null;
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM LECTURE ";
                                          
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, LectureId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                lecture = populateLecture(rs);
            
            }

            rs.close();
            ps.close();
            
            return lecture;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    public void updateLecture(Lecture lecture) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE LECTURE SET LECTURE_NAME_AR=?,"
                    + " LECTURE_NAME_EN=?,"
                    + " LECTURE_URL =?,"
                    + "COURSE_ID = ?,"
                    + "LECTURE_NUM =?,"
                    + " WHERE LECTURE_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, lecture.getCourseId());
            ps.setString(2, lecture.getLectureNameAR());
            ps.setString(3, lecture.getLectureNameEN());
            ps.setString(4, lecture.getLectureURL());
            ps.setInt(5, lecture.getLectureNUM());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
     public static void main(String [] args){        
        try {
            EventsDao dao = new EventsDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(LecturesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}