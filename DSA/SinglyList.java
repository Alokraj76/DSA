public class SinglyList 
{
    private static ListNode head;
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
    public boolean find(ListNode head, int searchKey)
    {
        if(head == null)
        {
            return false;
        }
        ListNode current = head;
        while(current!=null)
        {
            if(current.data == searchKey)
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public ListNode reverse(ListNode head)
    {
        if(head==null)
        {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current!=null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    public ListNode middleNode()
    {
        if(head == null)
        {
            return null;
        }
        ListNode fastptr = head;
        ListNode slowptr = head;
        while(fastptr!=null && fastptr.next!=null)
        {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }
        return slowptr;
    }
    public ListNode nthNodeFromEnd(int n)
    {
        if(head == null)
        {
            return null;
        }
        if(n <=0 )
        {
            throw new IllegalArgumentException("Invalid input" + n);
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count =0;
        while(count<n)
        {
            if(refPtr == null)
            {
                throw new IllegalArgumentException(n+ " is greater then the number of nodes in list");
            }
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr!=null)
        {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }
    public void removeDuplicate()
    {
        if(head == null)
        {
            return;
        }
        ListNode current = head;
        while(current!=null && current.next!=null)
        {
            if(current.data == current.next.data)
            {
                current.next = current.next.next;
            }
            else
            current = current.next;
        }
    }
    public ListNode insertSorted(int data)
    {   
        ListNode newNode = new ListNode(data);
        if(head == null)
        {
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;
        if(current.data>newNode.data)
        {
            newNode.next = current;
            head = newNode;
        }
        else
        {
            while(current!=null && current.data< newNode.data)
            {
                temp = current;
                current = current.next;
            }
            newNode.next = current;
            temp.next = newNode;
            
        }
        return head;
    }
    public void removeKey(int key)
    {
        if(head == null)
        {
            return;
        }
        ListNode current =head;
        ListNode temp = null;
        if(current!=null && current.data==key)
        {
            head = current.next;
            return;
        }
        while(current!=null && current.data!=key)
        {
            temp = current;
            current = current.next;
        }
        if(current == null)
        return;
        temp.next = current.next;
    }
    public boolean containaLoop()
    {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr!=null && fastPtr.next!=null)
        {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr)
            return true;
        }
        return false;
    }
    public ListNode startNodeinLoop()
    {
        ListNode fastptr = head;
        ListNode slowptr = head;

        while(fastptr!=null && fastptr.next!=null)
        {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if(slowptr == fastptr)
            {
                return getStartingNode(slowptr);
            }
        }
        return null;
    }
    private ListNode getStartingNode(ListNode slowptr)
    {
        ListNode temp = head;
        while(slowptr!=temp)
        {
            temp = temp.next;
            slowptr = slowptr.next;
        }
        return temp;
    }
    public void removeLoop()
    {
        ListNode fastptr = head;
        ListNode slowptr = head;
        while(fastptr!=null && fastptr.next!=null)
        {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if(slowptr == fastptr)
            {
                removeLoop(slowptr);
                return;
            }
        }
    }
    private void removeLoop(ListNode slowptr)
    {
        ListNode temp = head;
        while(slowptr.next!=temp.next)
        {
            temp = temp.next;
            slowptr = slowptr.next;
        }
        slowptr.next = null;
    }
    public ListNode merge(ListNode a , ListNode b)
    {
        if(a==null && b==null)
        {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(a!=null && b!=null)
        {
            if(a.data<=b.data)
            {
                tail.next = a;
                a= a.next;
            }
            else
            {
                tail.next = b;
                b= b.next;
            }
            tail = tail.next;
        }
        if(a==null)
        tail.next = b;
        else
        tail.next = a;
        return dummy.next;
    }
    public ListNode add(ListNode a, ListNode b)
    {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while(a!=null || b!=null)
        {
            int x = (a!=null)?a.data:0;
            int y = (b!=null)?b.data:0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum%10);
            tail = tail.next;
            if(a!=null)
            a = a.next;
            if(b!=null)
            b = b.next;
        }
        if(carry>0)
        tail.next = new ListNode(carry);
        return dummy.next;
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
    public void display(ListNode head)
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
        head = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(6);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        ListNode head2 = new ListNode(4);
        ListNode second2 = new ListNode(5);
        ListNode third2 = new ListNode(1);
        head2.next = second2;
        second2.next = third2;
        sl.display(head2);
        // sl.insertFirst(30);
        // sl.insertFirst(29);
        // sl.insertLast(29);
        // sl.insertLast(30);
        // sl.insert(2, 87);
        // sl.insert(4, 32);
        // System.out.println(sl.deleteFirst().data);
        // System.out.println(sl.deleteLast().data);
        // sl.delete(2);
        // if(sl.find(head,4))
        // {
        //     System.out.println("Search key found!!");
        // }
        // else
        // {
        //     System.out.println("Search key not found!!");
        // }
        //System.out.println("\n"+sl.countSize());
        // ListNode revereList = sl.reverse(head);
        // sl.display(revereList);
        // ListNode middle = sl.middleNode();
        // System.out.println("middle node is "+middle.data);
        // ListNode nthNode = sl.nthNodeFromEnd(5);
        // System.out.println("nth node is "+nthNode.data);
        // sl.removeDuplicate();
        // sl.display(sl.insertSorted(1));
        // sl.display(sl.insertSorted(0));
        // sl.removeKey(2);
        // sl.merge(head,head2);
        // sl.add(head,head2);
        sl.display(sl.add(head,head2));

        

    }
}
