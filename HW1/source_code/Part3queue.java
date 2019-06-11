// Part 3 here.....

import java.util.ArrayList;

class Part3_queue<E>{
    ArrayList<E> myQueue;

    public Part3_queue(){
        myQueue = new ArrayList<E>();
    }
    //Pushes an integer on top of the stack.
    private void enqueue(E value){
        myQueue.add(myQueue.size(),value);
    }
    //Removes what is on the top of the stack, and returns that value to the
    //    caller.
    private E dequeue(){
        if(isEmpty())
        {
            System.err.println("Queue is empty, cannot dequeue");
            return null;
        }
        E dequeue_value = myQueue.remove(0);
        return dequeue_value;
    }
    //Returns a True or False if the stack is Empty or not, respectively.
    private boolean isEmpty(){
        return (myQueue.size() == 0);
    }

    public static void main(String[] args){
        Part3_queue<Integer> myQueue = new Part3_queue<Integer>();
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(5);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.isEmpty());
    }
}