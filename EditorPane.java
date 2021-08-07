import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class EditorPane
{
	public static void main(String [] args)
	{
		JEditorPane jp = new JEditorPane();
		jp.setEditable(false);

		try
		{
			jp.setPage("http://www.oreilly.com");
		}
		catch(IOException e)
		{
			jp.setContentType("text/html");
			jp.setText("<html><head><title>Fault Page</title></head><body><h1>Sorry this page could"+
			            " not be Displayed Try again</body></html>");
		}

		JScrollPane jscroll = new JScrollPane(jp);
		JFrame frame = new JFrame("A Simple Browser");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setContentPane(jscroll);
		frame.setSize(500,500);
		frame.show();
	}
}

