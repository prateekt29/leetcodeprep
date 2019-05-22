package Subarray;

import java.util.HashMap;

public class MaximumSumSubArraySizeEqualsk {


    public static void main(String[] args) {


//        Given an array of integers and a number k, find maximum sum of a subarray of size k


    }

    public static int maxSum(int arr[], int n, int k)
    {
        // k must be greater
        if (n < k)
        {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int res = 0;
        for (int i=0; i<k; i++)
            res += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int curr_sum = res;
        for (int i=k; i<n; i++)
        {
            curr_sum += arr[i] - arr[i-k];
            res = Math.max(res, curr_sum);
        }

        return res;
    }

}
