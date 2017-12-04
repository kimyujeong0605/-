/*package openCSV;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
      
		String ss= "1호선/서울역/7호선/상도";
		// 출발호선/출발역/도착호선/도착역 형식 지켜주세요
		
		AnalysisPath path =  new AnalysisPath(ss);
		// AnalysisPath만 부르면 경로탐색부터 계산까지 다해줍니다. constructor가 다해 줘여
		int cnt =  0;
		
		
		for(ArrayList<Integer> timeArr : path.totalTime) {
			System.out.print(cnt++ + "th path time");
			for(Integer time : timeArr) {
				System.out.print(" "+ time);
			}
			System.out.println(" ");
		}
		cnt = 0;
		System.out.println(path.totalCongestion.size());
		for(ArrayList<Float> congestionArr : path.totalCongestion) {
			System.out.print(cnt++ + "th path congestion");
			for(Float congestion : congestionArr) {
				System.out.print(" " + congestion);
			}
			System.out.println(" ");
		}
	}
    
}*/
//저장확인용