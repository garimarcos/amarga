package packbarbestial;

import java.io.FileInputStream;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * A simple Java sound file example (i.e., Java code to play a sound file).
 * AudioStream and AudioPlayer code comes from a javaworld.com example.
 * @author alvin alexander, devdaily.com.
 */
public class AudioGaldu{
	
	private static AudioStream audioStream;
	
  public static void main(String[] args) throws Exception{
    // open the sound file as a Java input stream
	

	InputStream in = AudioGaldu.class.getResourceAsStream("/lose.wav");
    //InputStream in = new FileInputStream("resources/lose.wav");

    // create an audiostream from the inputstream
    audioStream = new AudioStream(in);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
  }
  
  public static void stop(){
	  AudioPlayer.player.stop(audioStream);
  }
  
}