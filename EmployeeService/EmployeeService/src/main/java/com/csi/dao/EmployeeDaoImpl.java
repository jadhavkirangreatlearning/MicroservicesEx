package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import com.csi.vo.Department;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    @Autowired
    DepartmentFeignClientAPI departmentFeignClientAPI;

    public Employee signUp(Employee employee){
        return employeeRepositoryImpl.save(employee);
    }

    public RestTemplateVO getDataById(long empId){

        RestTemplateVO restTemplateVO = new RestTemplateVO();

        Employee employee = employeeRepositoryImpl.findByEmpId(empId);

        Department department = departmentFeignClientAPI.getDepartmentById(employee.getDeptId());
        restTemplateVO.setEmployee(employee);

        restTemplateVO.setDepartment(department);

        return restTemplateVO;
    }

    public List<Employee> getDataByName(String empName){
        return employeeRepositoryImpl.findByEmpName(empName);
    }

    public List<Employee> getAllData(){
        return employeeRepositoryImpl.findAll();
    }

    public boolean signIn(String empEmailId, String empPassword){
        boolean flag = false;

        for(Employee employee: getAllData()){
            if(employee.getEmpEmailId().equals(empEmailId)
            && employee.getEmpPassword().equals(empPassword)){
                flag= true;
                break;
            }
        }

        return flag;
    }

    public Employee updateData(Employee employee){
        return employeeRepositoryImpl.save(employee);
    }

    public void deleteDataById(long empId){
        employeeRepositoryImpl.deleteById(empId);
    }
}
