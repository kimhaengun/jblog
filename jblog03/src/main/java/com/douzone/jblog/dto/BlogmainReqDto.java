package com.douzone.jblog.dto;

public class BlogmainReqDto {

	private String blogId;
	private Long categoryNo;
	private Long postNo;
	@Override
	public String toString() {
		return "BlogmainReqDto [blogId=" + blogId + ", categoryNo=" + categoryNo + ", postNo=" + postNo + "]";
	}
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public Long getPostNo() {
		return postNo;
	}
	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}
}
