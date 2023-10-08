/*
 * Created by JFormDesigner on Thu Dec 16 19:35:07 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 * @author 荣榆 张
 */
public class Manage extends JFrame {
    Admin admin;
    DefaultTableModel dtm;
    String Type = null;
    double Price = -999.99;

    public Manage() {
        initComponents();
        admin = new Admin();
        dtm = admin.GetTicketType();
        table1.setModel(dtm);
    }

    public static void main(String[] args){
        Manage mg = new Manage();
        mg.setVisible(true);
    }

    /**
     * 删除门票按钮监听
     * @param e
     */
    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        Type = type_textField.getText();
        Price = Double.parseDouble(price_textField.getText());
        if(Type != null && Price != -999.99){
            Object[] options = {"删除","取消"};
            int Result = JOptionPane.showOptionDialog(null,"是否删除该门票类型","购票系统管理端",
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(Result == 0){
                if(admin.delete(Type,Price)){
                    JOptionPane.showMessageDialog(null,"删除成功，门票数据已更新请重启购票端","购票系统管理端",JOptionPane.INFORMATION_MESSAGE);
                    dtm = admin.GetTicketType();
                    table1.setModel(dtm);
                }else{
                    JOptionPane.showMessageDialog(null,"删除失败，请检查是否有误","购票系统管理端",JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"请输入要删除的门票类型及门票价格防止误删","购票系统管理端",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        Type = type_textField.getText();
        Price = Double.parseDouble(price_textField.getText());
        if(Type != null && Price != -999.99){
            Object[] options = {"确认","取消"};
            int Result = JOptionPane.showOptionDialog(null,"是否添加该门票类型","购票系统管理端",
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(Result == 0){
                if(admin.insert(Type,Price)){
                    JOptionPane.showMessageDialog(null,"添加成功，门票数据已更新请重启购票端","购票系统管理端",JOptionPane.INFORMATION_MESSAGE);
                    dtm = admin.GetTicketType();
                    table1.setModel(dtm);
                }else{
                    JOptionPane.showMessageDialog(null,"添加失败，请稍后再试","购票系统管理端",JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"请输入要添加的门票类型及门票价格","购票系统管理端",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void tabbedPane1StateChanged(ChangeEvent e) {
        // TODO add your code here
       int index = tabbedPane1.getSelectedIndex();
       if(index == 1){
           DefaultTableModel record = admin.GetRecord();
           table2.setModel(record);
       }
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        String Date = null;
        Date = date_textField.getText();
        if(Date != null){
            DefaultTableModel record = admin.GetRecord(Date);
            table3.setModel(record);
            double[] data = admin.GetData(Date);
            DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
            count_label.setText(decimalFormat.format(data[0]));
            sum_label.setText(String.valueOf(data[1]));
        }else{
            JOptionPane.showMessageDialog(null,"请输入正确的日期格式","购票系统管理端",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        type_textField = new JTextField();
        label2 = new JLabel();
        price_textField = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        panel3 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        date_textField = new JTextField();
        count_label = new JLabel();
        sum_label = new JLabel();
        button3 = new JButton();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();

        //======== this ========
        setTitle("\u5c55\u89c8\u9986\u8d2d\u7968\u7cfb\u7edf\u2014\u2014\u7ba1\u7406\u7aef");
        Container contentPane = getContentPane();

        //======== tabbedPane1 ========
        {
            tabbedPane1.addChangeListener(e -> tabbedPane1StateChanged(e));

            //======== panel1 ========
            {

                //---- label1 ----
                label1.setText("\u95e8\u7968\u7c7b\u578b\uff1a");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));

                //---- label2 ----
                label2.setText("\u95e8\u7968\u4ef7\u683c\uff1a");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

                //---- button1 ----
                button1.setText("\u65b0\u589e\u95e8\u7968");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                });

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null},
                            {null, null},
                        },
                        new String[] {
                            "\u95e8\u7968\u7c7b\u578b", "\u95e8\u7968\u4ef7\u683c"
                        }
                    ));
                    scrollPane1.setViewportView(table1);
                }

                //---- button2 ----
                button2.setText("\u5220\u9664\u95e8\u7968");
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button2MouseClicked(e);
                    }
                });

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(type_textField, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                .addComponent(price_textField, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                            .addGap(31, 31, 31)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(button1)
                                .addComponent(button2))
                            .addContainerGap(53, Short.MAX_VALUE))
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(type_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2)
                                    .addComponent(price_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(button2, GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("\u95e8\u7968\u7ba1\u7406", panel1);

            //======== panel2 ========
            {

                //======== scrollPane2 ========
                {

                    //---- table2 ----
                    table2.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null},
                        },
                        new String[] {
                            "\u8ba2\u5355\u7f16\u53f7", "\u8eab\u4efd\u8bc1", "\u95e8\u7968\u7c7b\u578b", "\u95e8\u7968\u4ef7\u683c", "\u521b\u5efa\u65e5\u671f", "\u4f7f\u7528\u65e5\u671f", "\u4ed8\u6b3e\u72b6\u6001", "\u95e8\u7968\u72b6\u6001"
                        }
                    ));
                    scrollPane2.setViewportView(table2);
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                );
            }
            tabbedPane1.addTab("\u8ba2\u5355\u7ba1\u7406", panel2);

            //======== panel3 ========
            {

                //---- label3 ----
                label3.setText("\u51fa\u552e\u95e8\u7968\u6570\u91cf\uff1a");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));

                //---- label4 ----
                label4.setText("\u51fa\u552e\u95e8\u7968\u603b\u989d\uff1a");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));

                //---- label5 ----
                label5.setText("\u8f93\u5165\u8981\u67e5\u8be2\u7684\u65e5\u671f\uff1a");
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));

                //---- date_textField ----
                date_textField.setText("2021-12-10");

                //---- count_label ----
                count_label.setText("0");
                count_label.setFont(count_label.getFont().deriveFont(count_label.getFont().getSize() + 2f));

                //---- sum_label ----
                sum_label.setText("0.00");
                sum_label.setFont(sum_label.getFont().deriveFont(sum_label.getFont().getSize() + 2f));

                //---- button3 ----
                button3.setText("\u67e5\u8be2");
                button3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button3MouseClicked(e);
                    }
                });

                //======== scrollPane3 ========
                {

                    //---- table3 ----
                    table3.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, "", null, null, null, null, ""},
                            {null, null, null, null, null, null, null, null},
                        },
                        new String[] {
                            "\u8ba2\u5355\u7f16\u53f7", "\u8eab\u4efd\u8bc1", "\u95e8\u7968\u7c7b\u578b", "\u95e8\u7968\u4ef7\u683c", "\u521b\u5efa\u65e5\u671f", "\u4f7f\u7528\u65e5\u671f", "\u4ed8\u6b3e\u72b6\u6001", "\u95e8\u7968\u72b6\u6001"
                        }
                    ));
                    scrollPane3.setViewportView(table3);
                }

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addComponent(label3)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(count_label)
                                            .addGap(45, 45, 45)
                                            .addComponent(label4)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(sum_label))
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addComponent(label5)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(date_textField, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addGap(182, 182, 182)
                                    .addComponent(button3)))
                            .addContainerGap(100, Short.MAX_VALUE))
                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(date_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(count_label)
                                .addComponent(label4)
                                .addComponent(sum_label))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button3)
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(2, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("\u552e\u7968\u6570\u636e\u7edf\u8ba1", panel3);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label1;
    private JTextField type_textField;
    private JLabel label2;
    private JTextField price_textField;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JPanel panel3;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField date_textField;
    private JLabel count_label;
    private JLabel sum_label;
    private JButton button3;
    private JScrollPane scrollPane3;
    private JTable table3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
