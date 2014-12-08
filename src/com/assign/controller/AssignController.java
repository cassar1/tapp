package com.assign.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assign.models.Bet;
import com.assign.models.User;
import com.assign.models.UserLogin;
import com.assign.services.BettingManagement;
import com.assign.services.BettingManagementDB;
import com.assign.services.UserManagement;
import com.assign.services.UserManagementDB;

@Controller
@Scope("request")
public class AssignController {
	/*@Autowired
	private EntityManager em;*/
	
	@Autowired
    private User user;
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld()
	{
		String message = "<br><div align='center'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is comming from CrunchifyHelloWorld.java **********<br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping("/login")
	public ModelAndView logging()
	{
		String message = "<br><div align='center'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is comming from CrunchifyHelloWorld.java **********<br><br>";
		return new ModelAndView("login", "message", message);
	}
	
	@RequestMapping("/registration")
	public ModelAndView register_page()
	{
		return new ModelAndView("registration");
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("username_field") String username,@RequestParam("password_field") String pass,
			@RequestParam("first_name") String name,@RequestParam("last_name") String surname,
			@RequestParam("dob") String dob,@RequestParam("type") int account_type,
			@RequestParam("credit_card_num") String credit_num,@RequestParam("expiry_date") String expiry,
			@RequestParam("cvv") String cvv)
	{
		
		UserManagementDB manager = new UserManagementDB();
		User new_user = new User(username,pass,name,surname,dob,account_type,credit_num,expiry,cvv);
		boolean[] valid_credentials = new_user.validate_user();
		boolean valid_user = true;
		ArrayList<String> incorrect_inputs = new ArrayList<String>(); 
		
		for(int i = 0; i< valid_credentials.length;i++)
		{
			if(!valid_credentials[i])
			{
				switch(i)
				{
					case 0:incorrect_inputs.add("Name");
							break;
					case 1:incorrect_inputs.add("Last Name");
							break;
					case 2:incorrect_inputs.add("Username");
							break;
					case 3:incorrect_inputs.add("Password");
							break;
					case 4:incorrect_inputs.add("Dob");
							break;
					case 5:incorrect_inputs.add("credit card num");
							break;
					case 6:incorrect_inputs.add("expiry date");
							break;
					case 7:incorrect_inputs.add("cvv");
							break;
				}
				valid_user = false;
			}
		}
		ModelMap model = new ModelMap();
		if(valid_user)
		{
			User u = manager.get_user(new_user.getName());
			if(u == null)
			{
				manager.add_user(new_user);
				model.addAttribute("message", "Registration was successful");
				return new ModelAndView("login", "model", model);
			}
			else
			{
				model.addAttribute("message", "Username Already Exists");
				return new ModelAndView("login", "model", model);
			}	
		}
		else
		{
			
			model.addAttribute("message", "Registration was unsuccessful, please try again<br/>Please Enter Correct inputs for the following Fields:<br/>");
			for(int i = 0; i < incorrect_inputs.size();i++)
				model.addAttribute("incorrect"+i, incorrect_inputs.get(i)+", ");
			return new ModelAndView("registration", "model", model);
		}
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loggingIn(@RequestParam("username_field") String username,@RequestParam("password_field") String pass,HttpSession session)
	{
		ModelMap model = new ModelMap();
		UserManagementDB manager = new UserManagementDB();

		user = manager.get_user(username);
		if(user != null)
		{
	
			if(user.isBlocked())
			{
				System.out.println("blocked user");
				Date last_attempt = user.getLast_attempt();
				Date current_time;
				Date time = new Date();
				System.out.println("Dates");
				System.out.println(last_attempt);
				System.out.println(time);
				Calendar cal = Calendar.getInstance();
		    	current_time = cal.getTime();
		    	long diff = time.getTime() - last_attempt.getTime();  
		    	//System.out.println("current "+current_time.getTime());
		    	//System.out.println("last atempt "+last_attempt.getTime());
		    	long diffMinutes = diff / (60 * 1000 ) %60;       
		    	System.out.println("difference" + diffMinutes);
		    	if(diffMinutes >= 1)
		    		manager.reset(username);
		    	else
		    	{
		    		model.addAttribute("message", "User is blocked");
					return new ModelAndView("login", "model", model);
		    	}
			}

		}
		else
		{
			model.addAttribute("message", "Incorrect Credentials");
			return new ModelAndView("login", "model", model);
		}

			user = manager.validate_login(username, pass);
			System.out.println("----------------------------------------------");
			String message;				
			if(user == null)
			{
				user = manager.get_user(username);
				System.out.println("----------------------------------------------");
				if(user != null)
				{

					int attempts =user.getLogin_attempts();
					System.out.println(attempts);
					System.out.println(user.isBlocked());
					System.out.println(user.getLast_attempt());
					if(attempts == 3)
						manager.block_user(username);
					else
					{
						manager.increment_attempts(username);
					}
				}
				model.addAttribute("message", "Incorrect Credentials");
				
				return new ModelAndView("login", "model", model);
			}
			else
			{
				manager.reset(username);
				session.setAttribute("user", user);
				BettingManagementDB betting = new BettingManagementDB();
				//user.account_type = 2;
				List<Bet> user_bets = new ArrayList<Bet>();
				user_bets = betting.get_all_bets(user);
				System.out.println("User bets length "+ user_bets.size());
				model.addAttribute("bet", user_bets);
				message = "Welcome";
				model.addAttribute("name", user.getUser());
				return new ModelAndView("betting", "model", model);
			}
		
		/*model.addAttribute("message", "User is blocked for 5 minutes");
		return new ModelAndView("login", "model", model);*/
		
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView testing_after(@RequestParam("test") String test)
	{
		UserManagementDB manager = new UserManagementDB();
		if(test.equals("Aftertest"))
		{
			System.out.println("AFTER TEST");
			manager.test_after();
		}else
		{
			System.out.println("BEFORE TEST");
			manager.test_before();
		}
		ModelMap m  = new ModelMap();
		return new ModelAndView("login", "model", m);
	}
}


