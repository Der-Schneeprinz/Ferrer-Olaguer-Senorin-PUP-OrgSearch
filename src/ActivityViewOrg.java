import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import java.awt.ScrollPane;
import javax.swing.JSeparator;

public class ActivityViewOrg {

	//GUI Variables 
	private JFrame frmActivityViewOrg;
	
	//Connection Variables
	private Connection objConn;
	private boolean boolConn2Db = false;
	private Statement objSQLQuery;
	private ResultSet objResultSet;
	
	//User Variables
	String Email,Password;//put to main
	private JButton btnProfile;
	private JButton btnBack;
	private JLabel lblOrganizationName;
	private JSeparator separator;
	private ScrollPane scrollPane;
	private JLabel lblOrgsJoined;
	private JButton btnJoin;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityViewOrg window = new ActivityViewOrg();
					window.frmActivityViewOrg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ActivityViewOrg() {
		try {
			//connecting to server
			String strDriver = "com.mysql.cj.jdbc.Driver";
	        String strConn = "jdbc:mysql://localhost:3306/dbpuporgsearch";
	        String strUser = "root";
	        String strPass = "Whippycape2012";
        	Class.forName(strDriver);
			objConn = DriverManager.getConnection(strConn, strUser, strPass);
			objSQLQuery = objConn.createStatement();
			boolConn2Db = true;
			if (boolConn2Db) {
				System.out.println("Connected Succesfully..");
				initialize();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Connected Unsuccesfully..");
			e.printStackTrace();
		}  
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frmActivityViewOrg = new JFrame();
		frmActivityViewOrg.getContentPane().setBackground(new Color(176, 224, 230));
		//frmActivityViewOrg.setContentPane(new JLabel(new ImageIcon(ActivityViewOrg.class.getResource("/images/background.png"))));		
		frmActivityViewOrg.setTitle("PUP Organization Search");
		frmActivityViewOrg.setBounds(0, 0, (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3),(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		System.out.println(("Hello"+Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3) + " " + (Toolkit.getDefaultToolkit().getScreenSize().getHeight()));//to know screen size, mine 455.3333333333333 768.0
		frmActivityViewOrg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmActivityViewOrg.getContentPane().setLayout(null);
		
		btnProfile = new JButton(new ImageIcon(ActivityViewOrg.class.getResource("/images/user.png")));
		btnProfile.setBounds(10, 11, 100, 100);
		frmActivityViewOrg.getContentPane().add(btnProfile);
		
		btnBack = new JButton("BACK");
		btnBack.setOpaque(false);
		btnBack.setForeground(new Color(255, 69, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setBounds(145, 695, 150, 23);
		frmActivityViewOrg.getContentPane().add(btnBack);
		
		lblOrganizationName = new JLabel("Organization Name");
		lblOrganizationName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblOrganizationName.setBounds(120, 11, 309, 31);
		frmActivityViewOrg.getContentPane().add(lblOrganizationName);
		
		separator = new JSeparator();
		separator.setBounds(10, 156, 419, 23);
		frmActivityViewOrg.getContentPane().add(separator);
		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 197, 419, 460);
		/*
		 * contentPane.add(scrollPane);
			JList list = new JList(objPosts.toArray());
			scrollPane.setViewportView(list);	
		 */
		frmActivityViewOrg.getContentPane().add(scrollPane);
		frmActivityViewOrg.getContentPane().add(scrollPane);
		
		lblOrgsJoined = new JLabel("POSTS");
		lblOrgsJoined.setVerticalAlignment(SwingConstants.BOTTOM);
		lblOrgsJoined.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblOrgsJoined.setBounds(20, 160, 319, 31);
		frmActivityViewOrg.getContentPane().add(lblOrgsJoined);
		
		btnJoin = new JButton("Join");
		btnJoin.setBounds(20, 122, 79, 23);
		frmActivityViewOrg.getContentPane().add(btnJoin);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblDescription.setBounds(120, 35, 309, 31);
		frmActivityViewOrg.getContentPane().add(lblDescription);
		
		JLabel lblOrganizationType = new JLabel("Organization Type");
		lblOrganizationType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrganizationType.setBounds(120, 118, 159, 31);
		frmActivityViewOrg.getContentPane().add(lblOrganizationType);
		
		JButton btnEditDetails = new JButton("EDIT");
		btnEditDetails.setOpaque(false);
		btnEditDetails.setForeground(new Color(255, 69, 0));
		btnEditDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEditDetails.setContentAreaFilled(false);
		btnEditDetails.setBorderPainted(false);
		btnEditDetails.setBounds(349, 122, 80, 23);
		frmActivityViewOrg.getContentPane().add(btnEditDetails);
		
		JButton btnCreatePost = new JButton("Create Post");
		btnCreatePost.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreatePost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreatePost.setBounds(10, 652, 419, 37);
		frmActivityViewOrg.getContentPane().add(btnCreatePost);
		
	}
}
