/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rashidislam
 */
public class HTMLGenerator {
    
    public HTMLGenerator() {
        
    }
    
    public void displayHTML(ArrayList<Data> ourTweets, String catchPhrase) throws IOException{
            
       String searchQuery = catchPhrase; 
        
       //Overall
       int oTrulyPositive = 0, oPositive = 0, oNegative = 0, oTrulyNegative = 0;
       for(int i = 0; i < ourTweets.size(); i++) {
           if(ourTweets.get(i).getOverallPolarity() == 4) {
               oTrulyPositive++; 
           } else if(ourTweets.get(i).getOverallPolarity() == 3) {
               oPositive++;
           } else if(ourTweets.get(i).getOverallPolarity() == 2) {
               oNegative++; 
           } else if(ourTweets.get(i).getOverallPolarity() == 1) {
               oTrulyNegative++; 
           }
       }
       
       //Stanford
       int sPositive = 0, sNeutral = 0, sNegative = 0; 
       for(int i = 0; i < ourTweets.size(); i++) {
           if(ourTweets.get(i).getStanfordPolarity() == 3) {
               sPositive++; 
           } else if(ourTweets.get(i).getStanfordPolarity() == 2) {
               sNeutral++; 
           } else if(ourTweets.get(i).getStanfordPolarity() == 1) {
               sNegative++; 
           }
       }
       
       //Lingpipe
       int lPositive = 0, lNegative = 0; 
       for(int i = 0; i < ourTweets.size(); i++) {
           if(ourTweets.get(i).getLingpipePolarity() == 1) {
               lPositive++; 
           } else if(ourTweets.get(i).getLingpipePolarity() == 0) {
               lNegative++; 
           }
       }
        
       StringBuilder sb = new StringBuilder();
    
       sb.append("<html>");
       sb.append("<head>");
       sb.append("<title>The Twitter Project</title>");
       sb.append("<script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js'></script>");
       sb.append("<style>div{width:600px; height:600px; display:inline-block; margin-left:150px;} canvas{margin-top:100px;} h1,h2 {margin:100px; text-align:center;}</style>");
       sb.append("</head>");
       sb.append("<body>");
       sb.append("<h1>Sentiment Scores for Search Query: " + searchQuery + "</h1>");
       
       sb.append("<div><h2>Overall Sentiment Results</h2><canvas id='result1'></canvas></div>");
       sb.append("<div><h2>Stanford Core NLP Sentiment Results</h2><canvas id='result2'></canvas></div>");
       sb.append("<div><h2>Lingpipe Sentiment Results</h2><canvas id='result3'></canvas></div>");
      
       sb.append("<script>");
       
       sb.append("var ctx = document.getElementById('result1').getContext('2d'); \n");
       sb.append("var chart = new Chart(ctx, { \n");
       sb.append("type: 'pie', \n");
       sb.append(" data: { \n");
       sb.append("labels: ['Truly Positive', 'Positive', 'Negative', 'Truly Negative'], \n");
       sb.append("datasets: [{ \n");
       sb.append("label: 'My First dataset', \n");
       sb.append("backgroundColor: ['#1B5E20', '#66BB6A', '#FF9800', '#E65100'], \n");
       //sb.append("data: [80, 60, 12, 9], \n");
       sb.append("data: [" + oTrulyPositive + ", " + oPositive + ", " + oNegative + ", " + oTrulyNegative + "], \n");
       sb.append("}] \n");
       sb.append("}, \n");
       sb.append("options: {} \n");
       sb.append("}); \n");
       
       sb.append("var ctx = document.getElementById('result2').getContext('2d'); \n"); 
       sb.append("var chart = new Chart(ctx, { \n");
       sb.append("type: 'pie', \n");
       sb.append(" data: { \n");
       sb.append("labels: ['Positive', 'Neutral', 'Negative'], \n");
       sb.append("datasets: [{ \n");
       sb.append("label: 'My First dataset', \n");
       sb.append("backgroundColor: ['#1B5E20', '#66BB6A', '#E65100'], \n");
       //sb.append("data: [1, 2, 9], \n");
       sb.append("data: [" + sPositive + ", " + sNeutral + ", " + sNegative + "], \n");
       sb.append("}] \n");
       sb.append("}, \n");
       sb.append("options: {} \n");
       sb.append("}); \n");
       
       sb.append("var ctx = document.getElementById('result3').getContext('2d'); \n"); 
       sb.append("var chart = new Chart(ctx, { \n");
       sb.append("type: 'pie', \n");
       sb.append(" data: { \n");
       sb.append("labels: ['Positive', 'Negative'], \n");
       sb.append("datasets: [{ \n");
       sb.append("label: 'My First dataset', \n");
       sb.append("backgroundColor: ['#1B5E20', '#E65100'], \n");
       //sb.append("data: [48, 64], \n");
       sb.append("data: [" + lPositive + ", " + lNegative + "], \n");
       sb.append("}] \n");
       sb.append("}, \n");
       sb.append("options: {} \n");
       sb.append("}); \n");
       
       sb.append("</script>");
       sb.append("</body>");
       sb.append("</html>");
       
       FileWriter fw = new FileWriter("graphs.html");
       BufferedWriter bw = new BufferedWriter(fw);
       bw.write(sb.toString());
       bw.close();
       
        System.out.println("HTML GENERATOR DONE");
        
        Runtime.getRuntime().exec(new String[] {"open", "/Users/rahimulislam/NetBeansProjects/TheTwitterProject/graphs.html"});
    
    }
    
    
}



