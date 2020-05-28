package beans;

import daos.EventTypesDao;
import daos.EventsDao;
import daos.Lectures2Dao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.EventType;
import models.Lecture;

/**
 *
 * 
 */
@Named(value = "updateLectureBean")
@ViewScoped
public class UpdateLectureBean implements Serializable{
    private ArrayList<EventType> eventTypes;
    private ArrayList<Lecture> lecture;
    private final EventTypesDao eventTypesDao = new EventTypesDao();
    private final EventsDao eventsDao = new EventsDao();
    private final Lectures2Dao lecturs2Dao = new Lectures2Dao();
    private int eventId;
     private int lectureId;
    private int eventTypeId;
     private String lectureURL;
    private String lectureEn;
    private String lectureAr;
   
   
    private String  upload;
    
    @Inject
    private SessionBean sessionBean;
    
    public UpdateLectureBean() {        
    }
    
    @PostConstruct
    public void init(){                
        try {
            lectureId = sessionBean.getSelectedItemId();
            //eventTypes = eventTypesDao.buildEventTypes();
            
            if(lectureId > 0){
               Lecture lectur = lecturs2Dao.getLecture(lectureId);                
             
                lectureId = lectur.getLectureId();
                lectureAr= lectur.getLectureNameAR();
                lectureEn= lectur.getLectureNameEN();
                 lectureURL = lectur.getLectureURL();
                
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateLectureBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Lecture> getlecture() {
        return lecture;
    }        

    public int getlectureId() {
        return lectureId;
    }

    public void setlectureId(int lectureId) {
        this.lectureId = lectureId;
    }


    
    public String getLectureEn() {
        return lectureEn;
    }

    public void setLectureEn(String lectureEn) {
        this.lectureEn = lectureEn;
    }

    public String getLectureAr() {
        return lectureAr;
    }

    public void setLectureAr(String lectureAr) {
        this.lectureAr = lectureAr;
    }

      public String getupload() {
        return upload;
    }

    public void setupload(String upload) {
        this.upload = upload;
    }

   
    public void saveEvent() {
        try {
            Lecture lect = new Lecture();
            
           
            lect.setLectureId(lectureId);
       
           lect.setLectureNameEN(lectureEn);
            lect.setLectureNameAR(lectureAr);
          lect.setLectureURL(lectureURL);
            
            if (sessionBean.getSelectedItemId() > 0) {
                lecturs2Dao.updateLecture(lect);
            } else {
               lecturs2Dao.insertLecture(lect);
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateLectureBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("ManagLectures");
    }
      
 
}
