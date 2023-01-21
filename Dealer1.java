import java.awt.EventQueue;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Dealer1 {

	private JFrame frame;
	private JTextField ntxt;
	private JTextField ptxt;
	private JTextField ctxt;
	private JTextField mtxt;
	private JTextField btxt;
	private JTextField stxt;
	private JTextField kmtxt;
	private JTextField numtxt;
	private JTextField ytxt;
	private JTextField abc;
	
	public static String number = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dealer1 window = new Dealer1();
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
	public Dealer1() {
		initialize();
		connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	Connection con;
	PreparedStatement pst;
	
	void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership","root","Mysql@123$");
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error in connecting to the DataBase!!");
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 843, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Car Dealership");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(310, 11, 299, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(30, 100, 93, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		ntxt = new JTextField();
		ntxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ntxt.setBounds(100, 100, 150, 35);
		frame.getContentPane().add(ntxt);
		ntxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(30, 161, 78, 57);
		frame.getContentPane().add(lblNewLabel_2);
		
		ptxt = new JTextField();
		ptxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ptxt.setBounds(100, 175, 150, 35);
		frame.getContentPane().add(ptxt);
		ptxt.setColumns(10);
		
		ctxt = new JTextField();
		ctxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ctxt.setBounds(100, 250, 150, 35);
		frame.getContentPane().add(ctxt);
		ctxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Car");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(30, 252, 60, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		mtxt = new JTextField();
		mtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mtxt.setBounds(100, 325, 150, 35);
		frame.getContentPane().add(mtxt);
		mtxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Model");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(30, 327, 60, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Buying price");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(300, 96, 167, 36);
		frame.getContentPane().add(lblNewLabel_5);
		
		btxt = new JTextField();
		btxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btxt.setBounds(425, 100, 150, 35);
		frame.getContentPane().add(btxt);
		btxt.setColumns(10);
		
		stxt = new JTextField();
		stxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stxt.setBounds(425, 175, 150, 35);
		frame.getContentPane().add(stxt);
		stxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sale price ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(300, 173, 109, 33);
		frame.getContentPane().add(lblNewLabel_6);
		
		kmtxt = new JTextField();
		kmtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		kmtxt.setBounds(425, 250, 150, 35);
		frame.getContentPane().add(kmtxt);
		kmtxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Car number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(300, 321, 109, 36);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Km run");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_8.setBounds(300, 252, 93, 25);
		frame.getContentPane().add(lblNewLabel_8);
		
		numtxt = new JTextField();
		numtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		numtxt.setBounds(575, 325, 110, 35);
		frame.getContentPane().add(numtxt);
		numtxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Year of purchase");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_9.setBounds(100, 398, 160, 33);
		frame.getContentPane().add(lblNewLabel_9);
		
		ytxt = new JTextField();
		ytxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ytxt.setBounds(270, 400, 150, 35);
		frame.getContentPane().add(ytxt);
		ytxt.setColumns(10);
		
		Choice st = new Choice();
		st.setFont(new Font("Dialog", Font.PLAIN, 14));
		st.setBounds(425, 325, 60, 35);
		frame.getContentPane().add(st);
		
		try {
			BufferedReader p3 = new BufferedReader(new FileReader("Codes.txt"));
			while(true) {
				String str = p3.readLine();
				if(str == null) break;
				st.add(str);
			}
			p3.close();
		}
		
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error in loading State codes!!");
		}
		
		st.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				number = st.getSelectedItem()+"-"+abc.getText()+"-"+numtxt.getText();
			}
		});
		
		JButton sbutt = new JButton("Save");
		sbutt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PrintWriter p = new PrintWriter(new FileWriter("Data.txt",true));
					Calendar c = Calendar.getInstance();
					
					
					p.println("----------------------------------------------------------------------------");
					p.println("                           "+c.getTime());
					p.println("Name :"+ntxt.getText());
					String cname = ntxt.getText();
					p.println("Phone :"+ptxt.getText());
					String phno = ptxt.getText();
					p.println("Car Company :"+ctxt.getText());
					String comp = ctxt.getText().toLowerCase();
					p.println("Car Model :"+mtxt.getText());
					String model = mtxt.getText().toLowerCase();
					p.println("Buying price :"+btxt.getText());
					p.println("Sale price :"+stxt.getText());
					int sale = Integer.parseInt(stxt.getText());
					p.println("Year of Purchase :"+ytxt.getText());
					p.println("Car number :"+number);
					p.println("Kilometers run :"+kmtxt.getText());
					int km = Integer.parseInt(kmtxt.getText());
					p.close();
					
					BufferedReader p1 = new BufferedReader(new FileReader("Cars.txt"));
					boolean flag = false;
					
					while(true) {
						String str = p1.readLine();
						if(str == null) break;
						if(str.equals(comp)) {
							flag = true;
							break;
						}
					}
					p1.close();
					
					PrintWriter p2 = new PrintWriter(new FileWriter("Cars.txt",true));
					if(flag == false) {
						p2.println(comp);
					}
					p2.close();
					
					pst = con.prepareStatement("INSERT INTO car(model,company,price,kmrun,carno,name,phone) VALUES(?,?,?,?,?,?,?)");
					pst.setString(1, model);
					pst.setString(2, comp);
					pst.setInt(3, sale);
					pst.setInt(4, km);
					pst.setString(5, number);
					pst.setString(6, cname);
					pst.setString(7, phno);
					int n = pst.executeUpdate();
					
					ntxt.setText("");
					ptxt.setText("");
					ctxt.setText("");
					mtxt.setText("");
					ytxt.setText("");
					numtxt.setText("");
					btxt.setText("");
					stxt.setText("");
					kmtxt.setText("");
					abc.setText("");
					//st.requestFocus();
					st.requestFocusInWindow();
					ntxt.requestFocus();
					
					JOptionPane.showMessageDialog(null, "Record saved Successfully!!: "+n);
					con.close();
					pst.close();
				}
				
				catch(NumberFormatException e2)
				{
					JOptionPane.showMessageDialog(null, "Error!!\nPlease input valid data");
					System.exit(0);
				}
				catch(IOException a) {
					JOptionPane.showMessageDialog(null, "Error in inserting the record!!");
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error in updating the Database!!");
				}
			}
		});
		
		sbutt.setFont(new Font("Tahoma", Font.BOLD, 17));
		sbutt.setBounds(650, 175, 80, 35);
		frame.getContentPane().add(sbutt);
		
		JButton bbutt = new JButton("Buy");
		bbutt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Purchase1 obj = new Purchase1();
				obj.buy();
			}
		});
		bbutt.setFont(new Font("Tahoma", Font.BOLD, 17));
		bbutt.setBounds(650, 250, 80, 35);
		frame.getContentPane().add(bbutt);
		
		abc = new JTextField();
		abc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		abc.setColumns(10);
		abc.setBounds(506, 325, 50, 35);
		frame.getContentPane().add(abc);
	}
}
