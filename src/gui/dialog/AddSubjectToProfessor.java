package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.ProfessorController;
import controller.StudentController;
import controller.SubjectController;
import gui.AbstractTableModelNotPassedTableModel;
import gui.AbstractTableModelProfessorOnSubject;
import gui.MainFrame;
import gui.ProfessorTable;
import gui.StudentTable;
import model.BazaSubject;
import model.Grade;
import model.Professor;
import model.Student;
import model.Subject;

public class AddSubjectToProfessor extends JDialog {

	public static DefaultTableModel profSubTableModel;
	public static JTable profSubTable;
	
	public AddSubjectToProfessor(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		setSize(400, 250);
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);
		
		JPanel notPassedSubject = new JPanel(new BorderLayout());
		JPanel dugme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton dodaj = new JButton("Dodaj");
        JButton odustani = new JButton("Odustani");
        
        profSubTable = new JTable();
		
        profSubTable.setRowSelectionAllowed(true);
        profSubTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        profSubTable.getTableHeader().setReorderingAllowed(false);;
        profSubTable.setSelectionBackground(Color.LIGHT_GRAY);
		
		
		profSubTableModel = new DefaultTableModel();
		profSubTable.setModel(profSubTableModel);
		
		Vector<String> kolone = new Vector<String>();
		kolone.add("SifraPredmeta");
		kolone.add("ImePredmeta");
		profSubTableModel.setColumnIdentifiers(kolone);
		
		
		/*
		 * Ispisujem predmete koji se mogu dodati studentu
		 */
		
		List<Subject> predmeti = SubjectController.getInstance().getSubjects();
		//Student stud = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
		Professor p = ProfessorController.getInstance().getProfessortByID(ProfessorTable.getInstance().getSelectedRow());	
		List<Object[]> forAdd = new ArrayList<Object[]>();
		for(Subject s : predmeti) {
		
		boolean add = true;
		if(p.getListofSubjects().contains(s))
			add = false;
		
//		for(Subject g : p.getListofSubjects()) {
//			if(g.getSubjectCode().equals(s.getSubjectCode())) {
//				add = false;
//			}
//		}
			if(add) {
				Object[] row = {s.getSubjectCode(), s.getSubjectName()};
				//forAdd.add(row);
				profSubTableModel.addRow(row);
				
				
			}
				

		}
		for (Object[] o : forAdd) {
			profSubTableModel.addRow(o);
		}

		/*
		 * Listeneri
		 */
		
        dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(profSubTable.getSelectedRow()!=-1) {

					Subject predmet = BazaSubject.getInstance().getSubjectByCode(profSubTable.getValueAt(profSubTable.getSelectedRow(), 0).toString());
					//Student s = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
					Professor p = ProfessorController.getInstance().getProfessortByID(ProfessorTable.getInstance().getSelectedRow());	
					
					p.getListofSubjects().add(predmet);
	
	//					Object[] pred = {predmet.getSubjectCode(), predmet.getSubjectName(),
	//							predmet.getEspb(), predmet.getSubjectYear(), predmet.getSubjectSemester()};
					profSubTableModel.removeRow(profSubTable.getSelectedRow());
							
					AbstractTableModelProfessorOnSubject model = (AbstractTableModelProfessorOnSubject) ProfessorOnSubject.proSubTableModel;
							// azuriranje modela tabele, kao i njenog prikaza
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
        
        
        JScrollPane tabela = new JScrollPane(profSubTable);
		dugme.add(dodaj);
        dugme.add(odustani);
        
		notPassedSubject.add(tabela,BorderLayout.CENTER);
		notPassedSubject.add(dugme,BorderLayout.SOUTH);
		
		add(notPassedSubject);
		
	}
}
