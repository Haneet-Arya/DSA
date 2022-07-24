package setsAndMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LearningHashSet {
    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();
//        HashSet<Integer> s = new HashSet<>(size);
        s.add(5);
        s.add(10);
//        s.add(10);
//        System.out.println(s);
//        if (s.contains(5)) System.out.println("Present");
//        else System.out.println("Not Present");

        s.remove(10);
//        System.out.println(s.isEmpty());
//        System.out.println(s.size());
        s.clear();

        int[] a = {5, 10, 15, 5, 10};
        int[] b = {15, 5, 5, 10, 4};
//        System.out.println(countDistinct(a));
//        System.out.println(union(a, b));
//        System.out.println(intersection(a, b));
        countDistinct(new int[]{1, 2, 2, 1, 3, 1, 1, 3}, 4);
    }

    // counting distinct values in an array
    static int countDistinct(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int e : arr) {
            s.add(e);
        }

        return s.size();
    }

    // union of two arrays
    static int union(int[] a, int[] b) {
        Set<Integer> s = new HashSet<>();
        for (int e : a) {
            s.add(e);
        }
        for (int e : b) {
            s.add(e);
        }
        return s.size();
    }

    // Intersection of two arrays
    static int intersection(int[] a, int[] b) {
        int count = 0;
        Set<Integer> s = new HashSet<>();
        for (int e : a) {
            s.add(e);
        }
        for (int e : b) {
            if (s.contains(e)) {
                count++;
                s.remove(e);
            }
        }
        return count;
    }

    // Find subarray with the given sum
    static void subArray(int[] arr, int sum) {
        int currSum = 0, start = 0, end = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        // key as currentSum and value as index
        for (int i = 0; i < arr.length; i++) {
            currSum = arr[i];
            if (currSum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            if (map.containsKey(currSum - sum)) {
                start = map.get(currSum - sum) + 1;
                end = i;
                break;
            }
            map.put(currSum, i);
        }
        if (end == -1) System.out.println("No Subarray can be created");
        else System.out.println("Starting Index: " + start + "Ending Index: " + end);
    }
    // if it is asked to find smallest or largest sub array then maintain a length variable and instead of breaking
    // the loop check if length of current subarray is as per requirement

    // if question says to find the largest subarray with equal numbers of 0s and 1s, with the array [1,1,0,1,0,0,1]
    // then replace 0 with -1 and find the subarray of sum = 0 and maintain length variable


    // count distinct elements in window size of k
    static void countDistinct(int[] arr, int k){
        int count = 0;
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e: arr){
            if(count==k){
                if(map.get(arr[i])==1){
                    map.remove(arr[i]);

                } else {map.replace(arr[i], map.get(arr[i]) - 1);}
                count--;
                i++;
            }
            if(map.containsKey(e)){
                map.replace(e, map.get(e) + 1);
            }
            else {
                map.put(e, 1);
            }
            count++;

            if(count==k){
                System.out.println(map.size());
            }

        }
    }
}
