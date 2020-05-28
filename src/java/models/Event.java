package models;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Firas.Alhawari
 * 
 */
public class Event implements Serializable{
    private int eventId;
    private String nameEn;
    private String nameAr;
    private EventType type;
     private int Lecturenum;
      private int capacity;
    private String placeEn;
    private String placeAr;
    private Timestamp date;
     private String  drNameEn;
     private String  drNameAr;
    private String lectureEn;
    private String lectureAr;
     private String upload;


    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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
        public String getlectureEn() {
        return lectureEn;
    }

    public void setlectureEn(String lectureEn) {
        this.lectureEn = lectureEn;
    }

    public String getlectureAr() {
        return lectureAr;
    }

    public void setlectureAr(String lectureAr) {
        this.lectureAr = lectureAr;
    }


    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }   

    public int getcapacity() {
        return capacity;
    }

    public void setcapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getLecturenum() {
        return Lecturenum;
    }

    public void setLecturenum(int Lecturenum) {
        this.Lecturenum = Lecturenum;
    }

    
        public String getupload() {
        return upload;
    }

    public void setupload(String upload) {
        this.upload = upload;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
