package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EditDistance {


    public static void main(String[] args) {
//        Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
//                You have the following 3 operations permitted on a word:
//
//        Insert a character
//        Delete a character
//        Replace a character


    }

//    Let following be the function definition :-
//
//    f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
//
//    Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
//
//    f(i, j) = f(i - 1, j - 1)
//
//    Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
//
//    f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
//
//    f(i, j - 1) represents insert operation
//    f(i - 1, j) represents delete operation
//    f(i - 1, j - 1) represents replace operation
//    Here, we consider any operation from word1 to word2. It means, when we say insert operation, we insert a new character after word1 that matches the jth character of word2. So, now have to match i characters of word1 to j - 1 characters of word2. Same goes for other 2 operations as well.
//
//    Note that the problem is symmetric. The insert operation in one direction (i.e. from word1 to word2) is same as delete operation in other. So, we could choose any direction.
//
//    Above equations become the recursive definitions for DP.
//
//    Base Case:
//
//    f(0, k) = f(k, 0) = k
//
//    Below is the direct bottom-up translation of this recurrent relation. It is only important to take care of 0-based index with actual code :

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }

}
