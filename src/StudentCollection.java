
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
		testOne.remove(id2);
		testOne.remove(id);
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
			if (ids[i] != null) {
				cntr++;	
			}
			
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
		
		if (this.size() == 0) {
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
			if (ids[i] == id) {
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

		for (int i = 0; i < size; i++) {
			//if array ids index vale is null
			//and array names index is not the same as input name
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
					}
				}
			//if name already exists
			} else if (name != names[i] && id == ids[i]) {
				rName = names[i];
				names[i] = name;			
				break;
			//else update
			} else {
				break;

			}			
						
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
//		collection = new StudentCollection(this.ids);
		try {
			collection = (StudentCollection) super.clone();
			collection.ids = this.ids.clone();
			collection.names = this.names.clone();
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
