package main.java;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        /*
        "jdbc:mysql://localhost:3306/jdbc_db"
        jdbc 프로토콜 사용하는 DBMS :// 서버주소: 포트번호 (Mysql 의 기본 포트번호는 3306/DB 이름
        */
        final String URL = "jdbc:mysql://localhost:3306/jdbc_db";
        String user = "root";
        String password = "root";

        Connection conn = null; //DB연결객체
        Statement stmt = null; //DB 실행객체
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, user, password);
            System.out.println("DB연결성공!!");

            //DB - Read
            String sql = "select * from member";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id + "|" +name+"|"+email);

            }
            //DB -

           //conn.close();

        } catch (Exception e) {
            System.out.println("DB연결 실패!");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && stmt !=null && rs !=null) {
                    conn.close();
                    stmt.close();
                    rs.close();
                    System.out.println("DB 연결 종료!!!");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}