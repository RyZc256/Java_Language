package gui;

import java.awt.event.*;

import com.entity.Task;
import com.entity.User;
import com.util.Datetime;
import com.util.FTP;
import com.util.InterfaceHome;
import com.util.opHome;
import gui.EditInformation;
import gui.ModifyPwd;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import static java.lang.Thread.sleep;
/*
 * Created by JFormDesigner on Tue May 24 14:53:31 CST 2022
 */



/**
 * @author horizon
 */
public class StudentHome extends JFrame {
    // 用户实体
    private User user;
    // 主界面逻辑接口
    private InterfaceHome interfaceHome;
    // 当前选择的任务
    private int taskFlag;
    // 任务最大值
    private int maxTask;
    // 任务列表
    private ArrayList<Task> taskList;

    private FTP ftp;



    public StudentHome(User user) {
        initComponents();
        this.user = user;
        initInformation();
    }


    /**
     * 修改密码
     * @param e
     */
    private void modifyPwd(ActionEvent e) {
        // TODO add your code here
        ModifyPwd modifyPwd = new ModifyPwd(user);
        modifyPwd.setVisible(true);
    }


    /**
     * 编辑个人资料
     * @param e
     */
    private void button1(ActionEvent e) {
        // TODO add your code here
        EditInformation editInformation = new EditInformation(user,0);
        editInformation.setVisible(true);
    }

    /**
     * 打卡按钮
     * @param e
     */
    private void button2(ActionEvent e) {
        // TODO add your code here
        int result = interfaceHome.stuUpDateAttend(user);
        if(result==1)
            JOptionPane.showMessageDialog(null,"打卡成功","系统提醒",JOptionPane.INFORMATION_MESSAGE);
        else if(result==2)
            JOptionPane.showMessageDialog(null,"打卡失败","系统提醒",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"今日已打卡","系统提醒",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 任务界面 下一个按钮
     * @param e
     */
    private void taskNext(ActionEvent e) {
        // TODO add your code here
        previousTaskButton.setEnabled(true);
        // 如果触及上限，限制按钮
        if(taskFlag == maxTask)
            taskNextButton.setEnabled(false);
        else
            taskFlag++;
        displayTask();
    }


    /**
     * 任务界面 上一个按钮
     * @param e
     */
    private void previousTask(ActionEvent e) {
        // TODO add your code here
        taskNextButton.setEnabled(true);
        // 如果触及下限，限制按钮
        if(taskFlag == 0)
            previousTaskButton.setEnabled(false);
        else
            taskFlag--;
        displayTask();
    }


    /**
     * 完成任务
     * @param e
     */
    private void button3(ActionEvent e) {
        // TODO add your code here
        boolean result = false;
        // ftp内文件名称
        String ftpFileName = "";
        Task temp = taskList.get(taskFlag);
        // 文件选择
        JFileChooser chooser = new JFileChooser();
        // 选择类型为文档
        FileNameExtensionFilter filter = new FileNameExtensionFilter("doc & docx (Word Document)", "doc", "docx");
        // 只允许选择一个文件
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // 设置默认选择的文件类型
        chooser.setFileFilter(filter);
        // 不允许选择所有类型文件
        chooser.setAcceptAllFileFilterUsed(false);
        // 弹出提示
        int returnVal = chooser.showDialog(this, "提交");
        // 如果用户做出选择
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = chooser.getSelectedFile().getName();
            if(filename.endsWith("doc") || filename.endsWith("docx")) {
                try{
                    // 文件流
                    FileInputStream in = new FileInputStream(chooser.getSelectedFile());
                    // 重命名文件 学号_任务ID
                    if(filename.endsWith("doc")){
                        ftpFileName += temp.getStudent() + "_";
                        ftpFileName += temp.getId() + ".doc";
                    }else{
                        ftpFileName += temp.getStudent() + "_";
                        ftpFileName += temp.getId() + ".docx";
                    }
                    result = ftp.uploadFile(ftpFileName,in);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            else
                JOptionPane.showMessageDialog(null,"文件类型不支持","系统提醒",JOptionPane.INFORMATION_MESSAGE);
        }
        if(result){
            // 设置文件路径
            temp.setPath(ftpFileName);
            // 记录完成时间
            temp.setCompletionTime(new Datetime().now());
            // 改变状态
            temp.setStatus(1);
            if(interfaceHome.stuUpDateTask(temp)) {
                JOptionPane.showMessageDialog(null, "文件上传成功，任务完成", "系统提醒", JOptionPane.INFORMATION_MESSAGE);
                if(taskFlag!=0)
                    taskFlag--;
            }
            else
                JOptionPane.showMessageDialog(null,"文件上传成功，数据更新错误","系统提醒",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "文件上传失败，任务未完成", "系统提醒", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 张荣榆
        tabbedPane1 = new JTabbedPane();
        taskPanel = new JPanel();
        taskNextButton = new JButton();
        previousTaskButton = new JButton();
        taskNameLabel = new JLabel();
        taskContentLabel = new JLabel();
        cutoffDateLabel = new JLabel();
        button3 = new JButton();
        signPanel = new JPanel();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        personPenal = new JPanel();
        photo = new JLabel();
        nameLabel = new JLabel();
        sexLabel = new JLabel();
        ageLabel = new JLabel();
        idCardLabel = new JLabel();
        telphoneLabel = new JLabel();
        collegeLabel = new JLabel();
        classLabel = new JLabel();
        lastOnlineLabel = new JLabel();
        modifyPwdButton = new JButton();
        button1 = new JButton();
        label8 = new JLabel();

        //======== this ========
        setTitle("\u5b66\u751f\u5b9e\u4e60\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== taskPanel ========
            {
                taskPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
                .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax
                . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,
                12 ) ,java . awt. Color .red ) ,taskPanel. getBorder () ) ); taskPanel. addPropertyChangeListener( new java. beans
                .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e.
                getPropertyName () ) )throw new RuntimeException( ) ;} } );
                taskPanel.setLayout(null);

                //---- taskNextButton ----
                taskNextButton.setText("\u4e0b\u4e00\u4e2a");
                taskNextButton.addActionListener(e -> taskNext(e));
                taskPanel.add(taskNextButton);
                taskNextButton.setBounds(new Rectangle(new Point(445, 245), taskNextButton.getPreferredSize()));

                //---- previousTaskButton ----
                previousTaskButton.setText("\u4e0a\u4e00\u4e2a");
                previousTaskButton.addActionListener(e -> previousTask(e));
                taskPanel.add(previousTaskButton);
                previousTaskButton.setBounds(new Rectangle(new Point(365, 245), previousTaskButton.getPreferredSize()));

                //---- taskNameLabel ----
                taskNameLabel.setText("\u4efb\u52a1:");
                taskPanel.add(taskNameLabel);
                taskNameLabel.setBounds(30, 15, 370, taskNameLabel.getPreferredSize().height);

                //---- taskContentLabel ----
                taskContentLabel.setText("\u5185\u5bb9:");
                taskContentLabel.setVerticalAlignment(SwingConstants.TOP);
                taskPanel.add(taskContentLabel);
                taskContentLabel.setBounds(45, 45, 460, 150);

                //---- cutoffDateLabel ----
                cutoffDateLabel.setText("\u622a\u6b62\u65e5\u671f:");
                taskPanel.add(cutoffDateLabel);
                cutoffDateLabel.setBounds(285, 215, 245, cutoffDateLabel.getPreferredSize().height);

                //---- button3 ----
                button3.setText("\u5b8c\u6210\u4efb\u52a1");
                button3.addActionListener(e -> button3(e));
                taskPanel.add(button3);
                button3.setBounds(new Rectangle(new Point(445, 5), button3.getPreferredSize()));

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

            //======== signPanel ========
            {
                signPanel.setLayout(null);

                //---- button2 ----
                button2.setText("\u6253\u5361");
                button2.addActionListener(e -> button2(e));
                signPanel.add(button2);
                button2.setBounds(new Rectangle(new Point(460, 20), button2.getPreferredSize()));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }
                signPanel.add(scrollPane1);
                scrollPane1.setBounds(0, 0, 420, 290);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < signPanel.getComponentCount(); i++) {
                        Rectangle bounds = signPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = signPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    signPanel.setMinimumSize(preferredSize);
                    signPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u6253\u5361", signPanel);

            //======== personPenal ========
            {
                personPenal.setLayout(null);
                personPenal.add(photo);
                photo.setBounds(20, 10, 90, 90);

                //---- nameLabel ----
                nameLabel.setText("\u59d3\u540d:");
                personPenal.add(nameLabel);
                nameLabel.setBounds(125, 15, 250, nameLabel.getPreferredSize().height);

                //---- sexLabel ----
                sexLabel.setText("\u6027\u522b:");
                personPenal.add(sexLabel);
                sexLabel.setBounds(125, 40, 250, sexLabel.getPreferredSize().height);

                //---- ageLabel ----
                ageLabel.setText("\u5e74\u9f84:");
                personPenal.add(ageLabel);
                ageLabel.setBounds(125, 65, 250, ageLabel.getPreferredSize().height);

                //---- idCardLabel ----
                idCardLabel.setText("\u8eab\u4efd\u8bc1:");
                personPenal.add(idCardLabel);
                idCardLabel.setBounds(125, 90, 250, idCardLabel.getPreferredSize().height);

                //---- telphoneLabel ----
                telphoneLabel.setText("\u8054\u7cfb\u65b9\u5f0f:");
                personPenal.add(telphoneLabel);
                telphoneLabel.setBounds(125, 115, 250, telphoneLabel.getPreferredSize().height);

                //---- collegeLabel ----
                collegeLabel.setText("\u6240\u5c5e\u5b66\u9662:");
                personPenal.add(collegeLabel);
                collegeLabel.setBounds(125, 140, 250, collegeLabel.getPreferredSize().height);

                //---- classLabel ----
                classLabel.setText("\u6240\u5c5e\u73ed\u7ea7:");
                personPenal.add(classLabel);
                classLabel.setBounds(125, 165, 250, classLabel.getPreferredSize().height);

                //---- lastOnlineLabel ----
                lastOnlineLabel.setText("\u6700\u540e\u767b\u5f55\u65f6\u95f4:");
                personPenal.add(lastOnlineLabel);
                lastOnlineLabel.setBounds(125, 190, 250, lastOnlineLabel.getPreferredSize().height);

                //---- modifyPwdButton ----
                modifyPwdButton.setText("\u4fee\u6539\u5bc6\u7801");
                modifyPwdButton.addActionListener(e -> modifyPwd(e));
                personPenal.add(modifyPwdButton);
                modifyPwdButton.setBounds(new Rectangle(new Point(445, 45), modifyPwdButton.getPreferredSize()));

                //---- button1 ----
                button1.setText("\u4fee\u6539\u8d44\u6599");
                button1.addActionListener(e -> button1(e));
                personPenal.add(button1);
                button1.setBounds(new Rectangle(new Point(445, 5), button1.getPreferredSize()));

                //---- label8 ----
                label8.setText("2022-05-23\u00a9\ufe0fJAVA\u5f00\u53d1\u8fdb\u9636\u671f\u672b\u8bfe\u8bbe");
                personPenal.add(label8);
                label8.setBounds(new Rectangle(new Point(175, 260), label8.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < personPenal.getComponentCount(); i++) {
                        Rectangle bounds = personPenal.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = personPenal.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    personPenal.setMinimumSize(preferredSize);
                    personPenal.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u4e2a\u4eba\u4e2d\u5fc3", personPenal);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 555, 325);

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
        // 初始化
        interfaceHome = new opHome();
        taskFlag = 0;
        taskList = new ArrayList<>();
        ftp = new FTP();

        // 个人中心界面
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
                    classLabel.setText("所属班级:" + user.getsClass());
                    lastOnlineLabel.setText("最后上线时间:" + user.getLastOnline());
//                    System.out.println(user.toString());
                }
            }
        });
        infoThread.start();

        // 打卡界面
        Thread attendThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if(!interfaceHome.stuTodayAttend())
                    JOptionPane.showMessageDialog(null,"今日打卡数据有误","系统提醒",JOptionPane.INFORMATION_MESSAGE);
                while(true){
                    try{
                        table1.setModel(interfaceHome.stuGetAttend(user));
                        scrollPane1.setViewportView(table1);
                        sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        attendThread.start();

        Thread taskThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        taskList = interfaceHome.stuGetTask(user);
                        maxTask = taskList.size()-1;
                        displayTask();
                        sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        taskThread.start();
    }

    /**
     * 任务界面信息显示
     */
    public void displayTask(){
        try {
            taskNameLabel.setText("任务:" + taskList.get(taskFlag).getTitle());
            String html = "<html>内容:<br>";
            String data = taskList.get(taskFlag).getContent();
            for(int i=0;i<data.length();i++){
                html += (data.substring(i,i+1));
                if(i!=0 && i%20==0)
                    html += "<br>";
            }
            html += "</html>";
            taskContentLabel.setText(html);
            cutoffDateLabel.setText("截止日期:" + taskList.get(taskFlag).getDeadline());
        }catch (Exception e){
            e.printStackTrace();
            taskNameLabel.setText("任务");
            taskContentLabel.setText("内容");
            cutoffDateLabel.setText("截止日期");
        }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 张荣榆
    private JTabbedPane tabbedPane1;
    private JPanel taskPanel;
    private JButton taskNextButton;
    private JButton previousTaskButton;
    private JLabel taskNameLabel;
    private JLabel taskContentLabel;
    private JLabel cutoffDateLabel;
    private JButton button3;
    private JPanel signPanel;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel personPenal;
    private JLabel photo;
    private JLabel nameLabel;
    private JLabel sexLabel;
    private JLabel ageLabel;
    private JLabel idCardLabel;
    private JLabel telphoneLabel;
    private JLabel collegeLabel;
    private JLabel classLabel;
    private JLabel lastOnlineLabel;
    private JButton modifyPwdButton;
    private JButton button1;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
