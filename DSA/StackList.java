import java.util.EmptyStackException;

public class StackList 
{
    private ListNode top;
    private int length;

    private class ListNode
    {
        private ListNode next;
        private int data;

        public ListNode(int data)
        {
            this.data = data;
        }
    }
    public StackList()
    {
        this.top = null;
        this.length =0;
    }
    public int length()
    {
        return length;
    }
    public boolean isEmpty()
    {
        return length ==0;
    }

    public void push(int data)
    {
        ListNode newNode = new ListNode(data);
        if(top == null)
        {
            top = newNode;
        }
        else
        {
            newNode.next = top;
            top = newNode;
        }
        length++;
    }
    public int pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }
    public int peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        return top.data;

    }
    public void display()
    {
        ListNode current = top;
        while(current!=null)
        {
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) 
    {
        StackList st = new StackList();
        st.push(12);
        st.push(15);
        st.push(20);
        st.display();
        st.pop();
        st.display();
        System.out.println("Top element: " + st.peek());
        System.out.println("Length of the stack: " + st.length());
        System.out.println("Is the stack empty? " + st.isEmpty());
    }
}
