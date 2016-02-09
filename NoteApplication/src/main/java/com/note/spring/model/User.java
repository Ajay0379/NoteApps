package com.note.spring.model;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Email;


@Entity
@Table(name="User")

public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="User_id")
	private long userId;
	
	@Column(name="Email")

	@Email
	private String email;
	
	@Column(name="Password")
	@Min(8)
	private String password;
	
	@Column(name="Create_Time")
	private Date createTime;
	
	@Column(name="Last_Update_Time")
	private Date lastUpdateTime;

	
	/*private Set<Notes> notes = new HashSet<Notes>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Notes> getNotes() {
		return notes;
	}

	public void setNotes(Set<Notes> notes) {
		this.notes = notes;
	}*/

	

	public String getEmail() {
		return email;
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
}
