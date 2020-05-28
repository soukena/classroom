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
import models.Course;
import models.Event;
import daos.CoursesDao;
import models.Lecture;

/**
 *
 * 
 */
@Named(value = "manageCoursesBean")
@ViewScoped
public class ManageCoursesBean implements Serializable{
    private Event selectedEvent;
    private final CoursesDao coursesDao = new CoursesDao();
    private Course selectedCourse;
        private Lecture selectedLecture;

    private final EventTypesDao eventTypesDao = new EventTypesDao();
    private final EventsDao eventsDao = new EventsDao();
    private ArrayList<Event> events; 
    private ArrayList<Course> courses;
        private ArrayList<Lecture> lectures;

    private String lecture; 
 // private Username  selectedUsername;
    @Inject 
    private SessionBean sessionBean;
    
    public ManageCoursesBean() {        
    }       
    
    @PostConstruct
    public void init(){
        try {
          courses = coursesDao.buildCourses();  
        } catch (Exception ex) {
            Logger.getLogger(ManageCoursesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   }
    public void ManageAction (){
        if(this.selectedCourse != null) {
            sessionBean.setSelectedItemId(this.selectedCourse.getCourseId());
        }
    }

    public void view_lectures (){
        if(this.selectedCourse != null) {
            sessionBean.setSelectedItemId(this.selectedCourse.getCourseId());
        }
    }
  public void UplodeAction (){
        if(this.selectedCourse != null) {
            sessionBean.setSelectedItemId(this.selectedCourse.getCourseId());
        }
    }
    public Event getSelectedEvent() {
        return selectedEvent;
    }

  //  public void setSelectedEvent(Event selectedEvent) {
//        this.selectedEvent = selectedEvent;
 //   }  
 //   public Event getSelectedUsername() {
       // return selectedUsername;
 //   }
 
    
     public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
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
     public ArrayList<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(ArrayList<Lecture> lectures) {
        this.lectures = lectures;
    } 
    
     public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
    public void searchEvents(){        
    }
    
    public void saveSelectedItemId(){
        sessionBean.setSelectedItemId(selectedCourse.getCourseId());
    }
    
    public void deleteSelectedEvent(){
        try {
            eventsDao.deleteEvent(selectedCourse.getCourseId());
        } catch (Exception ex) {
            Logger.getLogger(ManageCoursesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getlecture() {
        return lecture;
    }
 
    public void setlecture(String lecture) {
        this.lecture = lecture;
    }
    
    
    
    
    
     
    }
