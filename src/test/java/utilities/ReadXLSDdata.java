package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSDdata {
	@SuppressWarnings("resource")
	public ArrayList<String> ReadFromXlsSheet(String filename, String sheetname) throws IOException {
		ArrayList<String> cellStr= new ArrayList<String> ();
		FileInputStream fileIn = new FileInputStream(filename);
		Workbook workbook = new XSSFWorkbook(fileIn);
		Sheet sheet = workbook.getSheet(sheetname);

		int totalrow = sheet.getLastRowNum();
		Row rowCells = sheet.getRow(0);
		int totalcell = rowCells.getLastCellNum();
		
		DataFormatter formate = new DataFormatter();
		for (int r = 1; r <= totalrow; r++) {
			for (int c = 0; c < totalcell; c++) {
				cellStr.add(formate.formatCellValue(sheet.getRow(r).getCell(c)));
			}
		}
		return cellStr;
	}
}
