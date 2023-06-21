package com.travel.travtronics.response;

public class LangQuestionAnswerResponse {
	
	
	private String questionName;
	
	private String answer;
	
	

	public LangQuestionAnswerResponse(String questionName, String answer) {
		super();
		this.questionName = questionName;
		this.answer = answer;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	

}
