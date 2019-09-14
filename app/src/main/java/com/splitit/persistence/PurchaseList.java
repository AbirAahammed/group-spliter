package com.splitit.persistence;

import com.splitit.domain.Purchase;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PurchaseList {

    DBAccessor dbAccessor;
    static Properties dbProperties = new Properties();
    private static Logger logger = Logger.getLogger(PurchaseList.class);
    public PurchaseList(){
        try{
            dbProperties = loadDBData();
        }catch (IOException ie){
            logger.error("FAILED TO OBTAIN DATABASE PROPERTIES");

        }
        dbAccessor = new DBAccessor(dbProperties.getProperty("db.url"), dbProperties.getProperty("db.user"), dbProperties.getProperty("db.key"));
    }
    public Properties loadDBData()throws IOException {
        Properties dbProperties = new Properties();
        dbProperties.load(new FileInputStream("/Users/abirahammed/Projects/Android Project/SplitIt/app/src/main/res/database.properties"));
        return dbProperties;
    }
    public List <Purchase > getPurchaseList(){
        List <Purchase> purchaseList = new ArrayList<>();
        Connection connection;
        try{
            connection = dbAccessor.getConnection();
            ResultSet rs = dbAccessor.execute(connection,
                    "SELECT purchase_id, purchase_title, price, purchase_date\n" +
                           "FROM purchase_data.purchases;");
            while (rs.next()){
                purchaseList.add( new Purchase(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getDate(4)));
            }
        }catch (SQLException se){
            logger.error(se);
        }
        return purchaseList;
    }

    public Purchase getPurchase(Long id){
        Connection connection;
        try{
            connection = dbAccessor.getConnection();
            ResultSet rs = dbAccessor.execute(connection,
                    String.format("SELECT purchase_id, purchase_title, price, purchase_date\n" +
                            "FROM purchase_data.purchases\n" +
                            "WHERE purchase_id = %d",id));
            rs.next();
            return new Purchase(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getDate(4));
        }catch (SQLException se){
            logger.error(se);
            return null;
        }
    }
}
