package Exceptions;

public class UserIdNotFoundException extends Exception {
	private static final long serialVersionUID = 2L;
	public UserIdNotFoundException(int id) {
		// TODO Auto-generated constructor stub
		super("user id is not found with id "+id);
	}

}
