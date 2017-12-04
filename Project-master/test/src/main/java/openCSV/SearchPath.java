package openCSV;

import java.util.ArrayList;
import java.util.Calendar;

public class SearchPath {
	Calendar cal = Calendar.getInstance();
	int currentHour;
	int currentMinute;
	
	Parsed_data data;
	ArrayList<ArrayList<ListNode>> totalPath = new ArrayList<ArrayList<ListNode>>(); // array for all path
	ArrayList<ListNode> pathUp= new ArrayList<ListNode>(); // array for one path
	ArrayList<ListNode> pathDown= new ArrayList<ListNode>(); // array for one path
	//int transferCount = 0; // counter for check number of transfer
	
	String startLine, endLine;
	String startStationName, endStationName;
	String currentLine, currentStationName;
	
	public SearchPath(String input) {
	//Input must be follow this form "startLine/startStationName/endLine/endStationName"
	//Separator is "/"
		String[] temp;
		temp = input.split("/");
		if(temp.length < 4) 
			System.exit(0);
		else {
			startLine = temp[0];
			currentLine = startLine;
			startStationName = temp[1];
			currentStationName = startStationName;
			endLine = temp[2];
			endStationName = temp[3];
		}
		currentHour = cal.get(Calendar.HOUR_OF_DAY);
		// am 1~4 has no data
		// from 5 to 0(24)
		currentMinute = cal.get(Calendar.MINUTE);
		pathUp.clear();
		pathDown.clear();
		totalPath.clear();
		
		data = new Parsed_data();
		
		//System.out.println("first search");
		search(true, this.pathUp,	findList().searchNode(startStationName), 0);
		//System.out.println("second search");
		search(false, this.pathDown, findList().searchNode(startStationName), 0);
	}
	
	private DoublyLinkedList findList() {
		if(currentLine.equals("1호선")) {
			return data.list1;
		}else if(currentLine.equals("2호선")) {
			return data.list2;
		}else if(currentLine.equals("3호선")) {
			return data.list3;
		}else if(currentLine.equals("4호선")) {
			return data.list4;
		}else if(currentLine.equals("5호선")) {
			return data.list5;
		}else if(currentLine.equals("6호선")) {
			return data.list6;
		}else if(currentLine.equals("7호선")) {
			return data.list7;
		}else if(currentLine.equals("8호선")) {
			return data.list8;
		}else if(currentLine.equals("신정지선")) {
			return data.list9;
		}else {
			return data.list10;
		}
	}
	

	private void search(boolean direction, ArrayList<ListNode> prevPath, ListNode nextStation, int transferCount) {
		ArrayList<ListNode> temp = (ArrayList<ListNode>) prevPath.clone();
		temp.add(nextStation);
		currentStationName = nextStation.name;
		currentLine = nextStation.line;
		
		//for(ListNode l : temp) {
		//	System.out.print(l.name + " ");
		//}
		//System.out.println(" "+ "transferCount = " + transferCount); 
		
		if(currentStationName.equals(endStationName) && currentLine.equals(endLine)) {
			if(totalPath.contains(temp)) return;
			this.totalPath.add(temp);
			//System.out.println("push path");
			return;
		}

		if(findList().searchNode(currentStationName).trans) {
			if(transferCount == 0) {
				for(ListNode n : findList().searchNode(currentStationName).transfer) {
					if(temp.contains(n)) continue;
					else {
						//System.out.println("first");
						search(true, temp, n, transferCount+1);
						//System.out.println("second");
						search(false, temp, n, transferCount+1);
					}
				}
			}else if(transferCount == 1) {
				for(ListNode n : findList().searchNode(currentStationName).transfer) {
					if(temp.contains(n)) continue;
					else {
						if(n.line.equals(endLine)) {
							//System.out.println("first");
							search(true, temp, n, transferCount+1);
							//System.out.println("second");
							search(false, temp, n, transferCount+1);
						}
					}
				}
			}
		}
		currentStationName = nextStation.name;
		currentLine = nextStation.line;

		
		if(direction) {
			if(nextStation.next.equals(findList().head)) {
				//System.out.println("line end");
				return;
			}
			if(temp.contains(nextStation.next)) {
				//System.out.println("circle");
				return;
			}
			else search(true, temp, nextStation.next, transferCount);
		}
		else if(!direction) {
			//System.out.println(nextStation.prev.name);
			//System.out.println(findList().head.prev.name);
			if(nextStation.prev.equals(findList().head.prev)) {
				//System.out.println("line end");
				return;
			}
			if(temp.contains(nextStation.prev)) {
				//System.out.println("circle");
				return;
			}
			else search(false, temp, nextStation.prev, transferCount);
		}
		
	}
}
