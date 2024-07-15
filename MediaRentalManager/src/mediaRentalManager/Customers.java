package mediaRentalManager;
import java.util.ArrayList;
/**
 * represents a customer who can rent and queue media from a media.
 * a customer has name, address, plan, a list of rented, a list of queue, and 
 * a number of rented media.
 * the class provides method for adding and removing media from the rented 
 * and queued lists
 * in addition, it checks whether a customer can rent or queue more media.
 */
public class Customers implements Comparable <Customers>{
	private String name;
	private String address;
	private String plan;
	private ArrayList<Media> rented;
	private ArrayList<Media> queue;
	private int numRented;
	/**
	 * Constructor a customer with a name, address and plan
	 * Initializes rented and queue arrayLists to be empty and numRented to 0
	 * @param name
	 * @param address
	 * @param plan
	 */
	public Customers (String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		this.rented = new ArrayList <Media>();
		this.queue = new ArrayList <Media>();
		this.numRented = 0;
	}
	/**
	 * get name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * get address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * get plan
	 * @return plan
	 */
	public String getPlan() {
		return plan;
	}
	/**
	 * get arrayLists of rented
	 * @return rented
	 */
	public ArrayList <Media> getRented() {
		return rented;
	}
	/**
	 * add a media object to the arrayList of media and increment the numRented
	 * @param media
	 */
	public void addRented (Media media) {
		rented.add(media);
		numRented++;
	}
	/**
	 * remove a media object to the arrayList of media and
	 * decrement the numRented
	 * @param media
	 */
	public void removeRented(Media media) {
		rented.remove(media);
		numRented--;
	}
	/**
	 * get numRented
	 * @return numRented
	 */
	public int getNumRented() {
		return numRented;
	}
	/**
	 * set numRented
	 * @param numRented
	 */
	public void setnumRented(int numRented) {
		this.numRented = numRented;
	}
	/**
	 * get the arrayList of queue
	 * @return queue
	 */
	public ArrayList <Media> getQueue() {
		return queue;
	}
	/**
	 * add the media object to the ArrayList of queue
	 * @param media
	 */
	public void addQueue(Media media) {
		queue.add(media);
	}
	/**
	 * remove the media object to the ArrayList of queue
	 * @param media
	 */
	public void removeQueue(Media media) {
		queue.remove(media);

	}
	/**
	 * return a String represent of the customer, including their name,
	 * address, plan and media rentals and queue
	 * @return string
	 */
	public String toString() {
		String result = "";
		result +=   "Name: " + name + ", " + 
					"Address: " + address + ", " + 
					"Plan: " + plan + "\n";
		if (!rented.isEmpty()) {
			result += "Rented: [";
			for(Media media : rented) {
				result += media.getTitle() + ", ";
			}
			result = result.substring(0, result.length() - 2) + "]\n";
		} else {
			result +="Rented: []\n";
		}
		if (!queue.isEmpty()) {
			result +="Queue: [";
			for(Media media : queue) {
				result += media.getTitle() + ", ";
			}
			result = result.substring(0, result.length() - 2) + "]\n";
		}  else {
			result +="Queue: []\n";
		}
		return result;	
	}
	/**
	 * compares customer to another customer based on the names. 
	 * @param customer
	 * @return positive, zero or negative integer
	 */
	@Override
	public int compareTo (Customers customer) {
		return this.getName().compareTo(customer.getName());
	}
}
