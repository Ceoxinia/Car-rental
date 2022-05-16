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

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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



public class vehicule {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField matricule;
	private JTextField modele;
	private JTextField categorie;
	private JTextField marque;
	private JTextField tarif;
	private JTable table1;


	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vehicule window = new vehicule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con;
	PreparedStatement pst,pstr,pstk;
	
	ResultSet rs;
	private JTextField prixkm;
	private JTextField PrixJournalier;
	private JTable table;
	private JTextField kilometragedebut;
	
	
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
    pst = con.prepareStatement("select matricule, id_mod as Modele, id_cat as Categorie , marque , tarif as TotalTarif,kilometrage as Kilometrage, Etat from vehicule order by id_cat");
    rs = pst.executeQuery();
    table1.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	
	public void table_loadCat(String cat)
    {
     try
     {
    pst = con.prepareStatement("select matricule, id_mod as Modele, id_cat as Categorie , marque , Etat from vehicule where id_cat=?");
    pst.setString(1, cat);
    rs = pst.executeQuery();
    table1.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }

	public void populateJList(JComboBox list) throws SQLException
	{
    try {
	    	
	    con = DriverManager.getConnection("jdbc:mysql://localhost/locDz", "root","mimi2001");

	    pst = con.prepareStatement("select id_cat from vehicule");
	    rs = pst.executeQuery();
	    

	    while (rs.next()) //go through each row that your query returns
	    {
	        String itemCode = rs.getString("id_cat"); //get the element in column "item_code"
	        list.addItem(itemCode); //add each item to the model
	    }
	    

	    rs.close();
	    pst.close();
	    }
	    catch (SQLException e)
	     {
	     e.printStackTrace();
	  }

	}
	
	public void populateJListMod(JComboBox list) throws SQLException
	{
    try {
	    	
	    con = DriverManager.getConnection("jdbc:mysql://localhost/locDz", "root","mimi2001");

	    pst = con.prepareStatement("select id_mod from modele");
	    rs = pst.executeQuery();
	    

	    while (rs.next()) //go through each row that your query returns
	    {
	        String itemCode = rs.getString("id_mod"); //get the element in column "item_code"
	        list.addItem(itemCode); //add each item to the model
	    }
	    list.addItem("Autre");

	    rs.close();
	    pst.close();
	    }
	    catch (SQLException e)
	     {
	     e.printStackTrace();
	  }
   

	}
	/**
	 * Create the application.
	 */
	public vehicule() {
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(27, 17, 1190, 85);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/marouakhemissi/Downloads/search-car-8953 (2).png"));
		lblNewLabel_3.setBounds(18, 6, 73, 69);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Par Categorie :");
		lblNewLabel_4.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(new Color(51, 102, 153));
		lblNewLabel_4.setBounds(91, 20, 111, 16);
		panel_3.add(lblNewLabel_4);
		
		JComboBox list = new JComboBox();
		try {
			populateJList(list);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		list.setBounds(91, 46, 400, 20);
		panel_3.add(list);
		
		////////////////////Recherche par categorie /////////////////
		
		JButton searchcat = new JButton("Par Categorie");
		searchcat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cat = list.getSelectedItem().toString();
				table_loadCat(cat);
			

				
				
			}
		});
		
		
		
		searchcat.setBounds(503, 42, 117, 29);
		panel_3.add(searchcat);
		
		
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(27, 110, 1190, 105);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		matricule = new JTextField();
		matricule.setBounds(46, 17, 205, 35);
		panel_5.add(matricule);
		matricule.setColumns(10);
		
		categorie = new JTextField();
		categorie.setBounds(312, 17, 205, 35);
		panel_5.add(categorie);
		categorie.setColumns(10);
		
		marque = new JTextField();
		marque.setBounds(312, 59, 205, 35);
		panel_5.add(marque);
		marque.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Marque");
		lblNewLabel_7.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 12));
		lblNewLabel_7.setForeground(new Color(51, 102, 153));
		lblNewLabel_7.setBounds(312, 47, 61, 16);
		panel_5.add(lblNewLabel_7);
		
		tarif = new JTextField();
		tarif.setColumns(10);
		tarif.setBounds(588, 59, 205, 35);
		panel_5.add(tarif);
		
		JLabel lblNewLabel_6_1 = new JLabel("Matricule");
		lblNewLabel_6_1.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_1.setBounds(46, 6, 61, 16);
		panel_5.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Categorie");
		lblNewLabel_6_2.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_2.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_2.setBounds(312, 6, 61, 16);
		panel_5.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_4 = new JLabel("Tarif");
		lblNewLabel_6_4.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_4.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_4.setBounds(588, 47, 61, 16);
		panel_5.add(lblNewLabel_6_4);
		
////////////modele ////////////////////
		
	JComboBox combomodele = new JComboBox();
	try {
		populateJListMod(combomodele);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	combomodele.setBounds(46, 64, 205, 27);
	panel_5.add(combomodele);
	
		
		/////////////Modification ///////////////////
		
		JButton Modifier = new JButton("Modifier");
		Modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mat = matricule.getText();
				String mar = marque.getText();
				String cat = categorie.getText();
				String mode= combomodele.getSelectedItem().toString();
				String km = kilometragedebut.getText();
				String tari = tarif.getText();
				
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				try {
					pst = con.prepareStatement("update vehicule set marque=?,id_mod=?,id_cat =?, tarif = ? ,kilometrage= ?  where matricule=?");
					pst.setString(1, mar);
					pst.setString(2, mode);
					pst.setString(3, cat);
					pst.setString(4, tari);
					pst.setString(5, km);
					pst.setString(6, mat);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Modifier!!!");
					
					
					
					matricule.setText("");
					categorie.setText("");
					marque.setText("");	
					kilometragedebut.setText("");
					matricule.requestFocus();
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
		Modifier.setBounds(1067, 63, 117, 29);
		panel_5.add(Modifier);
		
		
		
		
		
		/////////// Suppression ///////////////////
		
		JButton Supprimer = new JButton("Supprimer");
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mat = matricule.getText();
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "La Suppression de la vehicule implique la suppression d'historique de ses reservations , tarif , et contrats ! "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				try {
					pst = con.prepareStatement("delete from vehicule where matricule=? ");
					pstr = con.prepareStatement("delete from contrat where matricule = ? ");
					pstk=con.prepareStatement("delete from reservation where matricule = ? ");
					
					pstr.setString(1, mat);
					pstk.setString(1, mat);
					pst.setString(1, mat);
				    pstr.executeUpdate();
					
					pstk.executeUpdate();
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted!");
					
					
					
					matricule.setText("");
					categorie.setText("");
					marque.setText("");	
					matricule.requestFocus();
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
		Supprimer.setBounds(946, 63, 117, 29);
		panel_5.add(Supprimer);
		
		
		
		
		
		
		///////////ajouter /////////////////////////////////
		
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mat = matricule.getText();
				String mar = marque.getText();
				String cat = categorie.getText();
				String mode= combomodele.getSelectedItem().toString();
				String km = kilometragedebut.getText();
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				
				try {
					pst = con.prepareStatement("insert into vehicule(matricule,etat,marque,id_cat,id_mod,kilometrage)values(?,?,?,?,?,?)");
					
					
					pst.setString(1, mat);
					pst.setString(2, "non Reserve");
					pst.setString(3, mar);
					pst.setString(4, cat);
					pst.setString(6, km);
					
					if (mode=="Autre") {
					String mod = modele.getText();
					String pkm = prixkm.getText();
					String pj = PrixJournalier.getText();
					 
					PreparedStatement pstr = con.prepareStatement("insert into modele(id_mod,Prixkm,PrixJournalier)values(?,?,?)");	
					pstr.setString(1,mod);	
					pstr.setString(2, pkm);
					pstr.setString(3, pj);
					pstr.executeUpdate();
					
					pst.setString(5, mod);
					pst.executeUpdate();
					}
					else {
						pst.setString(5, mode);
						pst.executeUpdate();
					}
					
					
					
					table_load();					          
					matricule.setText("");
					categorie.setText("");
					marque.setText("");	
					matricule.requestFocus();
					
					   }
					 
					catch (SQLException e1)
					        {
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
		ajouter.setBounds(825, 63, 117, 29);
		panel_5.add(ajouter);
		
		
		JLabel lblNewLabel_6_6 = new JLabel("Modele");
		lblNewLabel_6_6.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_6.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_6.setBounds(46, 50, 61, 16);
		panel_5.add(lblNewLabel_6_6);
		
		kilometragedebut = new JTextField();
		kilometragedebut.setColumns(10);
		kilometragedebut.setBounds(588, 17, 205, 35);
		panel_5.add(kilometragedebut);
		
		JLabel lblNewLabel_6_3_1 = new JLabel("Kilometrage");
		lblNewLabel_6_3_1.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_3_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_3_1.setBounds(588, 6, 109, 16);
		panel_5.add(lblNewLabel_6_3_1);
		
		
		
		
		
		
		
		///////////////Recherche  par mat /////////////////////
		
		
		
		
		
		
		JButton recherche = new JButton("Par Matricule");
		recherche.setBounds(825, 21, 117, 29);
		panel_5.add(recherche);
		recherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String mat = matricule.getText();
			          
		 
		                pst = con.prepareStatement("select id_mod,id_cat,marque,tarif,kilometrage from vehicule where matricule = ?");
		                pst.setString(1, mat);
		                ResultSet rs = pst.executeQuery();
		 
		            if(rs.next()==true)
		            {
		              
		                String id_mod = rs.getString(1);
		                String id_cat = rs.getString(2);
		                String Marque = rs.getString(3);
		                String tar = rs.getString(4);             	
		                String kilom= rs.getString(5);
		   
		                marque.setText(Marque);
		                categorie.setText(id_cat);
		                kilometragedebut.setText(kilom);
		                tarif.setText(tar);
	
		                
		                
		            }  
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Unit doesn't exist ! ");
		            	matricule.setText(" ");
		                marque.setText(" ");
		                kilometragedebut.setText("");
		                tarif.setText("");
		            }
		            
		        }
		catch (SQLException ex) {
		          
		        }
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 330, 1190, 437);
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
	    
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(27, 227, 1190, 85);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		PrixJournalier = new JTextField();
		PrixJournalier.setBounds(582, 43, 217, 35);
		panel_4.add(PrixJournalier);
		PrixJournalier.setColumns(10);
		
		prixkm = new JTextField();
		prixkm.setBounds(326, 43, 192, 35);
		panel_4.add(prixkm);
		prixkm.setColumns(10);
		
		modele = new JTextField();
		modele.setBounds(51, 43, 217, 35);
		panel_4.add(modele);
		modele.setColumns(10);
		
		JLabel lblNewLabel_6_5 = new JLabel("Si vous voulez ajouter un nouveau modele , rempli ces champs : ");
		lblNewLabel_6_5.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_5.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_5.setBounds(20, 6, 367, 16);
		panel_4.add(lblNewLabel_6_5);
		
		JLabel pkm = new JLabel("Prix Kilometrage ");
		pkm.setBounds(326, 27, 98, 16);
		panel_4.add(pkm);
		pkm.setForeground(new Color(51, 102, 153));
		pkm.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		
		JLabel pkm_1 = new JLabel("Prix Journalier");
		pkm_1.setBounds(582, 27, 98, 16);
		panel_4.add(pkm_1);
		pkm_1.setForeground(new Color(51, 102, 153));
		pkm_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		
		JLabel lblNewLabel_6 = new JLabel("Modele");
		lblNewLabel_6.setBounds(49, 27, 61, 16);
		panel_4.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(51, 102, 153));
		lblNewLabel_6.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		
	}

		
		
		public void setVisible(boolean b) {
			if (true) {
			frame.setVisible(true); }
	}
	}


