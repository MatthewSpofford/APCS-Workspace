
public class program {
	
	public static void main(String[] args)
	{
		mystery1(321);
		int[] arr = {2, 4, 2, 3, 4, 1, 10, 5};
		String str = "ababc";
		int temp = countAbc(str);
		if(temp == 2)
			System.out.print("GOOD");
		else
			System.out.print("BAD");
	}
	
	public static void mystery1(int x)
	{
		System.out.print(x % 10);
		if((x / 10) != 0)
		{
			mystery1(x / 10);
		}
		System.out.print(x % 10);
	}
	
	public static int countAbc(String str) {
	  int posABC = str.indexOf("abc");
	  int posABA = str.indexOf("aba");
	  
	  if(posABC == -1 && posABA == -1)
	    return 0;
	  else if(posABC > -1 && posABA == -1)
	    return 1 + countAbc(str.substring(1 + posABC));
	  else if(posABA > -1 && posABC == -1)
	    return 1 + countAbc(str.substring(1 + posABA));
	  else if(posABC < posABA)
	    return 1 + countAbc(str.substring(1 + posABC));
	  else
	    return 1 + countAbc(str.substring(1 + posABA));
	}

	
	public static int array11(int[] nums, int index) {
	  if(nums.length == 0)
	    return 0;
	  
	  boolean outcome = nums[index] == 11;
	  if(nums.length - index == 1)
	    return outcome ? 1 : 0;
	  else
	    return outcome ? 1 : 0 + array11(nums, ++index);
	}
	
	public static boolean array220(int[] nums, int index) {
	  if(nums.length == 0)
	    return false;
	    
	  if(nums.length > index + 1)
	  {
	    if(nums[index] == nums[index+1]/10)
	      return true;
	    else
	      return array220(nums, ++index);
	  }
	  else
	    return false;
	}


}
