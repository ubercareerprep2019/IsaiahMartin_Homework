// Part 3 here.....


class Part3_queue{
    Part3_stack myQueue;

    public Part3_queue(){
        myQueue = new Part3_stack();
    }
    //Pushes an integer on top of the stack.
    public void enqueue(Integer value){
        myQueue.push(value);
        //System.out.println("Queues push: "+value);

    }
    //Removes what is on the top of the stack, and returns that value to the
    //    caller.
    public Object dequeue(){
        Part3_stack newQueue = new Part3_stack();
        while(! myQueue.isEmpty())
        {
            newQueue.push(myQueue.pop());
        }
        Object value = newQueue.pop();
        while(! newQueue.isEmpty())
        {
            //System.out.println("PUSH: "+newQueue.top());
            myQueue.push(newQueue.pop());
        }
        return value;
    }
    //Returns a True or False if the stack is Empty or not, respectively.
    private boolean isEmpty(){
        return myQueue.isEmpty();
    }

    public static void main(String[] args){
        Part3_queue myQueue = new Part3_queue();
        System.out.println("Enqueue 10");
        myQueue.enqueue(10);
        System.out.println("Enqueue 20");
        myQueue.enqueue(20);
        System.out.println("Enqueue 5");
        myQueue.enqueue(5);
        System.out.print("Dequeue: ");
        System.out.println(myQueue.dequeue());
        System.out.print("Dequeue: ");
        System.out.println(myQueue.dequeue());
        System.out.print("Dequeue: ");
        System.out.println(myQueue.dequeue());
        System.out.print("Empty??: ");
        System.out.println(myQueue.isEmpty());
    }
}