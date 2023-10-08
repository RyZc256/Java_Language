package gui;

import java.awt.event.*;

import com.entity.Student;
import com.entity.Task;
import com.entity.User;
import com.util.*;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import static java.lang.Thread.sleep;
/*
 * Created by JFormDesigner on Tue May 24 14:53:22 CST 2022
 */



/**
 * @author horizon
 */
public class TeacherHome extends JFrame {
    private User user;
    private InterfaceHome interfaceHome;
    private InterfaceInformation interfaceInformation;
    private int stuInfoFlag;
    private int stuInfoMax;
    private ArrayList<Student> students;
    private FTP ftp;

    public TeacherHome(User user) {
        initComponents();
        this.user = user;
        stuInfoFlag = 0;
        stuInfoMax = 0;
        interfaceHome = new opHome();
        ftp = new FTP();
        interfaceInformation = new Infortmation();
        initInformation();
    }

    private void modifyPwd(ActionEvent e) {
        // TODO add your code here
        ModifyPwd modifyPwd = new ModifyPwd(user);
        modifyPwd.setVisible(true);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        EditInformation editInformation = new EditInformation(user,1);
        editInformation.setVisible(true);
    }

    /**
     * 发布任务
     * @param e
     */
    private void button2(ActionEvent e) {
        // TODO add your code here
        Publish publish = new Publish(user,students);
        publish.setVisible(true);
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        int id = Integer.parseInt(comboBox1.getSelectedItem().toString().split("-")[0]);
        int student = Integer.parseInt(comboBox2.getSelectedItem().toString().split("-")[0]);
        String path = interfaceHome.getStuPath(id,student);
        if(path==null)
            JOptionPane.showMessageDialog(null,"学生未上传文件","系统提醒",JOptionPane.INFORMATION_MESSAGE);
        else{
            ftp.downloadFtpFile(path,"target/classes/Download");
            JOptionPane.showMessageDialog(null,String.format("下载成功,路径target/classes/Download/%s",path),"系统提醒",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        finishTask finishTask = new finishTask(user);
        finishTask.setVisible(true);
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
        table1.setModel(interfaceHome.teaGetTask(user));
        scrollPane1.setViewportView(table1);
    }

    private void previousStu(ActionEvent e) {
        // TODO add your code here
        if(stuInfoFlag == 0)
            previousStuButton.setEnabled(false);
        else 
            stuInfoFlag--;
        nextStuButton.setEnabled(true);
    }
    
    public void displayStuInfo(User user){
        if(user.getImage()!=null){
            ImageIcon image = new ImageIcon(getClass().getResource(user.getImage()));
            image.setImage(image.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT));
            stuPhoto.setIcon(image);
        }
        stuAccountLabel.setText("账号:"+user.getAccount());
        stuNameLabel.setText("姓名:"+ user.getName());
        stuSexLabel.setText("性别:" + user.getSex());
        stuAgeLabel.setText("年龄:" + user.getAge());
        stuIdCardLabel.setText("身份证:" + user.getIdCard());
        stuTelphoneLabel.setText("联系电话:" + user.getTelphone());
        stuCollegeLabel.setText("所属学院:" + user.getCollege());
        stuClassLabel.setText("管理班级:" + user.getsClass());
        stuLastOnlineLabel.setText("最后上线时间:" + user.getLastOnline());
    }

    private void nextStu(ActionEvent e) {
        // TODO add your code here
        if(stuInfoFlag == stuInfoMax)
            nextStuButton.setEnabled(false);
        else
            stuInfoFlag++;
        previousStuButton.setEnabled(true);
    }

    private void EditStu(ActionEvent e) {
        // TODO add your code here
        EditInformation editInformation = new EditInformation(students.get(stuInfoFlag),1);
        editInformation.setVisible(true);
    }

    private void addStu(ActionEvent e) {
        // TODO add your code here
        AddStudent addStudent = new AddStudent();
        addStudent.setVisible(true);
    }

    private void delStu(ActionEvent e) {
        // TODO add your code here
        if(interfaceInformation.delStu(students.get(stuInfoFlag)))
            JOptionPane.showMessageDialog(null,"删除成功","系统提醒",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"删除失败","系统提醒",JOptionPane.INFORMATION_MESSAGE);
            
    }
    
    

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 张荣榆
        tabbedPane1 = new JTabbedPane();
        taskPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();
        button3 = new JButton();
        button5 = new JButton();
        filePanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        button4 = new JButton();
        stuManagePanel = new JPanel();
        addStuButton = new JButton();
        delStuButton = new JButton();
        previousStuButton = new JButton();
        nextStuButton = new JButton();
        stuPhoto = new JLabel();
        stuNameLabel = new JLabel();
        stuSexLabel = new JLabel();
        stuAgeLabel = new JLabel();
        stuIdCardLabel = new JLabel();
        stuTelphoneLabel = new JLabel();
        stuCollegeLabel = new JLabel();
        stuClassLabel = new JLabel();
        stuLastOnlineLabel = new JLabel();
        stuAccountLabel = new JLabel();
        EditStuButton = new JButton();
        personPanel = new JPanel();
        nameLabel = new JLabel();
        sexLabel = new JLabel();
        ageLabel = new JLabel();
        idCardLabel = new JLabel();
        telphoneLabel = new JLabel();
        collegeLabel = new JLabel();
        classLabel = new JLabel();
        lastOnlineLabel = new JLabel();
        label8 = new JLabel();
        photo = new JLabel();
        button1 = new JButton();
        modifyPwdButton = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u5b9e\u4e60\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== taskPanel ========
            {
                taskPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
                ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
                . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
                . Color. red) ,taskPanel. getBorder( )) ); taskPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
                propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
                ; }} );
                taskPanel.setLayout(null);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }
                taskPanel.add(scrollPane1);
                scrollPane1.setBounds(0, 0, 420, 300);

                //---- button2 ----
                button2.setText("\u53d1\u5e03\u4efb\u52a1");
                button2.addActionListener(e -> button2(e));
                taskPanel.add(button2);
                button2.setBounds(new Rectangle(new Point(425, 20), button2.getPreferredSize()));

                //---- button3 ----
                button3.setText("\u505c\u6b62\u4efb\u52a1");
                button3.addActionListener(e -> button3(e));
                taskPanel.add(button3);
                button3.setBounds(new Rectangle(new Point(425, 60), button3.getPreferredSize()));

                //---- button5 ----
                button5.setText("\u5237\u65b0\u4efb\u52a1");
                button5.addActionListener(e -> button5(e));
                taskPanel.add(button5);
                button5.setBounds(new Rectangle(new Point(425, 100), button5.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < taskPanel.getComponentCount(); i++) {
                        Rectangle bounds = taskPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = taskPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    taskPanel.setMinimumSize(preferredSize);
                    taskPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u4efb\u52a1", taskPanel);

            //======== filePanel ========
            {
                filePanel.setLayout(null);

                //---- label1 ----
                label1.setText("\u4efb\u52a1:");
                filePanel.add(label1);
                label1.setBounds(new Rectangle(new Point(25, 20), label1.getPreferredSize()));

                //---- label2 ----
                label2.setText("\u5b66\u751f:");
                filePanel.add(label2);
                label2.setBounds(new Rectangle(new Point(25, 70), label2.getPreferredSize()));
                filePanel.add(comboBox1);
                comboBox1.setBounds(70, 15, 210, comboBox1.getPreferredSize().height);
                filePanel.add(comboBox2);
                comboBox2.setBounds(70, 65, 210, comboBox2.getPreferredSize().height);

                //---- button4 ----
                button4.setText("\u4e0b\u8f7d\u6587\u4ef6");
                button4.addActionListener(e -> button4(e));
                filePanel.add(button4);
                button4.setBounds(new Rectangle(new Point(330, 65), button4.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < filePanel.getComponentCount(); i++) {
                        Rectangle bounds = filePanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = filePanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    filePanel.setMinimumSize(preferredSize);
                    filePanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u6587\u4ef6\u7ba1\u7406", filePanel);

            //======== stuManagePanel ========
            {
                stuManagePanel.setLayout(null);

                //---- addStuButton ----
                addStuButton.setText("\u6dfb\u52a0\u5b66\u751f");
                addStuButton.addActionListener(e -> addStu(e));
                stuManagePanel.add(addStuButton);
                addStuButton.setBounds(new Rectangle(new Point(10, 260), addStuButton.getPreferredSize()));

                //---- delStuButton ----
                delStuButton.setText("\u5220\u9664\u5b66\u751f");
                delStuButton.addActionListener(e -> delStu(e));
                stuManagePanel.add(delStuButton);
                delStuButton.setBounds(new Rectangle(new Point(110, 260), delStuButton.getPreferredSize()));

                //---- previousStuButton ----
                previousStuButton.setText("\u4e0a\u4e00\u4e2a");
                previousStuButton.addActionListener(e -> previousStu(e));
                stuManagePanel.add(previousStuButton);
                previousStuButton.setBounds(new Rectangle(new Point(350, 260), previousStuButton.getPreferredSize()));

                //---- nextStuButton ----
                nextStuButton.setText("\u4e0b\u4e00\u4e2a");
                nextStuButton.addActionListener(e -> nextStu(e));
                stuManagePanel.add(nextStuButton);
                nextStuButton.setBounds(new Rectangle(new Point(435, 260), nextStuButton.getPreferredSize()));
                stuManagePanel.add(stuPhoto);
                stuPhoto.setBounds(20, 20, 90, 90);

                //---- stuNameLabel ----
                stuNameLabel.setText("\u59d3\u540d:");
                stuManagePanel.add(stuNameLabel);
                stuNameLabel.setBounds(125, 45, 250, stuNameLabel.getPreferredSize().height);

                //---- stuSexLabel ----
                stuSexLabel.setText("\u6027\u522b:");
                stuManagePanel.add(stuSexLabel);
                stuSexLabel.setBounds(125, 70, 250, stuSexLabel.getPreferredSize().height);

                //---- stuAgeLabel ----
                stuAgeLabel.setText("\u5e74\u9f84:");
                stuManagePanel.add(stuAgeLabel);
                stuAgeLabel.setBounds(125, 95, 250, stuAgeLabel.getPreferredSize().height);

                //---- stuIdCardLabel ----
                stuIdCardLabel.setText("\u8eab\u4efd\u8bc1:");
                stuManagePanel.add(stuIdCardLabel);
                stuIdCardLabel.setBounds(125, 120, 250, stuIdCardLabel.getPreferredSize().height);

                //---- stuTelphoneLabel ----
                stuTelphoneLabel.setText("\u8054\u7cfb\u65b9\u5f0f:");
                stuManagePanel.add(stuTelphoneLabel);
                stuTelphoneLabel.setBounds(125, 145, 250, stuTelphoneLabel.getPreferredSize().height);

                //---- stuCollegeLabel ----
                stuCollegeLabel.setText("\u6240\u5c5e\u5b66\u9662:");
                stuManagePanel.add(stuCollegeLabel);
                stuCollegeLabel.setBounds(125, 170, 250, stuCollegeLabel.getPreferredSize().height);

                //---- stuClassLabel ----
                stuClassLabel.setText("\u6240\u5c5e\u73ed\u7ea7:");
                stuManagePanel.add(stuClassLabel);
                stuClassLabel.setBounds(125, 195, 250, stuClassLabel.getPreferredSize().height);

                //---- stuLastOnlineLabel ----
                stuLastOnlineLabel.setText("\u6700\u540e\u767b\u5f55\u65f6\u95f4:");
                stuManagePanel.add(stuLastOnlineLabel);
                stuLastOnlineLabel.setBounds(125, 220, 250, stuLastOnlineLabel.getPreferredSize().height);

                //---- stuAccountLabel ----
                stuAccountLabel.setText("\u8d26\u53f7:");
                stuManagePanel.add(stuAccountLabel);
                stuAccountLabel.setBounds(125, 20, 250, stuAccountLabel.getPreferredSize().height);

                //---- EditStuButton ----
                EditStuButton.setText("\u7f16\u8f91\u5b66\u751f");
                EditStuButton.addActionListener(e -> EditStu(e));
                stuManagePanel.add(EditStuButton);
                EditStuButton.setBounds(new Rectangle(new Point(210, 260), EditStuButton.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < stuManagePanel.getComponentCount(); i++) {
                        Rectangle bounds = stuManagePanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = stuManagePanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    stuManagePanel.setMinimumSize(preferredSize);
                    stuManagePanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5b66\u751f\u7ba1\u7406", stuManagePanel);

            //======== personPanel ========
            {
                personPanel.setLayout(null);

                //---- nameLabel ----
                nameLabel.setText("\u59d3\u540d:");
                personPanel.add(nameLabel);
                nameLabel.setBounds(120, 25, 250, nameLabel.getPreferredSize().height);

                //---- sexLabel ----
                sexLabel.setText("\u6027\u522b:");
                personPanel.add(sexLabel);
                sexLabel.setBounds(120, 50, 250, sexLabel.getPreferredSize().height);

                //---- ageLabel ----
                ageLabel.setText("\u5e74\u9f84:");
                personPanel.add(ageLabel);
                ageLabel.setBounds(120, 75, 250, ageLabel.getPreferredSize().height);

                //---- idCardLabel ----
                idCardLabel.setText("\u8eab\u4efd\u8bc1:");
                personPanel.add(idCardLabel);
                idCardLabel.setBounds(120, 100, 250, idCardLabel.getPreferredSize().height);

                //---- telphoneLabel ----
                telphoneLabel.setText("\u8054\u7cfb\u65b9\u5f0f:");
                personPanel.add(telphoneLabel);
                telphoneLabel.setBounds(120, 125, 250, telphoneLabel.getPreferredSize().height);

                //---- collegeLabel ----
                collegeLabel.setText("\u6240\u5c5e\u5b66\u9662:");
                personPanel.add(collegeLabel);
                collegeLabel.setBounds(120, 150, 250, collegeLabel.getPreferredSize().height);

                //---- classLabel ----
                classLabel.setText("\u6240\u5c5e\u73ed\u7ea7:");
                personPanel.add(classLabel);
                classLabel.setBounds(120, 175, 250, classLabel.getPreferredSize().height);

                //---- lastOnlineLabel ----
                lastOnlineLabel.setText("\u6700\u540e\u767b\u5f55\u65f6\u95f4:");
                personPanel.add(lastOnlineLabel);
                lastOnlineLabel.setBounds(120, 200, 250, lastOnlineLabel.getPreferredSize().height);

                //---- label8 ----
                label8.setText("2022-05-23\u00a9\ufe0fJAVA\u5f00\u53d1\u8fdb\u9636\u671f\u672b\u8bfe\u8bbe");
                personPanel.add(label8);
                label8.setBounds(new Rectangle(new Point(170, 270), label8.getPreferredSize()));
                personPanel.add(photo);
                photo.setBounds(15, 20, 90, 90);

                //---- button1 ----
                button1.setText("\u4fee\u6539\u8d44\u6599");
                button1.addActionListener(e -> button1(e));
                personPanel.add(button1);
                button1.setBounds(new Rectangle(new Point(420, 15), button1.getPreferredSize()));

                //---- modifyPwdButton ----
                modifyPwdButton.setText("\u4fee\u6539\u5bc6\u7801");
                modifyPwdButton.addActionListener(e -> {
			modifyPwd(e);
			modifyPwd(e);
		});
                personPanel.add(modifyPwdButton);
                modifyPwdButton.setBounds(new Rectangle(new Point(420, 55), modifyPwdButton.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < personPanel.getComponentCount(); i++) {
                        Rectangle bounds = personPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = personPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    personPanel.setMinimumSize(preferredSize);
                    personPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u4e2a\u4eba\u4e2d\u5fc3", personPanel);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 535, 335);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    private void initInformation(){
        /**
         * 个人资料
         */
        Thread infoThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(user.getImage()!=null){
                        ImageIcon image = new ImageIcon(getClass().getResource(user.getImage()));
                        image.setImage(image.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT));
                        photo.setIcon(image);
                    }
                    nameLabel.setText("姓名:"+ user.getName());
                    sexLabel.setText("性别:" + user.getSex());
                    ageLabel.setText("年龄:" + user.getAge());
                    idCardLabel.setText("身份证:" + user.getIdCard());
                    telphoneLabel.setText("联系电话:" + user.getTelphone());
                    collegeLabel.setText("所属学院:" + user.getCollege());
                    classLabel.setText("管理班级:" + user.getsClass());
                    lastOnlineLabel.setText("最后上线时间:" + user.getLastOnline());
                }
            }
        });
        infoThread.start();


        /**
         * 任务选择框线程
         */
        Thread comboTaskThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(students!=null){
                        displayStuInfo(students.get(stuInfoFlag));
                    }
                    ArrayList<Task> tasks = interfaceHome.teaAllGetTask(user);
                    for (Task i: tasks){
                        String data = i.getId() + "-" + i.getTitle();
                        boolean flag = false;
                        for(int j=0;j<comboBox1.getItemCount();j++){
                            if(comboBox1.getItemAt(j).equals(data)){
                                flag = true;
                            }
                        }
                        if(!flag)
                            comboBox1.addItem(data);
                    }
                }
            }
        });
        comboTaskThread.start();


        /**
         * 获取学生线程
         */
        Thread getStuThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    students = interfaceHome.teaGetStu(user);
                    for(Student i:students){
                        String data = i.getAccount() + "-" + i.getName();
                        boolean flag = false;
                        for(int j=0;j<comboBox2.getItemCount();j++){
                            if(comboBox2.getItemAt(j).equals(data)){
                                flag = true;
                            }
                        }
                        if(!flag)
                            comboBox2.addItem(data);
                    }
//                    System.out.println(stuInfoFlag);
                    stuInfoMax = students.size()-1;
                }
            }
        });
        getStuThread.start();

        /**
        * 任务界面线程
        */
        Thread taskThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        table1.setModel(interfaceHome.teaGetTask(user));
                        scrollPane1.setViewportView(table1);
                        sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        taskThread.start();
        
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 张荣榆
    private JTabbedPane tabbedPane1;
    private JPanel taskPanel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JButton button3;
    private JButton button5;
    private JPanel filePanel;
    private JLabel label1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton button4;
    private JPanel stuManagePanel;
    private JButton addStuButton;
    private JButton delStuButton;
    private JButton previousStuButton;
    private JButton nextStuButton;
    private JLabel stuPhoto;
    private JLabel stuNameLabel;
    private JLabel stuSexLabel;
    private JLabel stuAgeLabel;
    private JLabel stuIdCardLabel;
    private JLabel stuTelphoneLabel;
    private JLabel stuCollegeLabel;
    private JLabel stuClassLabel;
    private JLabel stuLastOnlineLabel;
    private JLabel stuAccountLabel;
    private JButton EditStuButton;
    private JPanel personPanel;
    private JLabel nameLabel;
    private JLabel sexLabel;
    private JLabel ageLabel;
    private JLabel idCardLabel;
    private JLabel telphoneLabel;
    private JLabel collegeLabel;
    private JLabel classLabel;
    private JLabel lastOnlineLabel;
    private JLabel label8;
    private JLabel photo;
    private JButton button1;
    private JButton modifyPwdButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
