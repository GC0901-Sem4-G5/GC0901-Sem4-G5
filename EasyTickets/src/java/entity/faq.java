/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author dattr_000
 */
public class faq {
    private int id;
    private String question;
    private String answer;

    public faq() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public faq(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public faq(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    
    
    
}
