package mediaRentalManager;
/**
 * The MusicAlbums class extends the Media class to represent a music album
 * It stores information about the title, copiesAvailble, artist, and songs
 */
public class MusicAlbums extends Media {
	String artist;
	String songs;
	/**
	 * Constructor a new MusicAlbum object with the title, copiesAvaiable, 
	 * artist and songs.
	 * @param title
	 * @param copiesAvailable
	 * @param artist
	 * @param songs
	 */
	public MusicAlbums(String title, int copiesAvailable, String artist,
			String songs) {
		super(title, copiesAvailable);
		this.artist = artist;
		this.songs = songs;
	}
	/**
	 * get artist
	 * @return artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * get songs
	 * @return songs
	 */
	public String getSongs() {
		return songs;
	}
	/**
	 * return a string containing all the information about the album,
	 * including title, number of copies available, artist and songs. 
	 * @return a string which contains all the album information.
	 */
	public String toString() {
		return super.toString() + 
				"Artist: " + artist + ", " + 
				"Songs: " + songs + "\n";
	}
}
