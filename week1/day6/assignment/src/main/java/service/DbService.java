package service;

import java.sql.*;

public class DbService {
    private final Connection connection;

    public DbService(Connection connection) {
        this.connection = connection;
    }

    public int createNewAccount(int acNum, double amt, String acHldNm, Date crDt, boolean status) throws SQLException {
        var sql = "insert into bank_account values (?, ?, ?, ?, ?)";
        var ps1 = connection.prepareStatement(sql); // here you are creating sql
        ps1.setInt(1, acNum);
        ps1.setDouble(2, amt);
        ps1.setString(3, acHldNm);
        ps1.setDate(4, crDt);
        ps1.setBoolean(5, status);

        var affected = ps1.executeUpdate();
        connection.commit();

        return affected;
    }
    public void search() throws SQLException{
        String sql="select * from bank_account";
        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            int acNum=rs.getInt("acNum");
            int amt=rs.getInt("amt");
            String name=rs.getString("ac_HldNm");
            Date date=rs.getDate("crDt");
            boolean status=rs.getBoolean("status");
            System.out.println("acNum "+acNum+" "+amt+" "+"name"+name+" "+"date"+date+"status"+status);

        }
        rs.close();

    }
    public void selectWhere(int ac_Num)throws SQLException{
        String sql="select * from bank_account where ac_Num=?";
        PreparedStatement ps=connection.prepareStatement(sql);
//        ps.setInt("ac_Num");
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            int acNum=rs.getInt("acNum");
            int amt=rs.getInt("amt");
            String name=rs.getString("ac_HldNm");
            Date date=rs.getDate("crDt");
            boolean status=rs.getBoolean("status");
            System.out.println("acNum "+acNum+" "+amt+" "+"name"+name+" "+"date"+date+"status"+status);

        }
        rs.close();
    }
    public int update() throws SQLException{
        String sql="update * from bank_account set amt=amt+? where amt=?";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setInt(1,1000);
        ps.setInt(2,2000);
        int expected=ps.executeUpdate();
        return expected;

    }
    public int deposite() throws SQLException {
        String sql = "update * from bank_account set amt=amt+? where amt=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,500);
        ps.setInt(2,300);
        int expected = ps.executeUpdate();
        return expected;
    }

    public int withdraw() throws SQLException {
        String sql = "update * from bank_account set amt=amt+? where amt=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,100);
        ps.setInt(2, 200);
        int expected = ps.executeUpdate();
        return expected;
    }
    public int transferMoney() throws SQLException {
        String str1 = "update * from bank_account set amt=amt+? where amt=?";
        PreparedStatement ps1 = connection.prepareStatement(str1);
        ps1.setInt(1,10000);
        ps1.setInt(2,30000);
        int expected1 = ps1.executeUpdate();
        String str2 = "update * from bank_account set amt=amt+? where amt=?";
        PreparedStatement ps2 = connection.prepareStatement(str2);
        ps2.setInt(1,10000);
        ps2.setInt(2,30000);
        int expected= ps2.executeUpdate();
        return expected;
    }

public void showAllAccounts() throws SQLException {
    String sql = "select * from bank_account ";
    PreparedStatement ps = connection.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
        int id = rs.getInt("acc_num");
        double amt = rs.getDouble("amt_num");
        String nm = rs.getString("acc_hld_nm");
        boolean status = rs.getBoolean("status");

        System.out.println("acc num"+ id+" amount "+amt+" hld name"+nm+" status "+status);

    }
    connection.commit();
    rs.close();
}
public void findByAccountNum(int num) throws SQLException {
    String sql = "select * from bank_account where acc_num = ? ";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1,num);

    ResultSet rs = ps.executeQuery();

    while(rs.next()){

        double amt = rs.getDouble("amt_num");

        System.out.println("amount "+ amt);

    }
    if(rs.next() == false) System.out.println("Invalid Account Number");
    connection.commit();
    rs.close();


}





}
