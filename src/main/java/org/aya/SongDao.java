package org.aya;

import com.sun.security.jgss.GSSUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import java.sql.*;

public class SongDao {
    @Value("${database.driver}")
    private String driver;

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    public void selectAllRows()throws ClassNotFoundException, SQLException {

        /*
        * I have a question ?:
        * What is the diff between Class.forName(driver) and adding the dependency of mysql in the pom.xml.
        * why i get an error when i remove the dependency from pom.xml  ?!
        */

   try{
       //load driver
    Class.forName(driver);

    try(Connection con = DriverManager.getConnection(url,username,password);) {

        try(Statement stmt = con.createStatement()) {

            try( ResultSet resultSet = stmt.executeQuery("select * from songs")){

               while(resultSet.next()){
                   System.out.println(resultSet.getInt("song_id"));
                   System.out.println(resultSet.getString("song_name"));
                   System.out.println(resultSet.getString("singer_name"));
                }

             }
            }
        }
     }catch (ClassNotFoundException exception){
       System.err.println("Failed to load the DATABASE DRIVER");
       exception.printStackTrace();
        }
    }

}

