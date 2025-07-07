package base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateTime {

	public DateTime() {
		// TODO Auto-generated constructor stub
	}

	public String getDateandTime()
	{
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	 //get current date time with Date()
	 Date date = new Date();

	 // Now format the date
	 String date1= dateFormat.format(date);

	 // Print the Date
	// System.out.println("Current date and time is " +date1);
	return date1;
}
}

