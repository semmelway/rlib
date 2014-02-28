package r.util;

public class Time {
	public long seconds;
	public long minutes;
	public long hours;
	public long days;
	public long years;
	
	public Time (long milliseconds){
		seconds = milliseconds/1000;
		
		minutes = seconds/60;
		seconds -= 60 * minutes;
		
		hours = minutes/60;
		minutes -= 60 * hours;
		
		days = hours/24;
		hours -= 24 * days;
		
		years = days/365;
		days -= 365 * years;
	}
	
	public String getTime(){
		String time = "";
		
		if(years > 0)
			time = time.concat(years + " years, ");
		else if(years == 1)
			time = time.concat(years + " year, ");

		if(days > 0)
			time = time.concat(days + " days, ");
		else if(days == 0 && years > 0)
			time = time.concat(" 0 days, ");
		else if(days == 1)
			time = time.concat(days + " day, ");
			
		if(hours > 0)
			time = time.concat(hours + " hours, ");
		else if(hours == 0 && days > 0)
			time = time.concat(" 0 hours, ");
		else if(hours == 1)
			time = time.concat(hours + " hour, ");
			
		if(minutes > 0)
			time = time.concat(minutes + " minutes, ");
		else if(minutes == 0 && hours > 0)
			time = time.concat(" 0 minutes, ");
		else if(minutes == 1)
			time = time.concat(minutes + " minute, ");
			
		if(seconds > 0)
			time = time.concat(seconds + " seconds ");
		else if(seconds == 0 && minutes > 0)
			time = time.concat(" 0 seconds, ");
		else if(seconds == 1)
			time = time.concat(seconds + " second");
			
		return time;
		
	}
	
	public void update(long milliseconds){
		seconds = milliseconds/1000;
		
		minutes = seconds/60;
		seconds -= 60 * minutes;
		
		hours = minutes/60;
		minutes -= 60 * hours;
		
		days = hours/24;
		hours -= 24 * days;
		
		years = days/365;
		days -= 365 * years;
	}
	
	public static void main(String args[]){
		
		Time time = new Time(System.currentTimeMillis());
		
		System.out.println("seconds: " + time.seconds);
		System.out.println("minutes: " + time.minutes);
		System.out.println("hours: " + time.hours);
		System.out.println("days: " + time.days);
		System.out.println("years: " + time.years);
		
		System.out.println("\nOr: " + time.getTime() + "\n");
		
		time.update(3665000);
		
		System.out.println("seconds: " + time.seconds);
		System.out.println("minutes: " + time.minutes);
		System.out.println("hours: " + time.hours);
		System.out.println("days: " + time.days);
		System.out.println("years: " + time.years);
		
		System.out.println("\nOr: " + time.getTime() + "\n");
	}
}
