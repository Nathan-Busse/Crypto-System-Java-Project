public class CeaserAnalyser
{
	private Occurance[] occurances;
	private int index = 0;// index for occurance;

	public String analyseAndDecodeCeaser(String message)
	{
		occurances = new Occurance[26];
		String upperMessage = null;
		if(message.length() > 2000)// this is to avoid extra computation for the most occured character
		  upperMessage = message.substring(0,2000).toUpperCase();// 2000 character should be enough
		else
		 upperMessage = message.toUpperCase();
		char[] messageArray = upperMessage.toCharArray();
		char mostOccured = '\0';
		char key = '\0';
		//this loop is to fill up the occurances array with occured characters and number of times they occur.
		for(int i=0;i<messageArray.length;i++)
		{
			if( (hasOccured(messageArray[i])) || (! (Character.isLowerCase(messageArray[i])||Character.isUpperCase(messageArray[i]))) )//(messageArray[i]==' ') || (messageArray[i] == '\n')||
			continue;// skip the inner loop and go to the next character.
			else
			{
			  Occurance occured = new Occurance(messageArray[i],1);//record a new occurance.
			  for(int j=i+1;j<messageArray.length;j++)
			  {
				if(messageArray[i]==messageArray[j])
				   occured.count++;//increment the number of times the occurance has occured,
		       }
		       occurances[index++] = occured;// insert the occured in the array
		     }
		 }
		 mostOccured = getMostOccuredCharacter();
		 key = getKey(mostOccured);
		 return decodeCaeser(message,key);
	}

	public String decodeCaeser(String s,char key)
	{
		char[] cArray = s.toCharArray();
		char upperA = 'A';
		char upperKey = Character.toUpperCase(key);
		char offset = (char) (upperKey - upperA);

		for(int i=0;i<cArray.length;i++)
		    {
				if(Character.isLowerCase(cArray[i])||Character.isUpperCase(cArray[i]))
				{
					cArray[i] = deCodeCharacter(cArray[i],offset);
				}
			}
			return new String(cArray);
    }

    private char deCodeCharacter(char ch,char offset)
	{
		char upperA = 'A';
		char coded = Character.toUpperCase(ch);
		  coded -= offset;

		if(coded < upperA)
		 coded =(char)(coded + 26);

		return (Character.isUpperCase(ch))?coded:Character.toLowerCase(coded);
    }

    private char getMostOccuredCharacter()
    {
		int highestOccuredIndex = 0;
		for(int i=0;i<index;i++)
		{
			if( occurances[i].count > occurances[highestOccuredIndex].count  )
			 highestOccuredIndex = i;
		 }
		 return occurances[highestOccuredIndex].ch;
	 }

	 private boolean hasOccured(char ch)
	 {
		 boolean hasOccured = false;

		 for(int i=0;i<index;i++)
		  if(occurances[i].ch == ch)
		  hasOccured = true;

		  return hasOccured;
	 }
	 private char getKey(char mostOccured)
	 {
		 char upperA = 'A',upperZ = 'Z';
		 char key = (char)(mostOccured - 4);
		 if (key < upperA)
		 {
			 key =(char)(key + 26);		 		  ;

		 }
		 if(key > upperZ)
		 {
			 key = (char) (key - upperZ);
			 key = (char) ((upperA + key)-1);
		 }
		 return key;
	 }


	 public static void main(String args[])
	 {
		 String text = "A Man is he who says hEllo he triEs english envoy Ecology Especially emphasiced  aaaaaa enhanced";//13es,
		 System.out.println(text);
		 String coded = new Encriptor('F').codeCaeser(text);
         System.out.println(coded);
         String decoded = new CeaserAnalyser().analyseAndDecodeCeaser(coded);
         System.out.println(decoded);
	 }


}// end class



