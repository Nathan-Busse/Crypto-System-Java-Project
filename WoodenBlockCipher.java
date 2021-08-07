import java.io.*;

class WoodenBlockCipher
{
  public String encript(String message)
  {
	  char[] firstArray, secondArray;
	  message = message.trim();
      message = removeCharacter(message,' ');
      char[] charArray = message.toCharArray();
	  int length = charArray.length;
	  if(isOdd(length))
	  {
		  firstArray = new char[length/2 +1];
		  secondArray = new char[length/2];
	  }
	  else
	  {
		  firstArray = new char[length/2];
		  secondArray = new char[length/2];
	  }

    for(int i=0,j=0;i<firstArray.length;i++,j+=2)
     firstArray[i] = charArray[j];

    for(int i=0,j=1;i<secondArray.length;i++,j+=2)
      secondArray[i] = charArray[j];

    return (new String(firstArray) + new String(secondArray) );
    }



    public String decript(String message)
    {

		int firstlength=0,secondlength=0;
		int length = message.length();
		if(isOdd(length))
		{
			firstlength = length/2+1;
			secondlength = length-firstlength;
		}
		else
		{
			firstlength = length/2;
			secondlength = length-firstlength;
		}

		char[] firstArray = (message.substring(0,firstlength)).toCharArray();
		char[] secondArray = (message.substring(firstArray.length)).toCharArray();
		char[] charArray = new char[message.length()];

		for(int i=0,j=0;i<charArray.length;i+=2,j++)
		  charArray[i] = firstArray[j];
		for(int i=1,j=0;j<secondArray.length;i+=2,j++)
		  charArray[i] = secondArray[j];

		 return new String(charArray);
	 }

  private boolean isOdd(int n){ return (n%2==0);}


  private String removeCharacter(String message,char ch)
  {
	  StringBuffer buffer = new StringBuffer(message);
	  int index = 0;
	  while( (index = message.indexOf(ch,index)) > -1)
	  {
	    buffer.deleteCharAt(index);
	    message = buffer.toString();
      }
      return message;
  }

  public void writeBytes(String s,File file) throws FileNotFoundException
  {
  	FileOutputStream fos = new FileOutputStream(file);
  	try{
  		fos.write(s.getBytes("ASCII"));
  		fos.close();
  	}
  	catch(UnsupportedEncodingException ex)
  	{
  		 try{
  			 fos.write(s.getBytes());
  			 fos.close();
  			 }
  		 catch(UnsupportedEncodingException ee){}
  		 catch(IOException eeio){}
  	 }
  	 catch(IOException eio)
  	 {
  	 }
  }

  public String readBytes(File file)throws FileNotFoundException,IOException
  {
	byte[] theData;
  	FileInputStream fis = new FileInputStream(file);
  	theData  = new byte[fis.available()];
  	fis.read(theData);
  	fis.close();
    	 return new String(theData);
}

}