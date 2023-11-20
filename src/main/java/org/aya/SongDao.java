package org.aya;
import org.springframework.beans.factory.annotation.Value;
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

    try(Connection con = DriverManager.getConnection(url,username,password)) {

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

    public void insertSong(String songName, String singerName){
        try{
            Class.forName(driver);

            try(Connection con = DriverManager.getConnection(url,username,password)) {

                try(Statement stmt = con.createStatement()) {

                    stmt.executeUpdate("insert into songs (song_name, singer_name) values( '"+songName+"', '"+singerName+"')" );
                           // stmt.executeUpdate("insert into songs (song_id, song_name, singer_name) values (" + songId + ", 'Laytak ma3na', 'Maher zein')");

                }
            }
        }catch (ClassNotFoundException e1){
            System.err.println("Driver not loaded");
            e1.printStackTrace();
        }catch ( SQLException e2){
            System.err.println("There is an error in getting the connection");
            e2.printStackTrace();
        }
    }

    public  void deleteSongById(Integer songId){

        try{
            Class.forName(driver);

        try(Connection con = DriverManager.getConnection(url,username,password)) {

            try(Statement stmt = con.createStatement()) {

                stmt.executeUpdate("delete from songs where song_id = "+songId);
            }
        }
        }catch (ClassNotFoundException e1){
            System.err.println("Driver not loaded");
            e1.printStackTrace();
        }catch ( SQLException e2){
            System.err.println("There is an error in getting the connection");
            e2.printStackTrace();
        }

        }



    }




