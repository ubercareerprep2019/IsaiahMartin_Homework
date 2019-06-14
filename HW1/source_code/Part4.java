// Part 4 here.....
import java.lang.Integer;
import java.util.*;

class Part4_linkedlist<T>{
    listNode<T> head;
    int size = 0;

    public class listNode<T>{
        T data;
        listNode next;

        listNode(T value)
        {
            data = value;
        }

        void setNext(listNode next_node)
        {
            next = next_node;
        }
        listNode getNext()
        {
            return next;
        }
        T getValue(){
            return data;
        }
    }

    public Part4_linkedlist(){
        head = new listNode(null);
    }

    //Adds a single node containing data to the end of the list
    void pushBack(T data){
        listNode<T> next_node = new listNode<T>(data);
        listNode<T> curr = head;
        while(curr.getNext() != null)
        {
            curr = curr.getNext();
        }
        curr.setNext(next_node);
        size++;
    }
    //Removes a single node from the end of the list
    listNode<T> popBack()
    {
        listNode<T> curr = head;
        if (size > 0) {
            while (curr.getNext().getNext() != null) {
                curr = curr.getNext();
            }
            listNode<T> last = curr.getNext();
            curr.setNext(null);
            size--;
            return last;
        }
        return null;
    }
    //Adds a single node containing data to a chosen location in the list.
    // If the index is above the size of the list, do nothing.
    void insert(int index,T data) {
        listNode<T> curr = head;
        listNode<T> new_node = new listNode<T>(data);
        if(index > size)
        {
            System.err.println("Index too large: ");
            return;
        }
        int spot = index;
        while(spot > 0)
        {
            curr = curr.getNext();
            spot--;
        }
        new_node.setNext(curr.getNext());
        curr.setNext(new_node);
        size++;
    }
    //Erases a single node at the index location in the list.
    void erase(int index) {
        listNode<T> curr = head;
        if(index > size)
        {
            System.err.println("Index too large");
            return;
        }
        int spot = index;
        while(spot > 0)
        {
            curr = curr.getNext();
            spot--;
        }
        curr.setNext(curr.getNext().getNext());
        size--;
    }
    //Returns a single node at the index location in the list.
    listNode<T> elementAt(int index) {
        listNode<T> curr = head;
        if(index > size)
        {
            System.err.println("Index too large");
            return null;
        }
        int spot = index;
        while(spot >= 0)
        {
            curr = curr.getNext();
            spot--;
        }
        return curr;
    }

    //Returns the length of the list.
    int size(){
        return size;
    }

    //print all
    void print_all()
    {
        listNode<T> curr = head.getNext();
        if (size > 0) {
            while (curr.getNext() != null) {
                System.out.print(curr.getValue() + " ~ ");
                curr = curr.getNext();
            }
            System.out.println(curr.getValue());
        }
    }

    public void removeAll()
    {
        head = new listNode(null);
        size = 0;
    }

    public boolean hasCycle()
    {
        HashSet tracker = new HashSet();
        listNode<T> curr = head.getNext();
        if (size > 0) {
            while (curr != null) {
                if (tracker.contains(curr.getValue())) {
                    return true;
                }
                tracker.add(curr.getValue());
                curr = curr.getNext();
            }
        }
        return false;
    }

    public boolean is_palindrome()
    {
        int half = size/2;
        //System.out.println("half: "+half);
        if (size % 2 == 0)
        {
            for(int i=size-1; i>=half;i--)
            {
                //System.out.println(elementAt(i).getValue()+" ... "+elementAt((size-1)-1).getValue());
                if(elementAt(i).getValue() != elementAt((size-1) - i).getValue())
                {
                    return false;
                }
            }
        }
        else {
            for (int i = size - 1; i > half; i--) {
                //System.out.println(elementAt(i).getValue()+"!"+elementAt((size-1)-i).getValue());
                if (elementAt(i).getValue() != elementAt((size-1) - i).getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Part4_linkedlist<String> guest_list = new Part4_linkedlist();
        // testPushBackAddsOneNode
        guest_list.pushBack("Michael O'Leary");
        guest_list.pushBack("Jermaine Sanders");
        guest_list.pushBack("Manny Iglesias");
        guest_list.pushBack("Shanna O'Johnson");
        guest_list.pushBack("Lisa Rodgers");
        System.out.print("Print all added elements:\t");
        guest_list.print_all();
        // testPopBackRemovesCorrectNode
        guest_list.popBack();
        System.out.print("Remove last element with popBack():\t");
        guest_list.print_all();
        // testEraseRemovesCorrectNode
        guest_list.erase(0);
        System.out.print("Remove first element:\t");
        guest_list.print_all();
        guest_list.erase(1);
        System.out.print("Remove second element:\t");
        guest_list.print_all();
        // testSizeReturnsCorrectSize
        System.out.println("Expected Size: 2, Returned Size: "+guest_list.size());
        guest_list.pushBack("Andrew Yang");
        System.out.println("Expected Size: 3, Returned Size: "+guest_list.size());
        // testElementAtReturnNode
        System.out.println("Get 2nd Element with elementAt(): "+guest_list.elementAt(1).getValue());
        System.out.println("Get 1st Element with elementAt(): "+guest_list.elementAt(0).getValue());
        //test Insert
        guest_list.insert(1, "Shanna's son ");
        System.out.println("Insert Shanna's son as 2nd element: ");
        guest_list.print_all();
        guest_list.insert(0, "Jermaine's Daughter");
        System.out.println("Insert Jermaine's daughter as first element");
        guest_list.print_all();
        // testEraseDoesNothingIfNoNode
        System.out.println("Clearing list...");
        guest_list.removeAll();
        System.out.print("Erase on empty node: ");
        guest_list.erase(2);
        // testElementAtReturnsNoNodeIfIndexDoesNotExist
        System.out.print("Return on an index that doesn't exist: ");
        guest_list.elementAt(50);
        System.out.println("Reconstructing Original List...");
        guest_list.pushBack("Michael O'Leary");
        guest_list.pushBack("Jermaine Sanders");
        guest_list.pushBack("Manny Iglesias");
        guest_list.pushBack("Shanna O'Johnson");
        guest_list.pushBack("Lisa Rodgers");
        //Check for cycles
        System.out.println("Checking for Cycles");
        System.out.print("the current list:\t");
        guest_list.print_all();
        System.out.println("Has Cycle??: "+guest_list.hasCycle());
        guest_list.pushBack("Michael O'Leary");
        System.out.print("the current list:\t");
        guest_list.print_all();
        System.out.println("Has Cycle??: "+guest_list.hasCycle());
        guest_list.popBack();
        guest_list.insert(1,"Lisa Rodgers");
        System.out.print("the current list:\t");
        guest_list.print_all();
        System.out.println("Has Cycle??: "+guest_list.hasCycle());
        guest_list.erase(1);
        System.out.print("the current list:\t");
        guest_list.print_all();
        System.out.println("Has Cycle??: "+guest_list.hasCycle());
        //Palindrome test
        System.out.println("Clearing List...");
        System.out.println("Reconstructing List...");
        guest_list.removeAll();
        guest_list.insert(0,"a");
        guest_list.insert(1,"b");
        guest_list.insert(2,"e");
        guest_list.insert(3,"b");
        guest_list.insert(4,"a");
        System.out.println("Palindrome test");
        guest_list.print_all();
        System.out.println("Is plaindrome??: "+guest_list.is_palindrome());
        guest_list.erase(1);
        guest_list.erase(0);
        guest_list.print_all();
        System.out.println("Is plaindrome??: "+guest_list.is_palindrome());
        guest_list.pushBack("b");
        guest_list.pushBack("e");
        guest_list.print_all();
        System.out.println("Is plaindrome??: "+guest_list.is_palindrome());


    }

}