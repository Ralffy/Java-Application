package javaapplication3;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;



public class JavaApplication3 implements ItemListener, ActionListener, KeyListener{

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JButton but1 = new JButton("PAY");
    JTextField jf1 = new JTextField("");
    JTextField jf2 = new JTextField("");
    JTextField jf3 = new JTextField("");
    
    JToggleButton jtb1 = new JToggleButton("Coke", false);
    JToggleButton jtb2 = new JToggleButton("Sprite", false);
    JToggleButton jtb3 = new JToggleButton("Royal", false);
    
    JButton but2 = new JButton("Delete");
    
    JRadioButton rb1 = new JRadioButton("Coke");
    JRadioButton rb2 = new JRadioButton("Sprite");
    JRadioButton rb3 = new JRadioButton("Royal");
    
    ButtonGroup group = new ButtonGroup();
   
    
    String cWord;
    double pay, amount;
    
    int dialogButton = JOptionPane.YES_NO_OPTION;
    
    public JavaApplication3()
    {
        super();
        p.setLayout(null);
        
        
        f.setSize(600, 460);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        model.addColumn("Order Name");
        model.addColumn("Quantity");
        model.addColumn("Price");
        
        but1.setBounds(340, 350, 100, 50);
        but2.setBounds(220, 280, 100, 50);
        scrollPane.setBounds(220, 20, 340, 250);
        jf1.setBounds(460, 280, 100, 50);
        jf2.setBounds(460, 335, 100, 30);
        jf3.setBounds(460, 370, 100, 30);
        jtb1.setBounds(20, 20, 80, 60);
        jtb2.setBounds(100, 20, 80, 60);
        jtb3.setBounds(20, 80, 80, 60);
        
        rb1.setBounds(20,200,60,30);
        rb2.setBounds(80,200,60,30);
        rb3.setBounds(140,200,60,30);
        
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        
        group.add(rb1); 
        group.add(rb2);       
        group.add(rb3);
       
        p.add(rb1);
        p.add(rb2);
        p.add(rb3);
        
        
        p.add(jf1);
        p.add(jf2);
        p.add(jf3);
        p.add(scrollPane);
        p.add(but1);
        p.add(but2);
        p.add(jtb1);
        p.add(jtb2);
        p.add(jtb3);
        
        
        f.add(p);
        
        but1.addActionListener(this);
        but2.addActionListener(this);
        
        jf2.addKeyListener(this);
        
        jtb1.addItemListener(this);
        jtb2.addItemListener(this); 
        jtb3.addItemListener(this);
        
        rb1.addItemListener(this);
        rb2.addItemListener(this);
         rb3.addItemListener(this);
         
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
                double change = pay - amount;
                jf3.setText("" + String.format("%.2f", change));
            }
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==but1)
        {
            int dialogResult = JOptionPane.showConfirmDialog (null, "Transaction Finished?","Warning",dialogButton);
            if(dialogResult == 0) {
                model.setRowCount(0);
                
                jf1.setText("");
                jf2.setText("");
                jf3.setText("");
            }
        }
        if (e.getSource()==but2)
        {
            int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to delete?","Warning",dialogButton);
            if(dialogResult == 0) {
            
            int selectedRowIndex = table.getSelectedRow();
            double price = Double.parseDouble(model.getValueAt(selectedRowIndex,2).toString());
            total = total-price;
            jf1.setText(""+ String.format("%.2f", total));
            model.removeRow(selectedRowIndex);
            
            }
        }
    }
    
    double total;
    
    public void itemStateChanged(ItemEvent check)
    {
        if(jtb1.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            double price=20.00;
            int q1Int = 0;
            
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                price=price*q1Int;
                model.addRow(new Object[]{"Coke",q1Int,price});
                
                total =0;
                for(int i=0; i<model.getRowCount(); i++)
                {
                    total=total+Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText(""+ String.format("%.2f", total));
                 
                }
            }
        }
         if(jtb2.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            double price = 25.00;
            int q1Int = 0;
            if(!q1String.equals(""))
            {
                q1Int = Integer.parseInt(q1String);
                price= price*q1Int;
                model.addRow(new Object[]{"Sprite",q1Int,price});
                
                total =0;
                for(int i=0; i<model.getRowCount(); i++)
                {
                    total=total+Double.parseDouble(model.getValueAt(i, 2).toString());
                     jf1.setText(""+ String.format("%.2f", total));
                 
                }
            }
        }
        
          if(jtb3.isSelected())
        {
            String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            double price= 30.00;
            int q1Int = 0;
            if(!q1String.equals(""))
            {
                
                
                q1Int = Integer.parseInt(q1String);
                price = price*q1Int;
                model.addRow(new Object[]{"Royal",q1Int,price});
                
                total =0;
                 for(int i=0; i<model.getRowCount(); i++)
                {
                    total=total+Double.parseDouble(model.getValueAt(i, 2).toString());
                     jf1.setText(""+ String.format("%.2f", total));
                 
                }
                
            }
        }
        
        if(rb1.isSelected()){
            
              String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            double price=20.00;
            int q1Int = 0;
            
            if(!q1String.equals(""))
                
            {
                q1Int = Integer.parseInt(q1String);
                price=price*q1Int;
                model.addRow(new Object[]{"Coke",q1Int,price});
                
                total =0;
                for(int i=0; i<model.getRowCount(); i++)
                {
                    total=total+Double.parseDouble(model.getValueAt(i, 2).toString());
                    jf1.setText(""+ String.format("%.2f", total));
                }
            }
        }
          
        if(rb2.isSelected()){
             String q1String = JOptionPane.showInputDialog("Enter Quantity:");
             
            double price = 25.00;
            int q1Int = 0;
            if(!q1String.equals(""))
                
            {
                q1Int = Integer.parseInt(q1String);
                price= price*q1Int;
                model.addRow(new Object[]{"Sprite",q1Int,price});
                
                 total =0;
                for(int i=0; i<model.getRowCount(); i++)
                {
                    total=total+Double.parseDouble(model.getValueAt(i, 2).toString());
                     jf1.setText(""+ String.format("%.2f", total));
                 
                }
            }
        }
        
        if(rb3.isSelected())
        {
          String q1String = JOptionPane.showInputDialog("Enter Quantity:");
            double price= 30.00;
            int q1Int = 0;
            if(!q1String.equals(""))
                
            {
                q1Int = Integer.parseInt(q1String);
                price = price*q1Int;
                model.addRow(new Object[]{"Royal",q1Int,price});
                
                total=0;
                 for(int i=0; i<model.getRowCount(); i++)
                {
                    total=total+Double.parseDouble(model.getValueAt(i, 2).toString());
                     jf1.setText(""+ String.format("%.2f", total));
                 
                }
            }  
        }
        
    }
    
    public static void main(String[] args) {
        JavaApplication3 run = new JavaApplication3();
        
    }
    
}
