package com.test;

import com.excel.utility.Xls_Reader;

public class RowCount {

	public static void main(String[] args) {
	Xls_Reader reader = new Xls_Reader("C:\\workspace\\dataDriven_firstProject\\src\\com\\data\\openSourcedata.xlsx");
		
		int rowCount =reader.getRowCount("info");
		
		
		System.out.println(rowCount);

	}

}
