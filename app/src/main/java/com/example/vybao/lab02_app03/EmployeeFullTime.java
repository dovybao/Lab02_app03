package com.example.vybao.lab02_app03;

public class EmployeeFullTime extends Employee {
    @Override
    public double TinhLuong() {
        return 500;
    }
    @Override
    public String toString(){
        return super.toString() + "-->FullTime: "+ TinhLuong();
    }
}
