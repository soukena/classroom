package models;

import beans.SessionBean;
import java.io.Serializable;
import javax.inject.Inject;


/**
 *
 * @author Firas.Alhawari
 * 
 */
public class Lecture  implements Serializable{

    public static void add(Lecture software) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int courseId;
    private int lectureId;
    private int lectureNUM;
  
    private String lectureNameEN;
    private String lectureNameAR;
    private String lectureURL;
    
    private String LECTURE_URL1;
    private String LECTURE_URL2;
    private String LECTURE_URL3;
    private String upload;
     
    private String courseNameEn;
    private String courseNameAr;
    private String lecture1;
    private String lecture2;
    private String lecture3;
    private String lecture1NameEn;
    private String lecture1NameAr;
    private String lecture2NameEn;
    private String lecture2NameAr;
    private String lecture3NameEn;
    private String lecture3NameAr;
 

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
     public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }
     public int getLectureNUM() {
        return lectureNUM;
    }

    public void setLectureNUM(int lectureNUM) {
        this.lectureNUM = lectureNUM;
    }
    
    public String getLectureNameEN() {
        return lectureNameEN;
    }

    public void setLectureNameEN(String lectureNameEN) {
        this.lectureNameEN = lectureNameEN;
    }

    public String getLectureNameAR() {
        return lectureNameAR;
    }

    public void setLectureNameAR(String lectureNameAR) {
        this.lectureNameAR = lectureNameAR;
    }
        public String getLectureURL() {
        return lectureURL;
    }

    public void setLectureURL(String lectureURL) {
        this.lectureURL = lectureURL;
    }

    
        public String getLECTURE_URL1() {
        return LECTURE_URL1;
    }

    public void setLECTURE_URL1(String LECTURE_URL1) {
        this.LECTURE_URL1 = LECTURE_URL1;
    }
          public String getLECTURE_URL2() {
        return LECTURE_URL2;
    }

    public void setLECTURE_URL2(String LECTURE_URL2) {
        this.LECTURE_URL2 = LECTURE_URL2;
    }
    
          public String getLECTURE_URL3() {
        return LECTURE_URL3;
    }

    public void setLECTURE_URL3(String LECTURE_URL3) {
        this.LECTURE_URL3 = LECTURE_URL3;
    }
    
        public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
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

    public String getLecture1() {
        return lecture1;
    }

    public void setLecture1(String lecture1) {
        this.lecture1 = lecture1;
    }

    public String getLecture2() {
        return lecture2;
    }

    public void setLecture2(String lecture2) {
        this.lecture2 = lecture2;
    }

    public String getLecture3() {
        return lecture3;
    }

    public void setLecture3(String lecture3) {
        this.lecture3 = lecture3;
    }

    public String getLecture1NameEn() {
        return lecture1NameEn;
    }

    public void setLecture1NameEn(String lecture1NameEn) {
        this.lecture1NameEn = lecture1NameEn;
    }

    public String getLecture1NameAr() {
        return lecture1NameAr;
    }

    public void setLecture1NameAr(String lecture1NameAr) {
        this.lecture1NameAr = lecture1NameAr;
    }

    public String getLecture2NameEn() {
        return lecture2NameEn;
    }

    public void setLecture2NameEn(String lecture2NameEn) {
        this.lecture2NameEn = lecture2NameEn;
    }

    public String getLecture2NameAr() {
        return lecture2NameAr;
    }

    public void setLecture2NameAr(String lecture2NameAr) {
        this.lecture2NameAr = lecture2NameAr;
    }

    public String getLecture3NameEn() {
        return lecture3NameEn;
    }

    public void setLecture3NameEn(String lecture3NameEn) {
        this.lecture3NameEn = lecture3NameEn;
    }

    public String getLecture3NameAr() {
        return lecture3NameAr;
    }

    public void setLecture3NameAr(String lecture3NameAr) {
        this.lecture3NameAr = lecture3NameAr;
    }
    
  

}
