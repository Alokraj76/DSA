import java.util.NoSuchElementException;

public class CircularList 
{
    private ListNode last;
    private int length;

    private  class ListNode
    {
        private ListNode next;
        private int data;

        public ListNode(int data)
        {
            this.data = data;
        }
    }
    public CircularList()
    {
        this.last = null;
        this.length = 0;
    }
    public int length()
    {
        return length;
    }
    public boolean isEmpty()
    {
        return length == 0;
    }

    public void createList()
    {
        ListNode first = new ListNode(5);
        ListNode second = new ListNode(10);     
        ListNode third = new ListNode(20);
        first.next = second;
        second.next = third;
        third.next = first; // Making it circular
        last = third; // Last node points to the last element in the circular list
        length++; // Incrementing the length of the list
    }
    public void insertFirst(int value)
    {
        ListNode newNode = new ListNode(value);
        if(last == null)
        {
            last = newNode;
        }
        else
        {
            newNode.next = last.next; // New node points to the first node
        }
        last.next = newNode;
        length++;
    }
    public void insertLast(int data)
    {
        ListNode temp = new ListNode(data);
        if(last==null)
        {
            last = temp;
            last.next = last;
        }
        else
        {
            temp.next = last.next;
            last.next= temp;
            last= temp;
        }
        length++;
    }
    public ListNode deleteFirst()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("List is empty");
        }
        ListNode temp = last.next; // First node is the one after last
        if(last.next == last)
        {
            last = null;
        }
        else
        {
            last.next = temp.next;
        }
        temp.next = null;
        return temp;
    }
    public ListNode deleteLast()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException("List is empty");
        }
        ListNode current = last.next; // Start from the first node
        ListNode previous = null;
        while(current.next != last.next) // Loop until we reach the last node
        {
            previous = current;
            current = current.next;
        }
        if(previous == null) // Only one element in the list
        {
            last = null;
        }
        else
        {
            previous.next = last.next; // Previous node points to the first node
            last = previous; // Update last to the previous node
        }
        length--;
        return current; // Return the deleted node
    }
    public void display()
    {
        if(isEmpty())
        {
            System.out.println("List is empty");
            return;
        }
        ListNode current = last.next; // Start from the first node
        do
        {
            System.out.print(current.data + " ");
            current = current.next;
        } while(current != last.next); // Loop until we come back to the first node
        System.out.println();
    }
    public static void main(String[] args) 
    {
        CircularList cl = new CircularList();
        cl.createList();
        // cl.insertFirst(13);
        // cl.insertLast(25);
        // cl.deleteFirst();
        // cl.deleteFirst();
        cl.deleteLast();
        cl.display();
        System.out.println("Length of the list: " + cl.length());
        System.out.println("Is the list empty? " + cl.isEmpty());
    }
}
