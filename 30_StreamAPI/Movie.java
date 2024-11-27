

public class Movie {
	public String title;
	public int year;
	public double rating;
	
	
	public Movie(String title, int year, double rating) {
		super();
		this.title = title;
		this.year = year;
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", rating=" + rating + "]";
	}
	
	
}
