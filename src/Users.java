import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import keeptoo.KGradientPanel;
import net.proteanit.sql.DbUtils;

public class Users {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField nom;
	private JTextField prenom;
	private JTextField password;
	private JTable table1;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users window = new Users();
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
	Connection con;
	PreparedStatement pst;
	
	ResultSet rs;
	private JTextField username;
	
	
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
	public void table_load()
    {
     try
     {
    pst = con.prepareStatement("select name, lastname , username , password from user");
    rs = pst.executeQuery();
    table1.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	
	
	
	public Users() {
		initialize();
		Connect();
		table_load();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1500, 850);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(0, 0, 1500, 1000);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 200, 820);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("         Vehicules");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehicule vehicule = new vehicule();
				vehicule.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/car-1057 (4).png"));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(0, 211, 200, 60);
		panel_1.add(btnNewButton);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		
		JButton btnClients = new JButton("                    Clients");
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cl = new client();
				cl.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnClients.setHorizontalAlignment(SwingConstants.LEFT);
		btnClients.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/user-279.png"));
		btnClients.setForeground(new Color(255, 255, 255));
		btnClients.setOpaque(true);
		btnClients.setBorderPainted(false);
		btnClients.setBackground(new Color(0, 0, 0));
		btnClients.setBounds(0, 283, 200, 60);
		panel_1.add(btnClients);
		
		JButton btnReservation = new JButton("        Reservation");
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservation res = new reservation();
				res.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnReservation.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/hotel-booking-10293.png"));
		btnReservation.setHorizontalAlignment(SwingConstants.LEFT);
		btnReservation.setForeground(new Color(255, 255, 255));
		btnReservation.setOpaque(true);
		btnReservation.setBorderPainted(false);
		btnReservation.setBackground(new Color(0, 0, 0));
		btnReservation.setBounds(0, 367, 200, 60);
		panel_1.add(btnReservation);
		
		JButton btnFactures = new JButton("        Factures");
		btnFactures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facture fac = new Facture();
				fac.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnFactures.setHorizontalAlignment(SwingConstants.LEFT);
		btnFactures.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/tax-calculator-9256 (1).png"));
		btnFactures.setForeground(new Color(255, 255, 255));
		btnFactures.setOpaque(true);
		btnFactures.setBorderPainted(false);
		btnFactures.setBackground(new Color(0, 0, 0));
		btnFactures.setBounds(0, 467, 200, 60);
		panel_1.add(btnFactures);
		
		JButton btnContrats = new JButton("         Contrats");
		btnContrats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contrat contrat = new Contrat();
				contrat.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnContrats.setHorizontalAlignment(SwingConstants.LEFT);
		btnContrats.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/handshake-3309.png"));
		btnContrats.setForeground(new Color(255, 255, 255));
		btnContrats.setOpaque(true);
		btnContrats.setBorderPainted(false);
		btnContrats.setBackground(new Color(0, 0, 0));
		btnContrats.setBounds(0, 559, 200, 60);
		panel_1.add(btnContrats);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/icons8-user-100.png"));
		lblNewLabel.setBounds(43, 55, 113, 89);
		panel_1.add(lblNewLabel);
		
		JLabel Maroua = new JLabel("ADMIN");
		Maroua.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		Maroua.setForeground(new Color(255, 255, 255));
		Maroua.setBounds(70, 156, 86, 22);
		panel_1.add(Maroua);
		
		JButton users = new JButton("         Utilisateurs");
		users.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/icons8-gear-64 (1).png"));
	
		
		users.setOpaque(true);
		users.setHorizontalAlignment(SwingConstants.LEFT);
		users.setForeground(Color.WHITE);
		users.setBorderPainted(false);
		users.setBackground(Color.BLACK);
		users.setBounds(0, 656, 200, 60);
		panel_1.add(users);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login log = new login();
				log.setVisible(true);
				frame.setVisible(false);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/icons8-logout-rounded-left-30.png"));
		lblNewLabel_1.setBounds(0, 0, 61, 50);
		panel_1.add(lblNewLabel_1);
		
		KGradientPanel panel_2 = new KGradientPanel();
		panel_2.kGradientFocus = 100;
		panel_2.kEndColor = new Color(176, 224, 230);
		panel_2.kStartColor = new Color(100, 149, 237);
		panel_2.setkGradientFocus(500);
		panel_2.setBounds(200, 0, 1300, 820);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(27, 17, 1190, 85);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/search-car-8953 (2).png"));
		lblNewLabel_3.setBounds(18, 6, 73, 69);
		panel_3.add(lblNewLabel_3);
		
		////////////////////Recherche par user name /////////////////
		
		JButton search = new JButton("Par ID");
		search.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String usern = username.getText();
			try {
				pst =con.prepareStatement("select name,lastname, password from user where username=? ");
				pst.setString(1, usern);
				ResultSet rs =pst.executeQuery();
				if(rs.next()==true) {
					nom.setText(rs.getString(2));
					prenom.setText(rs.getString(1));
					password.setText(rs.getString(3));
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

				
				
			}
		});
		
		
		
		search.setBounds(503, 42, 117, 29);
		panel_3.add(search);
		
		username = new JTextField();
		username.setBounds(87, 42, 383, 26);
		panel_3.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_6_3_1 = new JLabel("Username");
		lblNewLabel_6_3_1.setBounds(87, 33, 109, 16);
		panel_3.add(lblNewLabel_6_3_1);
		lblNewLabel_6_3_1.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_3_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(27, 110, 1190, 75);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		nom = new JTextField();
		nom.setBounds(46, 17, 205, 35);
		panel_5.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(312, 17, 205, 35);
		panel_5.add(prenom);
		prenom.setColumns(10);
		
		password = new JTextField();
		password.setBounds(566, 17, 205, 35);
		panel_5.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 12));
		lblNewLabel_7.setForeground(new Color(51, 102, 153));
		lblNewLabel_7.setBounds(566, 6, 61, 16);
		panel_5.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6_1 = new JLabel("Nom");
		lblNewLabel_6_1.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_1.setBounds(46, 6, 61, 16);
		panel_5.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Prenom");
		lblNewLabel_6_2.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_2.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_2.setBounds(312, 6, 61, 16);
		panel_5.add(lblNewLabel_6_2);

		
		/////////////Modification ///////////////////
		
		JButton Modifier = new JButton("Modifier");
		Modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mat = nom.getText();
				String mar = password.getText();
				String cat = prenom.getText();
				String user = username.getText();
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				try {
					pst = con.prepareStatement("update user set password=?,name=?,lastname =? where username=?");
					pst.setString(1, mar);
					pst.setString(2, mat);
					pst.setString(3, cat);
					pst.setString(4, user);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Modifier!!!");
					
					
					
					nom.setText("");
					prenom.setText("");
					password.setText("");	
					nom.requestFocus();
					table_load();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				}
				else {
					JOptionPane.showMessageDialog(null, "Operation Canceled ! ");
				}
				
			
				
			}
		});
		Modifier.setBounds(1067, 21, 117, 29);
		panel_5.add(Modifier);
		
		
		
		
		
		/////////// Suppression ///////////////////
		
		JButton Supprimer = new JButton("Supprimer");
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mat = username.getText();
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				try {
					pst = con.prepareStatement("delete from user where username=? ");
					pst.setString(1, mat);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted!");
					
					
					
					nom.setText("");
					prenom.setText("");
					password.setText("");	
					nom.requestFocus();
					table_load();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				}
				else {
					JOptionPane.showMessageDialog(null, "Operation Canceled ! ");
				}
				
			}
		});
		Supprimer.setBounds(946, 21, 117, 29);
		panel_5.add(Supprimer);
		
		
		
		
		
		
		///////////ajouter /////////////////////////////////
		
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mat = nom.getText();
				String mar = password.getText();
				String cat = prenom.getText();
				String usern= username.getText();
				
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				
				
				
					try {
						pst = con.prepareStatement("insert into user(username,name,lastname,password)values(?,?,?,?)");
						pst.setString(1, usern);
						pst.setString(2, mat);
						pst.setString(4, mar);
						pst.setString(3, cat);
						
						pst.executeUpdate();
		
						
						table_load();					          
						nom.setText("");
						prenom.setText("");
						password.setText("");	
						username.setText("");
						nom.requestFocus();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} }
	
				/*cards card = new cards();
				card.setimage(img);
				card.setDetails(et);
				card.setBackground(new Color(0, 0, 0));
				card.setBounds(0, 0, 410, 320);
				card.setVisible(true);
				card.setLayout(null);
				panel_4.add(card);
				
				frame.revalidate();
				frame.repaint();*/
		
				
			}
		});
		ajouter.setBounds(817, 21, 117, 29);
		panel_5.add(ajouter);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 235, 1190, 561);
		panel_2.add(scrollPane);
		
		
		////////////////Table///////////////////////////
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		table1.setBorder(new LineBorder(Color.BLACK));
		table1.setBackground(new Color(176, 224, 230));
	    table1.setShowHorizontalLines(true);
	    table1.setShowVerticalLines(true);
	    table1.setFont(new Font("Serif", Font.BOLD, 16));
	    table1.getTableHeader().setFont(new Font("Times", Font.BOLD, 18));
	    table1.setRowHeight(20);
	    table1.getTableHeader().setBackground(Color.BLACK);
	    table1.getTableHeader().setForeground(Color.WHITE);
		
	}

		
		
		public void setVisible(boolean b) {
			if (true) {
			frame.setVisible(true); }
	}
	}