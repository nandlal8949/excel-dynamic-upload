package com.csm.utils;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * By Nandlal git(nandlal8949)
 */
@Service
public class ExcelUtils {
	
	public List<List<String>> getAllDetails(MultipartFile importFile) {
		List<List<String>> outerList = new ArrayList<>();
		InputStream inputStream;
		try {
			inputStream = importFile.getInputStream();
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			
			Iterator<Row> iterator = firstSheet.iterator();
			while (iterator.hasNext()) {
				Row next = iterator.next();
				Iterator<Cell> cellIterator = next.cellIterator();
				List<String> strList = new ArrayList<>();
				while (cellIterator.hasNext()) {
					Cell next2 = cellIterator.next();
					CellType cellType = next2.getCellType();
					if(cellType == cellType.NUMERIC) {
						DecimalFormat formatter = new DecimalFormat("###.#####");  
						String f = formatter.format(next2.getNumericCellValue());
						strList.add(f);
					}else {
						strList.add(next2.getStringCellValue());
					}
					
				}
				outerList.add(strList);
			}

		} catch (Exception e) {
			
		}
		return outerList;
		
	}
	
}
