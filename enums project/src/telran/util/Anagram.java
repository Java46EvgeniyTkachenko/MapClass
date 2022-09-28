package telran.util;

import java.util.HashMap;

public class Anagram {
	/**
	 * 
	 * @param <K>
	 * @param word
	 * @param anagram
	 * @return true if anagram is one of the possible anagrams of a given word
	 *         anagram is a string containing all symbols from a given word with
	 *         different order Example: yellow (wolely, lowlye, yellow) , wrong
	 *         anagrams (yello, yelllw)
	 */
	public static boolean isAnagram2(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		HashMap<Character, Integer> hashmap1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hashmap2 = new HashMap<Character, Integer>();

		char arr1[] = word.toCharArray();
		char arr2[] = anagram.toCharArray();

		for (int i = 0; i < arr1.length; i++) {
			if (hashmap1.get(arr1[i]) == null) {
				hashmap1.put(arr1[i], 1);
			} else {
				int c = (int) hashmap1.get(arr1[i]);
				hashmap1.put(arr1[i], ++c);
			}
			if (hashmap2.get(arr2[i]) == null) {
				hashmap2.put(arr2[i], 1);
			} else {
				int d = (int) hashmap2.get(arr2[i]);
				hashmap2.put(arr2[i], ++d);
			}
		}

		return hashmap1.equals(hashmap2);

	}

	public static boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		char arr1[] = word.toCharArray();
		char arr2[] = anagram.toCharArray();

		for (int i = 0; i < arr1.length; i++) {
			if (hashmap.get(arr1[i]) == null) {
				hashmap.put(arr1[i], 1);
			} else {
				int c = (int) hashmap.get(arr1[i]);
				hashmap.put(arr1[i], ++c);
			}
			if (hashmap.get(arr2[i]) == null) {
				hashmap.put(arr2[i], -1);
			} else {
				int d = (int) hashmap.get(arr2[i]);
				hashmap.put(arr2[i], --d);
			}
		}

		for (HashMap.Entry<Character, Integer> set : hashmap.entrySet()) {
			if (set.getValue() != 0) {
				return false;
			}
		}
		return true;
	}
}
