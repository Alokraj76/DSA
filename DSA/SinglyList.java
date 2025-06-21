public class SinglyList 
{
    private ListNode head;
    private static class ListNode
    {
        private int data;
        private ListNode next;
        public ListNode(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public void insertFirst(int value)
    {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }
    public void insertLast(int value)
    {
        ListNode newNode = new ListNode(value);
        if(head==null)
        {
            head = newNode;
            return;
        }
        ListNode current = head;
        while(current.next!=null)
        {
            current = current.next;
        }
        current.next = newNode;
    }
    public void insert(int position,int value)
    {
        ListNode newNode = new ListNode(value);
        if(position==1)
        {
            newNode.next = head;
            head = newNode;
        }
        else
        {
            ListNode previous = head;
            int count = 1;
            while(count< position-1)
            {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }
    public ListNode deleteFirst()
    {
        if(head==null)
        {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;

    }
    public ListNode deleteLast()
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode current  = head;
        ListNode previous = null;
        while(current.next!=null)
        {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }
    public void delete(int position)
    {
        if(position==1)
        {
            head = head.next;
        }
        else
        {
            ListNode previous = head;
            int count=1;
            while(count<position-1)
            {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }
    public int countSize()
    {
        if(head==null)
        {
            return 0;
        }
        int count =0;
        ListNode current = head;
        while(current!=null)
        {
            count++;
            current = current.next;
        }
        return count;
    }
    public void display()
    {
        ListNode current = head;
        while(current!=null)
        {
            System.out.print(current.data +"-->");
            current = current.next;
        }
        System.out.println("null ");
    }
    public static void main(String[] args) 
    {
        SinglyList sl = new SinglyList();
        sl.head = new ListNode(10);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(9);
        ListNode fourth = new ListNode(13);
        sl.head.next = second;
        second.next = third;
        third.next = fourth;
        sl.display();
        // sl.insertFirst(30);
        // sl.insertFirst(29);
        // sl.insertLast(29);
        // sl.insertLast(30);
        // sl.insert(2, 87);
        // sl.insert(4, 32);
        // System.out.println(sl.deleteFirst().data);
        // System.out.println(sl.deleteLast().data);
        sl.delete(2);
        sl.display();
        //System.out.println("\n"+sl.countSize());
    }
}
