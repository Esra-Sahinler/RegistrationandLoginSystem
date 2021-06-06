package core.adapters;

import entities.concretes.User;

public interface AuthServiceExternal {
	void register(User user);
	void login(User user);
}
