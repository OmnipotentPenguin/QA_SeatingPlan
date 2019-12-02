package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExport {

	public static void createExcel() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Class Seating Plan");

		int rowLength = SeatingPlan.names[0].length;
		int[] pcNumbers = new int[rowLength + 1];
		Row headerRow = sheet.createRow(0);

		for (int k = 0; k < pcNumbers.length; k++) {
			pcNumbers[k] = k;
			Cell cell = headerRow.createCell(k);
			cell.setCellValue(pcNumbers[k]);
		}

		int rowCount = 0;

		for (String[] seatRow : SeatingPlan.names) {
			Row row = sheet.createRow(++rowCount);
			int columnCount = 0;

			for (Object field : seatRow) {

				Cell firstCell = row.createCell(0);
				firstCell.setCellValue("Row: " + rowCount);

				Cell cell = row.createCell(++columnCount);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

		}

		try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Admin\\Desktop\\SeatingPlan.xlsx")) {
			workbook.write(outputStream);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
	}

}