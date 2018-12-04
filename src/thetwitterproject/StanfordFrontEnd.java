/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rashidislam
 */
public class StanfordFrontEnd {
    
    public StanfordFrontEnd() throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader("data/corpus/nytimes_news_articles.txt")); 
        ArrayList<String> list = new ArrayList<String>(); 
        int count = 0; 
        while(s.hasNext()) {
            s.nextLine();
            s.nextLine(); 
            String text = ""; 
            while(s.hasNext()) {
                String line = s.nextLine(); 
                if(line.isEmpty()) break; 
                text += line + " "; 
            }
            list.add(text);
            count++; 
            if(count == 10) break; 
        }
        s.close(); 
        System.out.println("STANFORD TRAINING END");
    }
    
    public double getStanfordSentiment(String catchPhrase) throws FileNotFoundException, IOException, Exception {
        Middleware mw = new Middleware(catchPhrase);
        return mw.getSentimentCoreNLP(); 
    }
    
}
