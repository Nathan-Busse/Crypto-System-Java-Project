import java.io.*;

class CompilerClass
{



public static void compile(String filePath)
{
	String javac = "javac";
	String execCommand = javac +" " + filePath + ".java";

try
{
Runtime aRun = Runtime.getRuntime();
Process p = aRun.exec(execCommand);

}

catch(Exception e)
{

System.out.println("Error occurred while compiling the file    " + e);
}
}


public static void run(String fileName)throws IOException
{
	/*String java = "javac";

	try
	{
	Runtime aRun = Runtime.getRuntime();
	Process p = aRun.exec(java + " " + filePath);

	}

	catch(Exception e)
	{
	System.out.println("Error occurred while running  the file    " + e);
	}*/



	 FileWriter writer = new FileWriter(new File("autoexec.bat"));
	 writer.write("java "+ fileName);
	 //System.out.println(filename);
	 writer.flush();
	 writer.close();


}

}// class ends