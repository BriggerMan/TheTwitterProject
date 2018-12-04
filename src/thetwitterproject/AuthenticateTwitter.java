/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import java.util.*;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author rashidislam
 */
public class AuthenticateTwitter { //Authentication - only done once, only needed once

    public Twitter Authenticate() {

        ConfigurationBuilder cb = new ConfigurationBuilder(); //A builder that can be used to construct a twitter4j configuration with desired settings.

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("nqb3IfNVfhM6iraCUejMWBcAP")
                .setOAuthConsumerSecret("toYNjbxjLB6dsaTgMx2GLGSU9an3HYyUiWDrr0o9cUgA0w39ew")
                .setOAuthAccessToken("918141097292988416-YgygqnGnXCv0QDGB9FhHOR57ZoCcmio")
                .setOAuthAccessTokenSecret("Ci4jWjAD3BpdtYjndu4ymcvYwgQtyv6TKklSyRDOH8gNj");

        TwitterFactory tf = new TwitterFactory(cb.build());

        Twitter twitter = tf.getInstance();
        return twitter; 

    }

}
