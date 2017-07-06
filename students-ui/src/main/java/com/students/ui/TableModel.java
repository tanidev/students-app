package com.students.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.students.model.Student;
import com.students.util.NumberConstants;

public class TableModel extends AbstractTableModel {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1200938650055850786L;
	
	private List<Student> studentsList;
	String[] columnNames = {"ID", "NAME", "AGE", "COUNTRY", "ZIP CODE"};
	
	public TableModel() {
		this.studentsList = new ArrayList<>();
	}

	@Override
	public int getRowCount() {
		return studentsList.size();
	}

	@Override
	public int getColumnCount() {
		return NumberConstants.NUM_OF_COLUMNS_STUDENT_TABLE;
	}
	
	@Override
	public String getColumnName(int column) {
		return this.columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student = this.studentsList.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return student.getId();
		case 1:
			return student.getName();
		case 2:
			return student.getAge();
		case 3:
			return student.getCountry();
		case 4:
			return student.getZipCode();
		default:
			return null;
		}
	
	}
	
	public void setStudentsList(List<Student> studentsList) {
		this.studentsList = studentsList;
	}
	
	public void updateTable() {
		fireTableDataChanged();
	}

}
