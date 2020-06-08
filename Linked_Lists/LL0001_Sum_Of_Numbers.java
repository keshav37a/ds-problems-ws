/* 
Input
1->2->3->END
1->2->3->End

Output
2->4->->6->END

Input
9->9->9->END
1->End

Output
1->0->0->0->END

*/

public class LL0001_Sum_Of_Numbers {
    public static void main(String[] args) {
        Utility utility = new Utility();
        LinkedListNode head1 = utility.input();
        LinkedListNode head2 = utility.input();
        LinkedListNode newHead = computeSum(head1, head2);
        utility.print(newHead);
    }
    public static LinkedListNode computeSum(LinkedListNode head1, LinkedListNode head2){
        int length1 = 0;
        int length2 = 0;

        LinkedListNode temp1 = head1;
        LinkedListNode temp2 = head2;

        while(temp1!=null){
            length1++;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            length2++;
            temp2 = temp2.next;
        }

        Info info = null;   
        if(length1>length2){
            int diff = length1 - length2;
            while(diff>0){
                LinkedListNode newNode = new LinkedListNode(0);
                newNode.next = head2;
                head2 = newNode;
                diff--;
            }

        }   
        else if(length1<length2){
            int diff = length2 - length1;
            while(diff>0){
                LinkedListNode newNode = new LinkedListNode(0);
                newNode.next = head1;
                head1 = newNode;
                diff--;
            }
        }  
        info = compute(head1, head2);
        if(info.isCarry){
            LinkedListNode newNode = new LinkedListNode(1);
            newNode.next = head1;
            head1 = newNode;
        }
        return head1;
    }
    public static Info compute(LinkedListNode head1, LinkedListNode head2){
        if(head1==null && head2==null)
            return new Info(null, false);
        System.out.println(head1.data+" " + head2.data);
        Info info = compute(head1.next, head2.next);

        int val1 = 0, val2 = 0;
        if(head1!=null)        
            val1 = head1.data;
        if(head2!=null)
            val2 = head2.data;

        int sum = head1.data + head2.data;
        if(info.isCarry)
            sum+=1;
        if(sum>9){
            sum = sum - 10;
            info.isCarry = true;
        }
        head1.data = sum;
        info.head = head1;
        return info;
    }
}

class Info{
    LinkedListNode head;
    boolean isCarry;
    public Info(LinkedListNode head, boolean isCarry){
        this.head = head;
        this.isCarry = isCarry;
    }
}