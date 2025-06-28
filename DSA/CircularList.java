public class CircularList 
{
    private static ListNode last;
    private int length;

    private static class ListNode
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
        last = null;
        length = 0;
    }
    public int length()
    {
        return length;
    }
    public boolean isEmpty()
    {
        return length == 0;
    }
    public void display(ListNode last)
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
        ListNode first = new ListNode(5);
        ListNode second = new ListNode(10);
        ListNode third = new ListNode(20);
        first.next  = second;
        second.next = third;
        third.next = first;
        last = third; // Last node points to the last element in the circular list
        cl.length++;
        cl.display(last);
    }
}
