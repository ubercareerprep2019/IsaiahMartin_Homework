// Part 3 here.....

import java.util.ArrayList;

class Part3_stack<Integer>{
    ArrayList<Integer> myStack;
    ArrayList<Integer> minStack;
    int size;

    public Part3_stack(){
        myStack = new ArrayList();
        minStack = new ArrayList();
        size = 0;
    }
    //Pushes an integer on top of the stack.
    public void push(Integer value){
        if(isEmpty())
        {
            minStack.add(0,value);
        }
        else
        {
            if((int)value < (int)minStack.get(0))
            {
                minStack.add(0,value);
            }
        }
        myStack.add(0,value);
        size++;
    }
    //Removes what is on the top of the stack, and returns that value to the
    //    caller.
    public Integer pop(){
        if(isEmpty())
        {
            System.err.println("Stack is empty, cannot pop");
            return null;
        }
        Integer pop_value = myStack.remove(0);
        size--;
        if(pop_value == minStack.get(0))
        {
            minStack.remove(0);
        }
        return pop_value;
    }
    //Looks at the top value, and returns it. Does not manipulate the stack.
    public Integer top(){
        if (!myStack.isEmpty())
        {
            return myStack.get(0);
        }
        System.err.println("Stack is empty, no top available");
        return null;
    }
    //Returns a True or False if the stack is Empty or not, respectively.
    public boolean isEmpty(){
        return (myStack.size() == 0);
    }

    public Integer min(){
        if (!minStack.isEmpty()) {
            return minStack.get(0);
        }
        System.err.println("Stack is empty, no min available");
        return null;
    }

    public int getSize()
    {
        return size;
    }

    // min(), which returns the minimum element of the stack in O(1) time, as opposed to O(n) time

    public static void main(String[] args){
        Part3_stack myStack = new Part3_stack();
        myStack.push(10);
        myStack.push(20);
        myStack.push(5);
        System.out.println("SIZE: " + myStack.getSize());
        System.out.println("MIN: " + myStack.min());
        System.out.println("POP: " + myStack.pop());
        System.out.println("SIZE: " + myStack.getSize());
        System.out.println("MIN: " + myStack.min());
        System.out.println("POP: " + myStack.pop());
        System.out.println("SIZE: " + myStack.getSize());
        System.out.println("PEAK TOP: " + myStack.top());
        System.out.println("MIN: " + myStack.min());
        System.out.println("POP: "+ myStack.pop());
        System.out.println("SIZE: " + myStack.getSize());
        System.out.println("EMPTY?: "+myStack.isEmpty());
        System.out.println("POP: "+myStack.pop());
        System.out.println("SIZE: " + myStack.getSize());
        System.out.println("PEAK TOP: "+myStack.top());
        System.out.println("MIN: "+myStack.min());
    }
}