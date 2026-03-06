package com.example.production_ready_features.clients.impl;

import com.example.production_ready_features.advice.ApiError;
import com.example.production_ready_features.advice.ApiResponse;
import com.example.production_ready_features.clients.EmployeeClient;
import com.example.production_ready_features.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;
    @Override
    public ApiResponse<List<EmployeeDTO>> getAllEmployee() {
    try{
     ApiResponse<List<EmployeeDTO>> employeeDTOList= restClient.get()
                .uri("/employees")
                .retrieve()
                .body(new ParameterizedTypeReference<ApiResponse<List<EmployeeDTO>>>() {
                });

        return employeeDTOList;}
    catch (Exception e){
        throw new RuntimeException(e);
    }
    }

    @Override
    public EmployeeDTO getEmplyeeById(Long employeeId) {
        try{
           ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOresponse= restClient.get()
                    .uri("/employees/{employeeId}",employeeId)
                    .retrieve()
                   .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                       System.out.println(new String(res.getBody().readAllBytes()));
                   })
                    .body(new ParameterizedTypeReference<>() {
                    });

            return employeeDTOresponse.getBody().getData();}
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        return null;
    }
}
