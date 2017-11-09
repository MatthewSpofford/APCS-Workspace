
public class Dictionary extends Book{

	private int pages;
	private int words;
	public Dictionary(int pages, int words)
	{
		super(pages, "Dictionary", "Webster");
		this.pages = pages;
		this.words = words;
	}
	
	public double getWrdPerPage()
	{
		return words / pages;
	}
}
