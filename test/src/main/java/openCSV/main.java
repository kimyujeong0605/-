package openCSV;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
public class main {
 
    public static void main(String[] args) {
    	 DoublyLinkedList list1 = new DoublyLinkedList();
    	 DoublyLinkedList list2 = new DoublyLinkedList();
    	 DoublyLinkedList list3 = new DoublyLinkedList();
    	 DoublyLinkedList list4 = new DoublyLinkedList();
    	 DoublyLinkedList list5 = new DoublyLinkedList();
    	 DoublyLinkedList list6 = new DoublyLinkedList();
    	 DoublyLinkedList list7 = new DoublyLinkedList();
    	 DoublyLinkedList list8 = new DoublyLinkedList();
    	 DoublyLinkedList list9 = new DoublyLinkedList();
    	 DoublyLinkedList list10 = new DoublyLinkedList();
    	 ArrayList<ListNode> transfer_data = new ArrayList<ListNode>();
  
    	 List<String[]> data = new ArrayList<String[]>();
    	    CSVRead read = new CSVRead();
    	    data = read.readCsv();
    	    Iterator<String[]> it = data.iterator();

    	    while (it.hasNext()) {
    	      String[] array = (String[]) it.next();
    	     
    	      if(array[0].equals("1ȣ��")) {
    	    	  insertNode(list1,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("2ȣ��")) {
    	    	  insertNode(list2,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("3ȣ��")) {
    	    	  insertNode(list3,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("4ȣ��")) {
    	    	  insertNode(list4,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("5ȣ��")) {
    	    	  insertNode(list5,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("6ȣ��")) {
    	    	  insertNode(list6,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("7ȣ��")) {
    	    	  insertNode(list7,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("8ȣ��")) {
    	    	  insertNode(list8,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("��������")){
    	    	  insertNode(list9,it,array,transfer_data);
    	      }
    	      else {
    	    	  insertNode(list10,it,array,transfer_data);
    	      }
    	      //System.out.print("\n");
    	    }
    	    //list1.printList();
    	    
    	    //�ٸ� ȣ���ε� ���� �̸��� �ִ� ��쿡�� ȯ�¿��̶� �����ϰ� ��������.
    	    for(int i =0;i<transfer_data.size();i++) {
    	    	for(int j=0;j<transfer_data.size();j++) {
    	    		if(transfer_data.get(i).line!=transfer_data.get(j).line&&transfer_data.get(i).name.equals(transfer_data.get(j).name)){
    	    			transfer_data.get(i).transfer.add(transfer_data.get(j));
    	    			transfer_data.get(i).trans=true;
    	    			   
    	    		}
    	
    	    	}
    	    }
    	 
    	    //����� ����Ȱ��� �������ؼ� �ӽ÷� ���� ���
    	    
    	  if(list7.searchNode("��").trans)
    	  {
    		  System.out.println("ȯ�¿�");
    	  }
    	  else {
    		  System.out.println("ȯ�¿� �ƴ�");
    	  }
    	     
    	    
    	    
    }
    //��带 ����µ� ���� �󼱺��� node�� ����� �ϼ��� ���� �����ʹ� ���� ����� ���� ��忡 �����͸� �����ϴ� ����, ȯ�¿���Ȯ���ؼ� transfer_data�� ȯ�¿��� ���� ���� ����
    public static void insertNode(DoublyLinkedList list,Iterator<String[]> it,String[] array,ArrayList<ListNode> transfer_data) {
    		list.insertLastNode(array);
    		array = (String[]) it.next();
    		list.insertDownData(array);
		      if(array[3].equals("1")) {
		    	  //arraylist�� ȯ�¿� ����� ������ �Ѱ���.
		    	  transfer_data.add(list.getTransfer());
		    	  //System.out.println(array[ 2]);
		      }
    }
}