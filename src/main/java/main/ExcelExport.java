package main;
 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * A very simple program that writes some data to an Excel file
 * using the Apache POI library.
 * @author www.codejava.net
 *
 */
public class ExcelExport {
 
    public static void createExcel(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Class Seating Plan");
         
        Object[][] bookData = {
                {"","1","2","3","4","5","6"},
                {"Row 1", SeatingPlan.names[0][0], SeatingPlan.names[0][1],SeatingPlan.names[0][2], SeatingPlan.names[0][3],SeatingPlan.names[0][4],SeatingPlan.names[0][5]},
                {"Row 2", SeatingPlan.names[1][0], SeatingPlan.names[1][1],SeatingPlan.names[1][2], SeatingPlan.names[1][3],SeatingPlan.names[1][4],SeatingPlan.names[1][5]},
                {"Row 3", SeatingPlan.names[2][0], SeatingPlan.names[2][1], SeatingPlan.names[2][2],SeatingPlan.names[2][3],SeatingPlan.names[2][4],SeatingPlan.names[2][5]},
                {"Row 4", SeatingPlan.names[3][0], SeatingPlan.names[3][1], SeatingPlan.names[3][2],SeatingPlan.names[3][3],SeatingPlan.names[3][4],SeatingPlan.names[3][5]},                
        };
 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 0;
             
            for (Object field : aBook) {
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