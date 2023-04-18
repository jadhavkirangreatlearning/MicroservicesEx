package com.csi.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mysql.cj.conf.PropertyDefinitions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private long deptId;

    private String deptName;

    private String deptCode;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date deptStartDate;
}
