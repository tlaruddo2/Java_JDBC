package com.example.jdbc_tutorial;

import java.sql.ResultSet;

public class Main {

    public static void main (String[] args){
        DBConnection connection = new DBConnection();
        String id1 = "admin111";
        String pw1 = "admin1111";
        System.out.println("관리자여부: " + connection.isAdmin(id1,pw1));

    }
}
