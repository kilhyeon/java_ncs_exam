package java_ncs_exam.control;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import java_ncs_exam.content.AbstractContentPanel;
import java_ncs_exam.content.TitlePanel;
import java_ncs_exam.dto.Title;
import java_ncs_exam.service.TitleService;
import java_ncs_exam.ui.list.AbstractCustomTablePanel;
import java_ncs_exam.ui.list.TitleTable;

@SuppressWarnings("serial")
public class TitleManagerUI extends AbstractManagerUI<Title> {
	private TitleService service;

	public TitleManagerUI() {
	}

	@Override
	protected void setService() {
		service = new TitleService();
	}

	@Override
	protected void tableLoadData() {
		((TitleTable) pList).setService(service);
		pList.loadData();
	}

	@Override
	protected AbstractContentPanel<Title> createContentPanel() {
		return new TitlePanel();
	}

	@Override
	protected AbstractCustomTablePanel<Title> createTablePanel() {
		return new TitleTable();
	}

	@Override
	protected void actionPerformedMenuUpdate() {
		try {
			Title updateTitle = pList.getItem();
			pContent.setItem(updateTitle);
			btnAdd.setText("����");
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "�ش� ��å�� �����ϼ���.", "���� ����", 2);
		}
	}

	@Override
	protected void actionPerformedMenuDelete() {
		try {
			Title delTitle = pList.getItem();
			service.removeTitle(delTitle);
			pList.loadData();
			JOptionPane.showMessageDialog(null, delTitle + "��(��) �����Ǿ����ϴ�.");
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "�ش� ��å�� �����ϼ���.", "���� ����", 2);
		}
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Title updateTitle = pContent.getItem();
		service.modifyTitle(updateTitle);
		pList.loadData();
		pContent.clearTf();
		btnAdd.setText("�߰�");
		JOptionPane.showMessageDialog(null, updateTitle.gettName() + "(" + updateTitle.gettNo() + ")��(��) "
				+ updateTitle.gettName() + "(" + updateTitle.gettNo() + ")" + "�� ����Ǿ����ϴ�.");
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		try {
			Title title = pContent.getItem();
			String regExp = "^[��-�R]*$";
			if (0 < title.gettNo() && title.gettNo() < 1000 && title.gettName().matches(regExp)) {
				service.addTitle(title);
				pList.loadData();
				pContent.clearTf();
				JOptionPane.showMessageDialog(null, title + " �߰��߽��ϴ�.");
			} else {
				JOptionPane.showMessageDialog(null, "������ ���� �ʽ��ϴ�.", "����", 0);
			}

		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "���� ����", "����", 0);
		}
	}

}
