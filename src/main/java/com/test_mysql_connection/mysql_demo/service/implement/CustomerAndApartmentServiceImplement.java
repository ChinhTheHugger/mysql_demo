package com.test_mysql_connection.mysql_demo.service.implement;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;
import com.test_mysql_connection.mysql_demo.entity.CustomerAndApartment;
import com.test_mysql_connection.mysql_demo.repository.CustomerAndApartmentRepository;
import com.test_mysql_connection.mysql_demo.service.CustomerAndApartmentService;

@Service
public class CustomerAndApartmentServiceImplement implements CustomerAndApartmentService {
    @Autowired
    private CustomerAndApartmentRepository cusandapRepository;

    @Override
    public void importToDb(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            List<CustomerAndApartment> CusAndAp = new ArrayList<>();
            multipartfiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workbook = new XSSFWorkbook(multipartfile.getInputStream());
                    XSSFSheet sheet = workbook.getSheetAt(0);
                    for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) - 1; rowIndex++) {
                        XSSFRow row = sheet.getRow(rowIndex);
                        if (rowIndex == 0) {
                            continue;
                        }
                        String customer_id = String.valueOf(row.getCell(0));
                        String customer_name = String.valueOf(row.getCell(1));
                        String customer_phone = String.valueOf(row.getCell(2));
                        String apartment_id = String.valueOf(row.getCell(3));
                        String apartment_name = String.valueOf(row.getCell(4));
                        String apartment_building = String.valueOf(row.getCell(5));
                        String apartment_floor = String.valueOf(row.getCell(6));
                        String apartment_room = String.valueOf(row.getCell(7));
                        CustomerAndApartment cusandap = CustomerAndApartment.builder().customer_id(customer_id).customer_name(customer_name).customer_phone(customer_phone).apartment_id(apartment_id).apartment_name(apartment_name).apartment_building(apartment_building).apartment_floor(apartment_floor).apartment_room(apartment_room).build();
                        CusAndAp.add(cusandap);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
            if (!CusAndAp.isEmpty()) {
                cusandapRepository.saveAll(CusAndAp);
            }
        }
    }

    public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {
		int numOfNonEmptyCells = 0;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {
				XSSFCell cell = row.getCell(columnIndex);
				if (cell != null && cell.getCellType() != CellType.BLANK) {
					numOfNonEmptyCells++;
				}
			}
		}
		return numOfNonEmptyCells;
	}
}
