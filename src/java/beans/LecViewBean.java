/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import daos.EventTypesDao;
import daos.EventsDao;
import daos.LecturesDao;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import models.Event;
import models.EventType;
import models.Lecture;

/**
 *
 * 
 */
@Named(value = "LecViewBean")
@ViewScoped
public class LecViewBean implements Serializable{
    private ArrayList<EventType> eventTypes;
    private final EventTypesDao eventTypesDao = new EventTypesDao();
    private final EventsDao eventsDao = new EventsDao();
    private final LecturesDao lecturesDao = new LecturesDao();
    private Lecture lecture;
    private int eventId;
    private int courseId;
    private int eventTypeId;
    private String nameEn;
    private String nameAr;
    private String placeEn;
    private String placeAr;
    private int capacity;
    private Date date;
    
    @Inject
    private SessionBean sessionBean;
    
    public LecViewBean() {        
    }
    
    @PostConstruct
    public void init(){    
        try {

           courseId = sessionBean.getSelectedItemId();
           lecture = lecturesDao.buildLectures(courseId);

  
 //            eventId = sessionBean.getSelectedItemId();
            //eventTypes = eventTypesDao.buildEventTypes();
//            setEventTypeId(5);
           
//            if(eventId > 0){
//                
//                if(eventId == 1){
//                    setCourseNameEn("Advanced software analysis and design");
//                    setCourseNameAr("تحليل وتصميم البرمجيات المتقدمة");
//                    setLecture1("https://www.youtube.com/watch?v=IzN9Vuoivrg&list=PL6XklZATqYx9dj72MKG6wLYjljeB2odra");
//                    setLecture2("https://www.youtube.com/watch?v=jzC2RGMQWFE&list=PL6XklZATqYx9dj72MKG6wLYjljeB2odra&index=2");
//                    setLecture3("https://www.youtube.com/watch?v=QPSMD1H9pnE&list=PL6XklZATqYx9dj72MKG6wLYjljeB2odra&index=4");
//                }
//                
//                if(eventId == 2){
//                    setCourseNameEn("Advanced digital systems");
//                    setCourseNameAr("الانظمة الرقمية المتقدمة");
//                    setLecture1("https://www.youtube.com/watch?v=AaN72s5WfOM&list=PLA3DPMKzhlJ_i-Igz3-YgVn_hDSVKsAuS");
//                    setLecture2("https://www.youtube.com/watch?v=NbON135lf60&list=PLA3DPMKzhlJ_i-Igz3-YgVn_hDSVKsAuS&index=2");
//                    setLecture3("https://www.youtube.com/watch?v=HjD5mVbbBK4&list=PLA3DPMKzhlJ_i-Igz3-YgVn_hDSVKsAuS&index=3");
//                }
//                
//                if(eventId == 3){
//                    setCourseNameEn("Mobile computing");
//                    setCourseNameAr("الحاسبات المحمولة");
//                    setLecture1("https://www.youtube.com/watch?v=5kBknJWi71Q&list=PLrjkTql3jnm-kLRBgIt8kvuwbTScoI2IJ");
//                    setLecture2("https://www.youtube.com/watch?v=t6XFH396rQc&list=PLrjkTql3jnm-kLRBgIt8kvuwbTScoI2IJ&index=2");
//                    setLecture3("https://www.youtube.com/watch?v=U3Hpe-ePSpw&list=PLrjkTql3jnm-kLRBgIt8kvuwbTScoI2IJ&index=3");
//                }
                
//                Event event = eventsDao.getEvent(eventId);                
//                nameEn = event.getNameEn();
//                nameAr = event.getNameAr();
//                placeEn = event.getPlaceEn();
//                placeAr = event.getPlaceAr();
//                capacity = event.getCapacity();
//                date = event.getDate();
//                eventTypeId = event.getType().getTypeId();
//            }
        } catch (Exception ex) {
            Logger.getLogger(LecViewBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<EventType> getEventTypes() {
        return eventTypes;
    }        

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
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

    public void setcapacity(int capacity) {
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
            Event event = new Event();
            
            EventType eventType = eventTypes.get(eventTypeId - 1);
            event.setEventId(eventId);
            event.setType(eventType);
            event.setNameEn(nameEn);
            event.setNameAr(nameAr);
            event.setPlaceEn(placeEn);
            event.setPlaceAr(placeAr);
            event.setcapacity(capacity);
            event.setDate(new Timestamp(date.getTime()));
            
            if (sessionBean.getSelectedItemId() > 0) {
                eventsDao.updateEvent(event);
            } else {
                eventsDao.insertEvent(event);
            }
        } catch (Exception ex) {
            Logger.getLogger(LecViewBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("manage_events");
    }
    
    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
