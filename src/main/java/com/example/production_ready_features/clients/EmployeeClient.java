package com.example.production_ready_features.clients;

import com.example.production_ready_features.advice.ApiResponse;
import com.example.production_ready_features.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {
   ApiResponse<List<EmployeeDTO>> getAllEmployee();
   EmployeeDTO getEmplyeeById(Long employeeId);
   EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
