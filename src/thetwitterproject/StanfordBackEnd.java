/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import java.util.Properties;

/**
 *
 * @author rashidislam
 */
public class StanfordBackEnd {
    
    private StanfordCoreNLP pipeline; 
    
    public StanfordBackEnd() {
        Properties props = new Properties(); 
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment"); 
        pipeline = new StanfordCoreNLP(props); 
    }
    
    public double getSentiment(String cs) {
        String sent = cs; 
        Annotation annotation = pipeline.process(sent); 
        for(CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            return RNNCoreAnnotations.getPredictedClass(tree); 
        }
        return -1; 
    }
    
    public double getSentiment2(String cs) {
        String sent = cs; 
        double mainSentiment = 0; 
        int longest = 0; 
        Annotation annotation = pipeline.process(sent); 
        for(CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            Tree tree = sentence.get(SentimentAnnotatedTree.class); 
            mainSentiment = RNNCoreAnnotations.getPredictedClass(tree); 
        }
        return mainSentiment; 
    }
    
}
