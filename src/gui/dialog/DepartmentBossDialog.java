package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.DepartmentController;
import controller.ProfessorController;
import controller.StudentController;
import controller.SubjectController;
import gui.AbstractTableModelDepartment;
import gui.AbstractTableModelNotPassedTableModel;
import gui.MainFrame;
import gui.StudentTable;
import model.BazaSubject;
import model.Department;
import model.Grade;
import model.Professor;
import model.Student;
import model.Subject;

public class DepartmentBossDialog extends JDialog {


	public static DefaultTableModel departmentBossTableModel;
	public static JTable deparmentBossTable;
	
	public DepartmentBossDialog() {
		
		//super(parent, title, modal);
		setTitle("Dodavanje sefa katedre");
		setModal(true);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel departmentPanel = new JPanel(new BorderLayout());
		JPanel dugme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton dodaj = new JButton("Dodaj sefa katedre");

        
		deparmentBossTable = new JTable();
		
		deparmentBossTable.setRowSelectionAllowed(true);
		deparmentBossTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		deparmentBossTable.getTableHeader().setReorderingAllowed(false);;
		deparmentBossTable.setSelectionBackground(Color.LIGHT_GRAY);
//		
//		
		departmentBossTableModel = new DefaultTableModel();
        deparmentBossTable.setModel(departmentBossTableModel);
        
        Vector<String> kolone = new Vector<String>();
		kolone.add("ImeProfesora");
		kolone.add("PrezimeProfesora");
		kolone.add("IDProfesora");
		departmentBossTableModel.setColumnIdentifiers(kolone);
		
		List<Professor> prof = ProfessorController.getInstance().getProfesori();
		Department d = DepartmentController.getInstance().getDepartment(DepartmentDialog.deparmentTable.getSelectedRow());
		//Subject subj = SubjectController.getInstance().getSubjectByCode(StudentTable.getInstance().getSelectedRow());
		Professor trenutniBoss = d.getDepartmentBoss();
		List<Professor> departmentProfessor = d.getDepartmentProffesor();
		

		for(Professor s : departmentProfessor) {
			if(s.getWorkingYear() >= 5
			&& (s.getPosition() == "vanredni profesor" || s.getPosition() == "redovni profesor")
			&& !(s.getIdCard().equals(trenutniBoss.getIdCard())))
			{

				Object[] row = {s.getFirstName(), s.getLastName(), s.getIdCard()};
				departmentBossTableModel.addRow(row);
			
			}
		}
        dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(deparmentBossTable.getSelectedRow()!=-1) {
					
					Professor noviBoss = ProfessorController.getInstance().getProfessortByID2(deparmentBossTable.getSelectedRow());
					//d.setDepartmentBoss(deparmentBossTable.getSelectedRow());
					d.setDepartmentBoss(noviBoss);
				}
				//AbstractTableModelDepartment model = (AbstractTableModelDepartment) DepartmentDialog.deparmentTable;
				// azuriranje modela tabele, kao i njenog prikaza
		        DepartmentDialog.departmentTableModel.fireTableDataChanged();
		        validate();

				dispose();
			}
			 
		});

        
        
        JScrollPane tabela = new JScrollPane(deparmentBossTable);
		dugme.add(dodaj);

        
        add(tabela,BorderLayout.CENTER);
        add(dugme,BorderLayout.SOUTH);
	//	pack();
       
		
	}
}
