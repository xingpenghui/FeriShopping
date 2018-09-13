package com.feri.test;

import org.gjt.mm.mysql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2018/8/9 12:09
 */
public class City_Main {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_fm","root","root");
        Statement statement=connection.createStatement();
        String sql1="select co.id coid,cy.id from t_county co left join  t_city cy  on substr(co.no,1,4)=cy.no";
        ResultSet rs=statement.executeQuery(sql1);
        Map<Integer,Integer> ids=new HashMap<>();
        while (rs.next()){
            ids.put(rs.getInt(1),rs.getInt(2));
           // String sql2="update t_county set cityid="+rs.getInt(1)+" where id="+rs.getInt(2);
            //statement.executeUpdate(sql2);
        }
        for(int id:ids.keySet()){
            String sql2="update t_county set cityid="+ids.get(id)+" where id="+id;
            statement.executeUpdate(sql2);
        }
        System.out.println(ids);

    }
}
