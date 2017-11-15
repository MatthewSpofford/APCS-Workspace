
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
	
	@Override
	public String toString()
	{
		return title + ", " + author + ", " + pages;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
			return true;
		if(getClass() != obj.getClass())
			return false;
		
		Book temp = (Book) obj;
		
		if(title == temp.title && author == temp.author && pages == temp.pages)
			return true;
		else
			return false;
	}
}
