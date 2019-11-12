
public class Solution<E> {

  E array[];
  
  public boolean remove(Object o) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals((E) o)) {
				array = resizeAndRemove(array, -1, (E)o);
				
				return true;
			}
		}
		
		// object not found
		return false;
	}
  
  public E[] resizeAndRemove(E[] originalArray, int incrementalSize, E o) {
		E[] localArray = (E[]) new Object[originalArray.length + incrementalSize];
		/* REMOVE CONDITION */
		// if the last element in the array we are copying from is equal to the element to be removed, then simply loop localArray.length times (originalArray.length-incrementalSize)
		if(originalArray[originalArray.length - 1].equals((String) o)) {
			for (int i = 0; i < localArray.length; i++) 
				localArray[i] = (E) originalArray[i];
		}
		// if the last element in the array we are copying from is not equal to the element to be removed, 
		// then start looping originalArray.length times and only include the elements that are not equal to the element to be removed, if it is, then skip the iteration
		else {
			int index = 0;
			for (int i = 0; i < originalArray.length; i++) {
				if (!originalArray[i].equals((String) o)) {
					localArray[index] = originalArray[i];
					index++;
				}
				// the current element in original array matches the element to be removed
				else {
					continue; // skip iteration
				}
			}
		}
		return localArray;
	}

}
