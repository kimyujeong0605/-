package openCSV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CSVRead {

  private String filename = "input//test.csv";

  public CSVRead() {}

  public List<String[]> readCsv() {

    List<String[]> data = new ArrayList<String[]>();

    try {
      // CSVReader reader = new CSVReader(new FileReader(filename), '\t');
      // UTF-8
      CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename),"EUC-KR"));
      String[] s;
      int iteration =0;
      while ((s = reader.readNext()) != null) {
    	  if(iteration == 0) {
    	        iteration++;  
    	        continue;
    	    }
        data.add(s);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }
}