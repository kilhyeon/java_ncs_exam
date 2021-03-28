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
			btnAdd.setText("수정");
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "해당 직책을 선택하세요.", "선택 오류", 2);
		}
	}

	@Override
	protected void actionPerformedMenuDelete() {
		try {
			Title delTitle = pList.getItem();
			service.removeTitle(delTitle);
			pList.loadData();
			JOptionPane.showMessageDialog(null, delTitle + "이(가) 삭제되었습니다.");
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "해당 직책을 선택하세요.", "선택 오류", 2);
		}
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Title beforeTitle = pList.getItem();
		try {
			Title updateTitle = pContent.getItem();
			String regExp = "^[가-힣]*$";
			if (0 < updateTitle.gettNo() && updateTitle.gettNo() < 1000 && updateTitle.gettName().matches(regExp)) {
				service.modifyTitle(updateTitle);
				pList.loadData();
				pContent.clearTf();
				btnAdd.setText("추가");
				JOptionPane.showMessageDialog(null, beforeTitle + "이(가) " + updateTitle + "로 변경되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "형식이 맞지 않습니다.", "오류", 0);
			}

		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "공란 존재", "오류", 0);
		}
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		try {
			Title title = pContent.getItem();
			String regExp = "^[가-힣]*$";
			if (0 < title.gettNo() && title.gettNo() < 1000 && title.gettName().matches(regExp)) {
				service.addTitle(title);
				pList.loadData();
				pContent.clearTf();
				JOptionPane.showMessageDialog(null, title + " 추가했습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "형식이 맞지 않습니다.", "오류", 0);
			}

		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "공란 존재", "오류", 0);
		}
	}

}
