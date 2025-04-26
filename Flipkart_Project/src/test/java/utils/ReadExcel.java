package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcel {

	public static  Object[][] readData() throws IOException {
		FileInputStream fis;
		 XSSFCell cell;
		 String[][]inputData=new String[2][1];
		 String fileName=".\\src\\test\\resources\\config\\InputDataFlipkart.xlsx";
		 try {
			 fis=new FileInputStream(fileName);
			 XSSFWorkbook workbook=new XSSFWorkbook(fis);
			 XSSFSheet sheet=workbook.getSheet("input");
			 int rowCount=sheet.getLastRowNum();
			 DataFormatter df=new DataFormatter();
			 for(int rowNo=1;rowNo<=rowCount;rowNo++)
			 {
				 int cellCount=sheet.getRow(rowNo).getLastCellNum();
				 for(int cellNo=0;cellNo<cellCount;cellNo++)
				 {
					cell=sheet.getRow(rowNo).getCell(cellNo);
					inputData[rowNo-1][cellNo]=df.formatCellValue(cell);
				 }
			 }
			 workbook.close();
		 }
		 catch(FileNotFoundException e)
		 {
			 e.printStackTrace();
		 }
		 catch(IOException e1)
		 {
			 e1.printStackTrace();
		 }
		 return inputData;
	}

}
