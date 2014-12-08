package interfaces;

import com.assign.models.*;

public interface User_management {
	public boolean add_user(User u);
	public User get_user(String username);
	public Integer get_user_id(String username);
	public User validate_login(String username,String pass);
	public boolean check_duplicate(String username);
	public void increment_attempts(String username); 
	public void reset(String username);
	public void block_user(String username);
	public void test_before();
	public void test_after();
}
