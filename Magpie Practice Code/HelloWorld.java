import java.util.Scanner;

// one class needs to have a main() method
public class HelloWorld
{
	// arguments are passed using the text field below this editor
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
    
	    String line = "jiruaoncmeiuwahfruiewhafuywnacuyweboygwayfudcbetygyfwfgcbyweabgfyewabcwegfdyweusgfyweugfyewgafyuewgyaruetwscgbwseytugfweyu";
	    int start = 12;
	    String find = "s";
	    
	    System.out.println(findIndex(line, find, start));
	    
	    in.close();
	}
  
	public static int findIndex(String line, String find, int start)
	{
		char finder = find.charAt(0);
		boolean lastIsFind = false;
	    boolean lastIsRepeat = false;
	    for(int i = 0; i < line.length(); i++)
	    {
	    	char curr = line.charAt(i);
	    	System.out.println(curr);
	    	if(curr == finder)
	    	{
	    		if(i + 1 == line.length())
	    			return i;
	    		if(lastIsFind)
	    			lastIsRepeat = true;
	    		else
	    			lastIsRepeat = false;
	    		lastIsFind = true;
	    	}
	    	else
	    	{
	    		if(lastIsFind && !lastIsRepeat && i - 1 >= start)
	    			return i - 1;
	    		lastIsFind = false;
	    		lastIsRepeat = false;
	    	}
	      	System.out.println(lastIsFind + "\n" + lastIsRepeat + "\n");
	    }
	    return -1;
	}
}

