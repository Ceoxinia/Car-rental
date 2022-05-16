import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import keeptoo.KGradientPanel;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class  MainMenu {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTable table;



	/**
	 * Launch the application.
	 * 
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	PreparedStatement pst,pst1,pst2,pst3,pst4,pst5;
	
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
    pst = con.prepareStatement("select * from vehicule order by categorie");
    rs = pst.executeQuery();
    table.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	
	/*public void populateJList(JList list, String query, Connection connection) throws SQLException
	{
	    DefaultListModel model = new DefaultListModel(); //create a new list model

	    Statement statement = (Statement) connection.createStatement();
	    ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query); //run your query

	    while (resultSet.next()) //go through each row that your query returns
	    {
	        String itemCode = resultSet.getString("item_code"); //get the element in column "item_code"
	        model.addElement(itemCode); //add each item to the model
	    }
	    list.setModel(model);

	    resultSet.close();
	    ((Connection) statement).close();

	}*/

	public MainMenu() throws SQLException {
		initialize();
		Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
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
		btnClients.setBounds(10, 283, 190, 60);
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
		btnFactures.setBounds(0, 468, 200, 60);
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
		
		RoundedPanel panel_3 = new RoundedPanel();
		panel_3.setBounds(213, 150, 250, 251);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/seo.png"));
		lblNewLabel_2.setBounds(56, 19, 128, 149);
		panel_3.add(lblNewLabel_2);
		
		    con = DriverManager.getConnection("jdbc:mysql://localhost/locDz", "root","mimi2001");
		
	
			pst = con.prepareStatement("select count(*) from vehicule");
			ResultSet rs = pst.executeQuery();
			rs.next();
		
			
			pst1 = con.prepareStatement("select count(*) from reservation where etat = ?");
			pst1.setString(1,"En Attente");
			ResultSet rs1 = pst1.executeQuery();
			rs1.next();
			pst2 = con.prepareStatement("select count(*) from vehicule where etat= ?");
			pst2.setString(1, "Reserve");
			ResultSet rs2 = pst2.executeQuery();
			if (rs2.next()==true) {
				String nbr_vre= rs2.getString(1);
			}
			pst3 = con.prepareStatement("select count(*) from user");
			ResultSet rs3 = pst3.executeQuery();
			if (rs3.next()==true) {
				String nbr_users= rs3.getString(1);
			}
			pst4 = con.prepareStatement("select count(*) from client");
			ResultSet rs4 = pst4.executeQuery();
			if (rs4.next()==true) {
				String nbr_client= rs4.getString(1);
			}
			pst5 = con.prepareStatement("select count(*) from facture");
			ResultSet rs5 = pst5.executeQuery();
			if (rs5.next()==true) {
				String nbr_fac= rs5.getString(1);
			}
			
			JLabel dfs = new JLabel("  Reservations En Attente :");
			dfs.setBounds(41, 166, 168, 16);
			panel_3.add(dfs);
			
			JLabel nbr_res = new JLabel();
			nbr_res.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			
			nbr_res.setText(rs1.getString(1));
			nbr_res.setBounds(112, 200, 61, 16);
			panel_3.add(nbr_res);
			
			RoundedPanel panel_3_1 = new RoundedPanel();
			panel_3_1.setLayout(null);
			panel_3_1.setBounds(485, 150, 250, 251);
			panel_2.add(panel_3_1);
			
			JLabel lblNewLabel_2_1 = new JLabel("");
			lblNewLabel_2_1.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/sport-car.png"));
			lblNewLabel_2_1.setBounds(56, 19, 128, 149);
			panel_3_1.add(lblNewLabel_2_1);
			
			JLabel lblNombreDesVehicules = new JLabel("   Nombre De Vehicules:");
			lblNombreDesVehicules.setBounds(41, 166, 168, 16);
			panel_3_1.add(lblNombreDesVehicules);
			
			JLabel nbr_vehicules = new JLabel(rs.getString(1));
			nbr_vehicules.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			nbr_vehicules.setBounds(112, 200, 61, 16);
			panel_3_1.add(nbr_vehicules);
			
			RoundedPanel panel_3_2 = new RoundedPanel();
			panel_3_2.setLayout(null);
			panel_3_2.setBounds(762, 150, 250, 251);
			panel_2.add(panel_3_2);
			
			JLabel lblNewLabel_2_2 = new JLabel("");
			lblNewLabel_2_2.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/people.png"));
			lblNewLabel_2_2.setBounds(56, 19, 128, 149);
			panel_3_2.add(lblNewLabel_2_2);
			
			JLabel lblNombreDesClients = new JLabel("     Nombre De Clients :");
			lblNombreDesClients.setBounds(41, 166, 168, 16);
			panel_3_2.add(lblNombreDesClients);
			
			JLabel nbr_clients = new JLabel(rs4.getString(1));
			nbr_clients.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			nbr_clients.setBounds(112, 200, 61, 16);
			panel_3_2.add(nbr_clients);
			
			RoundedPanel panel_3_3 = new RoundedPanel();
			panel_3_3.setLayout(null);
			panel_3_3.setBounds(213, 437, 250, 251);
			panel_2.add(panel_3_3);
			
			JLabel lblNewLabel_2_3 = new JLabel("");
			lblNewLabel_2_3.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/man.png"));
			lblNewLabel_2_3.setBounds(56, 19, 128, 149);
			panel_3_3.add(lblNewLabel_2_3);
			
			JLabel lblNombreDe = new JLabel("    Nombre D'Employes :");
			lblNombreDe.setBounds(41, 166, 168, 16);
			panel_3_3.add(lblNombreDe);
			
			JLabel nbr_users = new JLabel(rs3.getString(1));
			nbr_users.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			nbr_users.setBounds(112, 200, 61, 16);
			panel_3_3.add(nbr_users);
			
			RoundedPanel panel_3_4 = new RoundedPanel();
			panel_3_4.setLayout(null);
			panel_3_4.setBounds(485, 437, 250, 251);
			panel_2.add(panel_3_4);
			
			JLabel lblNewLabel_2_4 = new JLabel("");
			lblNewLabel_2_4.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/car.png"));
			lblNewLabel_2_4.setBounds(56, 19, 128, 149);
			panel_3_4.add(lblNewLabel_2_4);
			
			JLabel lblVehiculesReservees = new JLabel("    Vehicules Reservees :");
			lblVehiculesReservees.setBounds(41, 166, 168, 16);
			panel_3_4.add(lblVehiculesReservees);
			
			JLabel nbr_vehRes = new JLabel(rs2.getString(1));
			nbr_vehRes.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			nbr_vehRes.setBounds(112, 200, 61, 16);
			panel_3_4.add(nbr_vehRes);
			
			RoundedPanel panel_3_5 = new RoundedPanel();
			panel_3_5.setLayout(null);
			panel_3_5.setBounds(762, 437, 250, 251);
			panel_2.add(panel_3_5);
			
			JLabel lblNewLabel_2_5 = new JLabel("");
			lblNewLabel_2_5.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/taxes.png"));
			lblNewLabel_2_5.setBounds(56, 19, 128, 149);
			panel_3_5.add(lblNewLabel_2_5);
			
			JLabel lblFacturesNoncalculees = new JLabel("  Factures Non-Calculees :");
			lblFacturesNoncalculees.setBounds(41, 166, 168, 16);
			panel_3_5.add(lblFacturesNoncalculees);
			
			JLabel nbr_factures = new JLabel(rs5.getString(1));
			nbr_factures.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			nbr_factures.setBounds(112, 200, 61, 16);
			panel_3_5.add(nbr_factures);
	}
			
			
		
		
		
		public void setVisible(boolean b) {
			if (true) {
			frame.setVisible(true); }
	}
}

