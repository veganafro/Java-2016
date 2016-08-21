package homework;

import java.util.Scanner;

/**
 * 
 * @author Jeremy Muhia
 * 
 * @version 29 Feb 2016
 *
 */

public class SortedMerge {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.print("How long should the first array be?\n>");
		
		int length_list1 = input.nextInt();
		
		int[] list1 = new int[length_list1];
		
		for (int index = 0; index < length_list1; index++) {
			System.out.print("Give me the element at position " + index + " in the array\n>");
			
			list1[index] = input.nextInt();
			
		}
		
		System.out.print("How long should the second array be?\n>");
		
		int length_list2 = input.nextInt();
		
		int[] list2 = new int[length_list2];
		
		for (int index = 0; index < length_list2; index++) {
			System.out.print("Give me the element at position " + index + " in the array\n>");
			
			list2[index] = input.nextInt();
			
		}
		
		isSorted(list1);
		
		isSorted(list2);
		
		int[] merged = merge(list1, list2);
		
		isSorted(merged);
		
		for (int value: merged) {
			System.out.print(value + " ");
		}
		
		input.close();

	}
	
	public static int[] merge(int[] list1, int[] list2) {
		int[] merged = new int[list1.length + list2.length];
		
		//int nextFromList1 = 0;
		
		//int nextFromList2 = 0;
		
		int index = 0;
		
		for (int subIndex1 = 0; subIndex1 < list1.length; subIndex1++) {
			
			//if (list1[nextFromList1] > list2[nextFromList2]) {
				
				merged[index] = list1[subIndex1];
				
				index += 1;
				
				//if (nextFromList2 < list2.length - 1){
					
					//nextFromList2 += 1;
					
				//}
			
			//}
			//else {
				
				//merged[index] = list1[nextFromList1];
				
				//if (nextFromList1 < list1.length - 1){
					
					//nextFromList1 += 1;
				
				//}
				
			//}
		
		}
		for (int subIndex2 = 0; subIndex2 < list2.length; subIndex2++) {
			
			merged[index] = list2[subIndex2];
			
			index += 1;
			
		}
		
		return merged;
		
	}
	
	public static boolean isSorted(int[] list) {
		
		boolean sortState = false;
		
		for (int element = 0; element < list.length; element++) {
		
			int currentMinElement = list[element];
		
			for (int nextMinIndex = element + 1; nextMinIndex < list.length; nextMinIndex++) {
			
				int nextMinElement = list[nextMinIndex];
			
				if (currentMinElement > nextMinElement) {
				
					list[nextMinIndex] = list[element];
				
					list[element] = nextMinElement;
					
					currentMinElement = list[element];
					
				}
			
			}
		
		}
		
		sortState = true;
		
		return sortState;
		
	}

}
