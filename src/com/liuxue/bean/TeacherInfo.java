package com.liuxue.bean;

public class TeacherInfo {

	
	private String id;
	private String name;//���
	private String title;//����
	private String brief; //��Ҫ˵��
	private int totalCount;// ǩԼ������
	private int lastMonth;//�����ǩԼ����
	private int lastWeek;//���һ�ܼ�Լ��ʶ
	private String photo;
	private String link;// ��ϸt��
	private String type;//1 ����  2 �İ�  3 ��˼  4 �и� 5 SAT
	
	private ArrayList<ItemInfo> intem;//��ǩ�б�

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getLastMonth() {
		return lastMonth;
	}

	public void setLastMonth(int lastMonth) {
		this.lastMonth = lastMonth;
	}

	public int getLastWeek() {
		return lastWeek;
	}

	public void setLastWeek(int lastWeek) {
		this.lastWeek = lastWeek;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<ItemInfo> getIntem() {
		return intem;
	}

	public void setIntem(ArrayList<ItemInfo> intem) {
		this.intem = intem;
	}
	
	
	
}
