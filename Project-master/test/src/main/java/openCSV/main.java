/*package openCSV;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
      
		String ss= "1ȣ��/���￪/7ȣ��/��";
		// ���ȣ��/��߿�/����ȣ��/������ ���� �����ּ���
		
		AnalysisPath path =  new AnalysisPath(ss);
		// AnalysisPath�� �θ��� ���Ž������ ������ �����ݴϴ�. constructor�� ���� �࿩
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
//����Ȯ�ο�