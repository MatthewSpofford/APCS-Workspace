
public class program {
	
	public static void main(String[] args)
	{
		int[] arr = {2, 4, 2, 3, 4, 1, 10, 5};
		boolean temp = array220(arr,0);
		if(temp)
			System.out.print("GOOD");
		else
			System.out.print("BAD");
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
