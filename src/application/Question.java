package application;

public abstract class Question {
	private String question;
	private Reponse reponseJuste;

	public abstract float evaluationReponse();

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Reponse getReponseJuste() {
		return reponseJuste;
	}

	public void setReponseJuste(Reponse reponseJuste) {
		this.reponseJuste = reponseJuste;
	}

}
