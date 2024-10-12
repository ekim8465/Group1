package mypack;
import java.util.*;

public class TwoSum {
	
	public static void main(String[] args){
		int nums[] = {10, 20, 5, 0, -1, 30};
	
		int targetSum = 50;
		
		int[] results = getPair(nums, targetSum); //brute-force
		System.out.println("The required indices which add upto " + targetSum + "are : " + results[0] + "," + results[1] );
		
		int[] results2 = getPairOptimized(nums, targetSum); //optimized
		System.out.println("Using optimized Solution, the required indices which add upto " + targetSum + "are : " + results2[0] + "," + results2[1] );
	
	}

	//optimized //map: key = number, value:index
	private static int[] getPairOptimized(int[] nums, int targetSum) {//10:0 ; 20:1; 5:2; 0:3; -1:4;
		int[] results2 = {-1, 1};
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++) { 
			int num = nums[i]; //20; 5; 0; -1; 30; 
			int compliment = targetSum - num; //30; 45; 50; 51; 20;
			if(map.containsKey(compliment)) {
				results2[0] = i;
				results2[1] = map.get(compliment);
				break;
			}
			else{
				map.put(num, i);
			}
		}
		
		return results2;
	}

	private static int[] getPair(int[] nums, int targetSum) {//brute-force
		int[] results = {1, -1};
		
		for (int i=0; i<nums.length; i++) {
			for (int j=i+1; j<nums.length; j++) {
				if (nums[i] + nums[j] == targetSum) {
					results[0] = i;
					results[1] = j;
				}
			}
		}
		return results;
		
	}
	
	
}
