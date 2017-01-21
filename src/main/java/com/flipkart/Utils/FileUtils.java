package com.flipkart.Utils;

public class FileUtils {

	
	public static Object[][] getData(String filePath , String SheetName){
		Xls_Reader xls= new Xls_Reader(filePath);

		
		int rows = xls.getRowCount(SheetName);
		int cols = 	xls.getColumnCount(SheetName);
		
		Object[][] data= new Object[rows-1][cols];
		for(int i=0;i<rows-1;i++){//16
			for(int j=0;j<cols;j++){
			data[i][j]=	xls.getCellData(SheetName, j, i+2);
			}
		}
		
		return data;
	}
	
}
