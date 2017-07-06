package com.students.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.students.model.Student;

public class TablePanel extends JPanel {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6457507102190570986L;
	
	private JTable studentsTable;
	private TableModel tableModel;
	
	public TablePanel() {
		initializeVariables();
		initializeLayout();
		initializeTableHeaderAlignment();
		initializeTableAlignment();
	}

	private void initializeVariables() {
		this.tableModel = new TableModel();
		this.studentsTable = new JTable(tableModel);
	}
	
	private void initializeLayout() {
		
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));
		add(new JScrollPane(studentsTable), BorderLayout.CENTER);
		
	}
	
	private void initializeTableHeaderAlignment() {
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		this.studentsTable.getTableHeader().setDefaultRenderer(cellRenderer);
	}
	
	private void initializeTableAlignment() {
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		this.studentsTable.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		this.studentsTable.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		this.studentsTable.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		this.studentsTable.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		this.studentsTable.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
	}
	
	public void setTableModel(List<Student> students) {
		this.tableModel.setStudentsList(students);
	}
	
	public void updateTable() {
		this.tableModel.updateTable();
	}

}
