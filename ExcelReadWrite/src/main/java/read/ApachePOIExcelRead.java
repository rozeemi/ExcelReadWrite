package read;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ApachePOIExcelRead {

    private static final String FILE_NAME = "tmp/MyFirstExcel5.xls";
	

    public static void main(String[] args) {
    	
        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
 
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.cellIterator();
                
                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    
                    CellType cellType = currentCell.getCellType();
                    
                   
                    if(cellType == CellType.STRING) {
                    	System.out.print(currentCell.getStringCellValue()+" | ");
                    } else if(currentCell.getCellType() == CellType.NUMERIC)  {
                    	 
                    	 System.out.print(currentCell.getNumericCellValue() + "\t"); 
                    }
                    
                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}