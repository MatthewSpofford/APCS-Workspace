
public class Novel extends Book{
	
	private String genre;
	
	public Novel(int pages, String title, String genre, String author)
	{
		super(pages, title, author);
		this.genre = genre;
	}
}
