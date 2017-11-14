
public class Dictionary extends Book{

	private int words;
	public Dictionary(int pages, int words)
	{
		super(pages, "Dictionary", "Webster");
		this.words = words;
	}
	
	@Override
	public void pageMessage()
	{
		System.out.println("Number of pages: " + getPages());
		System.out.println("Words per Page: " + getWrdPerPage());
	}
	
	private double getWrdPerPage()
	{
		return words / getPages();
	}
}
