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
    	     
    	      if(array[0].equals("1호선")) {
    	    	  insertNode(list1,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("2호선")) {
    	    	  insertNode(list2,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("3호선")) {
    	    	  insertNode(list3,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("4호선")) {
    	    	  insertNode(list4,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("5호선")) {
    	    	  insertNode(list5,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("6호선")) {
    	    	  insertNode(list6,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("7호선")) {
    	    	  insertNode(list7,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("8호선")) {
    	    	  insertNode(list8,it,array,transfer_data);
    	      }
    	      else if(array[0].equals("신정지선")){
    	    	  insertNode(list9,it,array,transfer_data);
    	      }
    	      else {
    	    	  insertNode(list10,it,array,transfer_data);
    	      }
    	      //System.out.print("\n");
    	    }
    	    //list1.printList();
    	    
    	    //다른 호선인데 같은 이름이 있는 경우에는 환승역이라 간주하고 연결지음.
    	    for(int i =0;i<transfer_data.size();i++) {
    	    	for(int j=0;j<transfer_data.size();j++) {
    	    		if(transfer_data.get(i).line!=transfer_data.get(j).line&&transfer_data.get(i).name.equals(transfer_data.get(j).name)){
    	    			transfer_data.get(i).transfer.add(transfer_data.get(j));
    	    			transfer_data.get(i).trans=true;
    	    			   
    	    		}
    	
    	    	}
    	    }
    	 
    	    //제대로 연결된건지 보기위해서 임시로 만든 출력
    	    
    	  if(list7.searchNode("상도").trans)
    	  {
    		  System.out.println("환승역");
    	  }
    	  else {
    		  System.out.println("환승역 아님");
    	  }
    	     
    	    
    	    
    }
    //노드를 만드는데 먼저 상선부터 node를 만들고 하선에 대한 데이터는 상선이 만들어 놓은 노드에 데이터만 삽입하는 형식, 환승여부확인해서 transfer_data에 환승역에 대한 노드들 삽입
    public static void insertNode(DoublyLinkedList list,Iterator<String[]> it,String[] array,ArrayList<ListNode> transfer_data) {
    		list.insertLastNode(array);
    		array = (String[]) it.next();
    		list.insertDownData(array);
		      if(array[3].equals("1")) {
		    	  //arraylist에 환승역 노드의 정보를 넘겨줌.
		    	  transfer_data.add(list.getTransfer());
		    	  //System.out.println(array[ 2]);
		      }
    }
}