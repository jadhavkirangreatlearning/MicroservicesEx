package com.csi.dao;

import com.csi.model.Department;
import com.csi.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentDaoImpl {

    @Autowired
    DepartmentRepository departmentRepositoryImpl;


    public Department saveData(Department department) {
        return departmentRepositoryImpl.save(department);
    }

    public Optional<Department> getDataById(long deptId) {
        return departmentRepositoryImpl.findById(deptId);
    }

    public List<Department> getAllData() {
        return departmentRepositoryImpl.findAll();
    }

    public Department updateData(Department department) {
        return departmentRepositoryImpl.save(department);
    }

    public void deleteDataById(long deptId) {
        departmentRepositoryImpl.deleteById(deptId);
    }
}
