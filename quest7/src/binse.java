
import java.io.*;
/**
 * it performs binary search 
 * @author supreet
 */
public class binse {
	public static void sort(String [] words) {
		int length = words.length;
		for(int i=0; i<length; i++) {
			for(int j=i; j<length; j++) {
				if(words[i].compareTo(words[j]) > 0) {
					String temp = words[i];
					words[i] = words[j];
					words[j] = temp;
				}
			}
		}
	}
/**
 * 
 * @param word word to be searched using binary search
 * @param words array of string in which the word is to be searched
 * @param a lower index
 * @param b upper index
 * @return 
 */
	public static int bsearch(String word, String [] words, int a, int b) {
		if(b <= a)
			return -1;

		if(b - a == 1)
			return words[a].equals(word) ? a : -1;

		int pivot = (a + b)/2;
		if(word.compareTo(words[pivot]) < 0) {
			return bsearch(word, words, 0, pivot);
		} else if(word.compareTo(words[pivot]) > 0) {
			return bsearch(word, words, pivot, b);
		}

		return pivot;
	}

	
}