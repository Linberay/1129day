package cn.edu.guet.main;

import java.sql.PreparedStatement;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @Author liwei
 * @Date 2022/11/29 16:09
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {

        String sql = "SELECT * FROM users";// 用Java去执行这条SQL语句来获取数据
        String url = "jdbc:mysql://localhost:3306/test2?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Connection conn = null;// 表示数据库的连接对象
        PreparedStatement pstmt = null;// 表示SQL语句的对象
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, "root", "123456");
            pstmt = conn.prepareStatement(sql);// 把pstmt和sql语句做一个关联，pstmt就代表上面的sql语句

            rs = pstmt.executeQuery();

            while(rs.next()){
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        JFrame jFrame = new JFrame("主界面");
        jFrame.setSize(1200, 700);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        String head[] = {"id", "用户名", "密码"};
        Object[][] data = new Object[5][3];

        JTable jTable = new JTable(data, head);

        // 滚动面板
        JScrollPane jscrollpane = new JScrollPane();
        jscrollpane.setBounds(0, 0, 1200, 650);
        jscrollpane.setViewportView(jTable);// 把表格添加到滚动面板中
        jTable.setRowHeight(35);// 行高

        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        jTable.setDefaultRenderer(Object.class, r);// 每行内容居中显示

        JPanel jPanel = (JPanel) jFrame.getContentPane();
        jPanel.add(jscrollpane);


    }
}