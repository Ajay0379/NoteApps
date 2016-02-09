package com.note.spring.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;


    @Entity
	@Table(name = "Notes")
	public class Notes implements java.io.Serializable {
        	

	private static final long serialVersionUID = 1L;
	    @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="id")
		private long id;
	    
	    @Column(name="Title")
	    @NotNull
	    @Max(50)
        private String title;
	    
	    @Max(1000)
	    @Column(name="Note_Description")
        private String noteDescription;
	    
	    @Column(name="Create_Time")
		private Date createTime;
		
	    @Column(name="Last_Update_Time")
		private Date lastUpdateTime;
		
		@ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
		@JoinColumn(name="User_id", nullable=false)
		private User user;
		
		public Notes(){}
		
		public Notes(String title, String noteDescription, Date createTime, Date lastUpdateTime, User user) {
			this.title = title;
			this.noteDescription = noteDescription;
			this.createTime = createTime;
			this.lastUpdateTime = lastUpdateTime;
			this.user = user;
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getNoteDescription() {
			return noteDescription;
		}
		public void setNoteDescription(String noteDescription) {
			this.noteDescription = noteDescription;
		}
		
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		
		public Date getLastUpdateTime() {
			return lastUpdateTime;
		}
		public void setLastUpdateTime(Date lastUpdateTime) {
			this.lastUpdateTime = lastUpdateTime;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
	 
		
}