package com.Fly365.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public String[][] retrieveMyData(String filePath , String sheetName) throws IOException{
		File excel = new File(filePath);
		FileInputStream fileSt = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fileSt);
		 //org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(fileSt);
		 //org.apache.poi.ss.usermodel.Sheet gotSheet = wb.getSheetAt(0);

		 XSSFSheet gotSheet = wb.getSheet(sheetName);
		int rowNum = gotSheet.getLastRowNum() ;
		int colNum = gotSheet.getRow(0).getLastCellNum();
		System.out.println("rowNum : "+rowNum);
		String data [][]= new String[rowNum ][colNum];
		
		for(int i = 0 ; i<rowNum ; i++){
			Row row = gotSheet.getRow(i + 1);
			for(int j = 0 ; j<colNum ; j++){
				Cell cell = row.getCell(j);
				//cell.setCellType(Cell.CELL_TYPE_STRING);
				DataFormatter dataFormatter = new DataFormatter();
				//String value = new String();
				String value = dataFormatter.formatCellValue(cell);
				//value=cell.toString();
				data [i][j] = value;
				wb.close();
			}
		}
		return data;
		
	}
}
