// Part 3 here.....

import java.util.ArrayList;

class Part3_stack<E>{
    ArrayList<E> myStack;

    public Part3_stack(){
        myStack = new ArrayList<E>();
    }
    //Pushes an integer on top of the stack.
    private void push(E value){
        myStack.add(0,value);
    }
    //Removes what is on the top of the stack, and returns that value to the
    //    caller.
    private E pop(){
        if(isEmpty())
        {
            System.err.println("Stack is empty, cannot pop");
            return null;
        }
        E pop_value = myStack.remove(0);
        return pop_value;
    }
    //Looks at the top value, and returns it. Does not manipulate the stack.
    private E top(){
        return myStack.get(0);
    }
    //Returns a True or False if the stack is Empty or not, respectively.
    private boolean isEmpty(){
        return (myStack.size() == 0);
    }

    public static void main(String[] args){
        Part3_stack<Integer> myStack = new Part3_stack<Integer>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(5);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.pop());
    }
}