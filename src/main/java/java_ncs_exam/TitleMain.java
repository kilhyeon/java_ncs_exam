package java_ncs_exam;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java_ncs_exam.control.Management;

@SuppressWarnings("serial")
public class TitleMain extends JFrame {
	private Management titleFrame;

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
		titleFrame = new Management();
		titleFrame.setTitle("직책 관리");
		titleFrame.setVisible(true);
	}

}
