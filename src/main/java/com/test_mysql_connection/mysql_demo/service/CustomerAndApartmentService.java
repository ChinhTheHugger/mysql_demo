package com.test_mysql_connection.mysql_demo.service;

import java.util.*;
import org.springframework.web.multipart.*;
//need to add dependency for org.springframework.web to use this package

public interface CustomerAndApartmentService {
    void importToDb(List<MultipartFile> multipartfiles);
}
