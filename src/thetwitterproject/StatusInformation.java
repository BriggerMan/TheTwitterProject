/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import twitter4j.GeoLocation;
import twitter4j.Place;
import twitter4j.User;

/**
 *
 * @author rashidislam 
*/
public class StatusInformation {
    
    private User user;
    private Place place;
    private GeoLocation gLocation;
    private int favouriteCount;
    private String language;
    private int retweetCount;
    private String originalText;
    private String preProcessedText; 
    private int polarity; 
    private boolean favourited;
    private boolean retweeted;
    //getwithheldcountries

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public GeoLocation getgLocation() {
        return gLocation;
    }

    public void setgLocation(GeoLocation gLocation) {
        this.gLocation = gLocation;
    }

    public int getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(int favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getPreProcessedText() {
        return preProcessedText; 
    }
    
    public void setPreProcessedText(String preProcessedText) {
        this.preProcessedText = preProcessedText; 
    }
    
    public int getPolarity() {
        return polarity; 
    }
    
    public void setPolarity(int polarity) {
        this.polarity = polarity;
    }
    
    public boolean isFavourited() {
        return favourited;
    }

    public void setFavourited(boolean favourited) {
        this.favourited = favourited;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }
    
   
}
