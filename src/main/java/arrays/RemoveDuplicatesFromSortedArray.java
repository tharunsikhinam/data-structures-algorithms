package arrays;
import java.io.*;


/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Input: [0,0,1,1,2,3,3]
Output: [0,1,2,3]
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        //base condition
        if(nums.length == 0) return 0;
        int index = 1;
        // iterate through the array, find out non-duplicates and place them in order
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1])
                nums[index++] = nums[i];
        }
        return index;
    }
}

public class RemoveDuplicatesFromSortedArray {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            // create your own dummy array
            // int[] nums2 = {0,0,1,1,2,2,3,3};
            int ret = new Solution().removeDuplicates(nums);
            String out = integerArrayToString(nums, ret);

            System.out.print(out);
            System.exit(0);
        }
    }
}