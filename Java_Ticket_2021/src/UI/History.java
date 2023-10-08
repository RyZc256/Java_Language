/*
 * Created by JFormDesigner on Sun Dec 12 22:07:29 CST 2021
 */

package UI;

import jdk.nashorn.internal.scripts.JD;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author 荣榆 张
 */
public class History extends JFrame {
    User person;

    public History(User input) {
        person = input;
        initComponents();
        System.out.println(person.getSFZ());
        DefaultTableModel dtm = person.GetHistory();
        // 设置表格数据模型
        date_table.setModel(dtm);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        date_table = new JTable();

        //======== this ========
        setTitle("\u7528\u6237\u5386\u53f2\u8ba2\u5355");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- date_table ----
            date_table.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    "\u8ba2\u5355\u7f16\u53f7", "\u8eab\u4efd\u8bc1", "\u95e8\u7968\u7c7b\u578b", "\u95e8\u7968\u4ef7\u683c", "\u8d2d\u7968\u65e5\u671f", "\u4f7f\u7528\u65e5\u671f", "\u95e8\u7968\u72b6\u6001"
                }
            ));
            scrollPane1.setViewportView(date_table);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable date_table;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
