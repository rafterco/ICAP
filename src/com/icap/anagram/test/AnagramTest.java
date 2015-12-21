package com.icap.anagram.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

/**
 * ICAP test to find all the anagrams in a given dictionary. 
 * input:   Instance itialization block holding words that are and are not anagrams. 
 * output:  any anagrams in the dictionary - format [dog, god] 
 * 
 * @author colinrafter
 * commiting a new change to gitHub via the IDE.
		*/
public class AnagramTest {
	
	List<String> dictionary = new ArrayList<>();
	ListMultimap<String, String> multimap = ArrayListMultimap.create();
	
	public static void main(String... args){
		AnagramTest anagramTest = new AnagramTest();
		
		anagramTest.populateMultimap();
		anagramTest.printAnagrams();
	}

	/*
	 * Using each dictionary word as a key with its characters in alphabetic order will guarantee 
	 * an order to find each anagram. 
	 * 
	 * Using a Google multimap will allow many values for a single key. 
	 * 
	 * So looping through the dictionary once will populate the multimap with everything that is and is not an anagram. 
	 */
	private void populateMultimap() {
		for(String word: dictionary){
			char[] chars = word.toLowerCase().toCharArray();
			Arrays.sort(chars);
			String multimapKey = new String(chars);
			
			multimap.put(multimapKey, word);
		}
	}
	
	/*
	 * loop though the Multimap and print any values that have a count of > 1 (indicating an anagram for that key)
	 */
	private void printAnagrams() {
		System.out.println("Anagrams from the dictionary are: \n");
		
		Iterator<String> iterator = multimap.keySet().iterator();
		while(iterator.hasNext()){
			List<String> multimapValues = multimap.get(iterator.next());
			
			if(multimapValues.size() > 1)
				System.out.println(multimapValues);
		}
	}
	
	/*
	 * Instance itialization block to populate the dictionary. 
	 */
	{
		dictionary.add("dog");
		dictionary.add("God");
		dictionary.add("Java");
		dictionary.add("search");
		dictionary.add("chaser");
		dictionary.add("listen");
		dictionary.add("silent");
		dictionary.add("broker");
		dictionary.add("broke");
		
	}

}
