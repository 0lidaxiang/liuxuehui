package com.liuxue.bean;

public class SchoolInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;//���
	private String title;//����
	private String brief; //��Ҫ˵��
	private int counts;// ǩԼ����
	private String photo;
	private String link;// ��ϸt��
	private String type;//type 1 ��ѯ�н� 2 ������ѵ  3 ��������  0 ����ѧУ
	
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
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
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
