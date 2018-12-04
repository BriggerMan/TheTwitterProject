/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import com.aliasi.classify.Classification;
import com.aliasi.classify.LMClassifier;
import com.aliasi.lm.NGramProcessLM;
import com.aliasi.stats.MultivariateEstimator;
import com.aliasi.util.AbstractExternalizable;
import java.io.File;

/**
 *
 * @author rashidislam
 */
public class LingpipeBackEnd {
    
    private LMClassifier<NGramProcessLM, MultivariateEstimator> mClassifier; 
    
    public LingpipeBackEnd(String model) throws Exception {
        mClassifier = (LMClassifier<NGramProcessLM, MultivariateEstimator>) 
                AbstractExternalizable.readObject(new File(model));
    }
    
    public double getSentiment(String catchPhrase) {
        Classification classification = mClassifier.classify(catchPhrase);
        return Double.parseDouble(classification.bestCategory()); 
    }
    
}
