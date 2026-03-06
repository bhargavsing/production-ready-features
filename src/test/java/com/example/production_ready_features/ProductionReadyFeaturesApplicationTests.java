package com.example.production_ready_features;

import com.example.production_ready_features.advice.ApiResponse;
import com.example.production_ready_features.clients.EmployeeClient;
import com.example.production_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductionReadyFeaturesApplicationTests {

    @Autowired
    private EmployeeClient employeeClient;

    @Test
    @Order(2)
    void getAllEmployee(){
      ApiResponse<List<EmployeeDTO>> employeeDTOList= employeeClient.getAllEmployee();

        System.out.println(employeeDTOList);
    }

    @Test
    @Order(1)
    void getEmployeeById(){
        EmployeeDTO employeeDTO=employeeClient.getEmplyeeById(10L);

        System.out.println(employeeDTO);
    }
}
