package com.students.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.students.callbacks.AddStudentCallback;
import com.students.callbacks.RemoveStudentCallback;
import com.students.model.Student;
import com.students.service.MainFrameService;
import com.students.service.impl.MainFrameServiceImpl;
import com.students.util.NumberConstants;
import com.students.util.StringConstants;

public class MainFrame extends JFrame implements AddStudentCallback, RemoveStudentCallback {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2530989119935934612L;
	
	private MainFrameService mainFrameService;
	private TablePanel tablePanel;
	private StatusPanel statusPanel;
	private AddStudentForm addStudentForm;
	private RemoveStudentForm removeStudentForm;

	public MainFrame() {
		super(StringConstants.APP_NAME);
		constructAppWindow();
		setJMenuBar(createFrameMenu());
		initializeVariables();
		constructLayout();
		refreshTable();
		setCallbacks();
	}

	private void setCallbacks() {
		this.addStudentForm.setCallback(this);
		this.removeStudentForm.setCallback(this);
	}

	private void refreshTable() {
		List<Student> students = mainFrameService.getAllStudents();
		this.tablePanel.setTableModel(students);
		this.tablePanel.updateTable();
	}

	private void constructAppWindow() {
		setSize(NumberConstants.APPLICATION_WINDOW_SIZE_WIDTH, NumberConstants.APPLICATION_WINDOW_SIZE_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(Boolean.TRUE);
	}
	
	private JMenuBar createFrameMenu() {
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu(StringConstants.MAIN_MENU_FILE);
		JMenuItem openItem = new JMenuItem(StringConstants.FILE_MENU_ITEM_OPEN);
		JMenuItem exitItem = new JMenuItem(StringConstants.FILE_MENU_ITEM_EXIT);
		fileMenu.add(openItem);
		fileMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu(StringConstants.MAIN_MENU_WINDOW);
		JMenuItem addItem = new JMenuItem(StringConstants.WINDOW_MENU_ITEM_ADD_STUDENT);
		JMenuItem removeItem = new JMenuItem(StringConstants.WINDOW_MENU_ITEM_REMOVE_STUDENT);
		windowMenu.add(addItem);
		windowMenu.add(removeItem);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		addItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: Showing add student form	
				addStudentForm.setVisible(Boolean.TRUE);
			}
		});
		
		removeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeStudentForm.setVisible(Boolean.TRUE);		
			}
		});
		
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int action = JOptionPane.showConfirmDialog(MainFrame.this, StringConstants.FILE_MENU_ITEM_EXIT_TEXT, StringConstants.FILE_MENU_ITEM_EXIT_TITLE, JOptionPane.OK_CANCEL_OPTION);
				if(action == JOptionPane.OK_OPTION) {
					System.gc();
					System.exit(0);
				}
			}
		});
		
		return menuBar;
	}
	
	private void initializeVariables() {
		this.mainFrameService = new MainFrameServiceImpl();
		this.tablePanel = new TablePanel();
		this.statusPanel = new StatusPanel();
		this.addStudentForm = new AddStudentForm(this);
		this.removeStudentForm = new RemoveStudentForm(this);
	}
	
	private void constructLayout() {
		setLayout(new BorderLayout());
		add(tablePanel, BorderLayout.CENTER);
		add(statusPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void studentSaved() {
		refreshTable();
		this.removeStudentForm.loadData();
	}
	
	@Override
	public void studentRemoved() {
		refreshTable();
		this.removeStudentForm.loadData();
	}

}
