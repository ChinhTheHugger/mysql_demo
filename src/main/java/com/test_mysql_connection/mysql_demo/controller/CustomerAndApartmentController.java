package com.test_mysql_connection.mysql_demo.controller;


import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import com.test_mysql_connection.mysql_demo.service.CustomerAndApartmentService;

@RestController
@RequestMapping(path = "/customer-and-apartment")
public class CustomerAndApartmentController {
    @Autowired
    private CustomerAndApartmentService cusandapService;

    @PostMapping(path = "/import-to-db")
    public void ImportDataFromExcelToDB(@RequestPart(required = true) List<MultipartFile> files) {
        cusandapService.importToDb(files);
    }
}
