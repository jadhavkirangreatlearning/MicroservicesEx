package com.csi.dao;

import com.csi.vo.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "DepartmentService", url = "http://localhost:9191")
public interface DepartmentFeignClientAPI {
    @GetMapping(value = "/departments/{deptId}")
    Department getDepartmentById(@PathVariable("deptId") long deptId);

}