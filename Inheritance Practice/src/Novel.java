
public class Novel extends Book{
	
	private String genre;
	
	public Novel(int pages, String title, String genre, String author)
	{
		super(pages, title, author);
		this.genre = genre;
	}
	
	@Override
	public void pageMessage()
	{
		System.out.println("Number of Pages: " + getPages());
		System.out.println("Genre: " + genre);
	}
	
	@Override
	public String toString()
	{
		return getTitle() + ", " + getAuthor() + ", " + getPages() + ", " + genre;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(super.equals(obj))
		{
			if(getClass() == obj.getClass())
			{
				Novel temp = (Novel) obj;
				if(genre.equals(temp.genre))
					return true;
			}
		}
		
		return false;
	}
}
