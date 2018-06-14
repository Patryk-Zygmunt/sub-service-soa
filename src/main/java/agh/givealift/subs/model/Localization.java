package agh.givealift.subs.model;

import agh.givealift.subs.model.entity.City;

import java.util.Date;


public class Localization {
    private City city;
    private String placeOfMeeting;
    private Date date;
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPlaceOfMeeting() {
        return placeOfMeeting;
    }

    public void setPlaceOfMeeting(String placeOfMeeting) {
        this.placeOfMeeting = placeOfMeeting;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
