package business.concretes;

import java.util.Locale;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import business.validations.LoginValidation;
import business.validations.RegisterValidation;
import core.adapters.AuthServiceExternal;
import entities.concretes.User;

public class AuthManager implements AuthService{
	private final UserService userService;
    private final AuthServiceExternal authServiceExternal;

    public AuthManager(UserService userService, AuthServiceExternal authServiceExternal){
        this.userService = userService;
        this.authServiceExternal = authServiceExternal;
    }
	@Override
	public void login(User user) {
		boolean validationResult = LoginValidation.checkValidate(user);
        if (!validationResult) {
            System.out.println("Giri� ba�ar�s�z oldu");
            return;
        }

        if (!user.checkActivationCode()){
            System.out.println("Giri� ba�ar�s�z oldu");
            System.out.println("Aktivasyon kodunu onaylamadan giri� yap�lamaz");
            return;
        }

        System.out.println("Giri� ba�ar�l� oldu");
	}

	@Override
	public void register(User user) {
		boolean validationResult = RegisterValidation.checkValidate(user);
        if (!validationResult) return;

        boolean userExists = userService.getByEmail(user.geteMail().toLowerCase(Locale.ROOT));
        if (userExists) {
            System.out.println("Bu email adresi mevcut. L�tfen farkl� bir email adresi ile deneyin");
            return;
        }

        userService.add(user);
        System.out.println("Kay�t i�lemi ba�ar�l�");
        user.setActivateCode("Esra123");
        System.out.println("Do�rulama maili e-postan�za g�nderildi.");
	}
	
	 public void registerWithGoogle(User user){
	        authServiceExternal.register(user);

	        user.setActivateCode("Esra123");
	        System.out.println("Do�rulama maili e-postan�za g�nderildi.");
	    }

	    public void loginWithGoogle(User user){
	        if (!user.checkActivationCode()){
	            System.out.println("Giri� ba�ar�s�z oldu");
	            System.out.println("Aktivasyon kodunu onaylamadan giri� yap�lamaz");
	            return;
	        }

	        authServiceExternal.login(user);
	    }

}
