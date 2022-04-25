package LMSApiUtilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil{
	 FileInputStream fi;
	 FileOutputStream fo;
	 XSSFWorkbook wb;
	 XSSFSheet ws;
	 XSSFRow row;
	 XSSFCell cell;
	 Set<String> loginData;
	 String userfileName="./src/test/resources/LMSLoad/LMSLoad.xlsx";
	 String wsName;
	 
	 int Rcount;
	 int Ccount;
	 

	// Read Data from excel file and convert into List
	public List<List<String>> readUserData(String sheetName) throws IOException {
		wsName=sheetName;
		DataFormatter df=new DataFormatter();
		wb = new XSSFWorkbook(userfileName);
		ws=wb.getSheet(wsName);
		//System.out.println(sheetName);
		
		int rc =ws.getPhysicalNumberOfRows();
		row = ws.getRow(0);
		int cc =row.getLastCellNum();
		
		List<List<String>>  rowList= new ArrayList<List<String>>();
		List<String> colList=null;
	
		
		for (int i=1;i<rc;i++) {
			row=ws.getRow(i);
			colList=new ArrayList<String>();
			for (int j=0;j<cc;j++) {
				
				
				String val=df.formatCellValue(row.getCell(j));
				//jobsTD[i-1][j]=val;
				colList.add(val);
			}
			rowList.add(colList);
			//System.out.println(colList);
		}	
		wb.close();;
		return rowList;
	}
	

	
}


	/*
	private XSSFWorkbook wb;
	private XSSFSheet ws;
	private XSSFRow  row;
	private XSSFCell cell;
	private String xlsSheetName;
	private String xlPath;
	
	
	// Map<Key,Value> : Map<SheetName, Data> ==> Map<String,ArrayList<ArrayList<String>>>
	private Map<String,ArrayList<ArrayList<String>>> xlcache;
	
	public ExcelUtil(String fpath) {
		System.out.print(fpath);
		//fpath="./src/test/resources/LMSLoad/LMSLoad.xlsx";
		this.xlPath=fpath;
	}

	public String getData(String sName,int r,int c) {
		System.out.print(sName);
		
		if (xlcache.containsKey(sName)) {
			return getDataFromCache(sName,r,c);
		}
		else {
			return getDataFromXlsAfterCache(sName,r,c);
		}
	}

	private String getDataFromCache(String sname,int r,int c) {
		ArrayList<ArrayList<String>> rowList=  xlcache.get(sname);
		ArrayList<String> colList=rowList.get(r);
		return colList.get(c);
	}
	 
	private XSSFWorkbook getWorkBook() {
		if (wb== null) {
			try {
				wb = new XSSFWorkbook(new File(xlPath));
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return wb;
	}
	
	
	private XSSFSheet getSheet(String sName) {
		
		wb=getWorkBook();
		return wb.getSheet(sName);
	}
	
	private ArrayList<ArrayList<String>> getDataFromXl(String sName) {
		ArrayList<ArrayList<String>> rowList=  new ArrayList<ArrayList<String>>();
		ArrayList<String> colList=null;
		ws=getSheet(sName);
		int fRow=ws.getLastRowNum()+1;
		int lRow=ws.getFirstRowNum();
		
		for (int i=fRow;i<=lRow;i++) {
			row=ws.getRow(i);
			colList=new ArrayList<String>();
			colList=getColData(row);
			rowList.add(colList);
		}
		xlcache.put(sName, rowList);
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	return rowList;
	}

	private ArrayList<String> getColData(XSSFRow row) {
		ArrayList<String> colList=new ArrayList<String>();
		int fCol=row.getFirstCellNum();
		int lCol=row.getLastCellNum();
		for (int j=fCol;j<lCol;j++) {
			switch(cell.getCellType()) {
			case NUMERIC:
				colList.add(""+cell.getNumericCellValue());
				break;
			default:
				colList.add(cell.getStringCellValue());
				break;
			}
		}
		return colList;
	}
	
	private String getDataFromXlsAfterCache(String sName,int r,int c) {
		ArrayList<ArrayList<String>> rowList = getDataFromXl(sName);
		ArrayList<String> colList=rowList.get(r);
		return colList.get(c);
	}
	*/
