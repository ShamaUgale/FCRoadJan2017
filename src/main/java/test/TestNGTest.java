package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.Utils.FileUtils;
import com.flipkart.Utils.Xls_Reader;

public class TestNGTest {

	
	
	
	@Test(dataProvider="data")
	public void sampleDataFromExlTest(String uname, String pwd){
		System.out.println("username : "+ uname);
		System.out.println("Password : "+ pwd);
		System.out.println("");
		
		
		
	}
	
	
	
	@DataProvider
	public Object[][] data(){
		String projectpath= System.getProperty("user.dir");
		
		return FileUtils.getData(projectpath+"\\src\\main\\java\\test\\test.xlsx", "login");
		
		
		
	}

}
