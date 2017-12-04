package openCSV;

import java.util.ArrayList;


public class AnalysisPath {
	SearchPath path;
	public AnalysisPath(String input) {
		this.path = new SearchPath(input);
		int cnt = 0;
		for(ArrayList<ListNode> temp : path.totalPath) {
			System.out.println(cnt + "th path");
			for(ListNode l : temp) {
				System.out.print(l.name+ " ");
			}
			System.out.println("");
			cnt++;
		}
		
		calcTime();
		if(!calcCongestion()) {
			System.out.println("time over");
		}
	}
	
	ArrayList<ArrayList<Integer>> totalTime = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> time = new ArrayList<Integer>();
	ArrayList<ArrayList<Float>> totalCongestion = new ArrayList<ArrayList<Float>>();
	ArrayList<Float> congestion =  new ArrayList<Float>();
	
	boolean isTransfer = false;
	final int transferTime = 5;
	
	private void calcTime() {
		int time = 0;
		for(ArrayList<ListNode> arr : path.totalPath) {
			
			for(int i=0; i<arr.size(); i++) {
				if(i == arr.size()-1) continue;
				
				if(arr.get(i).name.equals(arr.get(i+1).name) && i == 0 && !(arr.get(i).line.equals(arr.get(i+1).line)))
					continue;
				else if(arr.get(i).name.equals(arr.get(i+1).name) && i!=0 && !arr.get(i).line.equals(arr.get(i+1).line)) { 
					time+=transferTime;
					this.time.add(time);
					continue;
				}
				if(arr.get(i).next.equals(arr.get(i+1)) && arr.get(i).next.line.equals(arr.get(i+1).line)) {
					time += arr.get(i).up_time;
					continue;
				}else if(arr.get(i).prev.equals(arr.get(i+1)) && arr.get(i).prev.line.equals(arr.get(i+1).line)) {
					time += arr.get(i).down_time;
					continue;
				}
				
			}
			this.time.add(time);
			this.totalTime.add((ArrayList<Integer>)this.time.clone());
			this.time.clear();
			time =0;
		}
	}
	
	private boolean calcCongestion(){
		int cnt_array = 0;
		int cnt_transfer = 0;
		if(path.currentHour == 0) path.currentHour = 19;
		path.currentHour -= 5;
		if(path.currentHour < 5 && path.currentHour> 0)
			return false;
		for(ArrayList<ListNode> arr : path.totalPath) {
			for(int i=0; i<arr.size(); i++) {
				if(i == arr.size()-1) continue;
				if(arr.get(i).name.equals(arr.get(i+1).name) && i == 0 && !arr.get(i).line.equals(arr.get(i+1).line)) {
					if(arr.get(i+1).next.equals(arr.get(i+2)))
						this.congestion.add(arr.get(i+1).up_data.get(path.currentHour));
					else if(arr.get(i+1).prev.equals(arr.get(i+2)))
						this.congestion.add(arr.get(i+1).down_data.get(path.currentHour));
					
				}else if(arr.get(i).name.equals(arr.get(i+1).name) && i!=0 && !arr.get(i).line.equals(arr.get(i+1).line)) {
					int tempHour = 0;
					if(path.currentMinute + this.totalTime.get(cnt_array).get(cnt_transfer) >= 60) {
						if(path.currentHour == 19)
							return false;
						tempHour = path.currentHour+1;
					}
					else {
						tempHour =  path.currentHour;
					}
					if(arr.get(i+1).next.equals(arr.get(i+2)))
						this.congestion.add(arr.get(i).up_data.get(tempHour));
					else if(arr.get(i+1).prev.equals(arr.get(i+2))) 
						this.congestion.add(arr.get(i).down_data.get(tempHour));
					cnt_transfer++;
					
				}else if(i == 0) {
					if(arr.get(i).next.equals(arr.get(i+1))) {
						this.congestion.add(arr.get(i).up_data.get(path.currentHour));
					}else if(arr.get(i+1).prev.equals(arr.get(i+1))) {
						this.congestion.add(arr.get(i).down_data.get(path.currentHour));
					}
				}
			}
			cnt_array++;
			cnt_transfer = 0;
			this.totalCongestion.add((ArrayList<Float>)this.congestion.clone());
			this.congestion.clear();
		}
		return true;
	}

}
