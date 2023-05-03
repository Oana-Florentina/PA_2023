package Homework;


/**
 * The Album class represents an album with a year, title, artist name, and list of genres.
 */
public class Album extends BaseEntity {
    private int year;
    private String title;
    private String artistName;
    private final String[] genres;

    /**
     * Constructs an album with the specified year, title, artist name, and genres string.
     *
     * @param year         the year the album was released
     * @param title        the title of the album
     * @param artistName   the name of the artist who released the album
     * @param genresString the string of genres associated with the album, separated by commas
     */
    public Album(int year, String title, String artistName, String genresString) {
        this.id = null;
        this.year = year;
        this.title = title;
        this.artistName = artistName;
        this.genres = genresString.split("\\s*,\\s*");
    }

    /**
     * Constructs an empty album with default values for all fields.
     */
    public Album() {
        this.id = null;
        this.year = 0;
        this.title = null;
        this.artistName = null;
        this.genres = null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String[] getGenres() {
        return genres;
    }

}

