package tr.lkd.lyk2015.springtodo.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@Column(name = "description")
	private String desc;
	@DateTimeFormat(iso= ISO.DATE)
	private Calendar dueDate;
	private boolean done;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	public String getDate()
	{
		Date date = this.dueDate.getTime();             
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
		String datetime= null;
		datetime = format1.format(date);
		System.out.println(datetime);
		
		return datetime;
	}
}
