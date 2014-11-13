package implementation;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public  class User {
	
	public String user;
	public String pass;
	public String first_name;
	public String last_name;
	public String dob;
	public int type;//0 free, 1 premium
	public String credit_card_num;
	public String expiry_date;
	public String cvv;
	
	public User(String user, String pass,String first_name,String last_name,
	String dob,int type,String credit_card_num,String expiry_date,String cvv)
	{
		this.user = user;
		this.pass = pass;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.type = type;
		this.credit_card_num = credit_card_num;
		this.expiry_date = expiry_date;
		this.cvv = cvv;
	}
	public User(String user,String pass)
	{
		this.user = user;
		this.pass = pass;		
	}
	public User()
	{
		
	}
	
	public boolean validate_user()
	{
		boolean[] validate = new boolean[9];
		validate[0] = validate_name(first_name);
		validate[1] = validate_name(last_name);
		validate[2] = validate_name(user);
		validate[3] = validate_password(pass);
		validate[4] = validate_dob(dob);
		validate[5] = validate_creditnum(credit_card_num);
		validate[6] = validate_expiry(expiry_date);
		validate[7] = validate_cvv(cvv);
		return true;
	}
	public boolean validate_password(String pass)
	{
		if(pass.length() >= 8)
			return true;
		else
			return false;
	}
	public  boolean validate_name(String inp)
	{
		Pattern p = Pattern.compile("[a-zA-Z ]");
	
		boolean is_good = p.matcher(inp).find();
		if(inp.isEmpty() || inp == null)
			return false;
		else if(!is_good)
			return false;
		else
			return true;
	}
	public boolean validate_dob(String dob)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		
		Date current = cal.getTime();
		System.out.println("current "+ current); 
		try 
		{
			Date d1 = dateFormat.parse(dob);
			System.out.println("input date: " + d1);
			
			long milli = Math.abs(current.getTime() - d1.getTime());
			int days = (int)(milli/(1000*60*60*24));
			System.out.println("days " + days);
			double years = days/365;
			System.out.println("years " + years);
			if(years >= 18)
				return true;
			else 
				return false;
		} catch (ParseException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean validate_creditnum(String num)
	{
		return luhnTest(num);
	}
    public static boolean luhnTest(String number){
        int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(number).reverse().toString();
        for(int i = 0 ;i < reverse.length();i++){
            int digit = Character.digit(reverse.charAt(i), 10);
            if(i % 2 == 0){//this is for odd digits, they are 1-indexed in the algorithm
                s1 += digit;
            }else{//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit;
                if(digit >= 5){
                    s2 -= 9;
                }
            }
        }
        return (s1 + s2) % 10 == 0;
    }

	public boolean validate_expiry(String expiry_date)
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
		Calendar cal = Calendar.getInstance();
		System.out.println(); 
		Date current = cal.getTime();
		try 
		{
			Date d1 = dateFormat.parse(expiry_date);
			//System.out.println(d1);
			
			if(d1.getTime() > current.getTime())
				return true;
			else 
				return false;
		} catch (ParseException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public boolean validate_cvv(String cvv)
	{
		if (cvv.length() == 3)
		{
				return isNumeric(cvv);
		}
		return false;
	}
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    int d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

	
}
