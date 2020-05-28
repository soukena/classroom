package beans;

import daos.CoursesDao;
import daos.EventTypesDao;
import daos.EventsDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Course;
import models.EventType;

/**
 *
 * 
 */
@Named(value = "addEditLectureBean")
@ViewScoped
public class AddEditLectureBean implements Serializable{
    private ArrayList<EventType> eventTypes;
    private ArrayList<Course> courses;
    private final EventTypesDao eventTypesDao = new EventTypesDao();
    private final EventsDao eventsDao = new EventsDao();
    private final CoursesDao coursesDao = new CoursesDao();
    private int eventId;
    private int courseId;
    private int eventTypeId;
    private String nameEn;
    private String nameAr;
    private String placeEn;
    private String placeAr;
    private int capacity;
    private Date date;
    private String  drNameEn;
    private String  drNameAr;
    
    @Inject
    private SessionBean sessionBean;
    
    public AddEditLectureBean() {        
    }
    
    @PostConstruct
    public void init(){                
        try {
            courseId = sessionBean.getSelectedItemId();
            //eventTypes = eventTypesDao.buildEventTypes();
            
            if(courseId > 0){
               Course course = coursesDao.getCourse(courseId);                
                nameEn = course.getCourseNameEn();
                nameAr = course.getCourseNameAr();
               drNameEn = course.getInstructorNameEn();
               drNameAr = course.getInstructorNameAr();
          
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditLectureBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Course> getCourse() {
        return courses;
    }        

    public int getCourseId() {
        return courseId;
    }

    public void setcourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getPlaceEn() {
        return placeEn;
    }

    public void setPlaceEn(String placeEn) {
        this.placeEn = placeEn;
    }

    public String getPlaceAr() {
        return placeAr;
    }

    public void setPlaceAr(String placeAr) {
        this.placeAr = placeAr;
    }

    public int getcapacity() {
        return capacity;
    }

    public void setLecture(int capacity) {
        this.capacity = capacity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }        
        
    public void saveEvent() {
        try {
           Course course = new Course();
            
           
           course.setCourseId(courseId);
           course.setCourseNameEn(nameEn);
           course.setCourseNameAr(nameAr);
           course.setInstructorNameEn(drNameEn);
           course.setInstructorNameAr(drNameAr);
            
           
            
            if (sessionBean.getSelectedItemId() > 0) {
                coursesDao.updatecourse(course);
            } else {
                coursesDao.insertcourse(course);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditLectureBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("manage_events");
    }
            public String getDrNameEn() {
        return drNameEn;
    }

    public void setDrNameEn(String drNameEn) {
        this.drNameEn = drNameEn;
    }
                

    public String getDrNameAr() {
        return drNameAr;
    }

    public void setDrNameAr(String drNameAr) {
        this.drNameAr = drNameAr;
    }
}
