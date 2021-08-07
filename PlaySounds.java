import java.applet.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class PlaySounds extends JFrame
{

	 AudioClip clip;
	 URL currentDirURL;
	 //URL url;
	 JComboBox soundChoice;
public  PlaySounds()
{

	setTitle("play");
	setSize(250,300);
	setDefaultCloseOperation(1);
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


    FilenameFilter filter = new FilenameFilter()
    {
		public boolean accept(File directory,String filename)
		{
			String name = filename.toLowerCase();
			return name.endsWith(".wav");
		}
    };

	String soundFiles[] = currentDir.list(filter);
	String soundFile = "TADA.WAV";

	soundChoice = new JComboBox(soundFiles);

	//System.out.println(soundFile);








	try
	{

	    clip = Applet.newAudioClip(new URL(currentDirURL,soundFile));
	}
	catch(MalformedURLException e)
	{
		System.err.println("bad URL"+ e);
		System.exit(1);
	}

	soundChoice.addActionListener(new ActionListener()
	{
      public void actionPerformed(ActionEvent e)
      {
		  try
		  {
			  clip = Applet.newAudioClip(new URL(currentDirURL,(String)soundChoice.getSelectedItem()));

		  }
		  catch(MalformedURLException ex)
		  	{
		  		System.err.println("bad URL"+ ex);
		  		System.exit(1);
		  	}
		}

    });

  JButton play = new JButton("play");
  play.addActionListener(new ActionListener()
  {
	  public void actionPerformed(ActionEvent ee)
	  {
		  clip.play();
	  }
  }
  );


  Container c = getContentPane();
  c.add(soundChoice,BorderLayout.NORTH);
  c.add(play,BorderLayout.SOUTH);
}// end constructor

 public static void main(String[] args)
 {
	 PlaySounds p = new PlaySounds();
	 p.setVisible(true);
 }
}



