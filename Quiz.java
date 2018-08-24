
public class Quiz {

	private String topic;
	private int quiz_no;
	private int question_no;
	private String question_stmt,option1,option2,option3,option4,correct; 
	
	public Quiz()
	{
		
	}
	
	
	
	public Quiz(String topic, int quiz_no, int question_no, String question_stmt,String option1, String option2, String option3,
			String option4, String correct) {
		super();
		this.topic = topic;
		this.quiz_no = quiz_no;
		this.question_no = question_no;
		this.question_stmt=question_stmt;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correct = correct;
	}


	
	
	
	public int getQuestion_no() {
		return question_no;
	}



	public void setQuestion_no(int question_no) {
		this.question_no = question_no;
	}



	public String getQuestion_stmt() {
		return question_stmt;
	}



	public void setQuestion_stmt(String question_stmt) {
		this.question_stmt = question_stmt;
	}



	public String getOption1() {
		return option1;
	}



	public void setOption1(String option1) {
		this.option1 = option1;
	}



	public String getOption2() {
		return option2;
	}



	public void setOption2(String option2) {
		this.option2 = option2;
	}



	public String getOption3() {
		return option3;
	}



	public void setOption3(String option3) {
		this.option3 = option3;
	}



	public String getOption4() {
		return option4;
	}



	public void setOption4(String option4) {
		this.option4 = option4;
	}



	public String getCorrect() {
		return correct;
	}



	public void setCorrect(String correct) {
		this.correct = correct;
	}



	public Quiz(String topic, int quiz_no) {
		super();
		this.topic = topic;
		this.quiz_no = quiz_no;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getQuiz_no() {
		return quiz_no;
	}
	public void setQuiz_no(int quiz_no) {
		this.quiz_no = quiz_no;
	}
	
	
	
}
