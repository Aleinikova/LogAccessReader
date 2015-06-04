package logfile;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ParseRecord implements IParseRecord {

	@Override
	public LogFileRecord parse(String line) {

		String[] words = line
				.split("(( - - )|( \\[)|(\\])|(\\[)|(\\\"\\s)|( \\\")| (?=-$)| (?=\\d+$))+");

		LogFileRecord log = new LogFileRecord();
		//System.out.print(words[0]+"\n"+words[1]+"\n"+words[2]+"\n"+words[3]+"\n"+words[4]+"\n");
		log.setHost(words[0]);
		SimpleDateFormat format = new SimpleDateFormat(
				"dd/MMMM/yyyy:HH:mm:ss ZZ", Locale.ENGLISH);
		try {
			log.setTime(format.parse(words[1]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		log.setRequest(words[2]);
		words[3]=words[3].replaceAll(" ", "");
		log.setCode(Integer.parseInt(words[3]));
		if (words[4].equals("-"))
			log.setSize(0);
		else
			log.setSize(Integer.parseInt(words[4]));

		return log;
	}

}
