package com.students.ui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.students.util.StringConstants;

public class StatusPanel extends JPanel {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3355827946764459853L;
	
	private JLabel statusLabel;
	private JLabel timerLabel;
	private Timer timer;
	
	public StatusPanel() {
		initializeVariables();
		initializeLayout();
		startTimer();
	}

	private void initializeVariables() {
		statusLabel = new JLabel(StringConstants.STATUS_PANEL_TEXT);
		timerLabel = new JLabel();
		timer = new Timer(timerLabel);
	}

	private void initializeLayout() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(statusLabel);
		add(timerLabel);
	}
	
	private void startTimer() {
		this.timer.start();
	}
	
	
	@SuppressWarnings("unused")
	private void stopTimer() {
		this.timer.setRunning(false);
	}

}
