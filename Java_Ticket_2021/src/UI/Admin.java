package UI;

import SQL.sqloperation;

import javax.swing.table.DefaultTableModel;

public class Admin {
    SQL.sqloperation db;

    Admin(){
        db = new sqloperation();
    }

    public DefaultTableModel GetTicketType(){
        String sql = "select * from Ticket";
        return db.GetType(sql);
    }

    public boolean delete(String Name,double Price){
        String sql = "delete from Ticket where Name='" + Name + "' and Price=" + Price + ";";
        return db.delete(sql);
    }

    public boolean insert(String Name,double Price){
        String sql = "insert into Ticket VALUES('" + Name + "'," + Price +");";
        return db.insert(sql);
    }

    public DefaultTableModel GetRecord(){
        String sql = "select * from Sale";
        return db.GetRecord(sql);
    }

    public DefaultTableModel GetRecord(String Date){
        String sql = "select * from Sale where CDate='" + Date + "'";
        return (db.GetRecord(sql));
    }

    public double[] GetData(String Date){
        String sql = "select * from Sale where CDate='" + Date + "'";
        return (db.GetData(sql));
    }

}
