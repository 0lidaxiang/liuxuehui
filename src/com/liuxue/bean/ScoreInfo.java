package com.liuxue.bean;

public class ScoreInfo {
	/*
	 * `id` int(15) NOT NULL,
  `student_id` int(15) NOT NULL,
  `oldscore` int(5) DEFAULT NULL,
  `old_listen` varchar(255) DEFAULT NULL,
  `old_speak` varchar(255) DEFAULT NULL,
  `old_read` varchar(255) DEFAULT NULL,
  `old_write` varchar(255) DEFAULT NULL,
  `listen` varchar(255) DEFAULT NULL,
  `speak` varchar(255) DEFAULT NULL,
  `read` varchar(255) DEFAULT NULL,
  `write` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  `teacher_id` int(15) DEFAULT NULL,
	 */

	//�߷�ѧԱ���
	private String studentId;
	private String oldscore;
	private String oldListen;
	private String oldSpeak;
	private String oldRead;
	private String oldWrite;
	private String listen;
	private String speak;
	private String read;
	private String write;
	private String score;
	private String teacher_id;
	private String description;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getOldscore() {
		return oldscore;
	}
	public void setOldscore(String oldscore) {
		this.oldscore = oldscore;
	}
	public String getOldListen() {
		return oldListen;
	}
	public void setOldListen(String oldListen) {
		this.oldListen = oldListen;
	}
	public String getOldSpeak() {
		return oldSpeak;
	}
	public void setOldSpeak(String oldSpeak) {
		this.oldSpeak = oldSpeak;
	}
	public String getOldRead() {
		return oldRead;
	}
	public void setOldRead(String oldRead) {
		this.oldRead = oldRead;
	}
	public String getOldWrite() {
		return oldWrite;
	}
	public void setOldWrite(String oldWrite) {
		this.oldWrite = oldWrite;
	}
	public String getListen() {
		return listen;
	}
	public void setListen(String listen) {
		this.listen = listen;
	}
	public String getSpeak() {
		return speak;
	}
	public void setSpeak(String speak) {
		this.speak = speak;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getWrite() {
		return write;
	}
	public void setWrite(String write) {
		this.write = write;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
