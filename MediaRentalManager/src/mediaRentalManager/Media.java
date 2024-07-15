package mediaRentalManager;
/**
 * The Media class represents all media types in the media rental system.
 * It stores information about the title and number of copies available.
 */
public class Media implements Comparable <Media>{
	String title;
	int copiesAvailable;
	/**
	 * Constructor a new Media object with the title, and copiesAvaiable, 
	 * @param title
	 * @param copiesAvailable
	 */
	public Media(String title, int copiesAvailable) {
		this.title = title;
		this.copiesAvailable = copiesAvailable;
	}
	/**
	 * get title
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * get copiesAvailable
	 * @return copiesAvailable
	 */
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	/**
	 * set copiesAvailable
	 * @param copiesAvailable
	 */
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	/**
	 * check if there are copies available
	 * @param media
	 * @return true if there are copies available, false otherwise
	 */
	public boolean copiesAvailable(Media media) {
		return getCopiesAvailable() > 0;
	}
	/**
	 * reduce the number of copiesAvailable
	 */
	public void reduce() {
		copiesAvailable--;
	}
	/**
	 * increase the number of copiesAvailable
	 */
	public void increase() {
		copiesAvailable++;
	}
	/**
	 * compares media to another media object based on the titles. 
	 * @param media
	 * @return positive, zero or negative integer
	 */
	@Override
	public int compareTo(Media media) {
		return this.getTitle().compareTo(media.getTitle());
	}
	/**
	 * return a string containing all the information about the Media,
	 * including title, and number of copies available.
	 * @return a string which contains all the media information.
	 */
	public String toString() {
		return  "Title: " + title + ", " + 
				"Copies Available: " + copiesAvailable + ", ";
	}
}
