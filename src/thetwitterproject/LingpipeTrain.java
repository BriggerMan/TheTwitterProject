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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author rashidislam
 */
public class LingpipeTrain {
    
    public LingpipeTrain() {
        
    }
    
    public void createLingpipSentimentModel(ArrayList<LingpipeDocument> catchLingpipeDoc) throws FileNotFoundException, IOException {
        ArrayList<String> comment = new ArrayList<String>(); 
        ArrayList<String> polarity = new ArrayList<String>(); 
        for(int i = 0; i < catchLingpipeDoc.size(); i++) {
            comment.add(catchLingpipeDoc.get(i).getDocument());
            polarity.add(catchLingpipeDoc.get(i).getClassification());
        }
        String[] mCategories = {"0.0", "1.0"}; 
        DynamicLMClassifier<NGramProcessLM> mClassifier = DynamicLMClassifier.createNGramProcess(mCategories, 8);
        for(int i = 0; i < catchLingpipeDoc.size(); i++) {
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
