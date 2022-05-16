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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.util.*;


public class reservation {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField adresse;
	private JTextField id_client;
	private JTextField Nom;
	private JTextField Num;
	private JTextField dateN;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reservation window = new reservation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement pst,pstr,psth,pstf,pstk,pstj,psty,pstw,vt,model;
	
	ResultSet rs;
	private JTextField prenomc;
	private JTextField Duree;
	private JTextField date;
	private JTable table_1;
	private JTextField id_res;
	
	
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
    pst = con.prepareStatement("select id_res, id_mod as Modele, n_permis as  N°Permis, dateD as Date, duree as Duree, Etat , matricule  from Reservation ");
    rs = pst.executeQuery();
    table.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch (SQLException e)
     {
     e.printStackTrace();
  }
    }
	
	public void table_loadEtat(String etat)
    {
     try
     {
    pst = con.prepareStatement("select id_res, id_mod as Modele, n_permis as  N°Permis, dateD as Date, duree as Duree,  Etat , matricule from reservation where etat=?");
    pst.setString(1, etat);
    rs = pst.executeQuery();
    table.setModel(DbUtils.resultSetToTableModel(rs));
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
	public reservation() {
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
		
		
		/*String [] categories = new String[20];
		int x= 0;
		
		
			try {
				pst = con.prepareStatement("select id_cat from vehicule order by matricule");
				ResultSet rs = pst.executeQuery();
				
			
				while (rs.next()) {
				categories[x]=rs.getString(1);
				x++;
					
				}
				
			}
			 catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			*/
			
		
		
			JComboBox<String> comboBox = new JComboBox<String>();
			comboBox.setForeground(new Color(0, 0, 0));
			comboBox.setToolTipText("");
			comboBox.setBounds(131, 31, 365, 49);
			comboBox.addItem("En Attente");
			comboBox.addItem("Acceptee");
			comboBox.addItem("Refusee");
			panel_3.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Par Etat :");
		lblNewLabel_4.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(new Color(51, 102, 153));
		lblNewLabel_4.setBounds(139, 20, 111, 16);
		panel_3.add(lblNewLabel_4);
		
		JButton RechercheEt = new JButton("Recherche Etat");
		RechercheEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String etat = comboBox.getSelectedItem().toString();
			    table_loadEtat(etat);
			}
		});
		RechercheEt.setBounds(512, 41, 117, 29);
		panel_3.add(RechercheEt);
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(27, 110, 1190, 106);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel modele = new JLabel("Modele Desire");
		modele.setForeground(new Color(51, 102, 153));
		modele.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		modele.setBounds(312, 6, 117, 16);
		panel_5.add(modele);
		
		JComboBox<String> combomodele = new JComboBox<String>();
		try {
			populateJListMod(combomodele);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		combomodele.setBounds(312, 22, 205, 27);
		panel_5.add(combomodele);
		
		
		/////////// modification 
		
		JButton Modifier = new JButton("Modifier");
		Modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mod = combomodele.getSelectedItem().toString();
				
				String datte = date.getText();
				String time = Duree.getText();
			
				String res = id_res.getText();
				
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 

				
				try {
	pstr = con.prepareStatement("update reservation set id_mod = ? ,dateD=?,duree=?  where id_res = ?");
	
	pstr.setString(1, mod);
	pstr.setString(2, datte);
	pstr.setString(3, time);
	pstr.setString(4, res);
	pstr.executeUpdate();
	table_load();
	JOptionPane.showMessageDialog(null, "Updated succesfully ");
	
				} catch( SQLException he) {
					
					
				} }
				
			}
		});
		Modifier.setBounds(1067, 64, 117, 29);
		panel_5.add(Modifier);
		//////////// delete /////////
		JButton Supprimer = new JButton("Supprimer");
		Supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res = id_res.getText();
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "La Supression de la reservation implique la suppression du contrat etabli aussi !!! "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				try {
					pst=con.prepareStatement("delete from reservation where id_res= ? ");
pstf=con.prepareStatement("delete from contrat where id_res= ? ");
					
					pstf.setString(1, res);
					pstf.executeUpdate();
pstr=con.prepareStatement("delete from facture where id_res= ? ");
					
					pstr.setString(1, res);
					pstr.executeUpdate();
					pst.setString(1, res);
					pst.executeUpdate();
					
					table_load();
					id_res.setText("");
					adresse.setText("");
					Num.setText("");
					date.setText("");
					Nom.setText("");
					id_client.setText("");
					dateN.setText("");
					Duree.setText("");
					prenomc.setText("");
					id_res.requestFocus();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} }
				
				
			}
		});
		Supprimer.setBounds(938, 64, 117, 29);
		panel_5.add(Supprimer);
		
		
		
		
		
		///////////ajouter ////////
		
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adr = adresse.getText();
				String num = Num.getText();
				String nom = Nom.getText();
				String mod = combomodele.getSelectedItem().toString();
				String idc = id_client.getText();
				String datte = date.getText();
				String time = Duree.getText();
				String birthday = dateN.getText();
				String prenom = prenomc.getText();
				
				
				
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
				int response = JOptionPane.showConfirmDialog(
                        null                       // Center in window.
                      , "Do you want to continue ? "        // Message
                      , "Confirme"               // Title in titlebar
                      , JOptionPane.YES_NO_OPTION  // Option type
                      , JOptionPane.QUESTION_MESSAGE  // messageType
                    );
				if (response == JOptionPane.YES_OPTION) { 
				
				
				try {
	pst = con.prepareStatement("insert into reservation(id_mod,etat,n_permis,nom,prenom,dateN,dateD,duree,adresse,num)values(?,?,?,?,?,?,?,?,?,?)");
	pstr = con.prepareStatement("insert into client(n_permis,nom,prenom,adresse,num,dateN)values(?,?,?,?,?,?)");
	
	pstr.setString(1, idc);
	pstr.setString(2, nom);
	pstr.setString(3, prenom);
	pstr.setString(6, birthday);
	pstr.setString(4, adr);
	pstr.setString(5, num);
	pstr.executeUpdate();
	
	
	pst.setString(1, mod);
	pst.setString(2, "En Attente");
	pst.setString(3, idc);
	pst.setString(4, nom);
	pst.setString(5, prenom);
	pst.setString(6, birthday);
	pst.setString(7, datte);
	pst.setString(8, time);
	pst.setString(9, adr);
	pst.setString(10, num);
	pst.executeUpdate();
	
	JOptionPane.showMessageDialog(null, "Reservation ajoutee! ");
	
	
	table_load();
	
	adresse.setText("");
	Num.setText("");
	date.setText("");
	Nom.setText("");
	id_client.setText("");
	dateN.setText("");
	Duree.setText("");
	prenomc.setText("");
	id_client.requestFocus();
	
	   }
	 
	catch (SQLException e1)
	        {
	e1.printStackTrace();
	} }
			
				
			}
		});
		ajouter.setBounds(798, 64, 117, 29);
		panel_5.add(ajouter);
		
		Duree = new JTextField();
		Duree.setColumns(10);
		Duree.setBounds(588, 17, 205, 35);
		panel_5.add(Duree);
		
		JLabel pkm_1 = new JLabel("Duree Location(jours)");
		pkm_1.setForeground(new Color(51, 102, 153));
		pkm_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		pkm_1.setBounds(588, 6, 168, 16);
		panel_5.add(pkm_1);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(859, 17, 205, 35);
		panel_5.add(date);
		
		JLabel pkm_1_1 = new JLabel("Date Debut(yyyy-mm-jj)");
		pkm_1_1.setForeground(new Color(51, 102, 153));
		pkm_1_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		pkm_1_1.setBounds(859, 5, 168, 16);
		panel_5.add(pkm_1_1);
		
		
		
		/////////////////////////////////////Verification///////////////////////////////////////////
		
		
		
		
		JButton verifier = new JButton("Verifier");
		verifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id_mod = combomodele.getSelectedItem().toString();
				String res = id_res.getText();
				String permis = id_client.getText();
				String n = Nom.getText();
				String preno=prenomc.getText();
				String datte = date.getText();
				String dur = Duree.getText();
				
		          
				 try {
           
					pst = con.prepareStatement("select matricule from vehicule where id_mod = ? and Etat= ?");
           
					pst.setString(1, id_mod);
					pst.setString(2, "Non Reserve");
                    ResultSet rs = pst.executeQuery();
 
          if(rs.next()==true) {
            	///////// accepter demande
            	pstr=con.prepareStatement("update reservation set matricule = ? , Etat= ? where id_res= ?");
            	pstr.setString(3, res);
            	pstr.setString(2, "Acceptee");
            	pstr.setString(1,rs.getString(1));
            	pstr.executeUpdate();
            	JOptionPane.showMessageDialog(null,"Reservation Acceptee !! le vehicule choisi : " + rs.getString(1));
            	table_load();
            	
            	/////////// changer l etat de vehicule 
            	psth= con.prepareStatement("update vehicule set Etat = ? where matricule= ?");
            	psth.setString(2,rs.getString("matricule"));
            	psth.setString(1, "Reserve");
            	
            	psth.executeUpdate();
            	///// creer une facture
            	pstf= con.prepareStatement("insert into facture(id_res,modele,matricule,n_permis,kmDebut,PrixKm,prixj) values (?,?,?,?,?,?,?)");
            	pstf.setString(3,rs.getString(1));
            	pstf.setString(1, res);
            	pstf.setString(2, id_mod);
            	model= con.prepareStatement("select Prixkm,PrixJournalier from modele where id_mod= ?");
            	
            	model.setString(1, id_mod);
            	ResultSet rsm = model.executeQuery();
            	if(rsm.next()==true) {
            	String PK = rsm.getString(1);
            	String PJ = rsm.getString(2);
            	
          
            	pstf.setString(4,permis);
            	pstf.setString(6, PK);
            	pstf.setString(7, PJ);
            	
                vt= con.prepareStatement("select kilometrage from vehicule where matricule= ?");
            	vt.setString(1,rs.getString(1));
            	ResultSet rsv = vt.executeQuery();
            	if (rsv.next()==true ) {
            	pstf.setString(5, rsv.getString(1));
            	pstf.executeUpdate();


            	////// creer une contrat 
                pstk= con.prepareStatement("insert into contrat(id_res,n_permis,matricule,nom,prenom,datte,duree) values (?,?,?,?,?,?,?)");
            	pstk.setString(3,rs.getString(1));
            	pstk.setString(2, permis);  	
            	pstk.setString(1, res);
            	pstk.setString(4,n);
            	pstk.setString(5, preno);  	
            	pstk.setString(6, datte);
            	pstk.setString(7, dur);
            	pstk.executeUpdate(); 
            	
          }
            	}
            	
          } else {
        	  pst = con.prepareStatement("select matricule from vehicule where id_mod = ? and Etat= ?");
              
				pst.setString(1, id_mod);
				pst.setString(2, "Reserve");
              ResultSet rsk = pst.executeQuery();
              
        	  
              if (rsk.next()==true) {
            	  String matricule = rsk.getString(1);
            	  pstj = con.prepareStatement("select  DATE_ADD(dateD, INTERVAL duree DAY) as DateFin from reservation where matricule = ? ");
            	  pstj.setString(1, rsk.getString(1));
            	  ResultSet rsf = pstj.executeQuery();
            	  if (rsf.next()==true) {
            		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
            		  
            		  Date date_fin= sdf.parse(rsf.getString(1));
  				  pstw = con.prepareStatement("select dateD,DATE_ADD(dateD, INTERVAL duree DAY) as DateFin from reservation where id_res = ?");
  				  pstw.setString(1, res);
  				  ResultSet rsh = pstw.executeQuery(); 
  				  if ( rsh.next()== true) {
  					 Date date_Debut2 =sdf.parse(rsh.getString(1));
           		  
           		     Date date_fin2= sdf.parse(rsh.getString(2));
  					 if (date_fin2.before(date_fin)== true || date_fin2.after(date_fin)== true && date_Debut2.after(date_fin)== true){

  						pstr=con.prepareStatement("update reservation set matricule = ? , Etat= ? where id_res= ?");
  		            	pstr.setString(3, res);
  		            	pstr.setString(2, "Acceptee");
  		            	pstr.setString(1,matricule);
  		            	pstr.executeUpdate();
  		            	table_load();
  		            	
  		            	/////////// changer l etat de vehicule 
  		            	psth= con.prepareStatement("update vehicule set Etat = ? where matricule= ?");
  		            	psth.setString(2,matricule);
  		            	psth.setString(1, "Reserve");
  		            	
  		            	psth.executeUpdate();
  		            	///// creer une facture
  		            	pstf= con.prepareStatement("insert into facture(id_res,modele,matricule,n_permis,kmDebut,PrixKm,prixj) values (?,?,?,?,?,?,?)");
  		            	pstf.setString(3,matricule);
  		            	pstf.setString(1, res);
  		            	pstf.setString(2, id_mod);
  		            	
  		            	model= con.prepareStatement("select Prixkm,PrixJournalier from modele where id_mod= ?");
  		            	
  		            	model.setString(1, id_mod);
  		            	ResultSet rsm = model.executeQuery();
  		            	if(rsm.next()==true) {
  		            	String PK = rsm.getString(1);
  		            	String PJ = rsm.getString(2);
  		            	
  		          
  		            	pstf.setString(4,permis);
  		            	pstf.setString(6, PK);
  		            	pstf.setString(7, PJ);
  		            	
  		                vt= con.prepareStatement("select kilometrage from vehicule where matricule= ?");
  		            	vt.setString(1,matricule);
  		            	ResultSet rsv = vt.executeQuery();
  		            	if (rsv.next()==true ) {
  		            	pstf.setString(5, rsv.getString(1));
  		            	pstf.executeUpdate();


  		            	////// creer une contrat 
  		                pstk= con.prepareStatement("insert into contrat(id_res,n_permis,matricule, duree,datte,prenom,nom) values (?,?,?,?,?,?,?)");
  		            	pstk.setString(3,matricule);
  		            	pstk.setString(2, permis);  	
  		            	pstk.setString(1, res);
  		            	pstk.setString(4,dur);
  		            	pstk.setString(5, datte);  	
  		            	pstk.setString(6, preno);
  		            	pstk.setString(7, n);
  		            	pstk.executeUpdate(); 
  		            	
  		            	JOptionPane.showMessageDialog(null, "reservation Acceptee ! , le vehicule choisi : " +  matricule + "\n" + " Une contrat,Facture du location est etabli");
  		            	
  		            	}
  		            	}
  						 
  					 } 
  		            	else {
  						psty=con.prepareStatement("update reservation set Etat = ? where id_res = ? ");
  						psty.setString(1, "Refusee");
  						psty.setString(2, res);
  						psty.executeUpdate();
  						
  						JOptionPane.showMessageDialog(null, "Malheureusement , Reservation Refusee ! ");
  					 //reservation annulee 
  						 }
  					 }
							 
  					
  				  }

            		  
            		  
            	  }else {
						psty=con.prepareStatement("update reservation set Etat = ? where id_res = ? ");
						psty.setString(1, "Refusee");
						psty.setString(2, res);
						psty.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Malheureusement , Reservation Refusee ! "); 
						}
            	  
  
            	  
              }
              }
          
       
         
				 catch (SQLException e1)
			        {
			e1.printStackTrace();
			} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
				 
		});
		verifier.setBounds(669, 64, 117, 29);
		panel_5.add(verifier);
		
		id_res = new JTextField();
		id_res.setColumns(10);
		id_res.setBounds(46, 17, 205, 35);
		panel_5.add(id_res);
		
		JLabel lblNewLabel_6_2 = new JLabel("ID Reservation");
		lblNewLabel_6_2.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_2.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_2.setBounds(46, 5, 122, 16);
		panel_5.add(lblNewLabel_6_2);
		
		/////////////////////Recherche///////////////////////////////////////////////////
		
		JButton RechercheID_Res = new JButton("Recherche");
		RechercheID_Res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String res = id_res.getText();
			          
		 
		                pst = con.prepareStatement("select id_mod,n_permis,duree,dateD,nom,prenom,dateN,adresse,num from reservation where id_res = ?");
		               pst.setString(1, res);
		                ResultSet rs = pst.executeQuery();
		 
		            if(rs.next()==true)
		            {
		              
		                String id_mod = rs.getString(1);
		                String permis = rs.getString(2);
		                
		                
		                combomodele.setSelectedItem(id_mod);
		                id_client.setText(permis);
		                adresse.setText(rs.getString(8));
		            	Num.setText(rs.getString(9));
		            	date.setText(rs.getString(4));
		            	Nom.setText(rs.getString(5));
		            	dateN.setText(rs.getString(7));
		            	Duree.setText(rs.getString(3));
		            	prenomc.setText(rs.getString(6));
		            	
		                //marque.setText(Marque);
		               // categorie.setText(id_cat);
		                
		                
		               
		                
		                
		                
		            }  
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Reservation n'existe pas ! ");
		            	//matricule.setText(" ");
		               // marque.setText(" ");
		            }
		            
		        }
		catch (SQLException ex) {
			ex.printStackTrace();

		        }
				
			}
				
			
		});
		RechercheID_Res.setBounds(540, 64, 117, 29);
		panel_5.add(RechercheID_Res);
		
		JLabel lblNewLabel_6 = new JLabel("ID Client");
		lblNewLabel_6.setBounds(46, 47, 61, 16);
		panel_5.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(51, 102, 153));
		lblNewLabel_6.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		
		id_client = new JTextField();
		id_client.setBounds(43, 59, 205, 35);
		panel_5.add(id_client);
		id_client.setColumns(10);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 352, 1190, 448);
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
		

		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(27, 234, 1190, 94);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Les Informations de client :");
		lblNewLabel_6_2_1.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_2_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		lblNewLabel_6_2_1.setBounds(6, 6, 211, 16);
		panel_4.add(lblNewLabel_6_2_1);
		
		Num = new JTextField();
		Num.setBounds(952, 34, 205, 35);
		panel_4.add(Num);
		Num.setColumns(10);
		
		JLabel Numero = new JLabel("Numero telephone");
		Numero.setBounds(952, 18, 122, 16);
		panel_4.add(Numero);
		Numero.setForeground(new Color(51, 102, 153));
		Numero.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		
		Nom = new JTextField();
		Nom.setBounds(16, 34, 205, 35);
		panel_4.add(Nom);
		Nom.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Nom Client");
		lblNewLabel_7.setBounds(16, 18, 61, 16);
		panel_4.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 12));
		lblNewLabel_7.setForeground(new Color(51, 102, 153));
		
		prenomc = new JTextField();
		prenomc.setBounds(254, 34, 205, 35);
		panel_4.add(prenomc);
		prenomc.setColumns(10);
		
		JLabel lblNewLabel_6_4 = new JLabel("Prenom Client");
		lblNewLabel_6_4.setBounds(256, 18, 137, 16);
		panel_4.add(lblNewLabel_6_4);
		lblNewLabel_6_4.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_4.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		
		adresse = new JTextField();
		adresse.setBounds(721, 34, 205, 35);
		panel_4.add(adresse);
		adresse.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Adresse");
		lblNewLabel_6_1.setBounds(721, 18, 122, 16);
		panel_4.add(lblNewLabel_6_1);
		lblNewLabel_6_1.setForeground(new Color(51, 102, 153));
		lblNewLabel_6_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		
		dateN = new JTextField();
		dateN.setBounds(491, 34, 205, 35);
		panel_4.add(dateN);
		dateN.setColumns(10);
		
		JLabel pkm = new JLabel("Date Naissance");
		pkm.setBounds(491, 18, 98, 16);
		panel_4.add(pkm);
		pkm.setForeground(new Color(51, 102, 153));
		pkm.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 12));
		
	}
		
	

		
		
		public void setVisible(boolean b) {
			if (true) {
			frame.setVisible(true); }
	}
	}


