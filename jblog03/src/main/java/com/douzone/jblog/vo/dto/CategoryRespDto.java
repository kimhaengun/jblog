package com.douzone.jblog.vo.dto;

public class CategoryRespDto { 
	private Long no; //카테고리 no
	private String name; //카테고리명
	private Long count; //카테고리 포스트 수
	private String desc; // 설명
	private String blogId; //blogId
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	@Override
	public String toString() {
		return "CategoryRespDto [no="+no+", name=" + name + ", count=" + count + ", desc=" + desc + ", blogId=" + blogId + "]";
	}
	
	
}
