package com.example.jdbc_tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    private Connection con; //
    private Statement st ; // object to run sql statement
    private ResultSet rs;

    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial","root","password");
            st = con.createStatement();
        }
        catch (Exception e){
            System.out.println("Database connection error" + e.getMessage());
        }
    }

    public boolean isAdmin (String adminID, String adminPassword){
        try {
            String SQL = "SELECT * FROM admin WHERE adminID = '" + adminID + "' and adminPassword = '" + adminPassword +"'";
            rs = st.executeQuery(SQL);
            if (rs.next()){
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Error in checking admin: " + e.getMessage());
        }
        return false;
    }

    public ResultSet selectAll(){
        try{
            String SQL = "SELECT * FROM admin";
            rs = st.executeQuery(SQL);
            return rs;
        }catch (Exception e ){
            System.out.println("Error in select all: " + e.getMessage());
        }
        return null;
    }

}
