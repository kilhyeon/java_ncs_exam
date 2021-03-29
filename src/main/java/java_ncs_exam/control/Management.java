package java_ncs_exam.control;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import java_ncs_exam.content.AbstractContentPanel;
import java_ncs_exam.content.AbstractCustomTablePanel;
import java_ncs_exam.content.TitlePanel;
import java_ncs_exam.content.TitleTable;
import java_ncs_exam.dto.Title;
import java_ncs_exam.service.TitleService;
import java_ncs_exam.ui.exception.EmptyTfException;

@SuppressWarnings("serial")
public class Management extends AbstractManagement<Title> {
	private TitleService service;

	public Management() {
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
		Title updateTitle = pList.getItem();
		pContent.setItem(updateTitle);
		btnAdd.setText("����");

	}

	@Override
	protected void actionPerformedMenuDelete() {
		Title delTitle = pList.getItem();
		service.removeTitle(delTitle);
		pList.loadData();
		JOptionPane.showMessageDialog(null, delTitle + "��(��) �����Ǿ����ϴ�.");

	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Title beforeTitle = pList.getItem();
		Title updateTitle = pContent.getItem();
		pList.loadData();
		pContent.clearTf();
		btnAdd.setText("�߰�");
		JOptionPane.showMessageDialog(null, beforeTitle + "��(��) " + updateTitle + "�� ����Ǿ����ϴ�.");

	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {

		Title title = pContent.getItem();

		service.addTitle(title);
		pList.loadData();
		pContent.clearTf();
		JOptionPane.showMessageDialog(null, title + " �߰��߽��ϴ�.");

	}

}
