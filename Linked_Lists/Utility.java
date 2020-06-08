import java.util.Scanner;
public class Utility {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
    }   
    public static LinkedListNode input(){
        int data = sc.nextInt();
        LinkedListNode head = null;
        LinkedListNode tail = null;
        while(data!=-1){
            LinkedListNode newNode = new LinkedListNode(data);
            if(head==null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static void print(LinkedListNode head){
        while(head!=null){
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println("END");
    }
}