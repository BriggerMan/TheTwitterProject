/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import com.aliasi.classify.Classification;
import com.aliasi.classify.Classified;
import com.aliasi.classify.DynamicLMClassifier;
import com.aliasi.lm.NGramProcessLM;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author rashidislam
 */
public class LingpipeCollection extends ArrayList<LingpipeDocument> {
    
    public LingpipeCollection(ArrayList<String> docs, ArrayList<String> classes) throws Exception {
        for(int i = 0; i < docs.size(); i++) {
            LingpipeDocument d = new LingpipeDocument(docs.get(i), classes.get(i));
            add(d); 
        }
    }
    
    public void createLingpipeSentimentModel() throws Exception {
        ArrayList<String> comment = new ArrayList<String>(); 
        ArrayList<String> polarity = new ArrayList<String>(); 
        for(int i = 0; i < size(); i++) {
            LingpipeDocument doc = get(i); 
            comment.add(doc.getDocument()); 
            polarity.add(doc.getClassification()); 
        }
        String[] mCategories = {"0.0", "1.0"}; 
        DynamicLMClassifier<NGramProcessLM> mClassifier = DynamicLMClassifier.createNGramProcess(mCategories, 8);
        for(int i = 0; i < size(); i++) {
            String document = comment.get(i); 
            Classification classification = new Classification("" + polarity.get(i));
            Classified<CharSequence> classified = new Classified<CharSequence>(document, classification);
            mClassifier.handle(classified); 
        }
        FileOutputStream fos = new FileOutputStream("model/lingpipe/aaa_sentiment.model");
        ObjectOutputStream oos = new ObjectOutputStream(fos); 
        mClassifier.compileTo(oos);
        oos.close();
        fos.close(); 
    }
    
}
