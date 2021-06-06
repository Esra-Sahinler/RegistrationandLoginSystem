package core.adapters;

import entities.concretes.User;
import googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthServiceExternal{
	private final GoogleAuthManager googleAuthManager;

    public GoogleAuthManagerAdapter() {
        this.googleAuthManager = new GoogleAuthManager();
    }
    
	@Override
	public void register(User user) {
		googleAuthManager.register(user);
	}

	@Override
	public void login(User user) {
		googleAuthManager.login(user);
	}

}
