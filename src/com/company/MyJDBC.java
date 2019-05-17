package com.company;
import java.sql.*;
import java.sql.Connection;


public class MyJDBC {
    private final String url = "jdbc:postgresql://localhost:5432/2019-05-17";
    private final String user = "student";
    private final String password = "C0d3Cr3w";


    public java.sql.Connection connect() {
        java.sql.Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = java.sql.DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public void getAllManufacturingData() { //gets all manufacturing data
        String SQL = "SELECT * "
                + "FROM manufacturers ";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

//            pstmt.setInt(0, actorID);
            ResultSet rs = pstmt.executeQuery();
            displayManufacturingData(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private void displayManufacturingData(ResultSet rs) throws SQLException { //returns manufacturing data
        while (rs.next()) {
            System.out.println(rs.getString("code") + "\t"
                    + rs.getString("name"));

        }
    }

    public void getProductData() { //gets all the products
        String SQL = "SELECT * "
                + "FROM  products";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

//            pstmt.setInt(0, actorID);
            ResultSet rs = pstmt.executeQuery();
            displayProductData(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private void displayProductData(ResultSet rs) throws SQLException { //returns product data
        while (rs.next()) {
            System.out.println(rs.getString("code") + "\t"
                    + rs.getString("name") +"\t" + rs.getString("price")+"\t" + rs.getString("manufacturer"));

        }
    }

    public void maxPriceData() // gets the maximum price of all the data
    {
        String SQL= "SELECT *" + "FROM products order by price desc LIMIT 1";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

//            pstmt.setInt(0, actorID);
            ResultSet rs = pstmt.executeQuery();
            displayProductData(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void allProductsUnder100()
    {
        String SQL ="Select * From products where price<100";
        try(Connection conn =connect())
        {
            PreparedStatement pstmt= connect().prepareStatement(SQL);
            ResultSet rs= pstmt.executeQuery();
            displayProductData(rs);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }



}