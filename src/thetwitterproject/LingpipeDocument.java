/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

/**
 *
 * @author rashidislam
 */
public class LingpipeDocument {
    
    private String document, classification; 
    
    public LingpipeDocument(String d, String c) {
        document = d; 
        classification = c; 
    }
    
    public void setDocument(String d) {
        document = d; 
    }
    
    public String getDocument() {
        return document; 
    }
    
    public void setClassification(String c) {
        classification = c; 
    }
    
    public String getClassification() {
        return classification; 
    }
    
}
