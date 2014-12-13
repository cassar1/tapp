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
		int valid = betting_db.validate_bet(user,risk,amount);
		System.out.println("valid bet "+ valid);
		List<Bet> user_bets = new ArrayList<Bet>();
		if(valid == 1)
		{
			Bet bet = new Bet(user.getUser(), risk,amount);
			betting_db.place_bet(bet);
			System.out.println("placebet");
			user_bets = betting_db.get_all_bets(user); 
			model.addAttribute("bet", user_bets);
			model.addAttribute("message", "Bet was placed successfully");
			return new ModelAndView("betting", "model", model);
		}
		else
		{
			if(valid == 0)
				model.addAttribute("message", "Bet could not be placed, cumulative amount exceeded");
			else if(valid == 2)
				model.addAttribute("message", "Bet could not be placed, free accounts can only place low risk bets");
			else if(valid == 3)
				model.addAttribute("message", "Bet could not be placed, free accounts can only place bets with 5 Euros or less");
			else if(valid == 4)
				model.addAttribute("message", "Bet could not be placed, maximum (3) number of bets have been already placed");
			user_bets = betting_db.get_all_bets(user); 
			model.addAttribute("bet", user_bets);
			return new ModelAndView("betting", "model", model);
		}
	}
	

@RequestMapping(value = "/betting")
	public ModelAndView get_betting(HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		if (user == null){
			ModelMap model = new ModelMap();
			model.addAttribute("message", "Access denied");
			return new ModelAndView("login", "model", model);
		}
		else{
			ModelMap model = new ModelMap();
			BettingManagementDB betting = new BettingManagementDB();
			List<Bet> user_bets = new ArrayList<Bet>();
			user_bets = betting.get_all_bets(user);
			System.out.println("User bets length "+ user_bets.size());
			model.addAttribute("bet", user_bets);
			model.addAttribute("name", user.getUser());
			return new ModelAndView("betting", "model", model);
		}
	}

}
