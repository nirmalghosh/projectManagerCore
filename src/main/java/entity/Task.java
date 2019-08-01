package entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task_tbl")
public class Task {
	@Id
    @GeneratedValue(strategy = IDENTITY)
	@Column(name = "Task_ID")
	private long taskID;
	
	@Column(name = "Parent_ID")
	private long parentID;
	
	@Column(name = "Task")
	private String task;
	
	@Column(name = "Start_Date")
	private Date startDate;
	
	@Column(name = "End_Date")
	private Date endDate;
	
	@Column(name = "Priority")
	private int priority;


	@ManyToOne
	@JoinColumn(name = "Project_ID")
	private Project project;

	

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public long getTaskID() {
		return taskID;
	}

	public void setTaskID(long taskID) {
		this.taskID = taskID;
	}

	public long getParentID() {
		return parentID;
	}

	public void setParentID(long parentID) {
		this.parentID = parentID;
	}

	

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	

}
