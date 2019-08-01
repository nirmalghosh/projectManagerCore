package entity;

import  javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="users")
	public class Users {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "User_ID")
		private long userID;
		
		@Column(name = "First_Name")
		private String firstName;
		
		@Column(name = "Last_Name")
		private String lastName;
		
		@Column(name = "Employee_ID")
		private String employeeID;
		
		@Column(name = "Project_ID")
		private String projectID;
		
		@Column(name = "Task_ID")
		private String taskID;

		public long getUserID() {
			return userID;
		}

		public void setUserID(long userID) {
			this.userID = userID;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(String employeeID) {
			this.employeeID = employeeID;
		}

		public String getProjectID() {
			return projectID;
		}

		public void setProjectID(String projectID) {
			this.projectID = projectID;
		}

		public String getTaskID() {
			return taskID;
		}

		public void setTaskID(String taskID) {
			this.taskID = taskID;
		}
		
		
}
