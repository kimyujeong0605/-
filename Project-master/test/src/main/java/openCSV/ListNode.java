package openCSV;

import java.util.ArrayList;

public class ListNode {
    ListNode prev; //이전역
    ListNode next; //다음역
    String name; //역명
    String line; //호선
	int up_time; //상선 소요시간 or 2호선은 내선
	int down_time; //하선 소요시간 or 2호선은 외선
	boolean trans; //환승여부
	ArrayList<Float> up_data = new ArrayList<Float>(); //상선의 혼잡도
	ArrayList<Float> down_data = new ArrayList<Float>(); //하선의 혼잡도
	ArrayList<ListNode> transfer = new ArrayList<ListNode>(); //환승역의 경우 환승역에 대한 node의 집합
	
    public ListNode(){
  
        this.prev = null;
        this.name = null;
        this.line =null;
        this.up_time=0;
        this.down_time=0;
        this.up_data=null;
        this.down_data=null;
        this.next = null;
        this.trans = false;
    }
    
    public ListNode(String[] data){
    	 this.line = data[0];
    	 this.name = data[2];
    	 if(data[3].equals("1"))
    		 this.trans = true;
    	 else
    		 this.trans = false;
    	this.up_time=Integer.parseInt(data[4]);
    	//05:00~0:00 혼잡도를 arraylist에 추가
    	 for(int i=6;i<26;i++) {
    	      this.up_data.add(Float.parseFloat(data[i]));
    	  }	      
       
    }
    
    public ListNode(ListNode prev,String line,String name,int up_time,ArrayList<Float>up_data, ListNode next) {
        super();
        this.prev = prev;
        this.line =line;
        this.name = name;
        this.up_time=up_time;
        this.down_time=down_time;
        this.up_data=up_data;
        this.down_data=down_data;
        this.next = next;
    }
    public String getLine() {
		return this.line;
	}
 
    public String getName() {
		return this.name;
	}
	
	public int getUp_time(){
		return this.up_time;
	}
	public int getDown_time(){
		return this.down_time;
	}
	public ArrayList<Float> getUp_data(){
		return this.up_data;
	}
	public ArrayList<Float> getDown_data(){
		return this.down_data;
	}
	
}
