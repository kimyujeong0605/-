package openCSV;

import java.io.IOException;
import java.util.ArrayList;

import com.sun.javafx.scene.traversal.TopMostTraversalEngine;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainClass extends Application {
		
	// main GUI의 모든 요소를 집어 넣을 pane 설정
	private AnchorPane anchorPane;
	

	public static void main(String[] args) {
		// 실행
		launch(args);
	}
	
	
	//이건 사용 안함.
	public void layout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainClass.class.getResource("main.fxml"));
			anchorPane = (AnchorPane)loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		final int MAX = 999;

		// 창 제목 설정
		stage.setTitle("자구설빙 지하철");

		// 버튼 만들기
		Button btn_search = new Button();
		btn_search.setText("검색");
		Button btn_cancle = new Button();
		btn_cancle.setText("취소");
		Button btn_ln = new Button();
		btn_ln.setText(" 호선 ");
		Button btn_ln2 = new Button();
		btn_ln2.setText(" 호선 ");

		// 취소
		btn_cancle.setOnAction(new EventHandler<ActionEvent>() { // 버튼을 눌렀을 때 실행
			public void handle(ActionEvent arg0) {
				stage.close();
			}
		});

		// 라벨 만들기
		Label lb_made = new Label("made by 자구설빙");
		Label lb_src = new Label("출발");
		Label lb_dest = new Label("도착");

		// 체크박스 만들기
		CheckBox ckb_comport = new CheckBox("편안함");
		CheckBox ckb_fast = new CheckBox("속도");

		// 리스트뷰

		ListView lv_linenumber = new ListView();

		lv_linenumber.getItems().add("==호선을 선택하세요.==");
		lv_linenumber.getItems().add("1호선");
		lv_linenumber.getItems().add("2호선");
		lv_linenumber.getItems().add("3호선");
		lv_linenumber.getItems().add("4호선");
		lv_linenumber.getItems().add("5호선");
		lv_linenumber.getItems().add("6호선");
		lv_linenumber.getItems().add("7호선");
		lv_linenumber.getItems().add("8호선");

		Button btn_select = new Button("Select");
		VBox vbox_ln = new VBox(lv_linenumber, btn_select);
		final Stage stage_line = new Stage();
		stage_line.setTitle("호선 설정");
		Scene scene_ln = new Scene(vbox_ln, 200, 225);
		stage_line.setScene(scene_ln);

		btn_ln.setOnAction(new EventHandler<ActionEvent>() { // 버튼을 눌렀을 때 실행
			public void handle(ActionEvent arg0) {
				stage_line.show();
			}
		});

		btn_select.setOnAction(event -> {
			ObservableList selectedIndices = lv_linenumber.getSelectionModel().getSelectedIndices();

			for (Object o : selectedIndices) {
				btn_ln.setText(o + "호선");
			}
			stage_line.close();
			;
		});

		ListView lv_linenumber2 = new ListView();

		lv_linenumber2.getItems().add("==호선을 선택하세요.==");
		lv_linenumber2.getItems().add("1호선");
		lv_linenumber2.getItems().add("2호선");
		lv_linenumber2.getItems().add("3호선");
		lv_linenumber2.getItems().add("4호선");
		lv_linenumber2.getItems().add("5호선");
		lv_linenumber2.getItems().add("6호선");
		lv_linenumber2.getItems().add("7호선");
		lv_linenumber2.getItems().add("8호선");

		Button btn_select2 = new Button("Select");
		VBox vbox_ln2 = new VBox(lv_linenumber2, btn_select2);
		Stage stage_line2 = new Stage();
		stage_line2.setTitle("호선 설정");
		Scene scene_ln2 = new Scene(vbox_ln2, 200, 225);
		stage_line2.setScene(scene_ln2);

		btn_ln2.setOnAction(new EventHandler<ActionEvent>() { // 버튼을 눌렀을 때 실행
			public void handle(ActionEvent arg0) {
				stage_line2.show();
			}
		});

		btn_select2.setOnAction(event -> {
			ObservableList selectedIndices = lv_linenumber2.getSelectionModel().getSelectedIndices();

			for (Object o : selectedIndices) {
				btn_ln2.setText(o + "호선");
			}
			stage_line2.close();

		});

		// TextField
		TextField tf_station = new TextField();
		TextField tf_station2 = new TextField();
		TextField tf_time = new TextField();

		tf_station.setText("서울역");  //출발역을 입력해주세요.
		tf_station2.setText("상도"); //도착역을 입력해주세요.
		tf_time.setText("시간범위(분)");

		
		//
		

		// 결과 창을 만들자

		Stage result_stage = new Stage();
		Stage result_stage1 = new Stage();
		Stage result_stage2 = new Stage();
		Stage result_stage3 = new Stage();
		Stage result_stage4 = new Stage();
		Stage result_stage5 = new Stage();
		result_stage.setTitle("결과창");

		
		btn_search.setOnAction(new EventHandler<ActionEvent>() { // 버튼을 눌렀을 때 실행
			public void handle(ActionEvent arg0) {
				
				if (btn_ln.getText() != " 호선 " && btn_ln2.getText() != " 호선 " && tf_station.getText() != null
						&& tf_station2.getText() != null) {
					
					String station = null;
					
					station = btn_ln.getText() + "/" + tf_station.getText() + "/" + btn_ln2.getText() + "/"
							+ tf_station2.getText();

					AnalysisPath path = new AnalysisPath(station);
					// AnalysisPath만 부르면 경로탐색부터 계산까지 다해줍니다. constructor가 다해 줘여

					int cnt = 0;
					for (ArrayList<Integer> timeArr : path.totalTime) {
						System.out.print(cnt++ + "th path time");
						int cc = 0;
						for (Integer time : timeArr) {
							
							System.out.print(" " + time);
							cc++;
						}
						System.out.println(" ");
					}
					
					int nowSize = cnt;
					cnt = 0;
					System.out.println(path.totalCongestion.size());
					for (ArrayList<Float> congestionArr : path.totalCongestion) {
						System.out.print(cnt++ + "th path congestion");
						for (Float congestion : congestionArr) {
							System.out.print(" " + congestion);
						}
						System.out.println(" ");
					}
					

					

										
					GridPane result_gridPane = new GridPane();
					
					Label lb_ln = new Label(btn_ln.getText());
					Label lb_ln2=new Label(btn_ln2.getText()); 
					Label lb_st=new Label(tf_station.getText());
					Label lb_st2=new Label(tf_station2.getText());
					result_gridPane.add(lb_ln, 3, 3, 1, 1);
					result_gridPane.add(lb_ln2, 10, 3, 1, 1);
					result_gridPane.add(lb_st, 3, 4, 1, 1);
					result_gridPane.add(lb_st2, 10, 4, 1, 1);
					
					result_gridPane.setHgap(20);
					result_gridPane.setVgap(20);
					


					
					////////////////////////////////////////////////////////////////////////////
					int index1 = 999;
					int index2=999;
					int index3=999;
					int index4=999;
					int index5=999;
					
					float temp1=999;
					float temp2=999;
					float temp3=999;
					float temp4=999;
					float temp5=999;
					
					ComboBox<String> combo = new ComboBox();
					if(ckb_comport.isSelected()==true && ckb_fast.isSelected()!=true) {

					combo.getItems().add("Path 1");
					combo.getItems().add("Path 2");
					combo.getItems().add("Path 3");
					combo.getItems().add("Path 4");
					combo.getItems().add("Path 5");
					Button btn_Go = new Button("Go");



					
					combo.setValue("Path 1");
					result_gridPane.add(combo,1,1,1,1);
					

if(tf_time.getText().equals("시간범위(분)")) {
						for(int i = 0; i<(path.totalCongestion.size());i++) {//1
							float j=0;
							for(int z=0; z<path.totalCongestion.get(i).size();z++) {
								j=j+path.totalCongestion.get(i).get(z);
							}
							j=j/(path.totalCongestion.get(i).size());
							if(j<=temp1) {
								temp1 = j;
								index1 = i;
							}
						}
						
						for(int i = 0; i<(path.totalCongestion.size());i++) {//2
							float j=0;
							for(int z=0; z<path.totalCongestion.get(i).size();z++) {
								j=j+path.totalCongestion.get(i).get(z);
							}
							j=j/(path.totalCongestion.get(i).size());
							if(j<=temp2 && j!=temp1) {
								temp2 = j;
								index2 = i;
							}
						}
						for(int i = 0; i<(path.totalCongestion.size());i++) { //3
							float j=0;
							for(int z=0; z<path.totalCongestion.get(i).size();z++) {
								j=j+path.totalCongestion.get(i).get(z);
							}
							j=j/(path.totalCongestion.get(i).size());
							if(j<=temp3 && j!=temp1 && j!=temp2) {
								temp3 = j;
								index3 = i;
							}
						}
						
						for(int i = 0; i<(path.totalCongestion.size());i++) { //4
							float j=0;
							for(int z=0; z<path.totalCongestion.get(i).size();z++) {
								j=j+path.totalCongestion.get(i).get(z);
							}
							j=j/(path.totalCongestion.get(i).size());
							if(j<=temp4 && j!=temp1 && j!=temp2 && j!=temp3) {
								temp4 = j;
								index4 = i;
							}
						}
						
						for(int i = 0; i<(path.totalCongestion.size());i++) { //5
							float j=0;
							for(int z=0; z<path.totalCongestion.get(i).size();z++) {
								j=j+path.totalCongestion.get(i).get(z);
							}
							j=j/(path.totalCongestion.get(i).size());
							if(j<=temp5 && j!=temp1 && j!=temp2 && j!=temp3 && j!=temp4) {
								temp5 = j;
								index5 = i;
							}
						}
}
else {
	int timetime = Integer.parseInt(tf_time.getText());
	for(int i = 0; i<(path.totalCongestion.size());i++) {//1
		float j=0;
		for(int z=0; z<path.totalCongestion.get(i).size();z++) {
			j=j+path.totalCongestion.get(i).get(z);
		}
		j=j/(path.totalCongestion.get(i).size());
		if(j<=temp1 && path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=timetime) {
			temp1 = j;
			index1 = i;
		}
	}
	
	for(int i = 0; i<(path.totalCongestion.size());i++) {//2
		float j=0;
		for(int z=0; z<path.totalCongestion.get(i).size();z++) {
			j=j+path.totalCongestion.get(i).get(z);
		}
		j=j/(path.totalCongestion.get(i).size());
		if(j<=temp2 && j!=temp1&& path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=timetime) {
			temp2 = j;
			index2 = i;
		}
	}
	for(int i = 0; i<(path.totalCongestion.size());i++) { //3
		float j=0;
		for(int z=0; z<path.totalCongestion.get(i).size();z++) {
			j=j+path.totalCongestion.get(i).get(z);
		}
		j=j/(path.totalCongestion.get(i).size());
		if(j<=temp3 && j!=temp1 && j!=temp2&& path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=timetime) {
			temp3 = j;
			index3 = i;
		}
	}
	
	for(int i = 0; i<(path.totalCongestion.size());i++) { //4
		float j=0;
		for(int z=0; z<path.totalCongestion.get(i).size();z++) {
			j=j+path.totalCongestion.get(i).get(z);
		}
		j=j/(path.totalCongestion.get(i).size());
		if(j<=temp2 && j!=temp1 && j!=temp2 && j!=temp3&& path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=timetime) {
			temp4 = j;
			index4 = i;
		}
	}
	
	for(int i = 0; i<(path.totalCongestion.size());i++) { //5
		float j=0;
		for(int z=0; z<path.totalCongestion.get(i).size();z++) {
			j=j+path.totalCongestion.get(i).get(z);
		}
		j=j/(path.totalCongestion.get(i).size());
		if(j<=temp5 && j!=temp1 && j!=temp2 && j!=temp3 && j!=temp4&& path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=timetime) {
			temp5 = j;
			index5 = i;
		}
	}
}


							Label lb_tr = new Label("환승역");
							Label lb_tr2 = new Label("환승역");
							Label lb_trst = new Label();
							Label lb_trst2 = new Label();

							Label lb_ltime = new Label("시간 : ");
							Label lb_lcomfort = new Label("혼잡도 :");
							result_gridPane.add(lb_ltime,  5, 7,1,1);
							result_gridPane.add(lb_lcomfort,  5, 8,1,1);
							

							
							result_stage.setScene(new Scene(result_gridPane, 700, 350));
							
							int count=0;
							String hwanseong1=null;
							String hwanseong2=null;
							for(int i=1; i<path.path.totalPath.get(index1).size()-1;i++) {
								if(count==0&&path.path.totalPath.get(index1).get(i).name.equals(path.path.totalPath.get(index1).get(i+1).name)) {
									count ++;
									hwanseong1 = path.path.totalPath.get(index1).get(i).name;
								}
								else if(count==1&&path.path.totalPath.get(index1).get(i).name.equals(path.path.totalPath.get(index1).get(i+1).name)) {
									count ++;
									hwanseong2 = path.path.totalPath.get(index1).get(i).name;
								}
							}
							
							Label lb_comfort; Image image;
							
							if(count==1) {
								result_gridPane.add(lb_tr,  6, 3,1,1);
								lb_trst = new Label(hwanseong1);
								result_gridPane.add(lb_trst,  6, 4,1,1);	
								Label lb_time = new Label(path.totalTime.get(index1).get(path.totalTime.get(index1).size()-1).toString());
								if((path.totalCongestion.get(index1).get(0)+path.totalCongestion.get(index1).get(1))/2<=34){
									lb_comfort = new Label("원활");
									image = new Image(getClass().getResourceAsStream("green.png"));
								}else if((path.totalCongestion.get(index1).get(0)+path.totalCongestion.get(index1).get(1))/2<=70){
									lb_comfort = new Label("보통");
									image = new Image(getClass().getResourceAsStream("blue.png"));
								}else {
									lb_comfort = new Label("혼잡");
									image = new Image(getClass().getResourceAsStream("red.png"));
								}
								lb_comfort.setGraphic(new ImageView(image));
								result_gridPane.add(lb_time,  6, 7,1,1);
								result_gridPane.add(lb_comfort,  6, 8,1,1);
							}else {
								result_gridPane.add(lb_tr,  5, 3,1,1);
								result_gridPane.add(lb_tr2,  7, 3,1,1);
								lb_trst = new Label(hwanseong1);
								lb_trst2 = new Label(hwanseong2);
								result_gridPane.add(lb_trst,  5, 4,1,1);
								result_gridPane.add(lb_trst2,  7, 4,1,1);
								Label lb_time = new Label(path.totalTime.get(index1).get(path.totalTime.get(index1).size()-1).toString());
								if((path.totalCongestion.get(index1).get(0)+path.totalCongestion.get(index1).get(1)+path.totalCongestion.get(index1).get(2))/3<=34){
									lb_comfort = new Label("원활");
									image = new Image(getClass().getResourceAsStream("green.png"));
									}else if((path.totalCongestion.get(index1).get(0)+path.totalCongestion.get(index1).get(1)+path.totalCongestion.get(index1).get(2))/3<=70){
										lb_comfort = new Label("보통");
										image = new Image(getClass().getResourceAsStream("blue.png"));
									}else {
										lb_comfort = new Label("혼잡");
										image = new Image(getClass().getResourceAsStream("red.png"));
									}
								lb_comfort.setGraphic(new ImageView(image));
								result_gridPane.add(lb_time,  6, 7,1,1);
								result_gridPane.add(lb_comfort,  6, 8,1,1);
							}
							result_gridPane.add(btn_Go, 2, 1,1,1);
							result_stage.show();
					

							btn_Go.setOnAction(new EventHandler<ActionEvent>() { // 버튼을 눌렀을 때 실행
								public void handle(ActionEvent arg0) {
									if(result_stage.isShowing()==true) {
										result_stage.close();
									}
									if(result_stage1.isShowing()==true) {
										result_stage1.close();
									}
									if(result_stage2.isShowing()==true) {
										result_stage2.close();
									}
									if(result_stage3.isShowing()==true) {
										result_stage3.close();
									}
									if(result_stage4.isShowing()==true) {
										result_stage4.close();
									}
									if(result_stage5.isShowing()==true) {
										result_stage5.close();
									}
									int index1 = 999;
									int index2=999;
									int index3=999;
									int index4=999;
									int index5=999;
									
									float temp1=999;
									float temp2=999;
									float temp3=999;
									float temp4=999;
									float temp5=999;
								
							//	ComboBox<String> combo = new ComboBox();
							//	combo.getItems().add("Path 1");
							//	combo.getItems().add("Path 2");
							//	combo.getItems().add("Path 3");
							//	combo.getItems().add("Path 4");
							//	combo.getItems().add("Path 5");
							//	Button btn_Go = new Button("Go");
									
									if(tf_time.getText().equals("시간범위(분)")) {
										for(int i = 0; i<(path.totalCongestion.size());i++) {//1
											float j=0;
											for(int z=0; z<path.totalCongestion.get(i).size();z++) {
												j=j+path.totalCongestion.get(i).get(z);
											}
											j=j/(path.totalCongestion.get(i).size());
											if(j<=temp1) {
												temp1 = j;
												index1 = i;
											}
										}
										
										for(int i = 0; i<(path.totalCongestion.size());i++) {//2
											float j=0;
											for(int z=0; z<path.totalCongestion.get(i).size();z++) {
												j=j+path.totalCongestion.get(i).get(z);
											}
											j=j/(path.totalCongestion.get(i).size());
											if(j<=temp2 && j!=temp1) {
												temp2 = j;
												index2 = i;
											}
										}
										for(int i = 0; i<(path.totalCongestion.size());i++) { //3
											float j=0;
											for(int z=0; z<path.totalCongestion.get(i).size();z++) {
												j=j+path.totalCongestion.get(i).get(z);
											}
											j=j/(path.totalCongestion.get(i).size());
											if(j<=temp3 && j!=temp1 && j!=temp2) {
												temp3 = j;
												index3 = i;
											}
										}
										
										for(int i = 0; i<(path.totalCongestion.size());i++) { //4
											float j=0;
											for(int z=0; z<path.totalCongestion.get(i).size();z++) {
												j=j+path.totalCongestion.get(i).get(z);
											}
											j=j/(path.totalCongestion.get(i).size());
											if(j<=temp4 && j!=temp1 && j!=temp2 && j!=temp3) {
												temp4 = j;
												index4 = i;
											}
										}
										
										for(int i = 0; i<(path.totalCongestion.size());i++) { //5
											float j=0;
											for(int z=0; z<path.totalCongestion.get(i).size();z++) {
												j=j+path.totalCongestion.get(i).get(z);
											}
											j=j/(path.totalCongestion.get(i).size());
											if(j<=temp5 && j!=temp1 && j!=temp2 && j!=temp3 && j!=temp4) {
												temp5 = j;
												index5 = i;
											}
										}
				}
				else {
					int timetime = Integer.parseInt(tf_time.getText());
					
					for(int i = 0; i<(path.totalCongestion.size());i++) {//1
						float j=0;
						for(int z=0; z<path.totalCongestion.get(i).size();z++) {
							j=j+path.totalCongestion.get(i).get(z);
						}
						j=j/(path.totalCongestion.get(i).size());
						if(j<=temp1 && path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=timetime) {
							temp1 = j;
							index1 = i;
						}
					}
					
					for(int i = 0; i<(path.totalCongestion.size());i++) {//2
						float j=0;
						for(int z=0; z<path.totalCongestion.get(i).size();z++) {
							j=j+path.totalCongestion.get(i).get(z);
						}
						j=j/(path.totalCongestion.get(i).size());
						if(j<=temp2 && j!=temp1&& path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=timetime) {
							temp2 = j;
							index2 = i;
						}
					}
					for(int i = 0; i<(path.totalCongestion.size());i++) { //3
						float j=0;
						for(int z=0; z<path.totalCongestion.get(i).size();z++) {
							j=j+path.totalCongestion.get(i).get(z);
						}
						j=j/(path.totalCongestion.get(i).size());
						if(j<=temp3 && j!=temp1 && j!=temp2&& path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=timetime) {
							temp3 = j;
							index3 = i;
						}
					}
					
					for(int i = 0; i<(path.totalCongestion.size());i++) { //4
						float j=0;
						for(int z=0; z<path.totalCongestion.get(i).size();z++) {
							j=j+path.totalCongestion.get(i).get(z);
						}
						j=j/(path.totalCongestion.get(i).size());
						if(j<=temp2 && j!=temp1 && j!=temp2 && j!=temp3&& path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=timetime) {
							temp4 = j;
							index4 = i;
						}
					}
					
					for(int i = 0; i<(path.totalCongestion.size());i++) { //5
						float j=0;
						for(int z=0; z<path.totalCongestion.get(i).size();z++) {
							j=j+path.totalCongestion.get(i).get(z);
						}
						j=j/(path.totalCongestion.get(i).size());
						if(j<=temp5 && j!=temp1 && j!=temp2 && j!=temp3 && j!=temp4&& path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=timetime) {
							temp5 = j;
							index5 = i;
						}
					}
				}
									
									if(combo.getValue().equals("Path 1")) {
										if(index1==999) {
											Alert alert = new Alert(AlertType.INFORMATION);
											alert.setTitle("조건에 부합하지 않은 경로입니다.");
											alert.setHeaderText("조건에 부합하지 않은 경로입니다.");
											alert.setContentText("조건설정을 다시하거나 다른 경로를 선택해주십시오.");

											alert.showAndWait();
										}else {
										GridPane result_gridPane1 = new GridPane();
										Label lb_tr = new Label("환승역");
										Label lb_tr2 = new Label("환승역");
										Label lb_trst = new Label();
										Label lb_trst2 = new Label();

										Label lb_ltime = new Label("시간 : ");
										Label lb_lcomfort = new Label("혼잡도 :");
										result_gridPane1.add(lb_ltime,  5, 7,1,1);
										result_gridPane1.add(lb_lcomfort,  5, 8,1,1);
										
										result_gridPane1.setHgap(20);
										result_gridPane1.setVgap(20);
										
										result_stage1.setScene(new Scene(result_gridPane1, 700, 350));
										
										int count=0;
										String hwanseong1=null;
										String hwanseong2=null;
										for(int i=1; i<path.path.totalPath.get(index1).size()-1;i++) {
											if(count==0&&path.path.totalPath.get(index1).get(i).name.equals(path.path.totalPath.get(index1).get(i+1).name)) {
												count ++;
												hwanseong1 = path.path.totalPath.get(index1).get(i).name;
											}
											else if(count==1&&path.path.totalPath.get(index1).get(i).name.equals(path.path.totalPath.get(index1).get(i+1).name)) {
												count ++;
												hwanseong2 = path.path.totalPath.get(index1).get(i).name;
											}else {
												
											}
										}
										
										Label lb_comfort; Image image;
										
										if(count==1) {
											result_gridPane1.add(lb_tr,  6, 3,1,1);
											lb_trst = new Label(hwanseong1);
											result_gridPane1.add(lb_trst,  6, 4,1,1);	
											Label lb_time = new Label(path.totalTime.get(index1).get(path.totalTime.get(index1).size()-1).toString());
											if((path.totalCongestion.get(index1).get(0)+path.totalCongestion.get(index1).get(1))/2<=34){
												lb_comfort = new Label("원활");
												image = new Image(getClass().getResourceAsStream("green.png"));
											}else if((path.totalCongestion.get(index1).get(0)+path.totalCongestion.get(index1).get(1))/2<=70){
												lb_comfort = new Label("보통");
												image = new Image(getClass().getResourceAsStream("blue.png"));
											}else {
												lb_comfort = new Label("혼잡");
												image = new Image(getClass().getResourceAsStream("red.png"));
											}
											lb_comfort.setGraphic(new ImageView(image));
											result_gridPane1.add(lb_time,  6, 7,1,1);
											result_gridPane1.add(lb_comfort,  6, 8,1,1);
										}else {
											result_gridPane1.add(lb_tr,  5, 3,1,1);
											result_gridPane1.add(lb_tr2,  7, 3,1,1);
											lb_trst = new Label(hwanseong1);
											lb_trst2 = new Label(hwanseong2);
											result_gridPane1.add(lb_trst,  5, 4,1,1);
											result_gridPane1.add(lb_trst2,  7, 4,1,1);
											Label lb_time = new Label(path.totalTime.get(index1).get(path.totalTime.get(index1).size()-1).toString());
											if((path.totalCongestion.get(index1).get(0)+path.totalCongestion.get(index1).get(1)+path.totalCongestion.get(index1).get(2))/3<=34){
													lb_comfort = new Label("원활");
													image = new Image(getClass().getResourceAsStream("green.png"));
												}else if((path.totalCongestion.get(index1).get(0)+path.totalCongestion.get(index1).get(1)+path.totalCongestion.get(index1).get(2))/3<=70){
													lb_comfort = new Label("보통");
													image = new Image(getClass().getResourceAsStream("blue.png"));
												}else {
													lb_comfort = new Label("혼잡");
													image = new Image(getClass().getResourceAsStream("red.png"));
												}
											lb_comfort.setGraphic(new ImageView(image));
											result_gridPane1.add(lb_time,  6, 7,1,1);
											result_gridPane1.add(lb_comfort,  6, 8,1,1);
										}
										result_gridPane1.add(btn_Go, 2, 1,1,1);
										Label lb_ln = new Label(btn_ln.getText());
										Label lb_ln2=new Label(btn_ln2.getText()); 
										Label lb_st=new Label(tf_station.getText());
										Label lb_st2=new Label(tf_station2.getText());
										result_gridPane1.add(lb_ln, 3, 3, 1, 1);
										result_gridPane1.add(lb_ln2, 10, 3, 1, 1);
										result_gridPane1.add(lb_st, 3, 4, 1, 1);
										result_gridPane1.add(lb_st2, 10, 4, 1, 1);
										

									result_gridPane1.add(combo,1,1,1,1);
									combo.setValue("Path 1");
										result_stage1.show();
										}
									}///
									
									else if(combo.getValue().equals("Path 2")) {
										if(index2==999) {
											Alert alert = new Alert(AlertType.INFORMATION);
											alert.setTitle("조건에 부합하지 않은 경로입니다.");
											alert.setHeaderText("조건에 부합하지 않은 경로입니다.");
											alert.setContentText("조건설정을 다시하거나 다른 경로를 선택해주십시오.");

											alert.showAndWait();
										}else {
										GridPane result_gridPane2 = new GridPane();
										Label lb_tr = new Label("환승역");
										Label lb_tr2 = new Label("환승역");
										Label lb_trst = new Label();
										Label lb_trst2 = new Label();

										Label lb_ltime = new Label("시간 : ");
										Label lb_lcomfort = new Label("혼잡도 :");
										result_gridPane2.add(lb_ltime,  5, 7,1,1);
										result_gridPane2.add(lb_lcomfort,  5, 8,1,1);
										
										result_gridPane2.setHgap(20);
										result_gridPane2.setVgap(20);
										
									result_stage2.setScene(new Scene(result_gridPane2, 700, 350));
										
										int count=0;
										String hwanseong1=null;
										String hwanseong2=null;
										for(int i=1; i<path.path.totalPath.get(index2).size()-1;i++) {
											if(count==0&&path.path.totalPath.get(index2).get(i).name.equals(path.path.totalPath.get(index2).get(i+1).name)) {
												count ++;
												hwanseong1 = path.path.totalPath.get(index2).get(i).name;
											}
											else if(count==1&&path.path.totalPath.get(index2).get(i).name.equals(path.path.totalPath.get(index2).get(i+1).name)) {
												count ++;
												hwanseong2 = path.path.totalPath.get(index2).get(i).name;
											}
										}
										
										Label lb_comfort; Image image;
										
										if(count==1) {
											result_gridPane2.add(lb_tr,  6, 3,1,1);
											lb_trst = new Label(hwanseong1);
											result_gridPane2.add(lb_trst,  6, 4,1,1);	
											Label lb_time = new Label(path.totalTime.get(index2).get(path.totalTime.get(index2).size()-1).toString());
											if((path.totalCongestion.get(index2).get(0)+path.totalCongestion.get(index2).get(1))/2<=34){
												lb_comfort = new Label("원활");
												image = new Image(getClass().getResourceAsStream("green.png"));
											}else if((path.totalCongestion.get(index2).get(0)+path.totalCongestion.get(index2).get(1))/2<=70){
												lb_comfort = new Label("보통");
												image = new Image(getClass().getResourceAsStream("blue.png"));
											}else {
												lb_comfort = new Label("혼잡");
												image = new Image(getClass().getResourceAsStream("red.png"));
											}
											lb_comfort.setGraphic(new ImageView(image));
											result_gridPane2.add(lb_time,  6, 7,1,1);
											result_gridPane2.add(lb_comfort,  6, 8,1,1);
										}else {
											result_gridPane2.add(lb_tr,  5, 3,1,1);
											result_gridPane2.add(lb_tr2,  7, 3,1,1);
											lb_trst = new Label(hwanseong1);
											lb_trst2 = new Label(hwanseong2);
											result_gridPane2.add(lb_trst,  5, 4,1,1);
											result_gridPane2.add(lb_trst2,  7, 4,1,1);
											Label lb_time = new Label(path.totalTime.get(index2).get(path.totalTime.get(index2).size()-1).toString());
											if((path.totalCongestion.get(index2).get(0)+path.totalCongestion.get(index2).get(1)+path.totalCongestion.get(index2).get(2))/3<=34){
													lb_comfort = new Label("원활");
													image = new Image(getClass().getResourceAsStream("green.png"));
												}else if((path.totalCongestion.get(index2).get(0)+path.totalCongestion.get(index2).get(1)+path.totalCongestion.get(index2).get(2))/3<=70){
													lb_comfort = new Label("보통");
													image = new Image(getClass().getResourceAsStream("blue.png"));
												}else {
													lb_comfort = new Label("혼잡");
													image = new Image(getClass().getResourceAsStream("red.png"));
												}
											lb_comfort.setGraphic(new ImageView(image));
											result_gridPane2.add(lb_time,  6, 7,1,1);
											result_gridPane2.add(lb_comfort,  6, 8,1,1);
										}
										result_gridPane2.add(btn_Go, 2, 1,1,1);
										Label lb_ln = new Label(btn_ln.getText());
										Label lb_ln2=new Label(btn_ln2.getText()); 
										Label lb_st=new Label(tf_station.getText());
										Label lb_st2=new Label(tf_station2.getText());
										result_gridPane2.add(lb_ln, 3, 3, 1, 1);
										result_gridPane2.add(lb_ln2, 10, 3, 1, 1);
										result_gridPane2.add(lb_st, 3, 4, 1, 1);
										result_gridPane2.add(lb_st2, 10, 4, 1, 1);
										result_gridPane2.add(combo,1,1,1,1);
										combo.setValue("Path 2");
										
										result_stage2.show();
										}
									}///
									else if(combo.getValue().equals("Path 3")) {
										if(index3==999) {
											Alert alert = new Alert(AlertType.INFORMATION);
											alert.setTitle("조건에 부합하지 않은 경로입니다.");
											alert.setHeaderText("조건에 부합하지 않은 경로입니다.");
											alert.setContentText("조건설정을 다시하거나 다른 경로를 선택해주십시오.");

											alert.showAndWait();
										}else {
										GridPane result_gridPane3 = new GridPane();
										Label lb_tr = new Label("환승역");
										Label lb_tr2 = new Label("환승역");
										Label lb_trst = new Label();
										Label lb_trst2 = new Label();

										Label lb_ltime = new Label("시간 : ");
										Label lb_lcomfort = new Label("혼잡도 :");
										result_gridPane3.add(lb_ltime,  5, 7,1,1);
										result_gridPane3.add(lb_lcomfort,  5, 8,1,1);
										
										result_gridPane3.setHgap(20);
										result_gridPane3.setVgap(20);
										
									result_stage3.setScene(new Scene(result_gridPane3, 700, 350));
										
										int count=0;
										String hwanseong1=null;
										String hwanseong2=null;
										for(int i=1; i<path.path.totalPath.get(index3).size()-1;i++) {
											if(count==0&&path.path.totalPath.get(index3).get(i).name.equals(path.path.totalPath.get(index3).get(i+1).name)) {
												count ++;
												hwanseong1 = path.path.totalPath.get(index3).get(i).name;
											}
											else if(count==1&&path.path.totalPath.get(index3).get(i).name.equals(path.path.totalPath.get(index3).get(i+1).name)) {
												count ++;
												hwanseong2 = path.path.totalPath.get(index3).get(i).name;
											}
										}
										
										Label lb_comfort;
										Image image;
										
										if(count==1) {
											result_gridPane3.add(lb_tr,  6, 3,1,1);
											lb_trst = new Label(hwanseong1);
											result_gridPane3.add(lb_trst,  6, 4,1,1);	
											Label lb_time = new Label(path.totalTime.get(index3).get(path.totalTime.get(index3).size()-1).toString());
											if((path.totalCongestion.get(index3).get(0)+path.totalCongestion.get(index3).get(1))/2<=34){
											lb_comfort = new Label("원활");
											image = new Image(getClass().getResourceAsStream("green.png"));
											}else if((path.totalCongestion.get(index3).get(0)+path.totalCongestion.get(index3).get(1))/2<=70){
												lb_comfort = new Label("보통");
												image = new Image(getClass().getResourceAsStream("blue.png"));
											}else {
												lb_comfort = new Label("혼잡");
												image = new Image(getClass().getResourceAsStream("red.png"));
											}
											lb_comfort.setGraphic(new ImageView(image));
											result_gridPane3.add(lb_time,  6, 7,1,1);
											result_gridPane3.add(lb_comfort,  6, 8,1,1);
										}else {
											result_gridPane3.add(lb_tr,  5, 3,1,1);
											result_gridPane3.add(lb_tr2,  7, 3,1,1);
											lb_trst = new Label(hwanseong1);
											lb_trst2 = new Label(hwanseong2);
											result_gridPane3.add(lb_trst,  5, 4,1,1);
											result_gridPane3.add(lb_trst2,  7, 4,1,1);
											Label lb_time = new Label(path.totalTime.get(index3).get(path.totalTime.get(index3).size()-1).toString());
											if((path.totalCongestion.get(index2).get(0)+path.totalCongestion.get(index3).get(1)+path.totalCongestion.get(index3).get(2))/3<=34){
												lb_comfort = new Label("원활");
												image = new Image(getClass().getResourceAsStream("green.png"));
												}else if((path.totalCongestion.get(index3).get(0)+path.totalCongestion.get(index3).get(1)+path.totalCongestion.get(index3).get(2))/3<=70){
													lb_comfort = new Label("보통");
													image = new Image(getClass().getResourceAsStream("blue.png"));
												}else {
													lb_comfort = new Label("혼잡");
													image = new Image(getClass().getResourceAsStream("red.png"));
												}
											lb_comfort.setGraphic(new ImageView(image));
											result_gridPane3.add(lb_time,  6, 7,1,1);
											result_gridPane3.add(lb_comfort,  6, 8,1,1);
										}
										result_gridPane3.add(btn_Go, 2, 1,1,1);
										Label lb_ln = new Label(btn_ln.getText());
										Label lb_ln2=new Label(btn_ln2.getText()); 
										Label lb_st=new Label(tf_station.getText());
										Label lb_st2=new Label(tf_station2.getText());
										result_gridPane3.add(lb_ln, 3, 3, 1, 1);
										result_gridPane3.add(lb_ln2, 10, 3, 1, 1);
										result_gridPane3.add(lb_st, 3, 4, 1, 1);
										result_gridPane3.add(lb_st2, 10, 4, 1, 1);
										result_gridPane3.add(combo,1,1,1,1);
										combo.setValue("Path 3");
										
										result_stage3.show();
										}
									}///
									else if(combo.getValue().equals("Path 4")) {
										if(index4==999) {
											Alert alert = new Alert(AlertType.INFORMATION);
											alert.setTitle("조건에 부합하지 않은 경로입니다.");
											alert.setHeaderText("조건에 부합하지 않은 경로입니다.");
											alert.setContentText("조건설정을 다시하거나 다른 경로를 선택해주십시오.");

											alert.showAndWait();
										}else {
										GridPane result_gridPane4 = new GridPane();
										Label lb_tr = new Label("환승역");
										Label lb_tr2 = new Label("환승역");
										Label lb_trst = new Label();
										Label lb_trst2 = new Label();

										Label lb_ltime = new Label("시간 : ");
										Label lb_lcomfort = new Label("혼잡도 :");
										result_gridPane4.add(lb_ltime,  5, 7,1,1);
										result_gridPane4.add(lb_lcomfort,  5, 8,1,1);
										
										result_gridPane4.setHgap(20);
										result_gridPane4.setVgap(20);
										
									result_stage4.setScene(new Scene(result_gridPane4, 700, 350));
										
										int count=0;
										String hwanseong1=null;
										String hwanseong2=null;
										for(int i=1; i<path.path.totalPath.get(index4).size()-1;i++) {
											if(count==0&&path.path.totalPath.get(index4).get(i).name.equals(path.path.totalPath.get(index4).get(i+1).name)) {
												count ++;
												hwanseong1 = path.path.totalPath.get(index4).get(i).name;
											}
											else if(count==1&&path.path.totalPath.get(index4).get(i).name.equals(path.path.totalPath.get(index4).get(i+1).name)) {
												count ++;
												hwanseong2 = path.path.totalPath.get(index4).get(i).name;
											}
										}
										
										Label lb_comfort; Image image;
										
										if(count==1) {
											result_gridPane4.add(lb_tr,  6, 3,1,1);
											lb_trst = new Label(hwanseong1);
											result_gridPane4.add(lb_trst,  6, 4,1,1);	
											Label lb_time = new Label(path.totalTime.get(index4).get(path.totalTime.get(index4).size()-1).toString());
											if((path.totalCongestion.get(index4).get(0)+path.totalCongestion.get(index4).get(1))/2<=34){
												lb_comfort = new Label("원활");
												image = new Image(getClass().getResourceAsStream("green.png"));
											}else if((path.totalCongestion.get(index4).get(0)+path.totalCongestion.get(index4).get(1))/2<=70){
												lb_comfort = new Label("보통");
												image = new Image(getClass().getResourceAsStream("blue.png"));
											}else {
												lb_comfort = new Label("혼잡");
												image = new Image(getClass().getResourceAsStream("red.png"));
											}
											lb_comfort.setGraphic(new ImageView(image));
											result_gridPane4.add(lb_time,  6, 7,1,1);
											result_gridPane4.add(lb_comfort,  6, 8,1,1);
										}else {
											result_gridPane4.add(lb_tr,  5, 3,1,1);
											result_gridPane4.add(lb_tr2,  7, 3,1,1);
											lb_trst = new Label(hwanseong1);
											lb_trst2 = new Label(hwanseong2);
											result_gridPane4.add(lb_trst,  5, 4,1,1);
											result_gridPane4.add(lb_trst2,  7, 4,1,1);
											Label lb_time = new Label(path.totalTime.get(index4).get(path.totalTime.get(index4).size()-1).toString());
											if((path.totalCongestion.get(index4).get(0)+path.totalCongestion.get(index4).get(1)+path.totalCongestion.get(index4).get(2))/3<=34){
													lb_comfort = new Label("원활");
													image = new Image(getClass().getResourceAsStream("green.png"));
												}else if((path.totalCongestion.get(index4).get(0)+path.totalCongestion.get(index4).get(1)+path.totalCongestion.get(index4).get(2))/3<=70){
													lb_comfort = new Label("보통");
													image = new Image(getClass().getResourceAsStream("blue.png"));
												}else {
													lb_comfort = new Label("혼잡");
													image = new Image(getClass().getResourceAsStream("red.png"));
												}
											lb_comfort.setGraphic(new ImageView(image));
											result_gridPane4.add(lb_time,  6, 7,1,1);
											result_gridPane4.add(lb_comfort,  6, 8,1,1);
										}
										result_gridPane4.add(btn_Go, 2, 1,1,1);
										Label lb_ln = new Label(btn_ln.getText());
										Label lb_ln2=new Label(btn_ln2.getText()); 
										Label lb_st=new Label(tf_station.getText());
										Label lb_st2=new Label(tf_station2.getText());
										result_gridPane4.add(lb_ln, 3, 3, 1, 1);
										result_gridPane4.add(lb_ln2, 10, 3, 1, 1);
										result_gridPane4.add(lb_st, 3, 4, 1, 1);
										result_gridPane4.add(lb_st2, 10, 4, 1, 1);
										result_gridPane4.add(combo,1,1,1,1);
										combo.setValue("Path 4");
										
										result_stage4.show();
										}
									}///
									
									else if(combo.getValue().equals("Path 5")) {
										if(index5==999) {
											Alert alert = new Alert(AlertType.INFORMATION);
											alert.setTitle("조건에 부합하지 않은 경로입니다.");
											alert.setHeaderText("조건에 부합하지 않은 경로입니다.");
											alert.setContentText("조건설정을 다시하거나 다른 경로를 선택해주십시오.");

											alert.showAndWait();
										}else {
										GridPane result_gridPane5 = new GridPane();
										Label lb_tr = new Label("환승역");
										Label lb_tr2 = new Label("환승역");
										Label lb_trst = new Label();
										Label lb_trst2 = new Label();

										Label lb_ltime = new Label("시간 : ");
										Label lb_lcomfort = new Label("혼잡도 :");
										result_gridPane5.add(lb_ltime,  5, 7,1,1);
										result_gridPane5.add(lb_lcomfort,  5, 8,1,1);
										
										result_gridPane5.setHgap(20);
										result_gridPane5.setVgap(20);
										
									result_stage5.setScene(new Scene(result_gridPane5, 700, 350));
										
										int count=0;
										String hwanseong1=null;
										String hwanseong2=null;
										for(int i=1; i<path.path.totalPath.get(index5).size()-1;i++) {
											if(count==0&&path.path.totalPath.get(index5).get(i).name.equals(path.path.totalPath.get(index5).get(i+1).name)) {
												count ++;
												hwanseong1 = path.path.totalPath.get(index5).get(i).name;
											}
											else if(count==1&&path.path.totalPath.get(index5).get(i).name.equals(path.path.totalPath.get(index5).get(i+1).name)) {
												count ++;
												hwanseong2 = path.path.totalPath.get(index5).get(i).name;
											}
										}
										
										Label lb_comfort; Image image;
										
										if(count==1) {
											result_gridPane5.add(lb_tr,  6, 3,1,1);
											lb_trst = new Label(hwanseong1);
											result_gridPane5.add(lb_trst,  6, 4,1,1);	
											Label lb_time = new Label(path.totalTime.get(index5).get(path.totalTime.get(index5).size()-1).toString());
											if((path.totalCongestion.get(index5).get(0)+path.totalCongestion.get(index5).get(1))/2<=34){
												lb_comfort = new Label("원활");
												image = new Image(getClass().getResourceAsStream("green.png"));
											}else if((path.totalCongestion.get(index5).get(0)+path.totalCongestion.get(index5).get(1))/2<=70){
												lb_comfort = new Label("보통");
												image = new Image(getClass().getResourceAsStream("blue.png"));
											}else {
												lb_comfort = new Label("혼잡");
												image = new Image(getClass().getResourceAsStream("red.png"));
											}
											lb_comfort.setGraphic(new ImageView(image));
											result_gridPane5.add(lb_time,  6, 7,1,1);
											result_gridPane5.add(lb_comfort,  6, 8,1,1);
										}else {
											result_gridPane5.add(lb_tr,  5, 3,1,1);
											result_gridPane5.add(lb_tr2,  7, 3,1,1);
											lb_trst = new Label(hwanseong1);
											lb_trst2 = new Label(hwanseong2);
											result_gridPane5.add(lb_trst,  5, 4,1,1);
											result_gridPane5.add(lb_trst2,  7, 4,1,1);
											Label lb_time = new Label(path.totalTime.get(index5).get(path.totalTime.get(index5).size()-1).toString());
											if((path.totalCongestion.get(index5).get(0)+path.totalCongestion.get(index5).get(1)+path.totalCongestion.get(index5).get(2))/3<=34){
													lb_comfort = new Label("원활");
													image = new Image(getClass().getResourceAsStream("green.png"));
												}else if((path.totalCongestion.get(index5).get(0)+path.totalCongestion.get(index5).get(1)+path.totalCongestion.get(index5).get(2))/3<=70){
													lb_comfort = new Label("보통");
													image = new Image(getClass().getResourceAsStream("blue.png"));
												}else {
													lb_comfort = new Label("혼잡");
													image = new Image(getClass().getResourceAsStream("red.png"));
												}
											lb_comfort.setGraphic(new ImageView(image));
											result_gridPane5.add(lb_time,  6, 7,1,1);
											result_gridPane5.add(lb_comfort,  6, 8,1,1);
										}
										result_gridPane5.add(btn_Go, 2, 1,1,1);
										Label lb_ln = new Label(btn_ln.getText());
										Label lb_ln2=new Label(btn_ln2.getText()); 
										Label lb_st=new Label(tf_station.getText());
										Label lb_st2=new Label(tf_station2.getText());
										result_gridPane5.add(lb_ln, 3, 3, 1, 1);
										result_gridPane5.add(lb_ln2, 10, 3, 1, 1);
										result_gridPane5.add(lb_st, 3, 4, 1, 1);
										result_gridPane5.add(lb_st2, 10, 4, 1, 1);
										result_gridPane5.add(combo,1,1,1,1);
										combo.setValue("Path 5");
										
										result_stage5.show();
										}
									}///
								}
							});
					

						
					}
					
			///////////////////////////////////////////////////////////////////////////////////
					
					else if(ckb_comport.isSelected()!=true && ckb_fast.isSelected()==true) {
						combo.getItems().add("Fastest");
						combo.setValue("Fastest");
					result_gridPane.add(combo, 1, 1, 1, 1);
					
					Label lb_tr = new Label("환승역");
					Label lb_tr2 = new Label("환승역");
					Label lb_trst = new Label();
					Label lb_trst2 = new Label();

					Label lb_ltime = new Label("시간 : ");
					Label lb_lcomfort = new Label("혼잡도 :");
					result_gridPane.add(lb_ltime,  5, 7,1,1);
					result_gridPane.add(lb_lcomfort,  5, 8,1,1);
					

					
					result_stage.setScene(new Scene(result_gridPane, 700, 350));
					
				int temp=999;
				int index = 0;
					for(int i = 0; i<(path.totalTime.size());i++) {
						if(path.totalTime.get(i).get(path.totalTime.get(i).size()-1)<=temp) {
							temp = path.totalTime.get(i).get(path.totalTime.get(i).size()-1);
							index = i;
						}
					}
					
					int count=0;
					String hwanseong1=null;
					String hwanseong2=null;
					for(int i=1; i<path.path.totalPath.get(index).size()-1;i++) {
						if(count==0&&path.path.totalPath.get(index).get(i).name.equals(path.path.totalPath.get(index).get(i+1).name)) {
							count ++;
							hwanseong1 = path.path.totalPath.get(index).get(i).name;
						}
						else if(count==1&&path.path.totalPath.get(index).get(i).name.equals(path.path.totalPath.get(index).get(i+1).name)) {
							count ++;
							hwanseong2 = path.path.totalPath.get(index).get(i).name;
						}
					}
					
					Label lb_comfort; Image image;
					
					if(count==1) {
						result_gridPane.add(lb_tr,  6, 3,1,1);
						lb_trst = new Label(hwanseong1);
						result_gridPane.add(lb_trst,  6, 4,1,1);	
						Label lb_time = new Label(path.totalTime.get(index).get(path.totalTime.get(index).size()-1).toString());
						if((path.totalCongestion.get(index).get(0)+path.totalCongestion.get(index).get(1))/2<=34){
							lb_comfort = new Label("원활");
							image = new Image(getClass().getResourceAsStream("green.png"));
						}else if((path.totalCongestion.get(index).get(0)+path.totalCongestion.get(index).get(1))/2<=70){
							lb_comfort = new Label("보통");
							image = new Image(getClass().getResourceAsStream("blue.png"));
						}else {
							lb_comfort = new Label("혼잡");
							image = new Image(getClass().getResourceAsStream("red.png"));
						}
						lb_comfort.setGraphic(new ImageView(image));
						result_gridPane.add(lb_time,  6, 7,1,1);
						result_gridPane.add(lb_comfort,  6, 8,1,1);
					}else {
						result_gridPane.add(lb_tr,  5, 3,1,1);
						result_gridPane.add(lb_tr2,  7, 3,1,1);
						lb_trst = new Label(hwanseong1);
						lb_trst2 = new Label(hwanseong2);
						result_gridPane.add(lb_trst,  5, 4,1,1);
						result_gridPane.add(lb_trst2,  7, 4,1,1);
						Label lb_time = new Label(path.totalTime.get(index).get(path.totalTime.get(index).size()-1).toString());
						if((path.totalCongestion.get(index).get(0)+path.totalCongestion.get(index).get(1)+path.totalCongestion.get(index).get(2))/3<=34){
								lb_comfort = new Label("원활");
								image = new Image(getClass().getResourceAsStream("green.png"));
							}else if((path.totalCongestion.get(index).get(0)+path.totalCongestion.get(index).get(1)+path.totalCongestion.get(index).get(2))/3<=70){
								lb_comfort = new Label("보통");
								image = new Image(getClass().getResourceAsStream("blue.png"));
							}else {
								lb_comfort = new Label("혼잡");
								image = new Image(getClass().getResourceAsStream("red.png"));
							}
						lb_comfort.setGraphic(new ImageView(image));
						result_gridPane.add(lb_time,  6, 7,1,1);
						result_gridPane.add(lb_comfort,  6, 8,1,1);
					}
					result_stage.show();
					}else {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("체크박스 선택 오류");
						alert.setHeaderText("체크박스 선택 오류");
						alert.setContentText("체크박스를 꼭 하나만 선택해주십시오.");

						alert.showAndWait();
					}

			//////////////////////////////////////////////////////////////////////////////////////

					
					
					
				}
				else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("역정보 오류");
					alert.setHeaderText("역 및 호선 정보 오류");
					alert.setContentText("올바른 호선과 역을 입력했는지 다시 한 번 확인해주세요.");

					alert.showAndWait();
				}
				
				
					}

			
		});
		
		
		
		

		// 메인 pane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(10);
		gridPane.setVgap(20);
		gridPane.add(ckb_comport, 0, 0, 1, 1);
		gridPane.add(ckb_fast, 1, 0, 1, 1);
		gridPane.add(tf_time, 2, 0, 1, 1);

		gridPane.add(lb_src, 0, 1, 1, 1);
		gridPane.add(btn_ln, 1, 1, 1, 1);
		gridPane.add(tf_station, 2, 1, 1, 1);

		gridPane.add(lb_dest, 0, 2, 1, 1);
		gridPane.add(btn_ln2, 1, 2, 1, 1);
		gridPane.add(tf_station2, 2, 2, 1, 1);

		gridPane.add(btn_search, 1, 4, 1, 1);
		gridPane.add(btn_cancle, 2, 4, 1, 1);
		gridPane.add(lb_made, 2, 5, 1, 1);

		// 창설정
		stage.setScene(new Scene(gridPane, 300, 230));
		stage.show();

	}

}

/*
 * 
 * import java.util.ArrayList;
 * 
 * public class main { public static void main(String[] args) {
 * 
 * String ss= "1호선/서울역/7호선/상도"; // 출발호선/출발역/도착호선/도착역 형식 지켜주세요
 * 
 * AnalysisPath path = new AnalysisPath(ss); // AnalysisPath만 부르면 경로탐색부터 계산까지
 * 다해줍니다. constructor가 다해 줘여 int cnt = 0;
 * 
 * 
 * for(ArrayList<Integer> timeArr : path.totalTime) { System.out.print(cnt++ +
 * "th path time"); for(Integer time : timeArr) { System.out.print(" "+ time); }
 * System.out.println(" "); } cnt = 0;
 * System.out.println(path.totalCongestion.size()); for(ArrayList<Float>
 * congestionArr : path.totalCongestion) { System.out.print(cnt++ +
 * "th path congestion"); for(Float congestion : congestionArr) {
 * System.out.print(" " + congestion); } System.out.println(" "); } }
 * 
 * }
 */
// 저장확인용
