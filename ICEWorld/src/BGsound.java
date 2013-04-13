import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

public class BGsound {
Clip clip;
 BGsound (String filename) {
	 try {
		 //Open an audio input
		URL url = this.getClass().getClassLoader().getResource(filename);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		//get sound clip resource
        clip = AudioSystem.getClip();
       //open audio
        clip.open(audioIn); 
       
        clip.start();
       clip.loop(clip.LOOP_CONTINUOUSLY); 
        
	} catch (LineUnavailableException e) {
		e.printStackTrace();
	} catch (UnsupportedAudioFileException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

	


/*public void playSound()
{
	clip.loop(Clip.LOOP_CONTINUOUSLY); // Play continuously
	
}
/*public void stopSound()
{
	clip.stop(); // Stop
}
public void playSoundOnce()
{
	AudioClip audioClip = (AudioClip) clip;
	audioClip.play(); // Play only once
}
*/
 public void decrease()//decrease volume
	{
	    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	    gainControl.setValue(10.0f); // Reduce volume by 10 decibels.
	}
	public void increase()//increase volume
	{
	    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	    gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
	}

public static void main (String []args) throws Exception{
	 new BGsound ("bgSound.wav");
	//song.playSound();
}
	
	   }