// Part 2 here.....

import javafx.util.Pair;
import java.util.ArrayList;

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
        for (int i=0; i < inputArray.size(); i++)
        {
            for(int j=i+1; j<inputArray.size(); j++)
            {
                int sum = inputArray.get(i) + inputArray.get(j);
                if(sum == targetSum)
                {
                    matching_pairs.add(new Pair(inputArray.get(i),inputArray.get(j)));
                }
            }
        }
        return matching_pairs;
    }






    public static void main(String[] args){
        /*
        System.out.println(isStringPermutation("cane","enac")); //true
        System.out.println(isStringPermutation("nakii","akn")); //false
        System.out.println(isStringPermutation("magic","camgi"));  //true
        System.out.println(isStringPermutation("","")); //true
        System.out.println(isStringPermutation("thesaurus","thesaurus")); //true
         */
        /*
        ArrayList<Integer> numbers = new ArrayList<Integer>(5);
        numbers.add(5);
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        System.out.println(pairsThatEqualSum(numbers,10));
         */
    }
}