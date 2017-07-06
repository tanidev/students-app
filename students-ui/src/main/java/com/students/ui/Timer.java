package com.students.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class Timer extends Thread {
	
	private boolean isRunning;
	private JLabel timeLabel;
	private SimpleDateFormat timeFormat;
	
	public Timer(JLabel timeLabel) {
		initializeVariables(timeLabel);
	}

	private void initializeVariables(JLabel timeLabel) {
		this.timeLabel = timeLabel;
		this.timeFormat = new SimpleDateFormat("HH:mm:ss");
		this.isRunning = Boolean.TRUE;
	}
	
	@Override
	public void run() {
		while(isRunning) {
			Date currentTime = new Date();
			timeLabel.setText(timeFormat.format(currentTime));
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

}
