import java.applet.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Sound
{

	 AudioClip clip;
	 URL currentDirURL;

public  Sound()
{
	//static AudioClip clip;
	//static URL currentDirURL;
	File currentDir = new File(System.getProperty("user.dir"));
	try
	{
		  currentDirURL = currentDir.toURL();
	}
	catch(MalformedURLException e)
	{
		System.err.println("bad URL"+ e);
		System.exit(0);
	}


    /*FilenameFilter filter = new FilenameFilter()
    {
		public boolean accept(File directory,String filename)
		{
			String name = filename.toLowerCase();
			return name.endsWith(".wav");
		}
	};*/

	//String soundFiles[] = currentDir.list(filter);
	String soundFile = "TADA.WAV";

	System.out.println(soundFile);

	try
	{

	    clip = Applet.newAudioClip(new URL(currentDirURL,soundFile));


	}
	catch(MalformedURLException e)
	{
		System.err.println("bad URL"+ e);
		System.exit(0);
	}

clip.play();

 }



 public static void main(String[] args)
 {
	 Sound s = new Sound();

 }
}