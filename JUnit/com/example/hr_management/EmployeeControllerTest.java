package com.example.hr_management;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeControllerTest {

    @Test
    void yearlysalary() {
        EmployeeController a =new EmployeeController();
        assertEquals(a.yearlysalary(8000.00),96000);
    }
}