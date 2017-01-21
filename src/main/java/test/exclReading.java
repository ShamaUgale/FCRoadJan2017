package test;

import com.flipkart.Utils.Xls_Reader;

public class exclReading {


	public static void main(String[] args) {

		String projectpath= System.getProperty("user.dir");
		
		Xls_Reader xls= new Xls_Reader(projectpath+"\\src\\main\\java\\test\\test.xlsx");
		
		int rows = xls.getRowCount("register");
	int cols = 	xls.getColumnCount("register");
	
	
	Object[][] data= new Object[rows-1][cols];
	System.out.println("Cells data : "+    xls.getCellData("login", 1, 5));
		
	
	for(int i=2;i<=rows;i++){
		for(int j=0;j<cols;j++){
			System.out.println(xls.getCellData("register", j, i));
		}
	}
		
	
	
	
	
	System.out.println("**************************************************");
	
	
	for(int i=0;i<rows-1;i++){//16
		for(int j=0;j<cols;j++){
		data[i][j]=	xls.getCellData("register", j, i+2);
		}
	}
	
	
	System.out.println("********************* fetch from object arry*********************************");
	
	
	

	for(int i=0;i<data.length;i++){
		for(int j=0;j<data[0].length;j++){
			System.out.println(data[i][j]);
		}
	}
		
	
	
	}
	
	
	
	
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
