package feladat2;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;

public class DelModHouse extends JDialog {
	private JTextField txfHrsz;
	private JTextField txfErtek;
	private Ingatlan ingatlan;
	private List<Ingatlan> ingatlanok;


	private boolean dialogResult = false;
	private JLabel lblTulaj;
	private JLabel lblAlapterulet;
	private JTextField txfAlapterulet;

	public boolean isDialogResult() {
		return dialogResult;
	}
	public Ingatlan getIngatlan() {
		return ingatlan;
	}
	

	/**
	 * Create the dialog.
	 */
	public DelModHouse(List<Ingatlan> ingatlanok) {
		this.ingatlanok = ingatlanok;
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblHrsz = new JLabel("HRSZ");
		lblHrsz.setBounds(39, 23, 118, 16);
		getContentPane().add(lblHrsz);
		
		txfHrsz = new JTextField();
		txfHrsz.setBounds(238, 18, 130, 26);
		getContentPane().add(txfHrsz);
		txfHrsz.setColumns(10);
		
		lblTulaj = new JLabel("Tulajdonos");
		lblTulaj.setBounds(39, 66, 156, 16);
		getContentPane().add(lblTulaj);
		
		lblAlapterulet = new JLabel("Alapterulet");
		lblAlapterulet.setBounds(39, 104, 156, 16);
		getContentPane().add(lblAlapterulet);
		
		JLabel lblErtek = new JLabel("Érték");
		lblErtek.setBounds(39, 152, 61, 16);
		getContentPane().add(lblErtek);
		
		txfErtek = new JTextField();
		txfErtek.setColumns(10);
		txfErtek.setBounds(238, 147, 130, 26);
		getContentPane().add(txfErtek);
		
		JButton btnMod = new JButton("Módosítás");
		btnMod.setBounds(56, 218, 117, 29);
		getContentPane().add(btnMod);
		
		JButton btnDel = new JButton("Törlés");
		btnDel.setBounds(187, 218, 117, 29);
		getContentPane().add(btnDel);
		
		JButton btnCancel = new JButton("Mégsem");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(316, 218, 117, 29);
		getContentPane().add(btnCancel);
		
		JButton btnSearch = new JButton("Keresés");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				search();
			}
		});
		btnSearch.setBounds(66, 185, 358, 29);
		getContentPane().add(btnSearch);
		
		txfAlapterulet = new JTextField();
		txfAlapterulet.setBounds(238, 99, 130, 26);
		getContentPane().add(txfAlapterulet);
		txfAlapterulet.setColumns(10);

	}
	
	public void search() {
		if (!txfHrsz.getText().isBlank()) {
			
		for (Ingatlan ingatlan : ingatlanok) {
			
			if (txfHrsz.getText().equals(ingatlan.getHrsz())) {
				lblTulaj.setText(ingatlan.getTulajdonos());
				txfAlapterulet.setText(Integer.toString(ingatlan.getAlapterulet()));
				txfErtek.setText(Integer.toString(ingatlan.getAr()));
			}
			
		}
			
		}else {
			JOptionPane.showMessageDialog(this, "HRSZ-t ki kell tölteni", "Figyelmeztetés", JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
