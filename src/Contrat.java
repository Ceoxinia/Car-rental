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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import keeptoo.KGradientPanel;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;

public class Contrat {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField id_res;
	private JTextField id_client;
	private JTextField MatriculeC;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contrat window = new Contrat();
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
	private JTextField prenomc;
	private JTextField Duree;
	private JTextField date;
	private JTextField NomC;
	
	
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
    pst = con.prepareStatement("select id_res as Reservation, n_permis as NPermis, nom as Nom, prenom as Prenom , datte as DateLocation , duree as Duree, matricule as Matricule from contrat");
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
	public Contrat() {
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
		panel_5.setBounds(27, 32, 1190, 142);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		id_res = new JTextField();
		id_res.setBounds(46, 17, 205, 35);
		panel_5.add(id_res);
		id_res.setColumns(10);
		
		id_client = new JTextField();
		id_client.setBounds(46, 59, 205, 35);
		panel_5.add(id_client);
		id_client.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("ID Client");
		lblNewLabel_6.setForeground(new Color(51, 102, 153));
		lblNewLabel_6.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(46, 47, 61, 16);
		panel_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Nom Client");
		lblNewLabel_7.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 12));
		lblNewLabel_7.setForeground(new Color(51, 102, 153));
		lblNewLabel_7.setBounds(312, 47, 61, 16);
		panel_5.add(lblNewLabel_7);
		
		MatriculeC = new JTextField();
		MatriculeC.setColumns(10);
		MatriculeC.setBounds(312, 17, 205, 35);
		panel_5.add(MatriculeC);
		
		JLabel lblNewLabel_6_1 = new JLabel("ID Reservation");
		lblNewLabel_6_1.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_1.setBounds(46, 6, 122, 16);
		panel_5.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_4 = new JLabel("Prenom Client");
		lblNewLabel_6_4.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_4.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_4.setBounds(588, 47, 137, 16);
		panel_5.add(lblNewLabel_6_4);
		
		JButton Modifier = new JButton("Imprimer");
		Modifier.setBounds(1067, 107, 117, 29);
		panel_5.add(Modifier);
		
		JButton Supprimer = new JButton("Supprimer");
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res=id_res.getText();
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				try {
					pst = con.prepareStatement("delete from contrat where id_res= ?");
					pst.setString(1, res);
					pst.executeUpdate();
					table_load();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} }
				else {
					JOptionPane.showMessageDialog(null, "Operation Cancelled !");
				}
			}
		});
		Supprimer.setBounds(945, 107, 117, 29);
		panel_5.add(Supprimer);
		
		
		
		
		prenomc = new JTextField();
		prenomc.setColumns(10);
		prenomc.setBounds(588, 59, 205, 35);
		panel_5.add(prenomc);
		
		Duree = new JTextField();
		Duree.setColumns(10);
		Duree.setBounds(588, 17, 205, 35);
		panel_5.add(Duree);
		
		JLabel pkm = new JLabel("Matricule");
		pkm.setForeground(new Color(51, 102, 153));
		pkm.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		pkm.setBounds(312, 6, 98, 16);
		panel_5.add(pkm);
		
		JLabel pkm_1 = new JLabel("Duree Location(jours)");
		pkm_1.setForeground(new Color(51, 102, 153));
		pkm_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		pkm_1.setBounds(588, 6, 168, 16);
		panel_5.add(pkm_1);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(859, 17, 205, 35);
		panel_5.add(date);
		
		JLabel pkm_1_1 = new JLabel("Date Debut");
		pkm_1_1.setForeground(new Color(51, 102, 153));
		pkm_1_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		pkm_1_1.setBounds(859, 5, 168, 16);
		panel_5.add(pkm_1_1);
		
		NomC = new JTextField();
		NomC.setColumns(10);
		NomC.setBounds(312, 59, 205, 35);
		panel_5.add(NomC);
		
		JButton Recherche = new JButton("Recherche");
		Recherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String res = id_res.getText();
				try {
					pst =con.prepareStatement("Select nom,prenom,n_permis,datte,duree,matricule from contrat where id_res = ?");
					pst.setString(1, res);
					ResultSet rs = pst.executeQuery();
					if(rs.next()==true) {
					NomC.setText(rs.getString(1));
					prenomc.setText(rs.getString(2));
					date.setText(rs.getString(4));
					Duree.setText(rs.getString(5));
					MatriculeC.setText(rs.getString(6));
					id_client.setText(rs.getString(3));
					
					}
					else { JOptionPane.showMessageDialog(null, "Contrat n'exist Pas !"); }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		Recherche.setBounds(819, 106, 117, 29);
		panel_5.add(Recherche);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 186, 1190, 615);
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