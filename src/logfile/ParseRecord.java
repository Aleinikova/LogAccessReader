package logfile;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ParseRecord implements IParseRecord {

	@Override
	public LogFileRecord parse(String line) {
		
		String[] words = line.split("(( - - )|( \\[)|(\\])|(\\[)|(\\\"\\s)|( \\\")| (?=-$)| (?=\\d+$))+");

		LogFileRecord log = new LogFileRecord();
		log.setHost(words[0]);
		SimpleDateFormat format = new SimpleDateFormat("dd/MMMM/yyyy:HH:mm:ss ZZ", Locale.ENGLISH);
		try {
			log.setTime(format.parse(words[1]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		log.setRequest(words[2]);
		log.setCode(Integer.parseInt(words[3]));
		log.setSize(Integer.parseInt(words[4]));

		return log;
	}


}
