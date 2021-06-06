package business.abstracts;

import entities.concretes.User;

public interface UserService {
	boolean getByEmail(String email);
	void add(User user);
	void update(User user);
	void delete(User user);
}
