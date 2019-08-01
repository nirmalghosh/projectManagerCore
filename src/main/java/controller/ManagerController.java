package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.ProjectRepository;
import dao.TaskRepository;
import dao.UserRepository;
import entity.Project;
import entity.Task;
import entity.Users;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ManagerController {
	@Autowired
	UserRepository userRepo;
	@Autowired
	ProjectRepository projRepo;
	@Autowired
	TaskRepository taskRepo;
	 @RequestMapping(value="hello", method = RequestMethod.GET)
	   public String printHello(ModelMap model) {
	      model.addAttribute("message", "Welcome");
	      return "hello";
	   }
	 
	 @RequestMapping(value="addUser", method = RequestMethod.POST)
		public String addUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("employeeID") String employeeID, ModelMap model){
			Users user= new Users();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmployeeID(employeeID);
			userRepo.saveAndFlush(user);
			String message = "{\"message\": \"User added\"}";
		    model.addAttribute("message", message);
		    return message;
		}
	 @RequestMapping(value="updateUser", method = RequestMethod.POST)
		public String updateUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("employeeID") String employeeID, ModelMap model){
		 String message =  "";
			List<Users> users = userRepo.findByEmployeeID(employeeID);
			if(users != null && !users.isEmpty()) {	
			    Users user = users.get(0);
			    user.setFirstName(firstName);
			    user.setLastName(lastName);
			    user.setEmployeeID(employeeID);
			    userRepo.saveAndFlush(user);
			    message = "{\"message\": \"User added\"}";
		        model.addAttribute("message", message);
			}
		    return message;
		}
	 
	 @RequestMapping(value="viewUser", method = RequestMethod.GET)
		public List<Users> viewUser(ModelMap model){
			List<Users> users = userRepo.findAll();
		    
		    return users;
		}
	 @RequestMapping(value="deleteUser", method = RequestMethod.DELETE)
		public String deleteUser(@RequestParam("employeeID") String employeeID,ModelMap model){
			userRepo.deleteUserByEmployeeID(employeeID);
			String message = "{\"message\": \"User deleted\"}";
		    model.addAttribute("message", message);
		    return message;
		}
	 @RequestMapping(value="addProject", method = RequestMethod.POST)
		public String addProject(@RequestParam("projectName") String projectName, @RequestParam("priority") int priority, ModelMap model){
			Project project= new Project();
			project.setProject(projectName);
			project.setPriority(priority);
			projRepo.saveAndFlush(project);
			String message = "{\"message\": \"Project added\"}";
		    model.addAttribute("message", message);
		    return message;
		}
	 @RequestMapping(value="updateProject", method = RequestMethod.POST)
		public String updateProject(@RequestParam("projectName") String projectName, @RequestParam("priority") int priority, ModelMap model){
		 String message =  "";
			List<Project> projects = projRepo.findByProject(projectName);
			if(projects != null && !projects.isEmpty()) {
			    Project project	= projects.get(0);
			    project.setPriority(priority);
			    projRepo.saveAndFlush(project);
			    message = "{\"message\": \"Project updated\"}";
		        model.addAttribute("message", message);
			}
		    return message;
		}
	 
	 @RequestMapping(value="viewProjects", method = RequestMethod.GET)
		public List<Project> viewProjects(ModelMap model){
			List<Project> projects = projRepo.findAll();
		    
		    return projects;
		}
	 @RequestMapping(value="deleteProject", method = RequestMethod.DELETE)
		public String deleteProject(@RequestParam("projectName") String projectName,ModelMap model){
		 projRepo.deleteProjectByName(projectName);
			String message = "{\"message\": \"User deleted\"}";
		    model.addAttribute("message", message);
		    return message;
		}
	 @RequestMapping(value="addTask", method = RequestMethod.POST)
		public String addTask(@RequestParam("taskName") String taskName, @RequestParam("priority") int priority,@RequestParam("projectID") int projectID, ModelMap model){
			
		 Task task= new Task();
		 Optional<Project> optionalProject = projRepo.findById(new Long(projectID));
		 optionalProject.ifPresent(project -> {
			 task.setProject(project);  
			});
			
			task.setTask(taskName);
			task.setPriority(priority);
			taskRepo.saveAndFlush(task);
			String message = "{\"message\": \"Task added\"}";
		    model.addAttribute("message", message);
		    return message;
		}
	 @RequestMapping(value="viewTasks", method = RequestMethod.GET)
		public List<Task> viewTasks(ModelMap model){
			List<Task> tasks = taskRepo.findAll();
		    return tasks;
		}
	 @RequestMapping(value="updateTask", method = RequestMethod.POST)
		public String updateTask(@RequestParam("taskName") String taskName, @RequestParam("priority") int priority, ModelMap model){
		 String message =  "";
			List<Task> tasks = taskRepo.findByTask(taskName);
			if(tasks != null && !tasks.isEmpty()) {
				Task task	= tasks.get(0);
				task.setPriority(priority);
				taskRepo.saveAndFlush(task);
			    message = "{\"message\": \"Task updated\"}";
		        model.addAttribute("message", message);
			}
		    return message;
		}
	 @RequestMapping(value="deleteTask", method = RequestMethod.DELETE)
		public String deleteTask(@RequestParam("taskID") long taskID,ModelMap model){
		    taskRepo.deleteTaskByTaskID(taskID);
			String message = "{\"message\": \"Task deleted\"}";
		    model.addAttribute("message", message);
		    return message;
		}
		   


}
