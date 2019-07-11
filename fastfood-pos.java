package javaapplication1;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import java.util.*;

public class JavaApplication1 implements ItemListener, ActionListener, KeyListener{

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JButton but1 = new JButton("FINISH ORDER");
    JTextField jf1 = new JTextField();
    JTextField jf2 = new JTextField();
    JTextField jf3 = new JTextField();
    
    JToggleButton jtb1 = new JToggleButton("FRIED CHICKEN", false);
    JToggleButton jtb2 = new JToggleButton("PORK CHOPS", false);
    JToggleButton jtb3 = new JToggleButton("STEAK", false);
    JToggleButton jtb4 = new JToggleButton("PIZZA", false);
    JToggleButton jtb5 = new JToggleButton("SALAD", false);
    JToggleButton jtb6 = new JToggleButton("FRIES", false);
    JToggleButton jtb7 = new JToggleButton("BURGER", false);
    JToggleButton jtb8 = new JToggleButton("SPAGHETTI", false);
    JToggleButton jtb9 = new JToggleButton("HOTDOG", false);
    JToggleButton jtb10 = new JToggleButton("BREAD", false);
    JRadioButton rb4 = new JRadioButton("Null");
    JRadioButton rb1 = new JRadioButton("Coke");
    JRadioButton rb2 = new JRadioButton("Sprite");
    JRadioButton rb3 = new JRadioButton("Royal");
    JButton but2 = new JButton("DELETE");
    JComboBox<String> majorChoice =  new JComboBox<String>();
    private final JMenuBar MainBar = new JMenuBar();
    private final JMenu Menu1 = new JMenu("File");
    private JMenu Menu2 = new JMenu("Colors");
    private JMenuItem Exit = new JMenuItem("Exit");
    private JMenu bright = new JMenu("Bright");
    private JMenuItem dark = new JMenuItem("Dark");
    private JMenuItem white = new JMenuItem("White");
    private JMenuItem gray = new JMenuItem("Gray");
    private JMenuItem blue = new JMenuItem("Blue");
    private final JMenu Menu3 = new JMenu("Help");
    
    String aa, cWord;
    double pay, amount, total;
    
    int dialogButton = JOptionPane.YES_NO_OPTION;
    
    ButtonGroup group = new ButtonGroup();
    
    public JavaApplication1()
    {
        super();
        p.setLayout(null);
        f.setSize(700, 560);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setJMenuBar(MainBar);
        
        model.addColumn("Order Name");
        model.addColumn("Quantity");
        model.addColumn("Price");
        
       
        
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        
        

        but1.setBounds(20, 400, 170, 70);
        but2.setBounds(190, 400, 170, 70);
        scrollPane.setBounds(20, 20, 340, 350);
        majorChoice.setBounds(370, 370, 150, 30);
        jf1.setBounds(20, 370, 117, 30);
        jf2.setBounds(133,370, 117, 30);
        jf3.setBounds(243, 370, 117, 30);
        jtb1.setBounds(370, 20, 150, 70);
        jtb2.setBounds(520, 20, 150, 70);
        jtb3.setBounds(370, 90, 150, 70);
        jtb4.setBounds(520, 90, 150, 70);
        jtb5.setBounds(370, 160, 150, 70);
        jtb6.setBounds(520, 160, 150, 70);
        jtb7.setBounds(370, 230, 150, 70);
        jtb8.setBounds(520, 230, 150, 70);
        jtb9.setBounds(370, 300, 150, 70);
        jtb10.setBounds(520, 300, 150, 70);
        
        
        
        
        rb1.setBounds(430, 420, 60, 30);
        rb2.setBounds(500, 420, 60, 30);
        rb3.setBounds(580, 420, 60, 30);
        
        
        p.add(jf1);
        p.add(jf2);
        p.add(jf3);
        p.add(scrollPane);
        p.add(majorChoice);
        p.add(but1);
        p.add(but2);
        p.add(jtb1);
        p.add(jtb2);
        p.add(jtb3);
        p.add(jtb4);
        p.add(jtb5);
        p.add(jtb6);
        p.add(jtb7);
        p.add(jtb8);
        p.add(jtb9);
        p.add(jtb10);
        p.add(rb1);
        p.add(rb2);
        p.add(rb3);
        
        MainBar.add(Menu1);
        MainBar.add(Menu2);
        MainBar.add(Menu3);
        Menu1.add(Exit);
        Menu2.add(bright);
        Menu2.add(dark);
        Menu2.add(white);
        bright.add(gray);
        bright.add(blue);
        
        majorChoice.addItem("Choose");
        majorChoice.addItem("Ice Cream");
        majorChoice.addItem("Pie");
        majorChoice.addItem("Cake");

        f.add(p);
        
        but1.addActionListener(this);
        but2.addActionListener(this);
        jf2.addKeyListener(this);
        jtb1.addItemListener(this);
        jtb2.addItemListener(this);
        jtb3.addItemListener(this);
        jtb4.addItemListener(this);
        jtb5.addItemListener(this);
        jtb6.addItemListener(this);
        jtb7.addItemListener(this);
        jtb8.addItemListener(this);
        jtb9.addItemListener(this);
        jtb10.addItemListener(this);
        rb1.addItemListener(this);
        rb2.addItemListener(this);
        rb3.addItemListener(this);
        Exit.addActionListener(this);
        dark.addActionListener(this);
        white.addActionListener(this);
        gray.addActionListener(this);
        blue.addActionListener(this);
        majorChoice.addItemListener(this);
    }
    
    public void keyPressed(KeyEvent e)
    {
        
    }
    public void keyReleased(KeyEvent e)
    {
        
    }
    public void keyTyped(KeyEvent e)
    {
        if (e.getSource()==jf2)
        {
            char c = e.getKeyChar();
            if(!jf2.getText().equals(""))
            {
                cWord = jf2.getText() + c;
                pay = Double.parseDouble(cWord);
                amount = Double.parseDouble(jf1.getText());
                if(pay>amount){
                double change = pay - amount;
                jf3.setText(" " + String.format("%.2f", change));
                aa="Yes";
        }else if(pay<amount){
            aa="No";
        }
    }
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==but1)
        {
            if(aa.equals("No")){
                String baba="Insufficient cash amount";
                   JOptionPane.showMessageDialog(null,baba);
            }
            if(aa.equals("Yes")){
                int dialogResult = JOptionPane.showConfirmDialog (null, "Transaction Finished?","Warning",dialogButton);
            if(dialogResult == 0) {
                model.setRowCount(0);
                Path file = Paths.get("C:\\Users\\lab1pc43\\Desktop\\Receipt.txt");
                    OutputStream creator = null;
                    OutputStream output = null;
                    BufferedWriter write = null;
                    String ann=jf1.getText();
                    String an=jf2.getText();
                    String gee=jf3.getText();
                    String na="Total Order: ";
                    String naa="Total Cash: ";
                    String naag="Change: ";
                    try{
                    output = new BufferedOutputStream(Files.newOutputStream(file, APPEND));
                    write = new BufferedWriter(new OutputStreamWriter(output));
                    write.write(na + " "+ ann);
                    write.newLine();
                    write.write(naa + " " + an );
                    write.newLine();
                    write.write(naag + " " + gee);
                    write.newLine();
                    write.flush();
                    write.close();
                    write.close();
                    }
                    catch(Exception x){
    }
                jf1.setText("");
                jf2.setText("");
                jf3.setText("");
            }
        }
        }
        if (e.getSource()==but2)
        {
            int dialogResult = JOptionPane.showConfirmDialog (null, "Are You Sure You Want to Delete?","Warning",dialogButton);
                if(dialogResult == 0) {
                int selectedRowIndex = table.getSelectedRow();
                model.removeRow(selectedRowIndex);
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
            }
        }
                if(e.getSource()==Exit){
                System.exit(0);
                }
                if(e.getSource()==dark){
                p.setBackground(Color.black);
                }
                if(e.getSource()==gray){
                p.setBackground(Color.gray);
                }
                if(e.getSource()==blue){
                p.setBackground(Color.blue);
                }
                if(e.getSource()==white){
                p.setBackground(Color.white);
                }

      
    }
    public void itemStateChanged(ItemEvent check)
    {
        if(jtb1.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals("")){
                try{
                 q1Int = Integer.parseInt(q1String);
                }catch(java.lang.NumberFormatException e){
                }
                finally{
                    if(q1Int==0.0){
                    String abb="You must input integer quantity";
                   JOptionPane.showMessageDialog(null,abb);
                }
                    p1 = q1Int * 20;
                model.addRow(new Object[]{"FRIED CHICKEN", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
                }
            }
            }
        if(jtb2.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"PORK CHOPS", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
                
            }
        }
        if(jtb3.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"Steak", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
                
            }
        }
         if(jtb4.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"PIZZA", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
                
            }
        }
          if(jtb5.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"SALAD", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
                
            }
        }
           if(jtb6.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"FRIES", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
                
            }
        }
           if(jtb7.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"Burger", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
                
            }
        }
           if(jtb8.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"Spaghetti", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
                
            }
        }
           if(jtb9.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"Hotdog", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
                
            }
        }
           if(jtb10.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"Bread", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                }
                
            }
        }
        if(rb1.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"Coke", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                group.clearSelection();
                }
                
            }
        }
        if(rb2.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"Sprite", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                    group.clearSelection();
                }
                
            }
        }
        if(rb3.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            
            int q1Int = 0;
            double p1 = 0.0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                p1 = q1Int * 20;
                model.addRow(new Object[]{"Royal", q1Int, p1});
                total = 0;
                jf1.setText("");
                for (int i = 0; i < model.getRowCount(); i++) {
                    total = total + Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText("" + total);
                    group.clearSelection();
                }
                
            }
        }
                
                   if(majorChoice.getSelectedItem().equals("Choose"))
                {
        }
                if(majorChoice.getSelectedItem().equals("Ice Cream"))
                {
                    String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            double price=20.00;
            int q1Int = 0;
            
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                price=price*q1Int;
                model.addRow(new Object[]{"Ice Cream",q1Int,price});
                
                total =0;
                for(int i=0; i<model.getRowCount(); i++)
                {
                    total=total+Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText(""+ String.format("%.2f", total));
                 
                }
                
                
            }
        }
                if(majorChoice.getSelectedItem().equals("Pie"))
                {
                    String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            double price=25.00;
            int q1Int = 0;
            
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                price=price*q1Int;
                model.addRow(new Object[]{"Pie",q1Int,price});
                
                total =0;
                for(int i=0; i<model.getRowCount(); i++)
                {
                    total=total+Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText(""+ String.format("%.2f", total));
                 
                }
                
                
            }
        }
           if(majorChoice.getSelectedItem().equals("Cake"))
                {
                    String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            double price=20.00;
            int q1Int = 0;
            
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                price=price*q1Int;
                model.addRow(new Object[]{"Cake",q1Int,price});
                
                total =0;
                for(int i=0; i<model.getRowCount(); i++)
                {
                    total=total+Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText(""+ String.format("%.2f", total));
                 
                }
                
                
            }
        }     
       
    }
    
    public static void main(String[] args) {
        JavaApplication1 run = new JavaApplication1();
        
    }
    
}