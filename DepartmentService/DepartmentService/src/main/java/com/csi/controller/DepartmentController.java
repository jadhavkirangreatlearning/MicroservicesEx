package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Department;
import com.csi.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentServiceImpl departmentServiceImpl;

    @PostMapping("/")
    public ResponseEntity<Department> saveData(@Valid @RequestBody Department department) {
        return new ResponseEntity<>(departmentServiceImpl.saveData(department), HttpStatus.CREATED);
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<Optional<Department>> getDataById(@PathVariable long deptId) {
        return ResponseEntity.ok(departmentServiceImpl.getDataById(deptId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Department>> getAllData() {
        return ResponseEntity.ok(departmentServiceImpl.getAllData());
    }

    @PutMapping("/{deptId}")
    public ResponseEntity<Department> updateData(@PathVariable long deptId, @RequestBody Department department
    ) {

        Department department1 = departmentServiceImpl.getDataById(deptId).orElseThrow(() -> new RecordNotFoundException("Department Id Does Not Exist"));

        department1.setDeptName(department.getDeptName());
        department1.setDeptCode(department.getDeptCode());
        department1.setDeptStartDate(department.getDeptStartDate());

        return ResponseEntity.ok(departmentServiceImpl.updateData(department1));
    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<String> deleteDataById(@PathVariable long deptId) {
        departmentServiceImpl.deleteDataById(deptId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}
