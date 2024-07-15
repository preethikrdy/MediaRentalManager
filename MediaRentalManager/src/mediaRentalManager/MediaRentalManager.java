package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Interface that defines the functionality expected from
 * the media rental manager.  The two possible media we can have
 * are movies and music albums.  A movie has a title, a number of copies
 * that are available for rent, and a rating (e.g., "PG"). An album
 * has a title, a number of copies, an artist, and a list of songs (String
 * with title of songs separated by commas).<br>
 * <br>
 * <b>IMPORTANT:</b>The database of the media rental manager, must define and use two
 * ArrayList.  One stores the media (both Movies and Album information)
 * and one stores Customer information.  You will lose significant credit
 * if you do not define and use these ArrayList objects.
 * 
 * @author cmsc131
 *
 */
public class MediaRentalManager implements MediaRentalManagerInt{
	private ArrayList <Customers> customersList;
	private ArrayList <Media> mediaList;
	private int limitedPlanLimit;

	/**
	 *Constructor that initializes customerList and mediaList. 
	 *Since LIMITED restricts the media to a default value of 2, 
	 *initialize limitedPlanLimit with a value of 2. 
	 */
	public MediaRentalManager () {
		this.customersList = new ArrayList<Customers>();
		this.mediaList = new ArrayList<Media>();
		this.limitedPlanLimit = 2;

	}
	/**
	 * Adds the specified customer to the database. The address is a physical address (not e-mail).
	 * The plan options available are: <b>LIMITED</b> and <b>UNLIMITED</b>.  LIMITED 
	 * defines a default maximum of two media that can be rented.
	 * @param name
	 * @param address
	 * @param plan 
	 */
	public void addCustomer(String name, String address, String plan) {
		Customers customers = new Customers(name, address, plan);
		customersList.add(customers);
	}
	/**
	 * Adds the specified movie to the database.  The possible values for rating are
	 * "PG", "R", "NR".
	 * @param title
	 * @param copiesAvailable
	 * @param rating
	 */
	public void addMovie(String title, int copiesAvailable, String rating) {
		Movies movies = new Movies(title, copiesAvailable, rating);
		mediaList.add(movies);
	}
	/**
	 * Adds the specified album to the database.  The songs String includes
	 * a list of the title of songs in the album (song titles are separated by
	 * commas).
	 * @param title
	 * @param copiesAvailable
	 * @param artist
	 * @param songs
	 */	
	public void addAlbum(String title, int copiesAvailable, 
			String artist, String songs) {
		MusicAlbums album = new MusicAlbums(title, copiesAvailable, 
				artist, songs);
		mediaList.add(album);
	}
	
	/** 
	 * This set the number of media associated with the LIMITED plan.
	 * @param value
	 */
	public void setLimitedPlanLimit(int value) {
		limitedPlanLimit = value;
	}

	/** 
	 * This get the number of media associated with the LIMITED plan.
	 * @return limitedPlanLimit
	 */
	public int getLimitedPlanLimit() {
		return limitedPlanLimit;
	}
	/**
	 * Returns information about the customers in the database.  The information is
	 * presented sorted by customer name.  See the public tests for the format
	 * to use.
	 * @return
	 */
	public String getAllCustomersInfo() {
		String info = "***** Customers' Information *****\n";
		Collections.sort(customersList);
		for(int i = 0 ; i < customersList.size(); i ++) {
			Customers customer = customersList.get(i);
			info += customer.toString();
		}
		return info;
	}
	
	/**
	 * Returns information about all the media (movies and albums) that are part
	 * of the database.  The information is presented sorted by media title.  See
	 * the public tests for the format to use.
	 * @return
	 */
	public String getAllMediaInfo() {
		String info = "***** Media Information *****\n";
		Collections.sort(mediaList);
		for(int i = 0 ; i < mediaList.size(); i ++) {
			Media media = mediaList.get(i);
			info += media.toString();
		}
		return info;
	}
	/**
	 * Adds the specified media title to the queue associated with a customer. 
	 * @param customerName
	 * @param mediaTitle
	 * @return false if the mediaTitle is already part of the queue (it will not be
	 * added)
	 */
	public boolean addToQueue(String customerName, String mediaTitle) {

		for(int i = 0 ; i < customersList.size(); i++) {
			Customers customer = customersList.get(i);
			if (customer.getName().equals(customerName)) {
				for(int j = 0; j < mediaList.size(); j++) {
					Media media = mediaList.get(j);
					boolean alreadyPart = false;
					for (int k = 0; k < customer.getQueue().size(); k++) {
						Media queue = customer.getQueue().get(k);
						if (queue.getTitle().equals(mediaTitle)) {
							alreadyPart = true;
							break;
						}
					}
					if (alreadyPart == false && 
							media.getTitle().equals(mediaTitle)) {
						customer.addQueue(media);
						return true;
					}
				}
			} 
		}
		return false; 
	}
	/**
	 * Removes the specified media title from the customer's queue.
	 * @param customerName
	 * @param mediaTitle
	 * @return false if removal failed for any reason (e.g., customerName not found)
	 */
	public boolean removeFromQueue(String customerName, String mediaTitle) {

		for(int i = 0 ; i < customersList.size(); i++) {
			Customers customer = customersList.get(i);
			if (customer.getName().equals(customerName)) {
				for (int k = 0; k < customer.getQueue().size(); k++) {
					Media queue = customer.getQueue().get(k);
					if (queue.getTitle().equals(mediaTitle)) {
						customer.getQueue().remove(i);
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Processes the requests queue of each customer.  The customers will be processed
	 * in alphabetical order.  For each customer, the requests queue will be checked
	 * and media will be added to the rented queue, if the plan associated with 
	 * the customer allows it, and if there is a copy of the media available.
	 * For UNLIMITED plans the media will be added to the rented queue always,
	 * as long as there are copies associated with the media available.  For
	 * LIMITED plans, the number of entries moved from the requests queue to the rented
	 * queue will depend on the number of currently rented media, and whether
	 * copies associated with the media are available.<br>
	 * <br> 
	 * For each media that is rented, the following message will be generated:<br>
	 * "Sending [mediaTitle] to [customerName]" <br>
	 * 
	 * @return 
	 */
	public String processRequests() {
		Collections.sort(customersList);
		String result = "";

		for(Customers customer : customersList) {
			ArrayList<Media> rented = new ArrayList<>();
			if (customer.getPlan().equals("UNLIMITED")) {
				for (Media media : customer.getQueue()) {
					if (media.copiesAvailable(media)) {
						customer.addRented(media);
						media.setCopiesAvailable(media.getCopiesAvailable() - 1);
						rented.add(media);
						result += "Sending " + media.getTitle() + " to " +
								customer.getName() + "\n";
					}
				}
			} else if (customer.getPlan().equals("LIMITED")) {
				int count = customer.getRented().size();
				int limit = limitedPlanLimit - count;

				for(Media media : customer.getQueue()) {
					if (limit == 0 ) {
						break;
					}
					if (media.copiesAvailable(media)) {
						customer.addRented(media);
						media.setCopiesAvailable(media.getCopiesAvailable() - 1);
						rented.add(media);
						limit--;
						result += "Sending " + media.getTitle() + " to " +
								customer.getName() + "\n";
					}
				}
			}
			for(Media media : rented) {
				customer.removeQueue(media);
			}
			rented.clear();
		}
		return result;
	}

	/**
	 * This is how a customer returns a rented media.  This method will remove the item
	 * from the rented queue and adjust any other values that are necessary (e.g., copiesAvailable)
	 * @param customerName
	 * @param mediaTitle
	 * @return
	 */
	public boolean returnMedia(String customerName, String mediaTitle) {
		for(Customers customer : customersList) {
			if (customer.getName().equals(customerName)) {
				for(int i = 0 ; i < customer.getRented().size(); i++) {
					Media media = customer.getRented().get(i);
					if (media.getTitle().equals(mediaTitle)) {
						customer.removeRented(media);
						customer.removeQueue(media);
						for(Media rentedMedia : mediaList) {
							if(rentedMedia.getTitle().equals(mediaTitle)) {
								rentedMedia.increase();
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Returns a SORTED ArrayList with media titles that satisfy the provided parameter values.
	 * If null is specified for a parameter, then that parameter should be ignore in the
	 * search.  Providing null for all parameters will return all media titles.
	 * @param title
	 * @param rating
	 * @param artist
	 * @param songs
	 * @return
	 */
	public ArrayList<String> searchMedia(String title, String rating, 
			String artist, String songs){
		ArrayList<String> result = new ArrayList<>();
		for(Media media : mediaList) {
			if (title != null && !media.getTitle().equals(title)){
				continue;
			}
			if (rating != null && !(media instanceof Movies)) {
				continue;
			}
			if (rating != null && media instanceof Movies && 
					!((Movies) media).getRating().equals(rating)){
				continue;
			}
			if (artist != null && !(media instanceof MusicAlbums)) {
				continue;	
			}
			if (artist != null && media instanceof MusicAlbums && 
					!((MusicAlbums) media).getArtist().equals(artist)){
				continue;
			}
			if (songs != null && !(media instanceof MusicAlbums)) {
				continue;
			}
			if (songs != null && media instanceof MusicAlbums && 
					((MusicAlbums) media).getSongs().indexOf(songs) == -1){
				continue;
			}
			result.add(media.getTitle());
		}
		Collections.sort(result);
		return result;

	}
}