package utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    // This method is to open the Excel data file based on the file patch
    public static void loadExcelFile(String sFilePath) throws Exception {
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(sFilePath);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            //ExcelWSheet = ExcelWBook.getSheet(sSheetName);
        } catch (Exception error) {
            throw (error);
        }
    }

    // This method is to get data from data file based on column, row and sheet name
    public static String getCellData(int intRowNo, int intColNum, String sSheetName) throws Exception {
        try {
            ExcelWSheet = ExcelWBook.getSheet(sSheetName);
            Cell = ExcelWSheet.getRow(intRowNo).getCell(intColNum);
            String sCellData = Cell.getStringCellValue();
            return sCellData;
        } catch (Exception error) {
            return "";
        }
    }

    // This method is to get the data count from the data file based on sheet name
    public static int getRowCount(String sSheetName) {
        ExcelWSheet = ExcelWBook.getSheet(sSheetName);
        int number = ExcelWSheet.getLastRowNum() + 1;
        return number;
    }
}