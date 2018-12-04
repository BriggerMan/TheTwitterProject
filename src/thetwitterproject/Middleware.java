/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import java.io.File;
import java.util.Vector;

/**
 *
 * @author rashidislam
 */
public class Middleware {
    
    private String sentence; 
    private double sentimentCore, sentimentLing;
    
    public Middleware(String s) {
        sentence = s; 
        sentimentCore = -1921974;
    }
    
    public void setSentence(String s) {
        sentence = s;
    }
    
    public String getSentence() {
        return sentence; 
    }
    
    public double getSentimentCoreNLP() {
        if(sentimentCore == -1921974) {
            StanfordBackEnd cnlps = new StanfordBackEnd(); 
            sentimentCore = cnlps.getSentiment(sentence); 
        }
        return sentimentCore; 
    }
    
    public double getSentimentLingpipe() {
        if(sentimentLing == -1921974) {
            System.err.println("No data yet. Cannot initialise sentiment Lingpipe score without a model.");
            return 0; 
        }
        return sentimentLing; 
    }
    
    public double getSentimentLingpipe(String model) throws Exception {
        LingpipeBackEnd lpbe = new LingpipeBackEnd(model); 
        sentimentLing = lpbe.getSentiment(sentence);
        return sentimentLing; 
    }
    
}
