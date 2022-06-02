package chat;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import org.alicebot.ab.MagicBooleans;


public class TestChatbot {

    private static final boolean TRACE_MODE = false;
    static String botName = "super";
 
    public static void TestChatbots(String r) {
        try {
            MagicBooleans.trace_mode = TRACE_MODE;
	        String response = r;
	            System.setProperty( 
	                "freetts.voices",
	                "com.sun.speech.freetts.en.us"
	                + ".cmu_us_kal.KevinVoiceDirectory"); 
	            
	            Central.registerEngineCentral( 
	                "com.sun.speech.freetts"
	                + ".jsapi.FreeTTSEngineCentral"); 
	            
	            Synthesizer synthesizer 
	                = Central.createSynthesizer( 
	                    new SynthesizerModeDesc(Locale.US)); 
	  
	            synthesizer.allocate(); 
	  
	            synthesizer.resume(); 
	  
	            synthesizer.speakPlainText( 
	            		response, null); 
	            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}