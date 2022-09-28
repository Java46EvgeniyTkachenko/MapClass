package telran.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * All methods of the class should have complexity O[1]
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
public LinkedHashMap<Integer, String> liHashMap  = new LinkedHashMap<>();	
public HashMap<Integer, String> hashMap  = new HashMap<>();	

public static void MyArray(int size) {
		LinkedHashMap<Integer, String> liHashMap  = new LinkedHashMap<>(size, .75f, true);;
		
	}
	/**
	 * sets all array's elements with a given value
	 * @param value
	 * @return 
	 */
@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setAll(HashMap value) {
		hashMap.putAll(value);
		System.out.println(hashMap.toString());
	
	}
	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	@SuppressWarnings("unchecked")
	public T get(int index) {
				
		return (T) hashMap.get(index);
	}
	/**
	 * sets a given value at a given index
	 * throws IndexOutOfBoundsException in the case of wrong index
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		hashMap.put(index, (String) value);
	}
	
}
