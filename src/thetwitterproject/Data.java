/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import java.util.ArrayList;
import twitter4j.Place;
import twitter4j.Status;

/**
 *
 * @author rashidislam
 */
public class Data {
        
    private Status status; //from twitter4j
    
    //from our own classes
    private StatusInformation statusInfo; 
    private UserInformation userInfo;
    private PlaceInformation placeInfo;
    
    private double stanfordPolarity, lingpipePolarity, overallPolarity; 
    
//    public Data() {
//        
//    }
    
    public Data(Status status){ //take status one at a time from arraylist and fills out the details
         this.status = status;
         this.statusInfo = new StatusInformation(); //for the variables declared above
         this.userInfo = new UserInformation();
         this.placeInfo = new PlaceInformation();
         
         populateStatusInformation();
         populatePlaceInformation(); 
         populateUserInformation(); 
    }
    
    public void populateStatusInformation(){
    
        statusInfo.setUser(this.status.getUser());
        statusInfo.setPlace(this.status.getPlace());
        statusInfo.setgLocation(this.status.getGeoLocation());
        statusInfo.setFavouriteCount(this.status.getFavoriteCount());
        statusInfo.setRetweetCount(this.status.getRetweetCount());
        statusInfo.setOriginalText(this.status.getText());
        statusInfo.setFavourited(this.status.isFavorited());
        statusInfo.setRetweeted(this.status.isRetweeted());
    }
    
    public void populatePlaceInformation(){
        Place place = this.status.getPlace();
        if (place != null){
           placeInfo.setCountry(place.getCountry());
        }else{
           placeInfo.setCountry("Country information not available");
        }
    }

    public void populateUserInformation(){
        userInfo.setFollowersCount(this.status.getUser().getFollowersCount());
        userInfo.setLanguage(this.status.getUser().getLang());
        userInfo.setLocation(this.status.getUser().getLocation());
        userInfo.setVerified(this.status.getUser().isVerified());
    }    

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StatusInformation getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(StatusInformation statusInfo) {
        this.statusInfo = statusInfo;
    }

    public UserInformation getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInformation userInfo) {
        this.userInfo = userInfo;
    }

    public PlaceInformation getPlaceInfo() {
        return placeInfo;
    }

    public void setPlaceInfo(PlaceInformation placeInfo) {
        this.placeInfo = placeInfo;
    }
    
    public void setStanfordPolarity(double catchPolarity) {
        stanfordPolarity = catchPolarity;
    }
    
    public double getStanfordPolarity() {
        return stanfordPolarity; 
    }
    
    public void setLingpipePolarity(double catchPolarity) {
        lingpipePolarity = catchPolarity; 
    }
    
    public double getLingpipePolarity() {
        return lingpipePolarity; 
    }
    
    public void overallPolarity() {
        double op = lingpipePolarity + stanfordPolarity; 
        setPolarity(op); 
    }
    
    public void setPolarity(double catchOP) {
        overallPolarity = catchOP; 
    }
    
    public double getOverallPolarity() {
        return overallPolarity; 
    }
    
}
