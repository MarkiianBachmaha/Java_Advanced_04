package task01;

import java.time.LocalDate;

public class Subscriber {

	private int id;
	private int userID;
	private int magazineID;
	private boolean subscriberStatus;
	private LocalDate subscriberDate;
	private int subscriberPeriod;

	public Subscriber(int id, int userID, int magazineID, boolean subscribeStatus, LocalDate subscribeDate,
			int subscribePeriod) {
		this.id = id;
		this.userID = userID;
		this.magazineID = magazineID;
		this.subscriberStatus = subscribeStatus;
		this.subscriberDate = subscribeDate;
		this.subscriberPeriod = subscribePeriod;
	}

	public Subscriber(int userID, int magazineID, boolean subscribeStatus, LocalDate subscribeDate,
			int subscribePeriod) {
		this.userID = userID;
		this.magazineID = magazineID;
		this.subscriberStatus = subscribeStatus;
		this.subscriberDate = subscribeDate;
		this.subscriberPeriod = subscribePeriod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getMagazineID() {
		return magazineID;
	}

	public void setMagazineID(int magazineID) {
		this.magazineID = magazineID;
	}

	public boolean getSubscriberStatus() {
		return subscriberStatus;
	}

	public void setSubscriberStatus(boolean subscribeStatus) {
		this.subscriberStatus = subscribeStatus;
	}

	public LocalDate getSubscriberDate() {
		return subscriberDate;
	}

	public void setSubscriberDate(LocalDate subscribeDate) {
		this.subscriberDate = subscribeDate;
	}

	public int getSubscribePeriod() {
		return subscriberPeriod;
	}

	public void setSubscribePeriod(int subscribePeriod) {
		this.subscriberPeriod = subscribePeriod;
	}

	@Override
	public String toString() {
		if (id == 0)
			return "userID#" + userID + ", magazineID#" + magazineID + ", Підписка: " + subscriberStatus
					+ ", Дата оформлення: " + subscriberDate + ", Період підписки: " + subscriberPeriod + " міс.";
		else
			return "Subscribe ID#" + id + ": userID#" + userID + ", magazineID#" + magazineID + ", Підписка: "
					+ subscriberStatus + ", Дата оформлення: " + subscriberDate + ", Період підписки: "
					+ subscriberPeriod + " міс.";
	}

}
