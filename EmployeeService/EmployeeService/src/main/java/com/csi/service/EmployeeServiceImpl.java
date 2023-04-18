package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee signUp(Employee employee){
        return employeeDaoImpl.signUp(employee);
    }

    public RestTemplateVO getDataById(long empId){


        return employeeDaoImpl.getDataById(empId);
    }

    public List<Employee> getDataByName(String empName){
        return employeeDaoImpl.getDataByName(empName);
    }

    public List<Employee> getAllData(){
        return employeeDaoImpl.getAllData();
    }

    public boolean signIn(String empEmailId, String empPassword){


        return employeeDaoImpl.signIn(empEmailId, empPassword);
    }

    public Employee updateData(Employee employee){
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteDataById(long empId){
        employeeDaoImpl.deleteDataById(empId);
    }
}
