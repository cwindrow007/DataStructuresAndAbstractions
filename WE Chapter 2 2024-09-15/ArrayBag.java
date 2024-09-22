
/**
 *  Christopher Windrow - CSC 270 (Data Structures)
 *  Project 2: Array Based Bag
 *  Description: Implements the Bag interface in which is used to build methods, The methods created help create an empty bag, get current size,
 *                  checks if a bag is empty, iterates through the bag to add, remove, remove a specific entry, clear,
 *                       get frequency of a specified item in the bag, test what the bag contains, and retrieves all entries of the bag.
 *                       This class is to be used with ArrayBagTest and BagInterface
 *
 */
public final class ArrayBag<T> implements BagInterface<T> {

    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Creates an empty bag having a given capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayBag(int desiredCapacity) {
        T[] tempBag = (T[]) new Object[desiredCapacity];
        bag = tempBag;
        numberOfEntries = 0;
    } // end constructor


    /**
     * Gets current number of entries in this bag
     * @return The number of entreis currently in this bag
     */
    @Override
    public int getCurrentSize() {

        return numberOfEntries;
    }

    /**
     * Sees if bag is empty
     * @return True if the bag is enmpty or false if it is not
     */
    @Override
    public boolean isEmpty() {

        return numberOfEntries == 0;
    }

    /**
     * Adds a new entry to this bag
     * @param newEntry the object will be added as a new entry to the bag
     * @return True if adding a new entry is successful, else it is false.
     */
    @Override
    public boolean add(T newEntry) {
        boolean result = true;
        if (numberOfEntries >= bag.length) {
            result = false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    /**
     * Removes one unspecified entry from this bag if it is possible
     * @return Removes the entry if removal is successful else is null.
     */
    @Override
    public T remove() {
        T result = null;
        if (numberOfEntries > 0) {
            result = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;

        }
        return result;
    }

    /**
     * Removes and returns an entry at specific index
     * @return Either removed the entry if found and is successful else is false.
     */
    @Override
    public boolean remove(T anEntry) {
        T result = null;
        boolean found = false;

        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                result = bag[i];
                found = true;

                bag[i] = bag[numberOfEntries - 1];
                bag[numberOfEntries - 1] = null;

                numberOfEntries--;
            }
        }
        return found;

    }

    /**
     * Removes all entries of the bag
     */
    @Override
    public void clear() {
        while (!isEmpty())
            remove();

    }

    /**
     * Counts number of times a given entry appears
     * @param anEntry The entry is counted
     * @return The number of times an entry appears in this bag
     */
    @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Test if the bag contains a certain given entry
     * @param anEntry The entry to locate
     * @return True if the bag contains an entry, else is false
     */
    @Override
    public boolean contains(T anEntry) {

        boolean found = false;
        int index = 0;
        while (!found && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                found = true;
            }
            index++;
        }
        return found;
    }

    /**
     * Retrieves all entries that are in this bag
     * @return A newly allocated array of all entries in the bag
     */
    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        }
        return result;
    }
}
