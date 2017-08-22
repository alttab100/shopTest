package Config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	String[][] excelData = null;

	public Excel() {
	}

	public Excel(String[][] excelData) {
		this.excelData = excelData;
	}

	public String[][] readExcel() {
		String srcPath = System.getProperty("user.dir");
		System.out.println(srcPath);
		String srcFile = "\\RunManager.xlsx";
		String excelFile = srcPath + srcFile;
		

		try {
			File dataFile = new File(excelFile);
			FileInputStream inputFile = new FileInputStream(dataFile);
			XSSFWorkbook wb = new XSSFWorkbook(inputFile);
			XSSFSheet ws = wb.getSheet("Sheet1");
			
			int wsRow = ws.getLastRowNum();
			int wsCol = ws.getRow(0).getPhysicalNumberOfCells();

			excelData = new String[wsRow + 1][wsCol];
			int rowNum = 0;
			Iterator<Row> rowIteartor = ws.iterator();
			while (rowIteartor.hasNext()) {
				int colNum = 0;
				Row row = rowIteartor.next();
				Iterator<Cell> cellIteartor = row.iterator();
				while (cellIteartor.hasNext()) {
					Cell cell = cellIteartor.next();
					String cellValue = cell.getStringCellValue();
					excelData[rowNum][colNum++] = cellValue;
				}
				rowNum++;
			}
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return excelData;
	}

	public String getColValue(String header, String testCaseID) {
		String cellvalue = null;
		int rowNum = -1;
		int colNum = -1;
		try {
			// Loop through Columns in First Row for Header
			for (int i = 0; i < excelData[0].length; i++) {
				if (excelData[0][i].equalsIgnoreCase(header)) {
					colNum = i;
					break;
				}
			}
			// Loop through Rows in First Column for TestCaseID
			for (int j = 0; j < excelData.length; j++) {
				if (excelData[j][0].equalsIgnoreCase(testCaseID)) {
					rowNum = j;
					break;
				}
			}
			cellvalue = excelData[rowNum][colNum];
		} catch (Exception e) {
			System.out.println("Invalid Reference : Header/Test Case ID Not Found");
			System.out.println("Row : " + rowNum + " Column : " + colNum + "Header:"+ header);
			// e.printStackTrace();
		}
		return cellvalue;
	}
}

