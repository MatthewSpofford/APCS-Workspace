
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
	}
}
