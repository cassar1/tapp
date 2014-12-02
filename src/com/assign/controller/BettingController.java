package com.assign.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assign.models.Bet;
import com.assign.models.User;
import com.assign.services.BettingManagementDB;

@Controller
public class BettingController {
	//BettingManagement betting = new BettingManagement();
	
	
	
	/*@RequestMapping(value = "/betting", method = RequestMethod.POST)
	public ModelAndView place_bet(@RequestParam("risk_level") int risk,@RequestParam("amount") int amount)
	{
		User user = new User("Jurgen","cassar");
		user.account_type = 2;
		ModelMap model = new ModelMap();
		boolean valid = betting.validate_bet(user,risk,amount);
		ArrayList<Bet> user_bets = new ArrayList<Bet>();
		if(valid)
		{
			Bet bet = new Bet("Jurgen", risk,amount);
			betting.place_bet(bet);
			user_bets = betting.get_all_bets(user); 
			model.addAttribute("bet", user_bets);
			return new ModelAndView("betting", "model", model);
		}
		else
		{
			return new ModelAndView("betting", "message", "There was an error placing bet");
		}
	}*/
	@RequestMapping(value = "/betting", method = RequestMethod.POST)
	public ModelAndView place_bet(@RequestParam("risk_level") int risk,@RequestParam("amount") int amount,HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		BettingManagementDB betting_db = new BettingManagementDB();
		ModelMap model = new ModelMap();
		boolean valid = betting_db.validate_bet(user,risk,amount);
		List<Bet> user_bets = new ArrayList<Bet>();
		if(valid)
		{
			Bet bet = new Bet(user.getUser(), risk,amount);
			betting_db.place_bet(bet);
			user_bets = betting_db.get_all_bets(user); 
			model.addAttribute("bet", user_bets);
			return new ModelAndView("betting", "model", model);
		}
		else
		{
			user_bets = betting_db.get_all_bets(user); 
			model.addAttribute("bet", user_bets);
			model.addAttribute("message", "There was an error placing bet");
			return new ModelAndView("betting", "model", model);
		}
	}
}