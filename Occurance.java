/*
this class is to record the number of occurances
of a particular character in a String or char array.
It is used by the CeaserAnalyser class to analyse the
highest number of occurances of a character.
*/

public class Occurance
{
   public char ch;
   public int count;

   public Occurance(char ch,int count)
   {
	   this.ch = ch;
	   this.count  = count;
   }
}
