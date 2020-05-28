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
import models.Lecture;

/**
 *
 *  
 */
public class LecturesDao extends ConnectionDao {
    
    public Lecture buildLectures(int courseId) throws Exception {
        try {   
            Lecture lecture = new Lecture();
            Connection conn = getConnection();
            
            String sql = "SELECT l.*, c.course_name_en, c.course_name_ar " +
                         "FROM LECTURE l " +
                         "LEFT JOIN COURSE c  ON  c.course_id = l.course_id " +
                         "WHERE c.COURSE_ID = " + courseId + "  ORDER BY l.LECTURE_ID ASC";
            PreparedStatement ps = conn.prepareStatement(sql);            
            
            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
              lecture.setCourseNameEn(rs.getString("COURSE_NAME_EN"));
              lecture.setCourseNameAr(rs.getString("COURSE_NAME_AR"));
                if (rs.getInt("LECTURE_NUM") == 1) {
                    lecture.setLecture1(rs.getString("LECTURE_URL"));
                    lecture.setLecture1NameAr(rs.getString("LECTURE_NAME_AR"));
                    lecture.setLecture1NameEn(rs.getString("LECTURE_NAME_EN"));
                }
                if (rs.getInt("LECTURE_NUM") == 2) {
                    lecture.setLecture2(rs.getString("LECTURE_URL"));
                    lecture.setLecture2NameAr(rs.getString("LECTURE_NAME_AR"));
                   lecture. setLecture2NameEn(rs.getString("LECTURE_NAME_EN"));
                }
                if (rs.getInt("LECTURE_NUM") == 3) {
                   lecture.setLecture3(rs.getString("LECTURE_URL"));   
                   lecture.setLecture3NameAr(rs.getString("LECTURE_NAME_AR"));
                   lecture.setLecture3NameEn(rs.getString("LECTURE_NAME_EN"));
               }
           }
            

            rs.close();
            ps.close();
            
            return lecture;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    
    
    
    
     
}
    
   
