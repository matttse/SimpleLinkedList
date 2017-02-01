/**
 * @ClassName StudentCollection
 * @author Matthew Tse
 *
 */
public class StudentCollection implements Cloneable {
	//keeps identification numbers of students
	private String[] ids;
	//keeps the names of students
	private String[] names;
	//number of students currently in collection
	private int size;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentCollection testOne = new StudentCollection();
		
		//first
		String testEmpty = Boolean.toString(testOne.isEmpty());
		System.out.println(testEmpty);
		
		StudentCollection testTwo = new StudentCollection(); 
		testTwo = testOne.clone();
		testOne.printStudents();
		testTwo.printStudents();
		
		//input
		testOne.put("U12-34-5678", "John Smith");
		testOne.put("U12-34-5678", "Jerry Smith");
		testOne.put("U22-33-4444", "Jane Doe");
		
		//second
		String testFill = Boolean.toString(testOne.isEmpty());
		System.out.println(testFill);
		testTwo = testOne.clone();
		testOne.printStudents();
		testTwo.printStudents();
		
				
	}
	
	/*
	 * @Method findIndex
	 * @param String id
	 * @precondition
	 * 		array ids must have at least 1 element
	 * @returns
	 * 		returns the index of the element
	 * 		defaults to -1 when none found
	 * @exception
	 * 		
	 * 	
	 */
	private int findIndex(String id) {
		int idx = -1;

		for (int i = 0; i < size; i++) {
			
			if (ids[i] == id) {
				idx = i;
				
			}
			
		}
		
		return idx;
		
	}
	
	/*
	 * @Method size
	 * @returns
	 * 		returns the number of elements in collection
	 * 		 		
	 * 	
	 */
	public int size() {
		int cntr = 0;
		
		for (int i = 0; i < size; i++) {
			cntr++;
		}
		
		return cntr;
		
	}
	
	/*
	 * @Method isEmpty
	 * @returns
	 * 		returns boolean
	 * 	
	 */
	public boolean isEmpty() {
		boolean stat = false;
		
		if (this.size() > 0) {
			stat = true;
		}
		
		return stat;
	}
	
	/*
	 * @Method get
	 * @precondition
	 * 		key - the key whose associated value is to be returned
	 * @returns
	 * 		the value to which the specified key is mapped, or null if this map contains no mapping for the key
	 * 		
	 * @exception
	 * 		ClassCastException - if the key is of an inappropriate type for this map (optional)
	 * 		NullPointerException - if the specified key is null and this map does not permit null keys (optional)
	 * 	
	 */
	public String get(String id) {
		String ret_val = null;
		for (int i = 0; i < size; i++) {
			if (i == Integer.parseInt(id)) {
				ret_val = names[i];
			}
		}
		
		return ret_val;
	}
	
	/*
	 * @Method put
	 * @precondition
	 * 		array ids and names must have at least 1 element
	 * @returns
	 * 		returns name
	 * @exception
	 * 		UnsupportedOperationException - if the put operation is not supported by this map
	 * 		ClassCastException - if the class of the specified key or value prevents it from being stored in this map
	 * 		NullPointerException - if the specified key or value is null and this map does not permit null keys or values
	 * 		IllegalArgumentException - if some property of the specified key or value prevents it from being stored in this map
	 */
	public String put(String id, String name) {
		String rName = null;

		//if id already exists
		if (this.findIndex(id) != -1) {
			rName = names[Integer.parseInt(id)];
			ids[size] = id;
			names[size] = name;				
			size++;	
		//add it to array
		} else {
	
			ids[size] = id;
			names[size] = name;				
			size++;	
			
		}

		return rName;
	}
	
	
	/*
	 * @Method remove
	 * @precondition
	 * 		key whose mapping is to be removed from the map
	 * @returns
	 * 		the previous value associated with key, or null if there was no mapping for key.
	 * 		
	 * @exception
	 * 		UnsupportedOperationException - if the remove operation is not supported by this map
	 * 		ClassCastException - if the key is of an inappropriate type for this map (optional)
	 * 		NullPointerException - if the specified key is null and this map does not permit null keys (optional)
	 * 	
	 */
	public String remove(String id) {
		String ret_val = null;
		//check null id
		if (this.get(id) != null) {
			//loop into list
			for (int i = 0; i < size; i++) {
				//find matching index with entered id
				if (this.findIndex(id) == Integer.parseInt(id)) {
					ids[i - 2] = ids[i - 1];
					names[i - 2] = names[i - 1];
					
				}
			}
				 
		}		
		
		return ret_val;
	}
	
	/*
	 * @Method clone
	 * @returns
	 *   	The return value is a copy of this bag. Subsequent changes to the
	 *   	copy will not affect the original, nor vice versa.
	 * @exception
	 * 		CloneNotSupportedException
	 * 		OutOfMemoryError
	 *   		Indicates insufficient memory for creating the clone.
	 * 	
	 */
	public StudentCollection clone() {
		StudentCollection collection;
		try {
			collection = (StudentCollection) super.clone();
			
		} catch (CloneNotSupportedException e) {
			
		      throw new RuntimeException
		      ("This class does not implement Cloneable");
		}
		
		return collection;
		
	}
	
	/*
	 * @Method printStudents
	 * 	
	 */
	public void printStudents() {
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				System.out.print("Id: " + ids[i] + ", ");
				System.out.println("Name: " + names[i]);
			}
		} else {
			System.out.println("no students");
		}

	}
	

}
