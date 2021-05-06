package task01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jdt.internal.compiler.batch.Main;

public class Application {

	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger(Main.class);
		PropertyConfigurator.configure("loggerConfig");
		log.trace("Starting application...");

		List<User> userList = new ArrayList<>();
		userList.add(new User("Богдан", "Хмельницький", "hmil@gmail.com", "1111", "USER"));
		userList.add(new User("Андрій", "Хитрий", "hytryy@gmail.com", "1111", "USER"));

		UserDao userDAO = new UserDao();
		userList.forEach(user -> {
			try {
				System.out.println(userDAO.insert(user.getFirstName(), user.getLastName(), user.getEmail(),
						user.getPassword(), user.getAccessLevel()));
			} catch (Exception e) {
				log.error("Error occured!", e);
				e.printStackTrace();
			}
		});

		MagazineDao magazineDao = new MagazineDao();
		magazineDao.insert(new Magazine("Forbes", "19170101", 1));
		magazineDao.readAll().forEach(System.out::println);

		SubscriberDao subscribeDAO = new SubscriberDao();
		System.out.println(subscribeDAO.insert(2, 1, true, LocalDate.parse("2020-06-26"), 20));
		subscribeDAO.readAll().forEach(System.out::println);
	}

}