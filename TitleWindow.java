import javax.swing.*;
import java.awt.*;

/*
A title window class */


public class TitleWindow extends JWindow
{

   public TitleWindow(int duration) // constructor
   {
      super();
      JPanel panel = (JPanel)getContentPane();
      Dimension screen =  Toolkit.getDefaultToolkit().getScreenSize();
      int width = 525;
      int height = 292;
      int x = (screen.width - width)/2;
      int y = (screen.height - height)/2;

      setBounds(x,y,width,height);
      JLabel label = new JLabel(new ImageIcon("images\\Title.gif"));
      this.getContentPane().add(label,BorderLayout.CENTER);
      //this.getContentPane().setBorder(BorderFactory.createLineBorder(Color.red,10));
      setVisible(true);

      try
      {
       Thread.sleep(1000);
       }
       catch(Exception e)
       {}

      setVisible(false);
  }



}
