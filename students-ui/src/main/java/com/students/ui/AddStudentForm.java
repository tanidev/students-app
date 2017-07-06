package com.students.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.students.callbacks.AddStudentCallback;
import com.students.model.Student;
import com.students.service.AddStudentFormService;
import com.students.service.impl.AddStudentFormServiceImpl;
import com.students.util.NumberConstants;
import com.students.util.StringConstants;

public class AddStudentForm extends JDialog implements ActionListener {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -810802901922175935L;
	
	private JButton cancelButton;
	private JButton saveButton;
	private JLabel nameLabel;
	private JLabel ageLabel;
	private JLabel countryLabel;
	private JLabel zipCodeLabel;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField countryField;
	private JTextField zipCodeField;
	private AddStudentFormService addStudentFormService;

	private AddStudentCallback addStudentCallback;
	
	public AddStudentForm(JFrame parentFrame) {
		
		super(parentFrame, StringConstants.ADD_STUDENT_FORM_TITLE, false);
		initializeVariables();
		constructLayout();
		setWindow(parentFrame);
		
	}

	private void initializeVariables() {
		
		this.cancelButton = new JButton(StringConstants.ADD_STUDENT_FORM_CANCEL_BUTTON);
		this.cancelButton.addActionListener(this);
		
		this.saveButton = new JButton(StringConstants.ADD_STUDENT_FORM_SAVE_BUTTON);
		this.saveButton.addActionListener(this);
		
		this.nameLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_NAME_LABEL);
		this.ageLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_AGE_LABEL);
		this.countryLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_COUNTRY_LABEL);
		this.zipCodeLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_ZIP_CODE_LABEL);
		this.nameField = new JTextField(10);
		this.ageField = new JTextField(10);
		this.countryField = new JTextField(10);
		this.zipCodeField = new JTextField(10);
		
		this.addStudentFormService = new AddStudentFormServiceImpl();
	}

	private void constructLayout() {
		
		JPanel studentInfoPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		
		Border spaceBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
		Border titleBorder = BorderFactory.createTitledBorder(StringConstants.ADD_STUDENT_FORM_SUBTITLE);
		
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
		studentInfoPanel.add(nameLabel, gridBagConstraints);
		
		gridBagConstraints.gridx++;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = noPadding;
		studentInfoPanel.add(nameField, gridBagConstraints);
		
		//Next line
		gridBagConstraints.gridy++;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.insets = rightPadding;
		studentInfoPanel.add(ageLabel, gridBagConstraints);
		
		gridBagConstraints.gridx++;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = noPadding;
		studentInfoPanel.add(ageField, gridBagConstraints);
		
		//Next line
		gridBagConstraints.gridy++;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.insets = rightPadding;
		studentInfoPanel.add(countryLabel, gridBagConstraints);
		
		gridBagConstraints.gridx++;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = noPadding;
		studentInfoPanel.add(countryField, gridBagConstraints);
		
		//Next line
		gridBagConstraints.gridy++;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.insets = rightPadding;
		studentInfoPanel.add(zipCodeLabel, gridBagConstraints);
		
		gridBagConstraints.gridx++;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = noPadding;
		studentInfoPanel.add(zipCodeField, gridBagConstraints);
		
		//Buttons panel
		buttonsPanel.add(saveButton);
		buttonsPanel.add(cancelButton);
		
		Dimension btnSize = cancelButton.getPreferredSize();
		saveButton.setPreferredSize(btnSize);
		
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
		} else if(e.getSource().equals(this.saveButton)) {
			
			String name = this.nameField.getText();
			Integer age = Integer.parseInt(this.ageField.getText());
			String country = this.countryField.getText();
			Integer zipCode = Integer.parseInt(this.zipCodeField.getText());
			
			Student student = new Student(name, age, country, zipCode);
			this.addStudentFormService.insertStudent(student);
			this.addStudentCallback.studentSaved();
			setVisible(Boolean.FALSE);
		}
		
	}

	public void setCallback(AddStudentCallback addStudentCallback) {
		this.addStudentCallback = addStudentCallback;
	}

}
