package icai.dtc.isw.domain;

public class Question{
	private int idQuestion;
	private String questionText;
	
	public Question (int idQuestion, String questionText) {
		this.idQuestion=idQuestion;
		this.questionText=questionText;
	}
	
	public int getIdQuestion() {
		return this.idQuestion;
	}
	
	public String getQuestionText() {
		return this.questionText;
	}

	@Override
	public int hashCode() {
		return idQuestion;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Question && idQuestion==((Question) o).getIdQuestion()) {
			return true;
		}else{
			return false;
		}
	}
}
