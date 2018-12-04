/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import java.util.ArrayList;
import twitter4j.Status;
import twitter4j.Twitter;

/**
 *
 * @author rashidislam
 */
public class GetSomeTweetsOld {
    
    TweetReceiver tweetReceiver; 
    
    ArrayList<Data> dataCollection = new ArrayList<Data>();
    
    public GetSomeTweetsOld() {
        this.tweetReceiver = new TweetReceiver(); 
    }
    
    public ArrayList RetrieveTweets(Twitter twitter, String searchQuery) {
        
        ArrayList<Status> retrievedTweets = tweetReceiver.getTweets(twitter, searchQuery); 
        
        for(int i = 0; i < retrievedTweets.size(); i++) {
            
            Data data = new Data(retrievedTweets.get(i)); 
            
            data.populateStatusInformation();
            data.populatePlaceInformation();
            data.populateUserInformation();
            
            dataCollection.add(data);
            
        }
        
        return dataCollection; 
        
    }
    
    public void PrintTweetDetails() {
        
        for(int i = 0; i < dataCollection.size(); i++) {
             
            StatusInformation statusInfo = dataCollection.get(i).getStatusInfo();
            UserInformation userInfo = dataCollection.get(i).getUserInfo();
            PlaceInformation placeInfo = dataCollection.get(i).getPlaceInfo();
            
            System.out.println("user: " + statusInfo.getUser());
            System.out.println("place: " + statusInfo.getPlace());
            System.out.println("gLocation: " + statusInfo.getgLocation());
            System.out.println("favourite count: " + statusInfo.getFavouriteCount());
            System.out.println("language: " + statusInfo.getLanguage());
            System.out.println("retweet count: " + statusInfo.getRetweetCount());
            System.out.println("text: " + statusInfo.getOriginalText());
            System.out.println("is favourited: " + statusInfo.isFavourited());
            System.out.println("is retweeted: " + statusInfo.isRetweeted());
            
            System.out.println("------------------------------------------------------------");
            
            System.out.println("followers count: " + userInfo.getFollowersCount());
            System.out.println("language: " + userInfo.getLanguage());
            System.out.println("location: " + userInfo.getLocation());
            System.out.println("verified: " + userInfo.isVerified());
            
            System.out.println("------------------------------------------------------------");
            
            System.out.println("country: " + placeInfo.getCountry());
            
            System.out.println("***********************************************************");
        }
        
    }
    
}