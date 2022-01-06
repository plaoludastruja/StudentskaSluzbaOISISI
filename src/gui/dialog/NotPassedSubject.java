package gui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class NotPassedSubject extends JPanel {

	private static NotPassedSubject instance = null;
	public static NotPassedSubject getInstance() {
		if(instance == null) {
			instance = new NotPassedSubject();
		}
		return instance;
	}
	
	public NotPassedSubject() {
	
		
		JPanel notPassedSubject = new JPanel(new BorderLayout());
		
		JPanel dugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton dodaj = new JButton("Dodaj");
        JButton obrisi = new JButton("Obrisi");
        JButton polaganje = new JButton("Polaganje");
		dugme.add(dodaj);
        dugme.add(obrisi);
        dugme.add(polaganje);

		JTable tabelica = new JTable();
		tabelica.setRowSelectionAllowed(true);
		tabelica.setColumnSelectionAllowed(true);
		tabelica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelica.getTableHeader();
		
		DefaultTableModel passedTableModel = new DefaultTableModel();
		Vector<String> kolone = new Vector<String>();

		kolone.add("SifraPredmeta");
		kolone.add("NazivPredmeta");
		kolone.add("ESPB");
		kolone.add("Godina Studija");
		kolone.add("Semestar");
		passedTableModel.setColumnIdentifiers(kolone);
		tabelica.setModel(passedTableModel);

		JScrollPane tabela = new JScrollPane(tabelica);
		
		notPassedSubject.add(dugme, BorderLayout.NORTH);
		notPassedSubject.add(tabela, BorderLayout.CENTER);
		
		add(notPassedSubject);
		}
}