package com.liuxue.bean;

public class CourseInfo {
	/*
	 *  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `bengin` varchar(255) DEFAULT NULL,
  `book` varchar(255) DEFAULT NULL,
  `object` varchar(255) DEFAULT NULL,
  `promise` varchar(255) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
	 */
	
	//�γ���Ϣ��
	
	private String name;//�γ����
	private String price;//�γ̼۸�
	private String teacherId;//��ʦid
	private String bengin;//����ʱ��
	private String book;//�Ͽν̲�
	private String promise;//���ֳ�ŵ
	private String object;//�ʺ�ѧ��
	private String description;//�γ�����
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getBengin() {
		return bengin;
	}
	public void setBengin(String bengin) {
		this.bengin = bengin;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getPromise() {
		return promise;
	}
	public void setPromise(String promise) {
		this.promise = promise;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
