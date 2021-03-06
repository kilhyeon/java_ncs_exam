package java_ncs_exam.content;

import javax.swing.SwingConstants;

import java_ncs_exam.dto.Title;
import java_ncs_exam.service.TitleService;
import java_ncs_exam.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class TitleTable extends AbstractCustomTablePanel<Title> {

	private TitleService service;

	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1);

		// 컬럼별 너비 조정
		setTableCellWidth(100, 250);

	}

	@Override
	public Object[] toArray(Title t) {
		return new Object[] { String.format("T%03d", t.gettNo()), t.gettName() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "번호", "직책" };
	}

	@Override
	public void initList() {
		list = service.showTitles();
	}

	public void setService(TitleService service) {
		this.service = service;
	}

	@Override
	public Title getItem() {
		int row = table.getSelectedRow();

		String stTitleNo = (String) table.getValueAt(row, 0);
		int titleNo = Integer.parseInt(stTitleNo.indexOf("T") == -1 ? stTitleNo : stTitleNo.substring(1));

		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Title(titleNo)));
	}

}
