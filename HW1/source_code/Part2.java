// Part 2 here.....

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.*;

class Part2{
    /*If s1 is the same length as s2 and every element in s1 is within s2, then it is a permutation */
    public static boolean isStringPermutation(String s1, String s2)
    {
//        If length of s1 != length of s2, return false
        if (s1.length() != s2.length()) {
            return false;
        }
        //otherwise make sure each element in string 1 is contained in string 2
        else {
            int i = 0;
            while (i < s1.length()) {
               if(! s2.contains(Character.toString(s1.charAt(i))))
               {
                    return false;
               }
                i++;
            }
            return true;
        }
    }

    /* Array<Pair<int>> pairsThatEqualSum(Array<int> inputArray, int targetSum)
    This function takes an array of integers and a target integer to which the array elements must sum.
    It returns an array of all pairs of integers from the input array whose sum equals the target.
     */
    public static  ArrayList<Pair<Integer,Integer>> pairsThatEqualSum(ArrayList<Integer> inputArray, int targetSum)
    {
        ArrayList<Pair<Integer,Integer>> matching_pairs = new ArrayList<Pair<Integer,Integer>>();
        //implement a hash set to prevent pair duplicates
        Set<Pair<Integer,Integer>> matching_set = new HashSet<Pair<Integer,Integer>>();
        for (int i=0; i < inputArray.size(); i++)
        {
            for(int j=i+1; j<inputArray.size(); j++)
            {
                //System.out.println(inputArray.get(i) + " ~~ "+ inputArray.get(j));
                int sum = inputArray.get(i) + inputArray.get(j);
                //System.out.println(sum + " // "+targetSum);
                if(sum == targetSum)
                {
                    matching_set.add(new Pair(inputArray.get(i),inputArray.get(j)));
                }
            }
        }
        for(Pair<Integer,Integer> pair : matching_set)
        {
            matching_pairs.add(pair);
        }
        return matching_pairs;
    }






    public static void main(String[] args){
        /*
        //Tests for isStringPermutation
        //a permutation
        System.out.println(isStringPermutation("cane","enac")); //true
        //a non-permutation
        System.out.println(isStringPermutation("nakii","akn")); //false
        //a permutation
        System.out.println(isStringPermutation("magic","camgi"));  //true
        //empty strings
        System.out.println(isStringPermutation("","")); //true
        //same strings
        System.out.println(isStringPermutation("thesaurus","thesaurus")); //true
        //a non-permutation
        System.out.println(isStringPermutation("thesaaras","thesaurus")); //false
        */

        /*
        //Tests for pairsThatEqualSum
        //array {5,5,2,8,1}
        ArrayList<Integer> numbers = new ArrayList<Integer>(5);
        numbers.add(5);
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        System.out.println(pairsThatEqualSum(numbers,10));
        //array {2,2,2,8,5}
        ArrayList<Integer> numbers2 = new ArrayList<Integer>(5);
        numbers2.add(2);
        numbers2.add(2);
        numbers2.add(2);
        numbers2.add(8);
        numbers2.add(5);
        System.out.println(pairsThatEqualSum(numbers2,10));
        //array {-12,2,9,20,-5,-17,0,-3}
        ArrayList<Integer> numbers3 = new ArrayList<Integer>(8);
        numbers3.add(-12);
        numbers3.add(2);
        numbers3.add(9);
        numbers3.add(20);
        numbers3.add(-5);
        numbers3.add(-17);
        numbers3.add(0);
        numbers3.add(-3);
        System.out.println(pairsThatEqualSum(numbers3,-3));
        */
    }
}