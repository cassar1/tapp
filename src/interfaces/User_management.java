package interfaces;

import implementation.User;

public interface User_management {
	public boolean add_user(User u);
	public User get_user(String username);
	public User validate_login(String username,String pass);
	public boolean check_duplicate(String username);
}
