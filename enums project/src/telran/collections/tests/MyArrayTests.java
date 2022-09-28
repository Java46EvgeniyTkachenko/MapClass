package telran.collections.tests;


import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.MyArray;

class MyArrayTests {
	private HashMap<Integer, String> hashTempMap = new HashMap<Integer, String>();
	@BeforeEach
	void setUp() {
				 		   
		    hashTempMap.put(1, "Geeks");
		    hashTempMap.put(2, "4");
		    hashTempMap.put(3, "Weeks");
		    hashTempMap.put(4, "Welcomes");
		    hashTempMap.put(5, "toYou");
	}

	@SuppressWarnings("static-access")
	@Test
	void testMyArray() {
	@SuppressWarnings("rawtypes")
	MyArray myArray = new MyArray(); 
	int size = 16;
	myArray.MyArray(size);
	}

	@Test
	void testSetAll() {
		@SuppressWarnings("rawtypes")
		MyArray myArray = new MyArray(); 
		myArray.setAll(hashTempMap);
		assertEquals(myArray.hashMap.toString(),hashTempMap.toString());
		     assertEquals(myArray.hashMap,hashTempMap);
	}

	@Test
	void testGet() {
		@SuppressWarnings("rawtypes")
		MyArray myArray = new MyArray(); 
	    myArray.setAll(hashTempMap);
		assertEquals(myArray.get(1),"Geeks");
		assertEquals(myArray.get(6),null);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testSet() {
		@SuppressWarnings("rawtypes")
		MyArray myArray = new MyArray(); 
	    myArray.set(6, "TestSet");
	    assertEquals(myArray.get(6),"TestSet");
	    
	}

}
