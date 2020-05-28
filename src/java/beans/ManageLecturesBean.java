/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import daos.EventTypesDao;
import daos.EventsDao;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Event;
import daos.Lectures2Dao;
import java.util.List;
import models.Lecture;

/**
 *
 * 
 */

@Named(value = "manageLecturesBean")
@ViewScoped
public class ManageLecturesBean implements Serializable{
    private Event selectedEvent;
    private final Lectures2Dao lectures2Dao = new Lectures2Dao();
    private Lecture selectedLecture;
    private final EventTypesDao eventTypesDao = new EventTypesDao();
    private final EventsDao eventsDao = new EventsDao();
    private ArrayList<Event> events;
    private final Lectures2Dao lecturesDao = new Lectures2Dao();
    private int eventTypeId;
     private int eventId;
     
    private Lecture lecture;
    private String courseNameEn;
    private String courseNameAr;
    private String uploadEn;
    private String uploadAr;
    private String lecture1;
    private String lecture2;
    private String lecture3;
    private String lecturetitle1EN;
    private String lecturetitle1AR;
    private String lecturetitle2EN;
    private String lecturetitle2AR;
    private String lecturetitle3EN;
    private String lecturetitle3AR;
    private String drNameAr;
    private String drNameEN;

    private List<Lecture> lectures;
 // private Username  selectedUsername;
    @Inject 
    private SessionBean sessionBean;
    
    public ManageLecturesBean() {        
    }       
    
    @PostConstruct
    public void init(){
        try {
      //  courseId = sessionBean.getSelectedItemId();
      //  lecture = lectures2Dao.buildLectures(courseId); 
       
        int courseId = sessionBean.getSelectedItemId();
        lectures = lectures2Dao.buildLectures(courseId);
      
        } catch (Exception ex) {
            Logger.getLogger(ManageLecturesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
     public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }
  public int getEventId() {
        return eventTypeId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;}
      
     public Lecture getSelectedLecture() {
        return selectedLecture;
    }

    public void setSelectedLecture(Lecture selectedLecture) {
        this.selectedLecture = selectedLecture;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }   
    
    
    
    public void searchEvents(){        
    }
    
    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedLecture.getLectureId());
    }
    
    public void deleteSelectedLecture(){
        try {
            eventsDao.deleteEvent(selectedLecture.getLectureId());
        } catch (Exception ex) {
            Logger.getLogger(ManageCoursesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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
      
     public String getLecturetitle1EN() {
        return lecturetitle1EN;
    }

    public void setLecturetitle1EN(String lecturetitle1EN) {
        this.lecturetitle1EN = lecturetitle1EN;
    }
        public String getLecturetitle1AR() {
        return lecturetitle1AR;
    }

    public void setLecturetitle1AR(String lecturetitle1AR) {
        this.lecturetitle1AR = lecturetitle1AR;
    }
    
       public String getLecturetitle2EN() {
        return lecturetitle2EN;
    }

    public void setLecturetitle2EN(String lecturetitle2EN) {
        this.lecturetitle2EN = lecturetitle2EN;
    }
    
        public String getLecturetitle2AR() {
        return lecturetitle2AR;
    }

    public void setLecturetitle2AR(String lecturetitle2AR) {
        this.lecturetitle2AR = lecturetitle2AR;
    }
       public String getLecturetitle3EN() {
        return lecturetitle3EN;
    }

    public void setLecturetitle3EN(String lecturetitle3EN) {
        this.lecturetitle3EN = lecturetitle3EN;
    }
    
           public String getLecturetitle3AR() {
        return lecturetitle3AR;
    }

    public void setLecturetitle3AR(String lecturetitle3AR) {
        this.lecturetitle3AR = lecturetitle3AR;
    }
    
      public String getDrNameAr() {
        return drNameAr;
    }

    public void setDrNameAr(String drNameAr) {
        this.drNameAr = drNameAr;
    }

    public String getDrNameEN() {
        return drNameEN;
    }

    public void setDrNameEN(String drNameEN) {
        this.drNameEN = drNameEN;
    }
         public String getUploadAr() {
        return uploadAr;
    }

    public void setUploadAr(String uploadAr) {
        this.uploadAr = uploadAr;
    }

    public String getUploadEn() {
        return uploadEn;
    }

    public void setUploadEn(String uploadEn) {
        this.uploadEn = uploadEn;
    }
    
     public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
    
}
     

     
     
   
    

    
    
    
    
     
    


