/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
            
public class Database {
    private final static String TEST_STAR = "\"GJ 876\"";
    
    public Database (){
    
    }
    public List<Planet> getPlanetOnStar(String star) {
        star = "\"" + star + "\"";
        List<Planet> planets = new ArrayList<>();
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs4420","root","root")) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select name, semi_major_axis, eccentricity from planets where star_name = " + star);
                while(rs.next())
                    planets.add(new Planet(rs.getString(1), rs.getDouble(2), rs.getDouble(3)));
            }  
        }catch(Exception e){ System.out.println(e);}  
        return planets;
    }    
}