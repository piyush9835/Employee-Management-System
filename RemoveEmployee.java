package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice choiceEMPID;
    JButton delete, back;

    RemoveEmployee(){

        setLayout(null);   // ✅ MOVED UP
        setSize(1000,400);
        setLocation(300,150);

        // 🔹 Background Image FIRST
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1000,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,1000,400);
        add(image);

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        image.add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        image.add(choiceEMPID);

        try{
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select * from employee");
            while (rs.next()){
                choiceEMPID.add(rs.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,100,30);
        labelName.setFont(new Font("Tahoma",Font.BOLD,15));
        image.add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,200,30);
        image.add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50,150,100,30);
        labelPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        image.add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200,150,200,30);
        image.add(textPhone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50,200,100,30);
        labelEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        image.add(labelEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,250,30);
        image.add(textEmail);

        try{
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery(
                    "select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'"
            );
            if(rs.next()){
                textName.setText(rs.getString("name"));
                textPhone.setText(rs.getString("phone"));
                textEmail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    ResultSet rs = c.statement.executeQuery(
                            "select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'"
                    );
                    if(rs.next()){
                        textName.setText(rs.getString("name"));
                        textPhone.setText(rs.getString("phone"));
                        textEmail.setText(rs.getString("email"));
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        image.add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == delete){
            try{
                conn c = new conn();
                c.statement.executeUpdate(
                        "delete from employee where empId = '"+choiceEMPID.getSelectedItem()+"'"
                );
                JOptionPane.showMessageDialog(null,"Employee Deleted Successfully");
                setVisible(false);
                new main_class();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new RemoveEmployee();
    }
}
