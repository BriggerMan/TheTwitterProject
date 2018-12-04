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
public class GetSomeTweets {
    
    public GetSomeTweets() {
        
    }
    
    public ArrayList getThoseTweets(Twitter twitter, String searchQuery) {
        
        TweetReceiver tweetReceiver = new TweetReceiver(); 
        ArrayList<Status> retrievedTweets = tweetReceiver.getTweets(twitter, searchQuery);
        
        return retrievedTweets; 
        
    }
    
}
