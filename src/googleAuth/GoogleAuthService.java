package googleAuth;

import entities.concretes.User;

public interface GoogleAuthService {
	boolean register(User user);
    boolean login(User user);
}
