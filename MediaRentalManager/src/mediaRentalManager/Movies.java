package mediaRentalManager;
/**
 * The Movies class extends the Media class to represent a movies
 * It stores information about the title, copiesAvailble, and rating.
 */
public class Movies extends Media{
	String rating;
	/**
	 * Constructor a new Movies object with the title, copiesAvaiable, 
	 * and rating
	 * @param title
	 * @param copiesAvailable
	 * @param rating
	 */
	public Movies(String title, int copiesAvailable, String rating) {
		super(title, copiesAvailable);
		this.rating = rating;
	}
	/**
	 * get rating
	 * @return rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * get copies Available
	 * @return copiesAvailable
	 */
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	/**
	 * return a string containing all the information about the movie,
	 * including title, number of copies available, and rating. 
	 * @return a string which contains all the movie information.
	 */
	public String toString() {
		return super.toString() + 
				"Rating: " + rating + "\n";
	}
}
