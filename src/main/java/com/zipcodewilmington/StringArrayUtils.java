package com.zipcodewilmington;


import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(String valueInArray:array){
            if(valueInArray.equals(value)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        for(int i=0;i<=array.length/2;i++){
            String temp=array[i].toString();
            array[i]=array[array.length-1-i] ;
            array[array.length-1-i]=temp;

        }
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        boolean status=false;
        for(int i=0;i<=array.length/2;i++) {
            if(array[i]==array[array.length-1-i])
                status=true;
            else
                status=false;
        }
        return  status;

    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
      String word="";
      for(String w:array) {
          word += w.toLowerCase();
      }
       String newword=word.replaceAll("(.)(?=.*\\1)", "").replaceAll("\\s+", "");
       if(newword.length()==26){
           return true;
       }
       else
        return false;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int counter=0;
        for(String str: array){
            if(str.equals(value)){
                counter++;
            }
        }
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> al=new ArrayList<String>(Arrays.asList(array));
        al.remove(valueToRemove);
        return al.toArray(new String[al.size()]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> al=new ArrayList<String>(Arrays.asList(array));
        ArrayList<String> result=new ArrayList<String>();
        int counter=0;
        while(counter<al.size())
        {
            if(counter<al.size()-1 && al.get(counter).equals(al.get(counter+1))) {
                counter++;
            }
            else {
                result.add(al.get(counter));
                counter++;
            }
        }
        return result.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> al= new ArrayList<String>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<array.length;i++){
            if(i< array.length-1 && array[i].equals(array[i+1])){
                if(sb.length()==0) {
                    sb.append(array[i]);
                    sb.append(array[i+1]);
                } else {
                    sb.append(array[i+1]);
                }
            }
            else{
                if(sb.length()>0){
                    al.add(sb.toString());
                    sb.delete(0,sb.length());
                }
                else{
                    al.add(array[i]);
                }
            }
        }
        return al.toArray(new String[0]);
    }
}
