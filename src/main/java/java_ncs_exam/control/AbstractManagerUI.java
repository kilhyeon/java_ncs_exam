package java_ncs_exam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java_ncs_exam.content.AbstractContentPanel;
import java_ncs_exam.ui.exception.InvalidCheckException;
import java_ncs_exam.ui.exception.SqlConstraintException;
import java_ncs_exam.ui.list.AbstractCustomTablePanel;

@SuppressWarnings("serial")
public abstract class AbstractManagerUI<T> extends JFrame implements ActionListener {

	private JPanel contentPane;
	protected JButton btnAdd;
	private JButton btnCancel;

	protected AbstractContentPanel<T> pContent;
	protected AbstractCustomTablePanel<T> pList;

	public AbstractManagerUI() {
		setService(); // service ����
		initialize();
		tableLoadData(); // component load data
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pContent = createContentPanel();
		contentPane.add(pContent);
//		pContent.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);

		btnAdd = new JButton("�߰�");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);

		btnCancel = new JButton("���");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		pList = createTablePanel();
		contentPane.add(pList);

		JPopupMenu popupMenu = createPopupMenu();
		pList.setPopupMenu(popupMenu);
	}

	protected abstract void setService();

	protected abstract void tableLoadData();

	protected abstract AbstractContentPanel<T> createContentPanel();

	protected abstract AbstractCustomTablePanel<T> createTablePanel();

	protected abstract void actionPerformedMenuUpdate();

	protected abstract void actionPerformedMenuDelete();

	protected abstract void actionPerformedBtnUpdate(ActionEvent e);

	protected abstract void actionPerformedBtnAdd(ActionEvent e);

	private void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clearTf();

		if (btnAdd.getText().contentEquals("����")) {
			btnAdd.setText("�߰�");
		}
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("����");
		updateItem.addActionListener(this);
		popMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("����");
		deleteItem.addActionListener(this);
		popMenu.add(deleteItem);

		return popMenu;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() instanceof JMenuItem) {
				if (e.getActionCommand().equals("����")) {
					actionPerformedMenuDelete();
				}

				if (e.getActionCommand().equals("����")) {
					actionPerformedMenuUpdate();
				}

			} else {
				if (e.getSource() == btnCancel) {
					actionPerformedBtnCancel(e);
				}

				if (e.getSource() == btnAdd) {
					if (e.getActionCommand().contentEquals("�߰�")) {
						actionPerformedBtnAdd(e);
					} else {
						actionPerformedBtnUpdate(e);
					}
				}
			}
		} catch (SqlConstraintException | InvalidCheckException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

}
