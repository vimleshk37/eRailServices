package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteXLSDdata {
	@SuppressWarnings("resource")
	public void WriteToXlsSheet(String filename, String sheetname, ArrayList<String> writeData) throws IOException {

		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet(sheetname);
		XSSFRow row;
		@SuppressWarnings("unused")
		XSSFCell cell;
		int rowid = 0;

		for (String cellStr : writeData) {
			row = spreadsheet.createRow(rowid++);
			int cellid = 0;
			cell = row.createCell(cellid);
			//cell.setCellValue(cellStr); //Error is showing not able to solve;
			System.out.println("Vimlesh "+cellStr);
		}
		
		FileOutputStream fileout = new FileOutputStream(filename);
		workbook.write(fileout);
		fileout.flush();
		fileout.close();

	}
}
