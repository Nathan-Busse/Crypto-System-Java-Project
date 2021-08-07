//import java.io.*;

public class Encripter
{


  public String code(String s)
  {
    char charArr[] = s.toCharArray();
    for(int i=0;i<s.length();i++)
    {
		/*if(i%2 == 0)
          charArr[i] += 2;
        else
          charArr[i] += 7;*/
          charArr[i] += i;
	}

	return new String(charArr);
 }


 public String decode(String s)
 {
	 char charArr[] = s.toCharArray();
	 for(int i=0;i<charArr.length;i++)
	 {
		 /*if(i%2 == 0)
		   charArr[i] -= 2;
		 else
		   charArr[i] -= 7;*/
		   charArr[i] -= i;
     }
    return new String(charArr);
}


}// class ends