package com.example.professor_allocation_thomas_mobile.model;

import java.util.List;

public class Professor {
    private int id;
    private String name;
    private String cpf;
    private List<Allocation> allocations;
    private Department department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Allocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}