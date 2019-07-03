import java.util.*;

class Crossing{

	//Find the max sum of the crossing subarray
	//param: array, low, mid, high indices
	
	
	static int maxCrossingSub(int A[], int low, int mid, int high){
		//Total sums of two sub arrays, the max total of the two sub arrays
		//The postions where of the sub arrays  
		int maxLeft = 0, leftPos = 0, maxRight = 0, rightPos = 0, crossMax = 0;
		int sum= 0;
		//Start from the middle and go down to 0
		for(int i = mid; i >= low; --i){
			//total the sum
			sum += A[i];
			//if sum is greater than the previous subarray total then update maxLeft
			if(sum > maxLeft){
				maxLeft = sum;
				//keep track of the subarray with the greatest sum
				leftPos = i;
			}
		}
		//initialize sum back to zero
		sum = 0;
		//repeat the previous steps but for mid + 1 to the length of the array
		for(int j = mid + 1; j < A.length; j++){
			sum += A[j];
			if(sum > maxRight){
				maxRight = sum;
				rightPos = j;
			}	
		}
		//Calculate the subarray that crosses the middle
		crossMax = maxRight + maxLeft;
		return crossMax;
		// System.out.format("The left position is %d and the right postion is %d and the total sum is %d\n", leftPos, rightPos, crossMax);
	}
	static int findMaxSubarray(int A[], int low, int high){
		//base case: only one element
		if(low == high){
			return A[1];
		}
		else{
			//find middle
			int mid = (low+high)/2;
			// Is it the left sub array, right sub array or the cross sub array 
			return Math.max(Math.max(findMaxSubarray(A, low, mid), findMaxSubarray(A, mid+1, high)), maxCrossingSub(A, low, mid, high)); 
    } 
		
}
	
	
	public static void main(String args[]){
		int A[] = {-2, 3, 5, -4, -6, 6, 2};
		int len = A.length;
		int maxSum = findMaxSubarray(A, 0, len);
		System.out.println("The Max sum is "+ maxSum);
		
		/** Not finished **
		//Need to return the subarray
		
		
		// ** Testing **
		// Crossing cross = new Crossing();
		// cross.maxCrossingSub(A, 0, mid, A.length);
	}
	

}