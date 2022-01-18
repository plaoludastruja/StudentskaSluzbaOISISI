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

import controller.DepartmentController;
import controller.ProfessorController;
import controller.StudentController;
import controller.SubjectController;
import gui.AbstractTableModelDepartment;
import gui.AbstractTableModelNotPassedTableModel;
import gui.MainFrame;
import gui.ProfessorTable;
import gui.StudentTable;
import model.BazaSubject;
import model.Department;
import model.Professor;
import model.Student;
import model.Subject;

public class DepartmentDialog extends JDialog{

	public static AbstractTableModelDepartment departmentTableModel;
	public static JTable deparmentTable;
	
	public DepartmentDialog() {
		
		//super(parent, title, modal);
		setTitle("Katedra");
		setModal(true);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel departmentPanel = new JPanel(new BorderLayout());
		JPanel dugme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton dodaj = new JButton("Dodaj sefa katedre");

        
        deparmentTable = new JTable();
		
        deparmentTable.setRowSelectionAllowed(true);
        deparmentTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        deparmentTable.getTableHeader().setReorderingAllowed(false);;
        deparmentTable.setSelectionBackground(Color.LIGHT_GRAY);
//		
//		
        departmentTableModel = new AbstractTableModelDepartment();
        deparmentTable.setModel(departmentTableModel);

        dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(deparmentTable.getSelectedRow()!=-1) {
					DepartmentBossDialog departmentBoss = new DepartmentBossDialog();
					departmentBoss.setVisible(true);
				}
				
//				if(deparmentTable.getSelectedRow()!=-1) {
//					Department d = DepartmentController.getInstance().getDepartment(StudentTable.getInstance().getSelectedRow());
//					
//					d.setDepartmentBoss(null)
//				}

			}
			
		});

        
        
        JScrollPane tabela = new JScrollPane(deparmentTable);
		dugme.add(dodaj);

        
        add(tabela,BorderLayout.CENTER);
        add(dugme,BorderLayout.SOUTH);
		pack();

		
	}
}
