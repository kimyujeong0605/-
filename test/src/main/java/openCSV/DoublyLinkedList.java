package openCSV;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    ListNode head;
    
    public DoublyLinkedList() {
        this.head = null;
    }
 /*   
    public void insertFirstNode(String[] data){
    	
        ListNode node = new ListNode(data);
        if(head==null){
            head = node;
            node.prev = node;
            node.next = node;
        }else{
            ListNode current = head;
            ListNode prev = current.prev;
 
            node.prev = prev;
            node.next = current;
            current.prev = node;
            prev.next = node;
            head = node;
        }
    }
    
    public void insertMiddleNode(ListNode prev, String[] data){
        ListNode node = new ListNode(data);
        if(head==null){
            head = node;
            node.prev = node;
            node.next = node;
        }else{
            ListNode current = head;
            
            while(current != prev){
                current = current.next;
            }
            ListNode next = current.next;
            
            node.next = next;
            node.prev = current;
            current.next = node;
            next.prev = node;
        }
    }
 */
    
    public void insertLastNode(String [] data){
        ListNode node = new ListNode(data);
        
        if(head==null){
            head = node;
            node.prev = node;
            node.next = node;
        }else{
        	
            ListNode current = head;
            while(current.next!=head){
                current = current.next;
            }
            ListNode next = current.next;
            
            node.next = next;
            next.prev = node;
            current.next = node;
            node.prev = current;
        }
    }
    public void insertDownData(String[]data) {
    	ListNode current = head;
    	 while(current.next!=head){
             current = current.next;
         }
         ListNode next = current.next;
         current.down_time=Integer.parseInt(data[3]);
	        // this.down_time=Integer.parseInt(data[3]);
	 	     for(int i=4;i<24;i++) {
	 	       current.down_data.add(Float.parseFloat(data[i]));
	 	 }	
    }
   /* 
    public void deleteFirstNode(){
        if(head==null){
            System.out.println("������ ����Ʈ�� �������� �ʽ��ϴ�.");
        }else{
            ListNode current = head;
            ListNode prev = current.prev;
            ListNode next = current.next;
            next.prev = prev;
            prev.next = next;
            head = next;
        }
    }
    
    public void deleteMiddleNode(String name){
        if(head==null){
            System.out.println("������ ����Ʈ�� �������� �ʽ��ϴ�.");
        }else{
            ListNode current = head;
            while(current.name != name){
                current = current.next;
            }
            ListNode prev = current.prev;
            ListNode next = current.next;
            prev.next = next;
            next.prev = prev;
        }
    }
    
    public void deleteLastNode(){
        if(head==null){
            System.out.println("������ ����Ʈ�� �������� �ʽ��ϴ�.");
        }else{
            ListNode current = head;
            while(current.next!=head){
                current = current.next;
            }
            ListNode prev = current.prev;
            ListNode next = current.next;
            prev.next = next;
            next.prev = prev;
        }
    }
    */
    public ListNode searchNode(String name){
        if(head==null){
            return null;
        }else{
            ListNode current = head;
            while(current.name != name){
                current = current.next;
            }
            return current;
        }
    }
    public void transferNode(String name,ListNode next){
        
        ListNode current = head;
        while(current.name != name){
            current = current.next;
        }
        current.transfer.add(next);
        
    }
    
    //ȯ�¿��� ��������� �Ѱ��ֱ� ���� �Լ�
    public ListNode getTransfer() {
    	ListNode current = head;
    	current = current.prev;
    	return current;
    }
    
    public void printList(){
        if(head==null){
            System.out.println("����� ������ �������� �ʽ��ϴ�.");
        }else{
            ListNode current = head;
            while(current.next!=head){
                System.out.println(current.name + " "+current.line+" "+current.up_time+" "+current.up_data.get(0)+" "+current.down_time+" "+current.down_data.get(0));
                current = current.next;
            }
            System.out.println(current.name + " "+current.line+" "+current.up_time+" "+current.up_data.get(0)+" "+current.down_time+" "+current.down_data.get(0));
        }
        
        System.out.println();
    }
}

