package StuMan;
import java.util.*; 

public class V2 {  public static void main(String[] args) {   // construct and fill up ArrayList   
	ArrayList<String> words = new ArrayList<String>();   words.add("four");   words.add("score");   words.add("and");   words.add("seven");   words.add("years");   words.add("ago");   System.out.println("words = " + words);   words.set(2,"hello");   System.out.println("words = " + words);   System.out.println("if words contain ~ ?= "+words.contains("~")); 

 
  // insert one tilde in front of each word  
for (int i = 0; i < words.size(); i += 2) { 
   words.add(i, "~");   } 
 
  System.out.println("after loop words = " + words);   System.out.println("if words contain ~ ?= "+words.contains("~"));   if(words.contains("~")){    System.out.println("first ~  in words = "+words.indexOf("~"));    System.out.println("last ~  in words = "+words.lastIndexOf ("~"));   }  
 
  // remove tildes  
  for (int i = 0; i < words.size(); i++) {    words.remove(i);   }   System.out.println("after second loop words = " + words);  } } 
