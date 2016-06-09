package r.util;

@SuppressWarnings("serial")
public class Date extends java.util.Date {
	
	public Date(long time){
		super(time);
	}
	
	@SuppressWarnings("deprecation")
	public String getSwedishDate(){
		String date = "";
		
		//Day
		date = date + getDate() + " ";
		
		//Mounth
		String[] mounths = {"Januari","Februari","Mars","April","Maj","Juni","Juli","Augusti","September","Oktober","November","December"};
		date = date + mounths[getMonth()] + " ";
		
		//Year
		date = date + getYear();
		
		System.out.println(getYear());

		return date;
	}

}
