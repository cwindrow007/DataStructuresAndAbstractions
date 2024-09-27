/**
 A class of bags whose entries are stored in a chain of linked nodes.
 The bag is never full.
 */

public class LinkedBag<T> implements BagInterface<T>{



    private class Node
    {
        private T    data; // Entry in bag
        private Node next; // Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node


    private Node firstNode;       // Reference to first node
    private int numberOfEntries;

    // Default constructor
    public LinkedBag()
    {


    } // end default constructor

    @Override
    public int getCurrentSize() {
        // TODO Auto-generated method stub
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        // TODO Auto-generated method stub
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;

        firstNode = newNode;
        numberOfEntries++;

        return true;
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        T result = null;
        if(firstNode != null)
        {
            result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }
        return result;
    }

    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located,
    // or null otherwise.
    private Node getReferenceTo(T anEntry)
    {
        Node currentNode;

        for (currentNode = firstNode;currentNode != null; currentNode = currentNode.next)
        {
            if (anEntry==currentNode.data)
                return currentNode;
        } // end while
        return currentNode;
    } // end getReferenceTo

    @Override
    public boolean remove(T anEntry) {

        boolean result = false;
        Node node = getReferenceTo(anEntry);
        if(node != null) {
            node.data = firstNode.data;

            firstNode = firstNode.next;
            numberOfEntries--;
            result = true;
            }
        return result;
    }

    @Override
    public void clear(){
        // TODO Auto-generated method stub
        while(!isEmpty())
            remove();
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        // TODO Auto-generated method stub
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;
        while((loopCounter < numberOfEntries) && (currentNode != null)) {
            if(anEntry.equals(currentNode.data)){
                frequency++;
            }
            loopCounter++;
            currentNode = currentNode.next;
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        // TODO Auto-generated method stub
        boolean found = false;
        Node currentNode = firstNode;

        for(Node temp = firstNode;temp != null; temp=temp.next){
            if (anEntry==temp.data){
                found = true;
            }else{
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    @Override
    public T[] toArray()
    {
        // TODO Auto-generated method stub

        T[] result = (T[]) new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }
        return result;
    }

}
/*
OUTPUT
C:\Users\Christopher\.jdks\openjdk-22.0.2\bin\java.exe "-javaagent:C:\Users\Christopher\AppData\Local\Programs\IntelliJ IDEA Ultimate\lib\idea_rt.jar=51108:C:\Users\Christopher\AppData\Local\Programs\IntelliJ IDEA Ultimate\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\Christopher\IdeaProjects\TestProject\out\production\TestProject LinkedBagTest
Testing an initially empty bag:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Testing isEmpty with an empty bag:
isEmpty finds the bag empty: OK.


Testing the method getFrequencyOf:
In this bag, the count of Two is 0

Testing the method contains:
Does this bag contain Two? false

Removing a string from the bag:
remove() returns null
The bag contains 0 string(s), as follows:


Removing "Two" from the bag:
remove("Two") returns false
The bag contains 0 string(s), as follows:

+++++++++++++++++++++++++++++++++++++++++++++++++++

Adding 6 strings to an initially empty bag with the capacity to hold more than 6 strings:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Adding One One Two One Three One
The bag contains 6 string(s), as follows:
One Three One Two One One
Testing isEmpty with a bag that is not empty:
isEmpty finds the bag not empty: OK.


Testing the method getFrequencyOf:
In this bag, the count of One is 4
In this bag, the count of Two is 1
In this bag, the count of Three is 1
In this bag, the count of Four is 0
In this bag, the count of XXX is 0

Testing the method contains:
Does this bag contain One? true
Does this bag contain Two? true
Does this bag contain Three? true
Does this bag contain Four? false
Does this bag contain XXX? false

Removing a string from the bag:
remove() returns One
The bag contains 5 string(s), as follows:
Three One Two One One

Removing "Two" from the bag:
remove("Two") returns true
The bag contains 4 string(s), as follows:
One One One One

Removing "One" from the bag:
remove("One") returns true
The bag contains 3 string(s), as follows:
One One One

Removing "Three" from the bag:
remove("Three") returns false
The bag contains 3 string(s), as follows:
One One One

Removing "XXX" from the bag:
remove("XXX") returns false
The bag contains 3 string(s), as follows:
One One One

Clearing the bag:
Testing isEmpty with an empty bag:
isEmpty finds the bag empty: OK.

The bag contains 0 string(s), as follows:

+++++++++++++++++++++++++++++++++++++++++++++++++++


Testing an initially empty bag that  will be filled to capacity:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Adding One Two One Three Two Three Four
The bag contains 7 string(s), as follows:
Four Three Two Three One Two One
Try to add XXX to the full bag:
Added a string beyond the bag's capacity: OK!
The bag contains 8 string(s), as follows:
XXX Four Three Two Three One Two One

Process finished with exit code 0

 */
