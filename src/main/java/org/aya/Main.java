package org.aya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

       SongDao songDao = context.getBean("songDao",SongDao.class);
      songDao.selectAllRows();
    }
}