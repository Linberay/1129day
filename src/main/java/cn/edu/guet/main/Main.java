package cn.edu.guet.main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @Author liwei
 * @Date 2022/11/29 16:09
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {

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