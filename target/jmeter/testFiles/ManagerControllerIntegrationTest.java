package controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManagerControllerIntegrationTest {
	@Autowired
    private MockMvc mvc;
	@Test
	public void helloTest() throws Exception {
		this.mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string("hello"));
	}
	@Test
	public void addUserTest() throws Exception {
		this.mvc.perform(post("/addUser?firstName=aaaa&lastName=bbb&employeeID=1111")).andExpect(status().isOk());
	}
	@Test
	public void updateUserTest() throws Exception {
		this.mvc.perform(post("/updateUser?firstName=First1&lastName=Last&employeeID=emplid")).andExpect(status().isOk());
	}
	@Test
	public void viewUserTest() throws Exception {
		this.mvc.perform(get("/viewUser")).andExpect(status().isOk());
	}
	@Test
	public void deleteUserTest() throws Exception {
		this.mvc.perform(delete("/deleteUser?employeeID=emplid")).andExpect(status().isOk());
	}
	@Test
	public void addProjectTest() throws Exception {
		this.mvc.perform(post("/addProject?projectName=aaaa&priority=5")).andExpect(status().isOk());
	}
	@Test
	public void updateProjectTest() throws Exception {
		this.mvc.perform(post("/updateProject?projectName=bbbb&priority=5")).andExpect(status().isOk());
	}
	@Test
	public void viewProjectTest() throws Exception {
		this.mvc.perform(get("/viewProjects")).andExpect(status().isOk());
	}
	@Test
	public void deleteProjectTest() throws Exception {
		this.mvc.perform(delete("/deleteProject?projectName=bbbb")).andExpect(status().isOk());
	}
	@Test
	public void addTaskTest() throws Exception {
		this.mvc.perform(post("/addTask?taskName=aaaa&priority=5&projectID=1")).andExpect(status().isOk());
	}
	@Test
	public void updateTaskTest() throws Exception {
		this.mvc.perform(post("/updateTask?taskName=aaaa&priority=6")).andExpect(status().isOk());
	}
	@Test
	public void viewTaskTest() throws Exception {
		this.mvc.perform(get("/viewTasks")).andExpect(status().isOk());
	}
	
	@Test
	public void deleteTaskTest() throws Exception {
		this.mvc.perform(delete("/deleteTask?taskID=0")).andExpect(status().isOk());
	}
 
}
