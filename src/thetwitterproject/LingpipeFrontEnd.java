/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rashidislam
 */
public class LingpipeFrontEnd {
    
    public LingpipeFrontEnd() throws FileNotFoundException, Exception {
        ArrayList<String> docs = new ArrayList<String>(); 
        ArrayList<String> classes = new ArrayList<String>(); 
        File dir = new File("data/util/txt_sentoken/neg");
        for(File file : dir.listFiles()) {
            if(file.isDirectory()) continue;
            Scanner s = new Scanner(file); 
            String doc = "";
            while(s.hasNext())
                doc += s.nextLine() + " "; 
            s.close(); 
            docs.add(doc); 
            classes.add("0.0");
        }
        dir = new File("data/util/txt_sentoken/pos"); 
        for(File file : dir.listFiles()) {
            if(file.isDirectory()) continue; 
            Scanner s = new Scanner(file); 
            String doc = ""; 
            while(s.hasNext())
                doc += s.nextLine() + " "; 
            s.close();
            docs.add(doc); 
            classes.add("1.0"); 
        }
        LingpipeCollection collection = new LingpipeCollection(docs, classes); 
        collection.createLingpipeSentimentModel(); 
        System.out.println("LINGPIPE TRAINING END");
    }
    
    public double getLingpipeSentiment(String catchPhrase) throws FileNotFoundException, IOException, Exception{ 
        Middleware mw = new Middleware(catchPhrase);
        return mw.getSentimentLingpipe("model/lingpipe/sentiment.model"); 
    }
    
}
