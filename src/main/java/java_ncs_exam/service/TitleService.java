package java_ncs_exam.service;

import java.util.List;

import java_ncs_exam.dao.TitleDao;
import java_ncs_exam.dto.Title;
import java_ncs_exam.impl.TitleDaoImpl;

public class TitleService {
	private TitleDao dao = TitleDaoImpl.getInstance();

	public List<Title> showTitles() {
		return dao.selectTitleByAll();
	}

	public void addTitle(Title title) {
		dao.insertTitle(title);
	}

	public void removeTitle(Title title) {
		dao.deleteTitle(title.gettNo());
	}

	public void modifyTitle(Title title) {
		dao.updateTitle(title);
	}

}
