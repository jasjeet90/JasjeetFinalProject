package utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public Object[][] passdata(String filePath, int sheetIndex) throws IOException {
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(sheetIndex);
		int rowcount = sheet.getLastRowNum();
		int rows = rowcount + 1;
		int cellcount = sheet.getRow(0).getLastCellNum();
		String data[][] = new String[rowcount][cellcount];
		for (int i = 1; i < rowcount + 1; i++) {
			Row r = sheet.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				data[i - 1][j] = r.getCell(j).getStringCellValue();
			}
		}

		return data;

	}
}
