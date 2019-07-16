/*This program is a coding practice.
The challenge is: Given an array of unique characters arr and a
string str, Implement a function getShortestUniqueSubstring that finds
the smallest substring of str containing all the characters in arr. Return
"" (empty string) if such a substring doesn't exist. */
package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App {
    /*Function: getShortestUniqueSubstring
    Description: compares a string to an array of characters. Starting
    with the smallest possible substring size (the size of the array) the
    method searches the string from left to right to find those array characters.
    if none are found, the search window increases by one on each pass to find
    a possible larger substring that could contain those characters. By starting
    with the smallest possible window it ensures that the first found result will
    be the smallest substring.
    input: array of unique characters and a string
    output: a substring containing the array characters or an empty string */
    static String getShortestUniqueSubstring(char[] arr, String str) {
        //first the array is sorted for easier comparing
        Arrays.sort(arr);
        //an arraylist is declared. this will be compared against the original array
        ArrayList<Character> al = new ArrayList<Character>();
        //starting and ending positions for the substring are initialized
        int start = 0;
        int end = 0;
        //the search window size is declared. it starts with the smallest possible
        //size(the size of the character array)
        int window = arr.length;
        //string length is determined
        int strLength = str.length();
        //while the window size is less than the string length
        while(window < strLength){
            //iterate through the string with the window
            for(int i = 0; i <= strLength-window; i++){
                //add each unique element in the window to the arraylist
                for(int j = i;j < window+i; j++){
                    if(!al.contains(str.charAt(j)))
                        al.add(str.charAt(j));
                }
                //sort the arraylist
                Collections.sort(al);
                //compare the arraylist to the original array
                //if it matches then the smallest substring has been found
                if(al.toString().equals(Arrays.toString(arr))){
                    start = i;
                    end = i + window;
                    strLength = -1;
                    break;
                }
                //if there is not a match then clear the arraylist, increase the
                //window size and continue the search
                else al.clear();
            }
            window++;
        }
        //return the found substring using the start and end indexes
        return str.substring(start,end);
    }

    public static void main(String[] args) throws Exception {
        //declare the array of characters and the string to be
        //searched for a substring with those characters
        char[] arr = new char[] {'x','y','z'};
        String str = "xyyzyzyx";
        //print out the found substring by calling the 
        //getShortestUniqueSubstring method
        System.out.println("The shortest substring is: "+
        getShortestUniqueSubstring(arr,str));

    }
}