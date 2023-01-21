import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Purchase1 {

	private JFrame frame;
	private JTable t;
	/**
	 * Launch the application.
	 */
	public static String selected=null;
	public void buy() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase1 window = new Purchase1();
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
	public Purchase1() {
		initialize();
		connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection con; 
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect() {
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
		frame.setBounds(100, 100, 876, 626);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select a Car Company ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(40, 22, 207, 45);
		frame.getContentPane().add(lblNewLabel);
		
		Choice c = new Choice();
		c.setFont(new Font("Dialog", Font.PLAIN, 15));
		c.setBounds(40, 73, 100, 24);
		frame.getContentPane().add(c);
		
		try {
			BufferedReader p = new BufferedReader(new FileReader("Cars.txt"));
			String str="";
			while(true)
			{
				str = p.readLine();
				if(str == null) break;
				else
					c.add(str);
			}
			p.close();
		}
		
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error in loading the car list to the choice field!!");
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 180, 780, 309);
		frame.getContentPane().add(scrollPane);
		
		t = new JTable();
		scrollPane.setViewportView(t);
		t.setCellSelectionEnabled(true);
		ListSelectionModel select= t.getSelectionModel();  
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		c.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String str=null;
				try {
					str = c.getSelectedItem();
					pst = con.prepareStatement("SELECT model,company,price,kmrun,carno FROM car WHERE company = ?");
					pst.setString(1, str);
					rs = pst.executeQuery();
					t.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
					pst.close();
					rs.close();
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error in loading data from the DataBase!!");
					e1.printStackTrace();
				}
					
					
				
			}
		});
		
		select.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent e) {  
        		 
                int row = t.getSelectedRow();  
                int column = t.getSelectedColumn();
                selected = (String)t.getValueAt(row, column);
              }       
            });
		
		JLabel lblNewLabel_1 = new JLabel("Select your Car");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 132, 151, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton prbutt = new JButton("Proceed");
		prbutt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Transfer obj = new Transfer();
	                obj.congrats();
			}
		});
		prbutt.setFont(new Font("Tahoma", Font.BOLD, 15));
		prbutt.setBounds(720, 517, 100, 40);
		frame.getContentPane().add(prbutt);
	}
}
