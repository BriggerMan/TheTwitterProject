/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetwitterproject;

import com.vdurmont.emoji.EmojiParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rashidislam
 */
public class CleanerClass {
    
    //EmojiParser ep = new EmojiParser(); 
    
    private String hashtagsRemoved;
    private String linksRemoved; 
    private String onlyLettersNumbers; 
    private String RTremoved; 
    private String usernameRemoved;
    private String usernameRemoved2;
    private String emailsRemoved; 
    
    public CleanerClass() {
        this.hashtagsRemoved = null;
        this.linksRemoved = null; 
        this.onlyLettersNumbers = null; 
        this.RTremoved = null; 
        this.usernameRemoved = null; 
        this.emailsRemoved = null; 
    }
    
    //sampleString = sampleString.replaceAll("#[A-Za-z]+","");
    
    public String removeHashtags(String catchPhrase) { //working
        
        String removeRegEx = "#[A-Za-z0-9]*"; 
        
        hashtagsRemoved = catchPhrase.replaceAll(removeRegEx, "");
        
        return hashtagsRemoved;
    }
    
    public String removeLinks(String catchPhrase) {
        
        String regexRemove = "[\\S]+://[\\S]+";
        
        linksRemoved = catchPhrase.replaceAll(regexRemove, "");
        
        return linksRemoved; 
    }
    
    //((http|ftp|https):\\/\\/)?[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])? - WORKING
    
    //^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]

    
    public String removeEmojis(String catchPhrase) { //working
        
        String removeRegEx = "[^A-Za-z0-9 ]"; //Space after 9 to account for whitespace
        
        onlyLettersNumbers = catchPhrase.replaceAll(removeRegEx, "");
        
        return onlyLettersNumbers; 
    }
    
    public String removeRT(String catchPhrase) {
        
        String removeRegEx = "[RT]"; 
        
        RTremoved = catchPhrase.replaceAll(removeRegEx, "");
        
        return RTremoved;
    }
    
    public String removeUsernameEmails(String catchPhrase) {
        
        String removeRegEx = "([a-zA-Z0-9\\_\\.]+)@([a-zA-Z0-9\\_\\.]+)"; 
        String removeRegEx2 = "@([a-zA-Z0-9\\_\\.]+)"; 
        
        usernameRemoved = catchPhrase.replaceAll(removeRegEx, "");
        usernameRemoved2 = usernameRemoved.replaceAll(removeRegEx2, "");
        
        
        return usernameRemoved2; 
    }
    
    //(?<=^|(?<=[^a-zA-Z0-9-\.]))#([A-Za-z]+[A-Za-z0-9-]+) -- underscore regex
    //(?<=^|(?<=[^a-zA-Z0-9-_\\.]))@([A-Za-z]+[A-Za-z0-9]+)
    
    //(?<=^|(?<=[^a-zA-Z0-9-\\.]))@([A-Za-z]+[A-Za-z0-9]+) - try now
    
    //(?<=^|(?<=[^a-zA-Z0-9-\\.]))@([A-Za-z0-9_]+) - WORKING
    
    //^@[A-Za-z0-9_]{1,15}$ - clean
    
}
