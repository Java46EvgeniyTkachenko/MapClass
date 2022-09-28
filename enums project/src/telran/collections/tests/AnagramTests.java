package telran.collections.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Anagram.*;

import org.junit.jupiter.api.Test;

class AnagramTests {

	@Test
	void testIsAnagram() {
		String test = "yellow";
		assertTrue(isAnagram(test, "wolely"));
		assertTrue(isAnagram(test, "lowlye"));
		assertTrue(isAnagram("dAtA", "tAdA"));
		assertFalse(isAnagram("DayTime","yaDmeTii"));
		assertFalse(isAnagram("Привет","веПри"));
		
	}

}
