// Part 4 here.....

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
        T getValue(){
            return listNode.data;
        }
    }

    public Part4_linkedlist(){
        head = new listNode(null);
    }

    //Adds a single node containing data to the end of the list
    void pushBack(T data){
        listNode<T> next_node = new listNode<T>(data);
        listNode<T> curr = head;
        while(curr.next != null)
        {
            curr = curr.next;
        }
        curr.next = next_node;
        size++;
    }
    //Removes a single node from the end of the list
    listNode<T> popBack()
    {
        listNode<T> curr = head;
        while(curr.next.next != null)
        {
            curr = curr.next;
        }
        listNode<T> last = curr.next;
        curr.next = null;
        size --;
        return last;
    }
    //Adds a single node containing data to a chosen location in the list.
    // If the index is above the size of the list, do nothing.
    void insert(uint index,T data) {
        listNode<T> curr = head;
        listNode<T> next_node = new listNode<T>(data);
        if(index > size.newValue())
        {
            System.err.println("Index too large");
            return;
        }
        int spot = index.newValue();
        while(spot > 0)
        {
            curr = curr.next;
            spot--;
        }
        next_node.next = curr.next;
        curr.next = next_node;
    }
    //Erases a single node at the index location in the list.
    void erase(uint index) {
        listNode<T> curr = head;
        if(index > size.newValue())
        {
            System.err.println("Index too large");
            return;
        }
        int spot = index.newValue();
        while(spot > 0)
        {
            curr = curr.next;
            spot--;
        }
        curr.next = curr.next.next;
    }
    //Returns a single node at the index location in the list.
    listNode<T> elementAt(uint index) {
        listNode<T> curr = head;
        if(index > size.newValue())
        {
            System.err.println("Index too large");
            return null;
        }
        int spot = index.newValue();
        while(spot > 0)
        {
            curr = curr.next;
            spot--;
        }
        return curr;
    }

    //Returns the length of the list.
    uint size(){
        return (uint)size;
    }

    public static void main(String[] args){
        //...
    }
}