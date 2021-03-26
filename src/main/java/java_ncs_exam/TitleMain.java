package java_ncs_exam;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java_ncs_exam.control.TitleManagerUI;

@SuppressWarnings("serial")
public class TitleMain extends JFrame {
	private TitleManagerUI titleFrame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleMain frame = new TitleMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public TitleMain() {
		createFrame();
	}

	public void createFrame() {
		titleFrame = new TitleManagerUI();
		titleFrame.setTitle("직책 관리");
		titleFrame.setVisible(true);
	}

}
