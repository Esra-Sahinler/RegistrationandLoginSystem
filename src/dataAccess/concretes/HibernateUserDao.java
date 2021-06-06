package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao{

	@Override
	public List<User> getAll() {
		User user = new User(1, "Esra", "Þahinler", "esra@gmail.com", "12345");
        List<User> users = new ArrayList<>();
        users.add(user);

        return users;
	}

	@Override
	public void add(User user) {
		System.out.println("Hibernate ile eklendi, " + user.getFirstName());
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile güncellendi, " + user.getFirstName());
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate ile silindi, " + user.getFirstName());
	}

}
