
public class Book {

	private int pages;
	private String title = "";
	private String author = "";
	
	public Book(int pages, String title, String author)
	{
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	
	public void pageMessage()
	{
		System.out.println("Number of pages: " + pages);
	}
	
	public int getPages()
	{
		return pages;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getAuthor()
	{
		return author;
	}
}
