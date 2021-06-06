package entities.concretes;

import entities.abstracts.Entity;

public class User implements Entity{
	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private String activateCode;
    private String confirmActivationCode;
	
	public User() { }
	
	public User(int id, String firstName, String lastName, String eMail, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    public void setConfirmActivationCode(String confirmActivationCode) {
        boolean result = this.activateCode.equals(confirmActivationCode);
        if (!result){
            System.out.println("Girilen kod doðru deðil, iþlem baþarýsýz");
            return;
        }

        this.confirmActivationCode = confirmActivationCode;
        System.out.println("Active etme iþlemi baþarýlý");
    }

    public boolean checkActivationCode(){
        if (!(this.activateCode == null))
           return this.activateCode.equals(this.confirmActivationCode);

        return false;
    }
}
