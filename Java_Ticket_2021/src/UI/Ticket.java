package UI;

import SQL.sqloperation;
import java.util.*;
import java.sql.*;

public class Ticket {
    String SID;
    String ID;
    SQL.sqloperation db;

    Ticket(){
        db = new sqloperation();
    }

    /**
     * 检票
     * @return
     */
    public String[] check(){
        String sql = "select * from Sale where SID='" + getSID() + "' and ID='" + getID() + "';";
        String[] data = db.Check(sql);
        return data;
    }

    /**
     * 入场
     * @return
     */
    public boolean enter(){
        String sql = "update Sale set EStatus='1' where SID='" + getSID() + "' and ID='" + getID() + "';";
        return db.update(sql);
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSID() {
        return SID;
    }

    public String getID() {
        return ID;
    }
}
