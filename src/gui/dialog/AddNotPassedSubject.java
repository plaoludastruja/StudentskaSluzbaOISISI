package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import controller.StudentController;
import controller.SubjectController;
import gui.AbstractTableModelNotPassedTableModel;
import gui.MainFrame;
import gui.StudentTable;
import model.BazaSubject;
import model.Grade;
import model.Student;
import model.Subject;

public class AddNotPassedSubject extends JDialog {
	
	public static DefaultTableModel notPassedTableModel;
	public static JTable tabelica;
	
	public AddNotPassedSubject(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		setSize(400, 250);
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);
		
		JPanel notPassedSubject = new JPanel(new BorderLayout());
		JPanel dugme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton dodaj = new JButton("Dodaj");
        JButton odustani = new JButton("Odustani");
        tabelica = new JTable();
		
		tabelica.setRowSelectionAllowed(true);
		tabelica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelica.getTableHeader().setReorderingAllowed(false);;
		tabelica.setSelectionBackground(Color.LIGHT_GRAY);
		
		
		DefaultTableModel notPassedTableModel = new DefaultTableModel();
		tabelica.setModel(notPassedTableModel);
		
		Vector<String> kolone = new Vector<String>();
		kolone.add("SifraPredmeta");
		kolone.add("ImePredmeta");
		notPassedTableModel.setColumnIdentifiers(kolone);
		
		
		/*
		 * Ispisujem predmete koji se mogu dodati studentu
		 */
		
		List<Subject> predmeti = SubjectController.getInstance().getSubjects();
		Student stud = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());

		for(Subject s : predmeti) {
			if(s.getSubjectYear() <= stud.getCurrentYear() && (!stud.getOtherExams().contains(s))){
				boolean add = true;
				
				for(Grade g : stud.getPassedExams()) {
					if(g.getSubject().getSubjectCode().equals(s.getSubjectCode())) {
						add = false;
					}
				}
				
				if(add) {
					Object[] row = {s.getSubjectCode(), s.getSubjectName()};
					notPassedTableModel.addRow(row);
				}
			}
		}

		
        dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(tabelica.getSelectedRow()!=-1) {

					Subject predmet = BazaSubject.getInstance().getSubjectByCode(tabelica.getValueAt(tabelica.getSelectedRow(), 0).toString());
					Student s = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
					
					s.getOtherExams().add(predmet);

					notPassedTableModel.removeRow(tabelica.getSelectedRow());	
					AbstractTableModelNotPassedTableModel model = (AbstractTableModelNotPassedTableModel) NotPassedSubject.notPassedTableModel;
					model.fireTableDataChanged();
					validate();
					dispose();
				
						
				}
			}
		});
		
        
        odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        
        
        JScrollPane tabela = new JScrollPane(tabelica);
		dugme.add(dodaj);
        dugme.add(odustani);
        
		notPassedSubject.add(tabela,BorderLayout.CENTER);
		notPassedSubject.add(dugme,BorderLayout.SOUTH);
		
		add(notPassedSubject);
		
	}
	
}
