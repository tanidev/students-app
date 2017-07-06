package com.students.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.students.callbacks.RemoveStudentCallback;
import com.students.model.Student;
import com.students.service.RemoveStudentFormService;
import com.students.service.impl.RemoveStudentFormServiceImpl;
import com.students.util.NumberConstants;
import com.students.util.StringConstants;

public class RemoveStudentForm extends JDialog implements ActionListener {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 607762627098487952L;
	
	private JButton cancelButton;
	private JButton removeButton;
	private JLabel studentLabel;
	private JComboBox<Student> studentComboBox;
	private RemoveStudentFormService removeStudentFormService;

	private RemoveStudentCallback removeStudentCallback;
	
	public RemoveStudentForm(JFrame parentFrame) {
		
		super(parentFrame, StringConstants.REMOVE_STUDENT_FORM_TITLE, false);
		initializeVariables();
		loadData();
		constructLayout();
		setWindow(parentFrame);
		
	}

	private void initializeVariables() {
		
		this.cancelButton = new JButton(StringConstants.REMOVE_STUDENT_FORM_CANCEL_BUTTON);
		this.cancelButton.addActionListener(this);
		
		this.removeButton = new JButton(StringConstants.REMOVE_STUDENT_FORM_SAVE_BUTTON);
		this.removeButton.addActionListener(this);
		
		this.studentLabel = new JLabel(StringConstants.REMOVE_STUDENT_FORM_STUDENT_LABEL);
		this.studentComboBox = new JComboBox<>();
		
		this.removeStudentFormService = new RemoveStudentFormServiceImpl();
	}
	
	public void loadData() {
		
		studentComboBox.removeAllItems();
		
		List<Student> studentsToRemove = removeStudentFormService.getAllStudents();
		studentsToRemove.forEach(studentComboBox::addItem);
		
	}

	private void constructLayout() {
		
		JPanel studentInfoPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		
		Border spaceBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
		Border titleBorder = BorderFactory.createTitledBorder(StringConstants.REMOVE_STUDENT_FORM_SUBTITLE);
		
		studentInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		studentInfoPanel.setLayout(new GridBagLayout());
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		Insets rightPadding = new Insets(0, 0, 0, 15);
		Insets noPadding = new Insets(0, 0, 0, 0);
		
		//First line
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.insets = rightPadding;
		studentInfoPanel.add(studentLabel, gridBagConstraints);
		
		gridBagConstraints.gridx++;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = noPadding;
		studentInfoPanel.add(studentComboBox, gridBagConstraints);
		
		//Buttons panel
		buttonsPanel.add(removeButton);
		buttonsPanel.add(cancelButton);
		
		Dimension btnSize = cancelButton.getPreferredSize();
		removeButton.setPreferredSize(btnSize);
		
		setLayout(new BorderLayout());
		add(studentInfoPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		setResizable(Boolean.FALSE);
				
	}

	private void setWindow(JFrame parentFrame) {
		setSize(NumberConstants.STUDENT_FORM_WINDOW_SIZE_WIDTH, NumberConstants.STUDENT_FORM_WINDOW_SIZE_HEIGHT);;
		setLocationRelativeTo(parentFrame);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(this.cancelButton)) {
			setVisible(Boolean.FALSE);
		} else if(e.getSource().equals(this.removeButton)) {
			
			Student student = (Student) this.studentComboBox.getSelectedItem();
			removeStudentFormService.deleteStudent(student);
			removeStudentCallback.studentRemoved();
			setVisible(Boolean.FALSE);
		}
		
	}

	public void setCallback(RemoveStudentCallback removeStudentCallback) {
		this.removeStudentCallback = removeStudentCallback;
	}

}
