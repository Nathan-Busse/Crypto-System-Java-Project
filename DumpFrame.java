import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.io.*;
import java.util.*;


/*import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.io.*;
import java.util.*;*/


 class PrintPage extends JPanel implements Printable {

 private Vector text = null;
 private int lineCount = 0;
 private int currLine  = 0;
 private int pageCount  = 0;


 public PrintPage(Vector text) {
  this.text = text;
  lineCount = text.size();
  pageCount = lineCount / 50;
 }

 public void paintComponent(Graphics g) {
  super.paintComponent(g);
 }

 public int print(Graphics g, PageFormat pf, int page)
                  throws PrinterException
 {
  if (page < pageCount) {
   drawPage(g);
   return Printable.PAGE_EXISTS;
  }
  return Printable.NO_SUCH_PAGE;
 }

 public void drawPage(Graphics g) {

  g.setFont(new Font("Serif", Font.PLAIN, 10));
  g.setColor(Color.black);

  for (int i = 0; currLine < lineCount && i < 50; i++,currLine++)
   g.drawString((String)text.get(currLine), i, 0);

  this.repaint();
    }
}



public class DumpFrame extends JFrame  {

    DumpFrame() {
  super();
  init();
 }

 private JTextArea    textArea;
 private JLabel       label;
 private JTextField   textField;
 private JPanel       panelNorth,
                      panelSouth;
 private JScrollPane  scrollPane;

 private JButton      enterButton,
                      printButton,
                      clearButton,
                      leaveButton;

 private Vector       text;
 private PrinterJob   printJob;
 private PrintPage    printPage;
 private PageFormat   pageFormat;

 private  PrintWriter out = null;

 // Button event handler follows
 private ButtonListener listener;

 public void init() {

  Container c = getContentPane();
  c.setLayout(new BorderLayout());

        panelNorth = new JPanel();

  label     = new JLabel("Dump for JAR: ");
  textField = new JTextField(20);
  panelNorth.add(label);
  panelNorth.add(textField);
  c.add(BorderLayout.NORTH, panelNorth);

  textArea       = new JTextArea(50,20);
  textArea.setEditable(false);
  scrollPane = new JScrollPane(textArea);
  c.add(BorderLayout.CENTER, scrollPane);

  enterButton = new JButton("Enter");
  printButton = new JButton("Print");
  clearButton = new JButton("Clear");
  leaveButton = new JButton("Leave");

  printButton.setEnabled(false);
  clearButton.setEnabled(false);

  listener = new ButtonListener();
  enterButton.addActionListener(listener);
  printButton.addActionListener(listener);
  clearButton.addActionListener(listener);
  leaveButton.addActionListener(listener);

  panelSouth  = new JPanel();
  panelSouth.add(enterButton);
  panelSouth.add(printButton);
  panelSouth.add(clearButton);
  panelSouth.add(leaveButton);

  c.add(BorderLayout.SOUTH, panelSouth);


  setBounds(0,0,400,400);
  setTitle("JAR Dump Utility");
  setVisible(true);
 }

// inner listener class for buttons follows
class ButtonListener implements ActionListener {

 private String         eventName = null;
 private int            returnVal = 0;
 private int            lineCount = 0;
 private LoadTextArea   load      = null;

 public void actionPerformed(ActionEvent evt) {
  eventName = evt.getActionCommand();
  if (eventName == "Enter")
   enterCommand();
  else
      if (eventName == "Print")
          printCommand();
      else
          if (eventName == "Clear")
              clearCommand();
          else
              leaveCommand();
 }

 public void enterCommand() {

        load = new LoadTextArea(textField.getText(), DumpFrame.this);
  text = load.loadText();
  lineCount = text.size();

  if (lineCount > 0) {
   for (int i = 0; i < lineCount; i++)
    textArea.append((String)text.get(i) + "\n");

            textArea.setCaretPosition(0);
      textField.setText((String)load.getFileName());
   printButton.setEnabled(true);
   clearButton.setEnabled(true);
  }

 }

 public void printCommand() {
  printJob = PrinterJob.getPrinterJob();
  printPage = new PrintPage(text);
  if (pageFormat == null)
      pageFormat = printJob.defaultPage();
  printJob.setPrintable(printPage, pageFormat);
  if (printJob.printDialog())
      try {
    printJob.print();
   }
      catch(PrinterException pe) {
    JOptionPane.showMessageDialog(DumpFrame.this, pe);
   }

 }

 public void clearCommand() {
  textField.setText("");
  textArea.setText("");
  printButton.setEnabled(false);
  clearButton.setEnabled(false);
 }

 public void leaveCommand() {
  dispose();
System.exit(0);
 }
}  // end ButtonListener
public static void main(String [] args)
{
	DumpFrame df = new DumpFrame();
	df.steBounds(50,50,500,500);
	df.setVisible(true);
}



}  // end DumpFrame


