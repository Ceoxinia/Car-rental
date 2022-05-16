import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import keeptoo.KGradientPanel;

import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class login {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pst;
	
	ResultSet rs;
	
	
	public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/locDz", "root","mimi2001");
        }
        catch (ClassNotFoundException ex)
        {
          ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
 
    }

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

    
		
		
		
		KGradientPanel panel = new KGradientPanel();
		panel.kEndColor = new Color(176, 224, 230);
		panel.kStartColor = new Color(100, 149, 237);
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 800, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/marouakhemissi/Documents/locdz.png"));
		lblNewLabel.setBounds(270, 87, 524, 468);
		panel.add(lblNewLabel);
		
		username = new RoundJTextField(40);
		username.setBounds(20, 179, 242, 34);
		
		panel.add(username);
		
		password = new RoundJPasswordField(20);
		password.setColumns(10);
		password.setBackground(Color.WHITE);
		password.setBounds(20, 265, 242, 34);
		
		panel.add(password);
		
		JButton loginButt = new JButton("authenticate");
		loginButt.setFont(new Font("Open Sans", Font.BOLD, 13));
		loginButt.setBackground(new Color(176, 224, 230));
		loginButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Username = username.getText();
				String Password = password.getText();
				
				try {
					pst = con.prepareStatement("select username,password from user where username = ? and password = ? ");
					pst.setString(2, Password);
					pst.setString(1,Username);
					rs = pst.executeQuery();
				
					if(rs.next()==true) {
						if (Username.equals("admin")) {
							MainAdmin mainA = new MainAdmin();
							mainA.setVisible(true);
							frame.setVisible(false); 
							}
							
					 else {
						MainMenu MainM = new MainMenu();
						MainM.setVisible(true);
						frame.setVisible(false);	
						
					}
				}
					
					else {
						JOptionPane.showMessageDialog(null, "You entered the wrong password or username, please try again!"); }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		loginButt.setForeground(new Color(0, 0, 128));
		loginButt.setBounds(64, 340, 159, 34);
		loginButt.setOpaque(true);
		panel.add(loginButt);
		loginButt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 139)));
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setBounds(41, 151, 101, 16);

		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(new Color(51, 51, 204));
		lblNewLabel_3.setBounds(41, 103, 61, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("LocDZ");
		lblNewLabel_4.setFont(new Font("Savoye LET", Font.BOLD, 71));
		lblNewLabel_4.setForeground(new Color(204, 255, 255));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(420, 21, 223, 85);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setBounds(41, 237, 79, 16);
		panel.add(lblNewLabel_2);
	}
	public void setVisible(boolean b) {
		if (true) {
		frame.setVisible(true); }
}
}
