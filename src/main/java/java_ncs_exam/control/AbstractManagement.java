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
import java_ncs_exam.content.AbstractCustomTablePanel;
import java_ncs_exam.ui.exception.EmptyTfException;
import java_ncs_exam.ui.exception.InvalidCheckException;
import java_ncs_exam.ui.exception.SqlConstraintException;

@SuppressWarnings("serial")
public abstract class AbstractManagement<T> extends JFrame implements ActionListener {

	private JPanel contentPane;
	protected JButton btnAdd;
	private JButton btnCancel;

	protected AbstractContentPanel<T> pContent;
	protected AbstractCustomTablePanel<T> pList;

	public AbstractManagement() {
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
				try {
					if (e.getActionCommand().contentEquals("�߰�")) {
						actionPerformedBtnAdd(e);
					} else {
						actionPerformedBtnUpdate(e);
					}
				}catch (InvalidCheckException e1) {
					JOptionPane.showMessageDialog(null, "������ ���� �ʽ��ϴ�.", "����", 2);
				} catch (EmptyTfException e1) {
					JOptionPane.showMessageDialog(null, "������ �����մϴ�.", "����", 2);
				}
//		} catch (InvalidCheckException e1) {
//			JOptionPane.showMessageDialog(null, "������ ���� �ʽ��ϴ�.", "����", 2);
//		} catch (EmptyTfException e1) {
//			JOptionPane.showMessageDialog(null, "������ �����մϴ�.", "����", 2);
//		} catch (IndexOutOfBoundsException e1) {
//			JOptionPane.showMessageDialog(null, "�ش� ��å�� �����ϼ���.", "���� ����", 2);
//		} catch (NumberFormatException e1) {
//			JOptionPane.showMessageDialog(null, "������ ���� �ʽ��ϴ�.", "����", 2);
			}
		}
	}
}
