package db;

import java.sql.*;
//如果boolwin 是0的话 就是什么都没通过 1 就是过第一关
public class Sqlserver {
    Connection con;
    Statement sql;
    public Sqlserver() {


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection(dbURL, userName, userPwd);
            this.con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Player;user=sa;password=123456"
            );
            this.sql= con.createStatement();
//            ResultSet rs =sql.executeQuery("SELECT * FROM Class");
//            while (rs.next()) {
//                System.out.print(rs.getString(1));
//                System.out.print(rs.getString(2));
//                System.out.println(rs.getString(3));
//            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean InDb(String name){ //判断是不是在数据库 是就返回true

        try {
            ResultSet rs =sql.executeQuery("SELECT * FROM player");
            while (rs.next()) {

                if (rs.getString(1).replace(" ","").equals(name)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public ResultSet TopTen() {

        try {
            ResultSet rs = sql.executeQuery("use Player select TOP 10 * from player order by score  desc ");
//            while (rs.next()){
//                System.out.println(rs.getString(4));
//            }
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public  void  insertDb(String username,String time, int score,int boolwin){ //插入数据
        try {
            PreparedStatement preparedStatement=con.prepareStatement("insert into player values(?,?,?,?)");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,time);
            preparedStatement.setInt(3,score);
            preparedStatement.setInt(4,boolwin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  ResultSet  getBoolWin(String username){

        try {
            PreparedStatement preparedStatement=con.prepareStatement(" select  max(boolwin) from player where name=?");
            preparedStatement.setString(1,username);
//            preparedStatement.executeUpdate();
            ResultSet rs =preparedStatement.executeQuery();
//            System.out.println(rs.getString(1));
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

        public static void main(String[] args) {
            Sqlserver sqlserver = new Sqlserver();
            String name="dd";
            String time="10";
            int score=1000;
            int boolwin=0;
            ResultSet resultSet=sqlserver.getBoolWin(name);
//            try {
//                while (resultSet.next()){
//                    System.out.println(resultSet.getString(1));
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }//必须加next 让他迭代一下
            try {
                resultSet.next();System.out.println(resultSet.getInt(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //            try {
//                System.out.println(resultSet.getString(1));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
}
