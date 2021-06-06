import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.adapters.GoogleAuthManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1, "Esra", "Þahinler", "yusuf@gmail.com", "12345");
        AuthManager authManager = new AuthManager(
                new UserManager(new HibernateUserDao()),
                new GoogleAuthManagerAdapter()
        );
        authManager.register(user);
        user.setConfirmActivationCode("Esra123");
        authManager.login(user);
	}

}
