package chat;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption; 
@SuppressWarnings("unused")
public class MyBot{
    HashMap<String, String> knowledge = new HashMap<String, String>();
    static String question;
    int a = 1;
    public MyBot() {
        knowledge.put("Hi", "Hello... Pleased to meet you!");
        knowledge.put("Hello", "Hi yo");
        knowledge.put("how are you?", "Great! And you?");
        knowledge.put("what time is it", "Look at your watch!");
        try (BufferedReader br = new BufferedReader(new FileReader("source.txt")))
        {

            String sCurrentLine;


            while ((sCurrentLine = br.readLine()) != null) {       
                String[] information = sCurrentLine.split("_");
                String k = information[0];
                String v = information[1];
                knowledge.put(k, v);
                }

        } catch (IOException e) {
            e.printStackTrace();
        } 

 }
    public void answer1(String message) {
    	question = message;
    	answer(question);
    }
public void answer(String question) {
    Set<String> keys = knowledge.keySet();
    for (String key : keys){
        String lowerKey = key.toLowerCase();
        String lowerQuestion = question.toLowerCase();
        if (lowerKey.equals(lowerQuestion)) {
           String str =knowledge.get(key);
           Chatf.bot(str);
           return;
        }
    }
    for (String key : keys){
    	
        String lowerKey = key.toLowerCase();
        String lowerQuestion = question.toLowerCase();
        if (lowerKey.contains(lowerQuestion)) {
            String str =knowledge.get(key);
            Chatf.bot(str);
            return;
         }
    }
        
reply(question);

}
   
public void reply(String question) {
    Chatf.bot("Sorry, Im dumb! How should I reply?");
    Chatf.bot("Type the response and click train me");
}
public void trainMe(String question,String ans) throws IOException {
	knowledge.put(question, ans);
	String s="_";
	String content = question +s+ans;
	Path path = Paths.get("test.txt");
	 Files.write(path, content.getBytes(StandardCharsets.UTF_8),
             StandardOpenOption.CREATE,
             StandardOpenOption.APPEND);
	Chatf.bot("Thanks,I'll remember that");
}

}
