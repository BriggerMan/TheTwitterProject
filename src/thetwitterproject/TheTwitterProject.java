/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import java.util.ArrayList;
import java.util.Scanner;
import twitter4j.Status;
import twitter4j.Twitter;



/**
 *
 * @author rashidislam
 */
public class TheTwitterProject {
    
    public void launchTheTwitterProject(String catchSearchQuery) throws Exception {
        
        Scanner input = new Scanner(System.in); 
        
        AuthenticateTwitter authTwitter = new AuthenticateTwitter(); 
        Twitter twitter = authTwitter.Authenticate(); 
        
        String searchQuery = catchSearchQuery; 
        
        GetSomeTweets getSomeTweets = new GetSomeTweets(); 
        
        ArrayList<Status> originalSet = new ArrayList<Status>(); 
        originalSet = getSomeTweets.getThoseTweets(twitter, searchQuery); //Retrieving tweets
        
        ArrayList<Data> ourTweets = new ArrayList<Data>(); 
        
        //Each tweet is its own Data object 
        for(int i = 0; i < originalSet.size(); i++) {
           Data d1 = new Data(originalSet.get(i)); 
           ourTweets.add(d1);
       }
        
        //Pre processing
        for(int i = 0; i < ourTweets.size(); i++) {
            
            CleanerClass cc = new CleanerClass(); 
            
            ourTweets.get(i).getStatusInfo().setOriginalText(cc.removeRT(ourTweets.get(i).getStatusInfo().getOriginalText()));
            ourTweets.get(i).getStatusInfo().setOriginalText(cc.removeHashtags(ourTweets.get(i).getStatusInfo().getOriginalText())); 
            ourTweets.get(i).getStatusInfo().setOriginalText(cc.removeLinks(ourTweets.get(i).getStatusInfo().getOriginalText())); 
            ourTweets.get(i).getStatusInfo().setOriginalText(cc.removeEmojis(ourTweets.get(i).getStatusInfo().getOriginalText()));
            ourTweets.get(i).getStatusInfo().setOriginalText(cc.removeUsernameEmails(ourTweets.get(i).getStatusInfo().getOriginalText()));
            
        }
        
        //Stanford 
        StanfordFrontEnd sfe = new StanfordFrontEnd(); 
        for(int i = 0; i < ourTweets.size(); i++) {
            ourTweets.get(i).setStanfordPolarity(sfe.getStanfordSentiment(ourTweets.get(i).getStatusInfo().getOriginalText()));
        }
        
        //Lingpipe
        LingpipeFrontEnd lfe = new LingpipeFrontEnd();
        for(int i = 0; i < ourTweets.size(); i++) { 
            ourTweets.get(i).setLingpipePolarity(lfe.getLingpipeSentiment(ourTweets.get(i).getStatusInfo().getOriginalText()));
        }
        
        for(int i = 0; i < ourTweets.size(); i++) {
            ourTweets.get(i).overallPolarity(); 
        }
        
        HTMLGenerator htmlGenerator = new HTMLGenerator();
        try {
            htmlGenerator.displayHTML(ourTweets, searchQuery);
        } catch(Exception e) {
            e.printStackTrace(); 
        }
        
        System.out.println("SENTIMENT ANALYSIS DONE");
        
        System.out.println("");
        
        for(int i = 0; i < ourTweets.size(); i++) {
            System.out.println(i + ": " + ourTweets.get(i).getStatusInfo().getOriginalText());
        }
        
        System.out.println("");
        System.out.println("------------------------------------------");
        System.out.println("");
        System.out.println("Stanford Core NLP Polarity");
        
        for(int i = 0; i < ourTweets.size(); i++) {
            System.out.println(i + ": " + ourTweets.get(i).getStanfordPolarity());
        }
        
        System.out.println("");
        System.out.println("------------------------------------------");
        System.out.println("");
        System.out.println("Lingpipe Polarity");
        
        for(int i = 0; i < ourTweets.size(); i++) {
            System.out.println(i + ": " + ourTweets.get(i).getLingpipePolarity());
        }
        
        System.out.println("");
        System.out.println("------------------------------------------");
        System.out.println("");
        System.out.println("Overall Polarity");
        
        for(int i = 0; i < ourTweets.size(); i++) {
            System.out.println(i + ": " + ourTweets.get(i).getOverallPolarity());
        }
        
    }

}