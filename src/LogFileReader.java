import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogFileReader {

	public static void Input(String name, int line, int numberLine, String nameNewFile)
			throws IOException {

		String path, pathNew;
		path = "C:\\Users\\g6\\Documents\\Eclipse\\logReader\\bin\\" + name;
		pathNew = "C:\\Users\\g6\\Documents\\Eclipse\\logReader\\bin\\" + nameNewFile;
		BufferedReader in = new BufferedReader(new FileReader(path));
		BufferedWriter out = new BufferedWriter(new FileWriter(pathNew));
		int j = 1;
		String s;
		while ((s = in.readLine())!=null) {

			if (j >= line && j < line+ numberLine )
			{
				out.write(s+"\n");
				
			}
			else if (j == line+ numberLine)
			{
				break;
			}
				j++;
			
		}
		in.close();
		out.close();

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String name = args[0];
		int line =Integer.parseInt(args[1]);
		int numberLine = Integer.parseInt(args[2]);
		String nameNewFile = args[3];
		//Input(name, line, numberLine);
		Input(name, line, numberLine,nameNewFile);

	}

}
