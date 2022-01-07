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
		tabelica.getTableHeader();
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
			if(s.getSubjectYear() <= stud.getCurrentYear()
			//&& ako je u listi za nepolozene da ne bude u malom dijalogu
			&& (!stud.getOtherExams().contains(s))
			//&& ako je u listi polozenih da n ebude tu
			//&& (!s.getPassedSubject().contains(stud))
			) {
				Object[] row = {s.getSubjectCode(), s.getSubjectName()};
				notPassedTableModel.addRow(row);

			}
		}



        /*
         * Dodavanje predmeta na listu nepolozenih
         * Doda se u tabelu nepolozenih predmeta studenta
         * Ali takodje se doda u tabelu nepolozenih predmeta svih drugih studenata
         */
		
		/*
		 * TEST: Dodati novi nepolozeni predmet Djordju,
		 * a onda uci u Sandrine nepolozene predmete
		 * 
		 * Imacemo predmet u obe tabele,
		 * Ali kod Sandre ga opet mozemo dodati
		 * jer nije dodat u listu njenih nepolozenih predmeta
		 * vec samo na Djorjevu listu
		 */
        dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Subject predmet = SubjectController.getInstance().getSubjectByCode(tabelica.getSelectedRow());
				Student s = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());				
				s.getOtherExams().add(predmet);

				Object[] pred = {predmet.getSubjectCode(), predmet.getSubjectName(),
						predmet.getEspb(), predmet.getSubjectYear(), predmet.getSubjectSemester()};
					
					//NotPassedSubject.notPassedTableModel.addRow(pred);
					
					NotPassedSubject.getInstance().notPassedTableModel.addRow(pred);
					notPassedTableModel.removeRow(tabelica.getSelectedRow());
					NotPassedSubject.notPassedTableModel.fireTableDataChanged();
					NotPassedSubject.tabelica.repaint();
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
