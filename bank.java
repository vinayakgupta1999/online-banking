import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Bank implements ActionListener
      {
	//for main Frame
	JFrame f1,f3,f4,f5,f6,f7,f8;
	JButton b11,b12;
	
	
	//for new account frame
	JLabel l21,l22,l23,l24,l25;
	JTextField t21,t22,t23,t24,t25;
	JButton b21,b22;
    JFrame f2;
    
    //for login frame
    JLabel l31,l32;
    JTextField t31,t32;  
        JButton b31;
    
        //for operation frame
        JButton b41,b42,b43,b44,b45;
     
        //for deposit frame
	JLabel l51;
	JTextField t51;
	JButton b51,b52,b53;
	
	
	//for withdraw frame
	
		JLabel l61;
		JTextField t61;
		JButton b61,b62,b63;
		
		
		//for money transfer frame
		
			JLabel l71,l72;
			JTextField t71,t72;
			JButton b71,b72,b73;
		
		//for balance check
			JLabel l81;
			JButton b81,b82;
			
			
			
	
			Connection co;
			PreparedStatement ps;
			ResultSet rs;
			
	Bank()
	{
		//frame1
		f1=new JFrame("MY BANK");
		b11=new JButton("New user");
		b12=new JButton("Existing user");
		Container c=f1.getContentPane();
		c.setLayout(null);
		b11.setBounds(230,150,200,80);
		b12.setBounds(230,270,200,80);
		Font font = new Font("Serif",Font.BOLD,20);
		b11.setFont(font);
		b12.setFont(font);
		c.add(b11);	
        c.add(b12);
        b11.addActionListener(this);
        b12.addActionListener(this);
        f1.setSize(600,500);
       f1.setVisible(true);
        
        
        //for frame2
        f2=new JFrame("New Account");
        l21=new JLabel("Name");
        l22=new JLabel("Password");
        l23=new JLabel("Phone no.");
        l24=new JLabel("City");
        l25=new JLabel("Ammount");
        t21=new JTextField();
        t22=new JTextField();
        t23=new JTextField();
        t24=new JTextField();
        t25=new JTextField();
        b21=new JButton("OK");
        b22=new JButton("Cancel");
        b21.setFont(font);
        l21.setFont(font);
        l22.setFont(font);
        l23.setFont(font);
        l24.setFont(font);
        t21.setFont(font);
        t22.setFont(font);
        t23.setFont(font);
        t24.setFont(font);
        l25.setFont(font);
        t25.setFont(font);
        b22.setFont(font);
        Container c1=f2.getContentPane();
	c1.setLayout(null);
        l21.setBounds(100,50,100,50);
        t21.setBounds(230,50,150,50);
        l22.setBounds(100,130,100,50);
        t22.setBounds(230,130,150,50);
        l23.setBounds(100,200,100,50);
        t23.setBounds(230,200,150,50);
        l24.setBounds(100,280,100,50);
        t24.setBounds(230,280,150,50);
        l25.setBounds(100,360,100,50);
        t25.setBounds(230,360,150,50);
        b21.setBounds(180,440,80,50);
        b22.setBounds(290,440,110,50);
        c1.add(l21);
        c1.add(l22);
        c1.add(l23);
        c1.add(l24);
        c1.add(t21);
        c1.add(t22);
        c1.add(t23);
        c1.add(t24);
        c1.add(b21);
        c1.add(l25);
        c1.add(t25);
        c1.add(b22);
        b21.addActionListener(this);
        b22.addActionListener(this);
        f2.setSize(600,600);
        
        
        
        
        // for frame3
        f3=new JFrame("Login");
        l31=new JLabel("Account No.");
        l32=new JLabel("Password");
        t31=new JTextField();
        t32=new JTextField();
        b31=new JButton("Signin");
        l31.setFont(font);
        l32.setFont(font);
        t31.setFont(font);
        t32.setFont(font);
        b31.setFont(font);
        Container c3=f3.getContentPane();
        c3.setLayout(null);
        l31.setBounds(100,100,150,50);
        t31.setBounds(280,100,150,50);
        l32.setBounds(100,180,150,50);
        t32.setBounds(280,180,150,50);
        b31.setBounds(180,260,140,50);
        c3.add(l31);
        c3.add(l32);
        c3.add(t31);
        c3.add(t32);
        c3.add(b31);
        b31.addActionListener(this);
        f3.setSize(500,500);
        
        
        
        //for Frame4 (Operation)
        f4=new JFrame("Select Operation");
        b41=new JButton("Deposite");
        b42=new JButton("Widthraw");
        b43=new JButton("Transfer");
        b44=new JButton("Check balance");
        b45=new JButton("Quite");
        b41.setFont(font);
        b42.setFont(font);
        b43.setFont(font);
        b44.setFont(font);
        b45.setFont(font);
        Container c4=f4.getContentPane();
        c4.setLayout(null);
        b41.setBounds(130,100,200,80);
        b42.setBounds(130,210,200,80);
        b43.setBounds(130,320,200,80);
        b44.setBounds(130,430,200,80);
        b45.setBounds(168,540,100,80);
        c4.add(b41);
        c4.add(b42);
        c4.add(b43);
        c4.add(b44);
        c4.add(b45);
        b41.addActionListener(this);
        b42.addActionListener(this);
        b43.addActionListener(this);
        b44.addActionListener(this);
        b45.addActionListener(this);
        f4.setSize(550,680);
        
        
        
        
        // Deposit frame
        f5=new JFrame("Deposit");
        l51=new JLabel("Ammount");
        t51=new JTextField();
        b51=new JButton("Deposite");
        b52=new JButton("Back");
        b53=new JButton("Quite");
        b51.setFont(font);
        b52.setFont(font);
        b53.setFont(font);
        t51.setFont(font);
        l51.setFont(font);
        Container c5=f5.getContentPane();
        c5.setLayout(null);
        l51.setBounds(100,100,150,50);
        t51.setBounds(220,100,150,50);
        b51.setBounds(100,200,120,50);
        b52.setBounds(230,200,120,50);
        b53.setBounds(170,260,120,50);
        c5.add(l51);
        c5.add(t51);
        c5.add(b51);
        c5.add(b52);
        c5.add(b53);
        b51.addActionListener(this);
        b52.addActionListener(this);
        b53.addActionListener(this);
        f5.setSize(500,500);
        
        
        
        // widhraw frame
        
        f6=new JFrame("Widhraw");
        l61=new JLabel("Ammount");
        t61=new JTextField();
        b61=new JButton("Withraw");
        b62=new JButton("Back");
        b63=new JButton("Quite");
        b61.setFont(font);
        b62.setFont(font);
        b63.setFont(font);
        t61.setFont(font);
        l61.setFont(font);
        Container c6=f6.getContentPane();
        c6.setLayout(null);
        l61.setBounds(100,100,150,50);
        t61.setBounds(220,100,150,50);
        b61.setBounds(100,200,120,50);
        b62.setBounds(230,200,120,50);
        b63.setBounds(170,260,120,50);
        c6.add(l61);
        c6.add(t61);
        c6.add(b61);
        c6.add(b62);
        c6.add(b63);
        b61.addActionListener(this);
        b62.addActionListener(this);
        b63.addActionListener(this);
        f6.setSize(500,500);
        
        
        
        //transfer
        f7=new JFrame("Transfer");
        l71=new JLabel("Ammount");
        l72=new JLabel("To");
        t71=new JTextField();
        t72=new JTextField();
        b71=new JButton("Transfer");
        b72=new JButton("Back");
        b73=new JButton("Quite");
        b71.setFont(font);
        b72.setFont(font);
        b73.setFont(font);
        t71.setFont(font);
        l71.setFont(font);
        l72.setFont(font);
        t72.setFont(font);
        Container c7=f7.getContentPane();
        c7.setLayout(null);
        l71.setBounds(100,100,150,50);
        t71.setBounds(220,100,150,50);
        l72.setBounds(100,180,150,50);
        t72.setBounds(220,180,150,50);
        b71.setBounds(100,300,120,50);
        b72.setBounds(230,300,120,50);
        b73.setBounds(170,380,120,50);
        c7.add(l71);
        c7.add(l72);
        c7.add(t72);
        c7.add(t71);
        c7.add(b71);
        c7.add(b72);
        c7.add(b73);
        c7.add(b72);
        b71.addActionListener(this);
        b72.addActionListener(this);
        b73.addActionListener(this);
        f7.setSize(500,500);
        
        
        
        //for balance check frame
        f8=new JFrame("Balance check");
        l81=new JLabel();
        b81=new JButton("Back");
        b82=new JButton("Quite");
        Font font1 = new Font("Serif",Font.BOLD,40);
        l81.setFont(font1);
        b81.setFont(font);
        b82.setFont(font);
        Container c8=f8.getContentPane();
        c8.setLayout(null);
        l81.setBounds(145,100,250,150);
        b81.setBounds(100,280,100,50);
        b82.setBounds(230,280,100,50);
        c8.add(l81);
        c8.add(b81);
        c8.add(b82);
        b81.addActionListener(this);
        b82.addActionListener(this);
        f8.setSize(500,500);
        
        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	co=DriverManager.getConnection("jdbc:mysql://localhost:3306/mybank","root",null);
        }
        catch(Exception e)
        {
        	System.out.println("Exception1"+e);
        }
   }
	public void actionPerformed(ActionEvent e1)
	{
		if(e1.getSource()==b11)
		{
			t21.setText("");
			t22.setText("");
			t23.setText("");
			t24.setText("");
			t25.setText("");
			f2.setVisible(true);
			f1.setVisible(false);
		}
		else if(e1.getSource()==b12)
		{ 
			t31.setText("");
			t32.setText("");
			f3.setVisible(true);
			f1.setVisible(false);
		}
		else if(e1.getSource()==b22)
		{
			f2.setVisible(false);
			f1.setVisible(true);
		}
		else if(e1.getSource()==b21)
		{
			String s1=t21.getText();
			String s2=t22.getText();
			String s3=t23.getText();
			String s4=t24.getText();
			String s41=t25.getText();
			
			String s5="";
			int d=0;
                     try
			{
        	 ps=co.prepareStatement("select * from mybank where phoneno=?");
        	 ps.setInt(1,Integer.parseInt(s3));
        	 rs=ps.executeQuery();
        	 while(rs.next())
        	 {
        		 d=1;
        		 }
        	 if(d==1)
        	
        		 {
        		 JOptionPane.showMessageDialog(f2,"Try another number this number is already exists","Account Box",JOptionPane.INFORMATION_MESSAGE);
        		 
        	ps.close();	 
        		 }
        	 else
        	 {
        	 ps=co.prepareStatement("insert into mybank(name,password,phoneno,city,balance) values(?,?,?,?,?)");
        	 ps.setString(1,s1);
        	 ps.setString(2,s2);
        	 ps.setInt(3,Integer.parseInt(s3));
        	 ps.setString(4,s4);
        	 ps.setInt(5,Integer.parseInt(s41));
        	 ps.executeUpdate();
        	 ps.close();
        	 ps=co.prepareStatement("select count(*) from mybank");
        	 rs=ps.executeQuery();
        	 while(rs.next())
        	 {
        		 s5=rs.getString(1);
        		 }
        	 if(Integer.parseInt(s41)<500)
    		 {
    			 JOptionPane.showMessageDialog(f2,"Please give ammount more then 500","Account Box",JOptionPane.INFORMATION_MESSAGE);
    			 
    		 }
        	 else
        	 JOptionPane.showMessageDialog(f2,"Your account no."+s5,"Account Box",JOptionPane.INFORMATION_MESSAGE);
        	 ps.close();
        	 }
			}
        	 catch(Exception e3)
			{
				System.out.println("Exception2"+e3);
			}
         f2.setVisible(false);
         f1.setVisible(true);
		}
		else if(e1.getSource()==b31)
		{
			String s1=t31.getText();
			String s2=t32.getText();
			String st="";
			int c=0;
			try
			{
				ps=co.prepareStatement("select * from mybank where Acno=?");
				ps.setInt(1,Integer.parseInt(s1));
				rs=ps.executeQuery();
				while(rs.next())
				{
					c=1;
					st=rs.getString(2);
				}
				if(c==1)
				{
					if(st.equals(s2))
					{
						JOptionPane.showMessageDialog(f3,"Succesfully signin","Account info",JOptionPane.INFORMATION_MESSAGE);
						f3.setVisible(false);
						f4.setVisible(true);
	                }
					else
						JOptionPane.showMessageDialog(f3,"Password wrong","Account info",JOptionPane.INFORMATION_MESSAGE);	
						}
				else
	
				JOptionPane.showMessageDialog(f3,"You have no Account","Account info",JOptionPane.INFORMATION_MESSAGE);
			rs.close();
			ps.close();
			}
			catch(Exception e4)
			{
				System.out.println("Exception3>"+e4);
			}
			}
		else if(e1.getSource()==b41)
		{ 
			t51.setText("");
			f4.setVisible(false);
			f5.setVisible(true);
		}
		else if(e1.getSource()==b42)
		{
			t61.setText("");
			f4.setVisible(false);
			f6.setVisible(true);
		}
		else if(e1.getSource()==b43)
		{ 
			t71.setText("");
			t72.setText("");
			f4.setVisible(false);
			f7.setVisible(true);
		}
		else if(e1.getSource()==b44)
		{
			String s1="";
			String s2=t31.getText();
			try
			{
				ps=co.prepareStatement("select balance from mybank where Acno=?");
				ps.setInt(1,Integer.parseInt(s2));
				rs=ps.executeQuery();
				while(rs.next())
				{
				s1=rs.getString("balance");
				}
				ps.close();
				l81.setText(s1);
			}catch(Exception ee1)
			{
				System.out.println("Exception5"+ee1);
			}
			f4.setVisible(false);
			f8.setVisible(true);
		}
		else if(e1.getSource()==b45)
		{
			System.exit(0);
		}
		else if(e1.getSource()==b51)
		{
			String s1=t51.getText();
			String s2="Deposit";
			try
			{
			ps=co.prepareStatement("update mybank set balance=balance+? where Acno=?");
			ps.setInt(1,Integer.parseInt(s1));
			ps.setInt(2,Integer.parseInt(t31.getText()));
			ps.executeUpdate();
			ps.close();
			ps=co.prepareStatement("insert into detail(ammount,fromac,toac,type) values(?,?,?,?)");
			ps.setInt(1,Integer.parseInt(t51.getText()));
			ps.setInt(2,Integer.parseInt(t31.getText()));
			ps.setInt(3,Integer.parseInt(t31.getText()));
			ps.setString(4,s2);
			ps.executeUpdate();
			ps.close();
			}
			catch(Exception e5)
			{
				System.out.println("Exception6"+e5);
			}
		}
		else if(e1.getSource()==b52)
		{
			f5.setVisible(false);
			f4.setVisible(true);
			}
		else if(e1.getSource()==b53)
		{
			System.exit(0);
		}
		else if(e1.getSource()==b61)
		{
			String s1=t61.getText();
			String s2="Witdraw";
			try
			{
				ps=co.prepareStatement("update mybank set balance=balance-? where Acno=?");
				ps.setInt(1,Integer.parseInt(s1));
				ps.setInt(2,Integer.parseInt(t31.getText()));
				ps.executeUpdate();
				ps.close();
				ps=co.prepareStatement("insert into detail(ammount,fromac,toac,type) values(?,?,?,?)");
				ps.setInt(1,Integer.parseInt(t61.getText()));
				ps.setInt(2,Integer.parseInt(t31.getText()));
				ps.setInt(3,Integer.parseInt(t31.getText()));
				ps.setString(4,s2);
				ps.executeUpdate();
				ps.close();
			}
			catch(Exception e6)
			{
				System.out.println("Exception7"+e6);
			}
		}
		else if(e1.getSource()==b62)
		{
			f6.setVisible(false);
			f4.setVisible(true);
		}
		
		else if(e1.getSource()==b63)
		{
			System.exit(0);
		}
		else if(e1.getSource()==b71)
		{
			String s1=t31.getText();
			String s2="";
			String s3=t71.getText();
			String s4=t72.getText();
			String s5="Transfer";
			int tot;
			try
			{
				ps=co.prepareStatement("select balance from mybank where Acno=?");
				ps.setInt(1,Integer.parseInt(s1));
				rs=ps.executeQuery();
				while(rs.next())
				{
				s2=rs.getString("balance");
				}
				ps.close();
				tot=Integer.parseInt(s2)-Integer.parseInt(s3);
			   if(tot<0)
			   {
				   JOptionPane.showMessageDialog(f7,"You have no sufficient balance for this operation","Balance info",JOptionPane.ERROR_MESSAGE);
			   }
			   else
			   {
				   ps=co.prepareStatement("update mybank set balance=balance-? where Acno=?");
				   ps.setInt(1,Integer.parseInt(s3));
				   ps.setInt(2,Integer.parseInt(t31.getText()));
				   ps.executeUpdate();
				   ps.close();
				   ps=co.prepareStatement("update mybank set balance=balance+? where Acno=?");
				   ps.setInt(1,Integer.parseInt(s3));
				   ps.setInt(2,Integer.parseInt(s4));
				   ps.executeUpdate();
				   ps.close();
				   ps=co.prepareStatement("insert into detail(ammount,fromac,toac,type) values(?,?,?,?)");
				   ps.setInt(1,Integer.parseInt(s3));
				   ps.setInt(2,Integer.parseInt(t31.getText()));
				   ps.setInt(3,Integer.parseInt(s4));
				   ps.setString(4,s5);
				   ps.executeUpdate();
				   ps.close();
				   
			   }
				   
				
			}
			catch(Exception e7)
			{
				System.out.println("Exception8"+e7);
			}
		}
		else if(e1.getSource()==b72)
		{
			f7.setVisible(false);
			f4.setVisible(true);
}
		else if(e1.getSource()==b73)
		{
			System.exit(0);
		}
		else if(e1.getSource()==b81)
		{
			f8.setVisible(false);
			f4.setVisible(true);
		}
		else if(e1.getSource()==b82)
		{
			System.exit(0);
		}
		
		
}
	public static void main(String ar[])
	{
	 	new Bank();
	}

}
