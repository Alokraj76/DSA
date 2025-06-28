import java.util.NoSuchElementException;

public class DoublyList 
{
    private ListNode head;
    private ListNode tail;
    private int length;
    private class ListNode 
    {
        private int data;
        private ListNode next;
        private ListNode prev;
        public ListNode(int data) 
        {
            this.data = data;
        }
    }
    public DoublyList() 
    {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean isEmpty() 
    {
        return length == 0;
    }
    public int length() 
    {
        return length;
    }

    public void insertFirst(int value)
    {
        ListNode newNode = new ListNode(value);
        if(isEmpty())
        {
            tail = newNode;
        }
        else
        {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }
    public void insertLast(int value)
    {
        ListNode newNode = new ListNode(value);
        if(isEmpty())
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }
    public ListNode deleteFirst()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if(head == tail)
        {
            tail = null;
        }
        else
        {
            head.next.prev = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }
    public ListNode deleteLast()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if(head == tail)
        {
            head = null;
        }
        else
        {
            tail.prev.next = null;
        }
        tail = tail.prev;
        temp.prev = null;
        length--;
        return temp;
    }
    public void displyForward()
    {
        ListNode temp = head;
        while(temp!= null)
        {
            System.out.print(temp.data +"--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void displayBackward()
    {
        ListNode temp = tail;
        while(temp!=null)
        {
            System.out.print(temp.data +"<-- ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) 
    {
        DoublyList dll = new DoublyList();
        // dll.insertFirst(10);
        // dll.insertFirst(20);
        // dll.insertFirst(30);    
        // dll.insertFirst(40);
        dll.insertLast(12);
        dll.insertLast(14);
        dll.insertLast(16);
        dll.insertLast(18);
        dll.insertLast(20);
        // dll.deleteFirst();
        // dll.deleteFirst();
        // dll.deleteLast();
        // dll.deleteLast();
        System.out.println("Display Forward:");
        dll.displyForward();
        System.out.println("Display Backward:");
        dll.displayBackward();
        System.out.println("Length of the list: " + dll.length());
        System.out.println("Is the list empty? " + dll.isEmpty());
    }
}
