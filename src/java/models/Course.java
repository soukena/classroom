/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 *
 */
public class Course {
    
    private int courseId;
    private String courseNameEn;
    private String courseNameAr;
    private String instructorNameEn;
    private String instructorNameAr;
    
    public int getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(int cousreId) {
        this.courseId = cousreId;
    }

    public String getCourseNameEn() {
        return courseNameEn;
    }

    public void setCourseNameEn(String courseNameEn) {
        this.courseNameEn = courseNameEn;
    }

    public String getCourseNameAr() {
        return courseNameAr;
    }

    public void setCourseNameAr(String courseNameAr) {
        this.courseNameAr = courseNameAr;
    }

    public String getInstructorNameEn() {
        return instructorNameEn;
    }

    public void setInstructorNameEn(String instructorNameEn) {
        this.instructorNameEn = instructorNameEn;
    }

    public String getInstructorNameAr() {
        return instructorNameAr;
    }

    public void setInstructorNameAr(String instructorNameAr) {
        this.instructorNameAr = instructorNameAr;
    }
    
}
