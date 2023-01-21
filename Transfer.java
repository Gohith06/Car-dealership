import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Transfer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	private JTextField nametxt;
	private JTextField phtxt;
	private JTextField cartxt;
	private JTextField motxt;
	private JTextField prtxt;
	private JTextField krtxt;
	private JTextField cntxt;
	public void congrats() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer window = new Transfer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transfer() {
		initialize();
		connect();
		load();
	}
	
	Connection con; 
	PreparedStatement pst;
	ResultSet rs;
	
	void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership","root","Mysql@123$");
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error in connecting to the DataBase!!");
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	void load()
	{
		try {
			String name;
			String comp;
			String model;
			int sale;
			int km;
			String phno;
			String s = Purchase1.selected;
			pst = con.prepareStatement("SELECT * FROM car WHERE carno = ?");
			pst.setString(1, s);
			rs = pst.executeQuery();
			rs.next();
				model = rs.getString(1);
				comp = rs.getString(2);
				sale = rs.getInt(3);
				km = rs.getInt(4);
				name = rs.getString(6);
				phno = rs.getString(7);
				
			PrintWriter p1 = new PrintWriter(new FileWriter("Records.txt",true));
			p1.println("----------------------------------------------------------------------------");
			p1.println("                           "+Calendar.getInstance().getTime());
			p1.println("SOLD TO :");
			p1.println("Name :"+name+"------------>"+name);
			p1.println("Phone :"+phno);	
			p1.println("Car company :"+cartxt.getText());
			p1.println("Model :"+model);
			p1.println("Km run :"+km);
			p1.println("Price :"+sale);
			p1.println("Car number :"+s);
			p1.close();
			
			nametxt.setText(name);
			phtxt.setText(phno);
			cartxt.setText(comp);
			motxt.setText(model);
			prtxt.setText(String.valueOf(sale));
			krtxt.setText(String.valueOf(km));
			cntxt.setText(s);
		}
	
		catch(IOException f) {
			f.printStackTrace();
		}
	
		catch(SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error in loading data from the DataBase!!");
			e1.printStackTrace();
		}
	}
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 645, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(30, 100, 65, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		nametxt = new JTextField();
		nametxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nametxt.setBounds(100, 100, 150, 35);
		frame.getContentPane().add(nametxt);
		nametxt.setColumns(10);
		
		phtxt = new JTextField();
		phtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phtxt.setBounds(100, 175, 150, 35);
		frame.getContentPane().add(phtxt);
		phtxt.setColumns(10);
		
		cartxt = new JTextField();
		cartxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cartxt.setBounds(100, 250, 150, 35);
		frame.getContentPane().add(cartxt);
		cartxt.setColumns(10);
		
		motxt = new JTextField();
		motxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		motxt.setBounds(100, 325, 150, 35);
		frame.getContentPane().add(motxt);
		motxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(30, 175, 77, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Car");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(30, 252, 65, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Model");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(30, 323, 65, 33);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(300, 100, 77, 36);
		frame.getContentPane().add(lblNewLabel_5);
		
		prtxt = new JTextField();
		prtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prtxt.setBounds(425, 100, 150, 35);
		frame.getContentPane().add(prtxt);
		prtxt.setColumns(10);
		
		krtxt = new JTextField();
		krtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		krtxt.setBounds(425, 175, 150, 35);
		frame.getContentPane().add(krtxt);
		krtxt.setColumns(10);
		
		cntxt = new JTextField();
		cntxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cntxt.setBounds(425, 250, 150, 35);
		frame.getContentPane().add(cntxt);
		cntxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Km run");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(300, 177, 77, 24);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Car number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(300, 246, 107, 36);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("Purchase");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(253, 11, 299, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton pbutt = new JButton("Purchase");
		pbutt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					try {
						pst = con.prepareStatement("DELETE FROM car WHERE carno = ?");
						pst.setString(1, cntxt.getText());
						pst.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Purchase Successfull!!");
						
						nametxt.setText("");
						phtxt.setText("");
						cartxt.setText("");
						motxt.setText("");
						prtxt.setText("");
						krtxt.setText("");
						cntxt.setText("");
						con.close();
						pst.close();
						rs.close();
					}
					catch(SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error in Deleting data from the DataBase!!");
						e1.printStackTrace();
					}
					
			}
		});
		pbutt.setFont(new Font("Tahoma", Font.BOLD, 17));
		pbutt.setBounds(459, 372, 116, 36);
		frame.getContentPane().add(pbutt);
	}
}
