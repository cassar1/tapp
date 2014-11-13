package implementation;

import java.util.ArrayList;

import interfaces.User_management;

public class UserManagement implements User_management {
	public ArrayList<User> accounts = new ArrayList<User>();
	
	@Override
	public boolean add_user(User u) {
		accounts.add(u);
		return true;
	}

	@Override
	public User get_user(String username) {
		for(User u : accounts)
		{
			if(u.user.equals(username))
				return u;
		}
		return null;
	}

	@Override
	public User validate_login(String username, String pass) {
		for(User u : accounts)
		{
			if(u.user.equals(username) && u.pass.equals(pass))
				return u;
		}
		return null;
	}

	@Override
	public boolean check_duplicate(String username) {
		for(User u : accounts)
		{
			if(u.user.equals(username))
				return true;
		}
		return false;
	}

}
