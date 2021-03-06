package BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KClosestElement {


    public static void main(String[] args) {



        KClosestElement ob = new KClosestElement();
        Integer[] arr = { 0,1,1,1,2,3,6,7,8,9};
        List<Integer> list = Arrays.asList(arr);


        System.out.println(findClosestElements(list, 9, 4));


    }

    public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int n = arr.size();
        if (x <= arr.get(0)) {
            return arr.subList(0, k);
        } else if (arr.get(n - 1) <= x) {
            return arr.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(arr, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k + 1), high = Math.min(arr.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if ((x - arr.get(low)) <= (arr.get(high) - x))
                    high--;
                else if ((x - arr.get(low)) > (arr.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return arr.subList(low, high + 1);
        }
    }
}
