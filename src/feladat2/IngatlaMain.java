package feladat2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class IngatlaMain {

	private JFrame frame;
	private List<Ingatlan> ingatlanok;
	private DefaultListModel<Ingatlan> listModel;
	private JList lstIngatlanok;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngatlaMain window = new IngatlaMain();
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
	public IngatlaMain() {
		try {
			Dbkezelo.connectToDB();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame,"Adatbázis Hiba","Hiba", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("sikeres DB kapcsolat");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Object[] options = {"igen", "nem", "mentés"};
			
				
				if (JOptionPane.showOptionDialog(frame, "Biztos ki akar lépni, mentés gombra kattintva a napi változások is elmentődnek", "Kilépés", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]) == JOptionPane.YES_OPTION) {
					try {
						Dbkezelo.disconnectFromDB();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frame, "Adatbázis zárás sikertelen","Hiba", JOptionPane.ERROR_MESSAGE);
					}
					System.exit(0);
				}
				
				
			}
		});
		frame.setBounds(100, 100, 500, 434);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ingatlanok = new ArrayList<Ingatlan>();
		try {
			ingatlanok = Dbkezelo.readHouse();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(frame,"Adatbázis Hiba","Hiba", JOptionPane.ERROR_MESSAGE);
		}
		JButton btnExit = new JButton("Kilépés");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(360, 371, 117, 29);
		frame.getContentPane().add(btnExit);
		
		JButton btnSearch = new JButton("Keresés");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modDelSearchHouse();
			}
		});
		btnSearch.setBounds(19, 31, 117, 29);
		frame.getContentPane().add(btnSearch);
		
		JButton btnDelete = new JButton("Törlés");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modDelSearchHouse();
			}
		});
		btnDelete.setBounds(19, 91, 117, 29);
		frame.getContentPane().add(btnDelete);
		
		JButton btnMod = new JButton("Ár Módosítás");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modDelSearchHouse();
			}
		});
		btnMod.setBounds(19, 145, 117, 29);
		frame.getContentPane().add(btnMod);
		
		lstIngatlanok = new JList();
		lstIngatlanok.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstIngatlanok.setBounds(207, 36, 270, 323);
		frame.getContentPane().add(lstIngatlanok);
		listaHozzarendeles();
	}
	private void listaHozzarendeles() {
		
		listModel = new DefaultListModel<Ingatlan>();
		for (Ingatlan ingatlan : ingatlanok) {
			
			listModel.addElement(ingatlan);
		}
		lstIngatlanok.setModel(listModel);
		
		}
	private void modDelSearchHouse() {
		DelModHouse ownWindow = new DelModHouse(ingatlanok);
		ownWindow.setVisible(true);
		
	}

	
}
