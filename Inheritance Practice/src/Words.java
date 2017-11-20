import java.util.ArrayList;

public class Words {
	
	public static void main(String[] args)
	{
		Dictionary webster = new Dictionary(600, 1300);
		Dictionary weby = new Dictionary(600, 1300);
		Novel book2 = new Novel(600, "The Book", "SciFi", "Me");
		Novel book = new Novel(600, "The Book", "SciFi", "Me");

		System.out.println(webster.equals(weby));
		System.out.println(webster.equals(book2));
		System.out.println(book2.equals(book));
		
		System.out.println(book2 + "\n" + webster);
		
		webster.pageMessage();
		book.pageMessage();
		
		System.out.println("\n\n");
		
		Book[] library = new Book[4];
		library[0] = webster;
		library[1] = book;
		library[2] = book2;
		library[3] = weby;
		
		for(Book temp : library)
		{
			temp.pageMessage();
		}
		System.out.println(((Novel)library[2]).getGenre() + "\n\n");
		
		Online[] onlineLib = new Online[4];
		
		onlineLib[0] = book;
		onlineLib[1] = weby;
		onlineLib[2] = webster;
		onlineLib[3] = book2;
		
		for(Online temp : onlineLib)
		{
			System.out.println(temp.isOnline());
		}
	}
}
