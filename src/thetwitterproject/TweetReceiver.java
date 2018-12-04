/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import java.util.ArrayList;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author rashidislam
 */
class TweetReceiver {

   
    public ArrayList<Status> getTweets(Twitter twitter, String searchQuery) { //The return type of this method matches the var in Main

           
        ArrayList<Status> statuses = new ArrayList<Status>();
        
        Query query = new Query(searchQuery);

        QueryResult result = null;
        
        try {
            result = twitter.search(query);
        } catch (TwitterException e) {
            System.out.println("Something went wrong");
        }
        
        if (result != null) {
            for (Status status : result.getTweets()) {
                statuses.add(status);
            }
        }
        
        return statuses;
    }
       
    
}
