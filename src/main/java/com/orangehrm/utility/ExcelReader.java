package com.orangehrm.utility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelReader {
    String[][] sheetData = null;
    String[][] array2 = null;
    String[][] filterValue = null;

    public String[][] getDataFromSheet(String excelFile, String testCaseName) throws IOException {
        String dataSheet = System.getProperty("user.dir") + excelFile;
        FileInputStream fileInputStream = new FileInputStream(dataSheet);

        XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
        XSSFSheet workSheet = workBook.getSheetAt(0);

        FormulaEvaluator formulaEvaluator = workBook.getCreationHelper().createFormulaEvaluator();

        int numberOfRow = workSheet.getPhysicalNumberOfRows();
        XSSFRow rows = workSheet.getRow(0);
        int numberOfCol = rows.getLastCellNum();

        sheetData = new String[numberOfRow][numberOfCol];

        for (int readRow = 0; readRow < numberOfRow; readRow++) {
            for (int readCol = 0; readCol < numberOfCol; readCol++) {
                XSSFRow rowNum = workSheet.getRow(readRow);
                XSSFCell currCell = rowNum.getCell((short) readCol);

                switch (formulaEvaluator.evaluate(currCell).getCellType()) {
                    case NUMERIC:
                    case STRING:
                    case BLANK:
                    case BOOLEAN:
                        sheetData[readRow][readCol] = (new DataFormatter().formatCellValue(currCell));
                        break;
                }
            }
        }

        List<String[]> l = new ArrayList<String[]>(Arrays.asList(sheetData));
        l.remove(0);

        array2 = l.toArray(new String[][]{});
        int countFilter = 0;

        for (int row = 0; row < array2.length; row++) {
            if (array2[row][0].equals(testCaseName)) {
                countFilter++;
            }
        }

        filterValue = new String[countFilter][numberOfCol - 1];

        int finalFilterRow = 0;
        boolean filterValueFound = false;

        for (int row = 0; row < array2.length; row++) {
            for (int col = 1; col < array2[row].length; col++) {
                if (array2[row][0].equals(testCaseName)) {
                    filterValue[finalFilterRow][col - 1] = array2[row][col];
                    filterValueFound = true;
                }
            }
            if (filterValueFound) {
                finalFilterRow++;
            }
        }
        workBook.close();
        return filterValue;
    }
}
