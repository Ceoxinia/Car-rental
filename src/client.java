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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import keeptoo.KGradientPanel;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class client {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTable table;
	private JTextField n_permis;
	private JTextField date;
	private JTextField nom;
	private JTextField phonenum;
	private JTextField prenom;
	private JTextField Adresse;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client window = new client();
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
	PreparedStatement pst,pstr,pstk,pstf;
	
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
	public void table_load()
    {
     try
     {
    pst = con.prepareStatement("select n_permis as NPermis, nom as Nom, prenom as Prenom, dateN as DateNaissance, adresse as Adresse, num as Telephone from client");
    rs = pst.executeQuery();
    table.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	/**
	 * Create the application.
	 */
	public client() {
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
		
		JLabel Maroua = new JLabel("Maroua");
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
		
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(27, 32, 1190, 114);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		n_permis = new JTextField();
		n_permis.setBounds(46, 17, 205, 35);
		panel_5.add(n_permis);
		n_permis.setColumns(10);
		
		date = new JTextField();
		date.setBounds(312, 59, 205, 35);
		panel_5.add(date);
		date.setColumns(10);
		
		nom = new JTextField();
		nom.setBounds(312, 17, 205, 35);
		panel_5.add(nom);
		nom.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("La Date de Naissance");
		lblNewLabel_6.setForeground(new Color(51, 102, 153));
		lblNewLabel_6.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(312, 50, 137, 16);
		panel_5.add(lblNewLabel_6);
		
		phonenum = new JTextField();
		phonenum.setColumns(10);
		phonenum.setBounds(46, 59, 205, 35);
		panel_5.add(phonenum);
		
		JLabel lblNewLabel_6_1 = new JLabel("Numero Permis");
		lblNewLabel_6_1.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_1.setBounds(46, 6, 122, 16);
		panel_5.add(lblNewLabel_6_1);
		
		JLabel ID_Cpmtrat = new JLabel("Nom");
		ID_Cpmtrat.setForeground(new Color(51, 102, 153));
		ID_Cpmtrat.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		ID_Cpmtrat.setBounds(312, 6, 117, 16);
		panel_5.add(ID_Cpmtrat);
		///////////Modification ///////////////////////////
		
		JButton Modifier = new JButton("Modifier");
		Modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String per = n_permis.getText();
				String no = nom.getText();				
				String pre= prenom.getText();
				String dateN= date.getText();
				String add= Adresse.getText();
				String num = phonenum.getText();
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				
			try {
				pst=con.prepareStatement("update client set nom = ? , prenom = ? , num = ? , adresse = ? , dateN= ? where n_permis = ?")	;
				
				pstr=con.prepareStatement("update reservation set nom = ? , prenom = ? , num = ? , adresse = ? , dateN= ? where n_permis = ?")	;
				pst.setString(6,per);
				pst.setString(1,no);
				pst.setString(2, pre);
				pst.setString(5, dateN);
				pst.setString(4, add);
				pst.setString(3, num);
				pst.executeUpdate();
				
				pstr.setString(6,per);
				pstr.setString(1,no);
				pstr.setString(2, pre);
				pstr.setString(5, dateN);
				pstr.setString(4, add);
				pstr.setString(3, num);
				pstr.executeUpdate();
				
				table_load();
				
				JOptionPane.showMessageDialog(null, "Updated!");

				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				} else {
					JOptionPane.showMessageDialog(null, "Operation Cancelled !");
				}
				
			}
		});
		Modifier.setBounds(1067, 75, 117, 29);
		panel_5.add(Modifier);
		
		JButton Supprimer = new JButton("Supprimer");
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pr = n_permis.getText();
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "La suppression du client implique la suppression de l'historique de ses reservation et contrats ! "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				try {
					pst= con.prepareStatement("delete from client where n_permis = ? ");
					pstr=con.prepareStatement("delete from reservation where n_permis = ?");
					pstk=con.prepareStatement("delete from contrat where n_permis = ? ");
					pstf = con.prepareStatement("delete from facture where n_permis = ?");
					pstf.setString(1, pr);
					
					pst.setString(1, pr);
					pstr.setString(1, pr);
					pstk.setString(1, pr);
					
					pstk.executeUpdate();
					pstr.executeUpdate();
					pst.executeUpdate();
					pstf.executeUpdate();
					table_load();
					JOptionPane.showMessageDialog(null, "Deleted!");
					
					nom.setText("");				
					 prenom.setText("");
					date.setText("");
				    Adresse.setText("");
					phonenum.setText("");
					n_permis.setText("");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else {
					JOptionPane.showMessageDialog(null, "Operation Cancelled !");
				}
				
			}
		});
		Supprimer.setBounds(948, 75, 117, 29);
		panel_5.add(Supprimer);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(588, 17, 205, 35);
		panel_5.add(prenom);
		
		JLabel tlf = new JLabel("Numero de Telephone");
		tlf.setForeground(new Color(51, 102, 153));
		tlf.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		tlf.setBounds(46, 50, 137, 16);
		panel_5.add(tlf);
		
		JLabel Prixj = new JLabel("Prenom");
		Prixj.setForeground(new Color(51, 102, 153));
		Prixj.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		Prixj.setBounds(588, 6, 168, 16);
		panel_5.add(Prixj);
		
		Adresse = new JTextField();
		Adresse.setColumns(10);
		Adresse.setBounds(859, 17, 205, 35);
		panel_5.add(Adresse);
		
		JLabel Adres = new JLabel("Adresse");
		Adres.setForeground(new Color(51, 102, 153));
		Adres.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		Adres.setBounds(859, 5, 168, 16);
		panel_5.add(Adres);
		
		
		JButton Recherche = new JButton("Recherche");
		
		
		
		///////////////searchhhhhhh ////////////////////
		
		
		
		
		Recherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pr= n_permis.getText();
				try {
					pst=con.prepareStatement("select nom,prenom,dateN,adresse,num from client where n_permis = ? ");
					pst.setString(1, pr);
					ResultSet rs = pst.executeQuery();
					if (rs.next()==true) {
						nom.setText(rs.getString(1));				
						 prenom.setText(rs.getString(2));
						date.setText(rs.getString(3));
					Adresse.setText(rs.getString(4));
						phonenum.setText(rs.getString(5));
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		Recherche.setBounds(819, 75, 117, 29);
		panel_5.add(Recherche);
		
		
		
		////////////// ajouter client /////////////////////////////////////
		
		
		JButton Ajouter = new JButton("Ajouter");
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String npermis = n_permis.getText();
				String no = nom.getText();				
				String pre= prenom.getText();
				String dateN= date.getText();
				String add= Adresse.getText();
				String num = phonenum.getText();
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
			
				try {
					pst=con.prepareStatement("insert into client(n_permis,nom,prenom,dateN,adresse,num) values(?,?,?,?,?,?)");
					pst.setString(1,npermis);
					pst.setString(2,no);
					pst.setString(3, pre);
					pst.setString(4, dateN);
					pst.setString(5, add);
					pst.setString(6, num);
					pst.executeUpdate();
					
					table_load();
					nom.setText("");				
					 prenom.setText("");
					date.setText("");
				    Adresse.setText("");
					phonenum.setText("");
					n_permis.setText("");
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} } else {
					JOptionPane.showMessageDialog(null, "Operation cancelled !");
				}
				
			}
		});
		Ajouter.setBounds(690, 75, 117, 29);
		panel_5.add(Ajouter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 179, 1190, 589);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(Color.BLACK));
		table.setBackground(new Color(176, 224, 230));
	    table.setShowHorizontalLines(true);
	    table.setShowVerticalLines(true);
	    table.setFont(new Font("Serif", Font.BOLD, 16));
	    table.getTableHeader().setFont(new Font("Times", Font.BOLD, 18));
	    table.setRowHeight(20);
	    table.getTableHeader().setBackground(Color.BLACK);
	    table.getTableHeader().setForeground(Color.WHITE);
	}
	    
	  

		
		
		public void setVisible(boolean b) {
			if (true) {
			frame.setVisible(true); }
	}
	}