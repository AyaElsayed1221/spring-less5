package org.aya;
import lombok.Setter;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Setter
public class SongDao {
    //@Value("${database.driver}")
    private String driver;

    //@Value("${database.url}")
    private String url;

    //@Value("${database.username}")
    private String username;

    //@Value("${database.password}")
    private String password;

    private Connection con;

    /** Init method:
     *  The method createSongDBConnection() is not invoked in any place
     *Here, the createSongDBConnection() method is the init method fo us.
     * annotated the method with @PostConstruct to use it as an init method.
     * We don't want to call our init metho, the Spring framwork will call it for us.
     * We cn give our init method a name as anything we may say it init or createSongDB or xyz
     *Why Init method ??
     * 1. You can add custom code / logic during bean initialization
     * It can be used for setting up resources like DB/Socked/file etc.
     **/

    //Ths is a good coding
    //@PostConstruct
    public void init(){
        System.out.println("init method is invoked");
        createSongDBConnection();
    }

    public void createSongDBConnection(){
        try{
            /*
             * I have a question ?:
             * What is the diff between Class.forName(driver) and adding the dependency of mysql in the pom.xml.
             * why i get an error when i remove the dependency from pom.xml  ?!
             */
            //load driver
            Class.forName(driver);

             con = DriverManager.getConnection(url,username,password);

        }catch (ClassNotFoundException e){
            System.err.println("Failed to load the DATABASE DRIVER");
            e.printStackTrace();
        }catch (SQLException e){
            System.err.println("There is an error in getting the connection");
            e.printStackTrace();
        }
    }

/**
 * Destroy method:
 * Before Spring remove SongDao bean from the container, it will call this method.
 *
 **/
//@PreDestroy
public void destroy(){
    System.out.println("Destroy method is invoked");
    closeSongDBConnection();
}

    public void closeSongDBConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
}
    public void selectAllRows()  {

        try(Statement stmt = con.createStatement()) {

            try( ResultSet resultSet = stmt.executeQuery("select * from songs")){
               while(resultSet.next()){
                   System.out.println(resultSet.getInt("song_id"));
                   System.out.println(resultSet.getString("song_name"));
                   System.out.println(resultSet.getString("singer_name"));
                }
            }
     }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertSong(String songName, String singerName){

        try(Statement stmt = con.createStatement()) {
            stmt.executeUpdate("insert into songs (song_name, singer_name) values( '"+songName+"', '"+singerName+"')" );
        }catch ( SQLException e){
            System.err.println("There is an error in getting the connection");
            e.printStackTrace();
        }
    }

    public  void deleteSongById(Integer songId){

    try(Statement stmt = con.createStatement()) {
        stmt.executeUpdate("delete from songs where song_id = "+songId);
    }catch ( SQLException e){
            System.err.println("There is an error in getting the connection");
            e.printStackTrace();
        }
        }
    }




