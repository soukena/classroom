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
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Course;

/**
 *
 * @author User
 */
public class CoursesDao extends ConnectionDao {     
    public ArrayList<Course> buildCourses() throws Exception {
        ArrayList<Course> courses = new ArrayList<>();
        Connection conn = getConnection();
        
        try {
           
            String sql = "SELECT * FROM COURSE ORDER BY COURSE_ID ASC";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                courses.add(populateCourse(rs));
            }
        
            rs.close();
            ps.close();

    return courses;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        }
    
    
     
    private Course populateCourse(ResultSet rs)
            throws SQLException {
        Course course = new Course();
        
        course.setCourseId(rs.getInt("COURSE_ID"));
        course.setCourseNameEn(rs.getString("COURSE_NAME_EN"));
        course.setCourseNameAr(rs.getString("COURSE_NAME_AR"));                    
        course.setInstructorNameEn(rs.getString("INSTRUCTOR_NAME_EN"));  
        course.setInstructorNameAr(rs.getString("INSTRUCTOR_NAME_AR"));
             
   
        return course;
    }
    
    
    
    
    
    
    
    
    
    
    
    
public void insertcourse(Course course) throws Exception {                
        try {
            Connection conn = getConnection();
            
            String sql = "INSERT INTO COURSE (COURSE_ID,"
                   
                    + " COURSE_NAME_AR,"
                    + " COURSE_NAME_EN,"
                    + " INSTRUCTORE_NAME_EN,"
                    + " INSTRUCTORE_NAME_EN,"
                    + " VALUES ((select max(COURSE_ID) from COURSE)+1,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql); 
            
            ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getCourseNameEn());
            ps.setString(3, course.getCourseNameAr());
            ps.setString(4, course.getInstructorNameEn());
            ps.setString(5, course.getInstructorNameAr());
           
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }} 
 public void updatecourse(Course course) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE COURSE SET COURSE_NAME_AR=?,"
                    + " COURSE_NAME_EN=?,"
                    + " INSTRUCTORE_NAME_EN =?,"
                    +"  INSTRUCTORE_NAME_EN =?,"
                    + " WHERE COURSE_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getCourseNameEn());
            ps.setString(3, course.getCourseNameAr());
            ps.setString(4, course.getInstructorNameEn());
            ps.setString(5, course.getInstructorNameAr());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
 
  public Course getCourse(int CourseId) throws Exception {
        try {   
            Course course = null;
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM COURSE ";
                                          
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setInt(1, CourseId);
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                course = populateCourse(rs);
            
            }

            rs.close();
            ps.close();
            
            return course;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
      public static void main(String [] args){        
        try {
           CoursesDao dao = new CoursesDao();                
            //ArrayList<Event> events = dao.buildEvents();
        } catch (Exception ex) {
            Logger.getLogger(CoursesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
 
    
    