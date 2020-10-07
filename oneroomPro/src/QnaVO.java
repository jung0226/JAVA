
public class QnaVO {
	private int qna_num;
	private String qna_name;
	private String qna_pwd;
	private String qna_title;
	private String qna_content;
	private String qna_write_date;
	private String answer_title;
	private String answer_content;
	private String answer_writer;
	private String answer_write_date;

	public QnaVO() { }
	public QnaVO(int qna_num, String qna_name, String qna_pwd, String qna_title, String qna_content) {
		this.qna_num = qna_num;
		this.qna_name= qna_name;
		this.qna_pwd= qna_pwd;
		this.qna_title= qna_title;
		this.qna_content = qna_content;
	}
	public QnaVO(int qna_num, String qna_name, String qna_pwd, String qna_title, String qna_content, String qna_write_date,
			 String answer_title, String answer_content, String answer_writer, String answer_write_date) {
		this(qna_num, qna_name, qna_pwd, qna_title, qna_content);
		this.answer_title=answer_title;
		this.answer_content=answer_content;
		this.answer_writer=answer_writer;
		this.answer_write_date=answer_write_date;
	}
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getQna_name() {
		return qna_name;
	}
	public void setQna_name(String qna_name) {
		this.qna_name = qna_name;
	}
	public String getQna_pwd() {
		return qna_pwd;
	}
	public void setQna_pwd(String qna_pwd) {
		this.qna_pwd = qna_pwd;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getQna_write_date() {
		return qna_write_date;
	}
	public void setQna_write_date(String qna_write_date) {
		this.qna_write_date = qna_write_date;
	}
	public String getAnswer_title() {
		return answer_title;
	}
	public void setAnswer_title(String answer_title) {
		this.answer_title = answer_title;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public String getAnswer_writer() {
		return answer_writer;
	}
	public void setAnswer_writer(String answer_writer) {
		this.answer_writer = answer_writer;
	}
	public String getAnswer_write_date() {
		return answer_write_date;
	}
	public void setAnswer_write_date(String answer_write_date) {
		this.answer_write_date = answer_write_date;
	}
	

}
