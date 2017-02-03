
/**
 * @ClassName StudentCollection
 * @author Matthew Tse
 *
 */
public class StudentCollection implements Cloneable {
	

	//keeps identification numbers of students
	private String[] ids = new String[20];
	//keeps the names of students
	private String[] names = new String[20];
	//number of students currently in collection
	private int size = 20;

	/**
	 * @Method Main
	 * @param args
	 */
	public static void main(String[] args) {
		String id = "U22-33-4444";
		String id2 = "U12-34-5678";
		String stu1 = "John Smith";
		String stu2 = "Jane Doe";
		String stu3 = "Jerry Smith";
		StudentCollection testOne = new StudentCollection();

		//first
		String testEmpty = Boolean.toString(testOne.isEmpty());
		System.out.println(testEmpty);
		System.out.println("--------------------------");
		StudentCollection testTwo = new StudentCollection(); 
		testTwo = (StudentCollection) testOne.clone();
		System.out.println("testOne empty");
		
		testOne.printStudents();
		System.out.println("end\n");
		System.out.println("testTwo clone empty");
		testTwo.printStudents();
		System.out.println("end\n");
		System.out.println("--------------------------");
		//input
		System.out.println("testOne put student 1");
		
		testOne.put(id, stu1);
//		testOne.printStudents();
		System.out.println(testOne.get(id));
		System.out.println("end\n");
		
		System.out.println("testOne put student 2");
		
		testOne.put(id2, stu2);
		
		System.out.println(testOne.get(id2));
		
		System.out.println("end\n");
		System.out.println("testOne put student 3 update");
		
		String testNameOut = testOne.put(id, stu3);
		System.out.println(testNameOut);
		
		System.out.println(testOne.get(id));
		System.out.println("end\n");
		System.out.println("--------------------------");
		//second
		String testFill = Boolean.toString(testOne.isEmpty());
		System.out.println(testFill);
		
		//third

		System.out.println("--------------------------");
		System.out.println("testTwo get 1");
		System.out.println(testTwo.get(id));
		System.out.println("end\n");
			
		System.out.println("testTwo get 2");
		System.out.println(testTwo.get(id2));
		System.out.println("end\n");
		
		System.out.println("--------------------------");
		//four		
		System.out.println("testOne get 1");
		System.out.println(testOne.get(id));
		System.out.println("end\n");
			
		System.out.println("testOne get 2");
		System.out.println(testOne.get(id2));
		System.out.println("end\n");
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		System.out.println("clone after");
		testTwo = testOne.clone();
		testTwo.printStudents();
		System.out.println("end\n");
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		
		System.out.println("remove");
		//five
//		testOne.remove(id2);
		testOne.remove(id);
//		testTwo.remove(id2);
//		testTwo.remove(id);
		System.out.println("testTwo get 1");
		System.out.println(testTwo.get(id));
		System.out.println("end\n");
			
		System.out.println("testTwo get 2");
		System.out.println(testTwo.get(id2));
		System.out.println("end\n");
		System.out.println("--------------------------");
		//four		
		System.out.println("testOne get 1");
		System.out.println(testOne.get(id));
		System.out.println("end\n");
			
		System.out.println("testOne get 2");
		System.out.println(testOne.get(id2));
		System.out.println("end\n");
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		System.out.println("testOne ");
		
		testOne.printStudents();
		System.out.println("end\n");
		System.out.println("testTwo clone ");
		testTwo.printStudents();
		System.out.println("end\n");
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		System.out.println("testOne size");
		System.out.println(testOne.size());
		System.out.println("end\n");
		System.out.println("testTwo size");
		System.out.println(testTwo.size());
		System.out.println("end\n");
		System.out.println("--------------------------");

	}
	
	/*
	 * @Method findIndex
	 * @param String id
	 * @precondition
	 * 		size must be instantiated
	 * @returns
	 * 		returns the index of the element
	 * 		defaults to -1 when none found
	 * @exception
	 * 		
	 * 	
	 */
	private int findIndex(String id) {
		//initialize index
		int idx = -1;
		//loop index
		for (int i = 0; i < size; i++) {
			//where the string value id exists in the array
			if (ids[i] == id) {
				//set index to idx
				idx = i;				
			}//end if
		}//end index loop
		
		return idx;
		
	}
	
	/*
	 * @Method size
	 * @returns
	 * 		returns the number of elements in collection	
	 */
	public int size() {
		//initialize counter
		int cntr = 0;
		//loop into array
		for (int i = 0; i < size; i++) {
			//where values exist in either list
			if (ids[i] != null && names[i] != null) {
				//increment
				cntr++;	
			}//end if
		}//end for
		
		return cntr;
		
	}
	
	/*
	 * @Method isEmpty
	 * @returns
	 * 		returns boolean
	 * 	
	 */
	public boolean isEmpty() {
		//initialize return value; default to empty
		boolean stat = true;
		//check if size has been incremented
		if (this.size() != 0) {
			stat = false;
		}//end if
		
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
		//initialize return value to null
		String ret_val = null;
		//loop into arrays
		for (int i = 0; i < size; i++) {
			//where the id string is the same as the stored string from ids
			if (ids[i] == id) {
				ret_val = names[i];
			}//end if
		}//end for
		
		return ret_val;
	}
	
	/*
	 * @Method put
	 * @precondition
	 * 		array ids and names must have at least 1 element
	 * @returns
	 * 		returns name
	 * @postcondition
	 * 		new value exists at index for both lists
	 * @exception
	 * 		UnsupportedOperationException - if the put operation is not supported by this map
	 * 		ClassCastException - if the class of the specified key or value prevents it from being stored in this map
	 * 		NullPointerException - if the specified key or value is null and this map does not permit null keys or values
	 * 		IllegalArgumentException - if some property of the specified key or value prevents it from being stored in this map
	 */
	public String put(String id, String name) {
		//initialize return name
		String rName = null;
		//loop into list
		for (int i = 0; i < size; i++) {
			//while array ids index value is null
			while (ids[i] == null) {
				names[i] = name;
				ids[i] = id;
				
			}
			
			//if not found
			if (this.findIndex(id) == -1) {
				if (i > 0) {
					if (ids[i-1] == id) {
						ids[i] = null;
						names[i] = null;
						break;
					}//end if replace value
				}//end if not the first value to avoid exception
			//if name already exists
			} else if (name != names[i] && id == ids[i]) {
				rName = names[i];
				names[i] = name;			
				break;
			//else update
			} else {
				break;

			}//end if			
						
		}//end for
		
		return rName;
	}
	
	
	/*
	 * @Method remove
	 * @precondition
	 * 		key whose mapping is to be removed from the map
	 * @returns
	 * 		the previous value associated with key, or null if there was no mapping for key.
	 * @postcondition
	 * 		value at index is reset to null	
	 * @exception
	 * 		UnsupportedOperationException - if the remove operation is not supported by this map
	 * 		ClassCastException - if the key is of an inappropriate type for this map (optional)
	 * 		NullPointerException - if the specified key is null and this map does not permit null keys (optional)
	 * 	
	 */
	public String remove(String id) {
		//initialize return value
		String ret_val = null;
		//initialize index
		int idx = 0;
		//check null id
		if (id != null) {
			//loop into list
			for (int i = 0; i < size; i++) {
				//find matching index with entered id
				if (this.findIndex(id) >= 0) {
					idx = this.findIndex(id);
					ids[idx] = null;
					names[idx] = null;
					
				}//end if found index
			}//end for loop
		}//end if check		
		
		return ret_val;
	}
	
	/*
	 * @Method clone
	 * @returns
	 *   	The return value is a copy of this bag. Subsequent changes to the
	 *   	copy will not affect the original, nor vice versa.
	 * @postcondition
	 * 		creates a clone copy of object and properties that is independent of original
	 * @exception
	 * 		CloneNotSupportedException
	 * 		OutOfMemoryError
	 *   		Indicates insufficient memory for creating the clone.
	 * 	
	 */
	public StudentCollection clone() {
		//instantiate collection
		StudentCollection collection;
		//try clone
		try {
			//make deep clone
			collection = (StudentCollection) super.clone();
			collection.ids = this.ids.clone();
			collection.names = this.names.clone();
		//catch exception
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
		for (int i = 0; i < size; i++) {
			System.out.print("Id: " + ids[i] + ", ");
			System.out.println("Name: " + names[i]);					
		}

	}
	

}
