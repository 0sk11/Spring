package spring.core.quest2;

import java.util.*;

public class Question {
	int questionId;
	String question;
	List<String> answers;
	//Set<String> answers;
	//Map<Integer, String> answers;
	
	public Question() {}
	
	public Question(int questionId, String question, List<String> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}
	
	public int getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<String> getAnswers() {
		return answers;
	}
	
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	/*
	 * public Set<String> getAnswers() { return answers; } public void
	 * setAnswers(Set<String> answers) { this.answers = answers; }
	 */
	
	/*
	 * public Map<Integer, String> getAnswers() { return answers; } public void
	 * setAnswers(Map<Integer, String> answers) { this.answers = answers; }
	 */
	
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", queston=" + question + ", answers=" + answers + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + questionId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (questionId != other.questionId)
			return false;
		return true;
	}
	
	
	
}
