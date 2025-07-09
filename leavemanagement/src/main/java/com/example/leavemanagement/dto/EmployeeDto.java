package com.example.leavemanagement.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private String role;

    @Override
    public String toString() {
        return "EmployeeDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", role='" + role + '\'' +
            '}';
    }
}
