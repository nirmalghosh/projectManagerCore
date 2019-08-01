package controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManagerTest {
	@Test
	public void test() {
		
	}
	
	@Test
	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
	  throws ClientProtocolException, IOException {
	  
	    
	    HttpUriRequest request = new HttpGet( "http://localhost:8080/projectManagerWeb/hello" );
	 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void addUserTest() throws Exception {
		HttpUriRequest request = new HttpPost( "http://localhost:8080/projectManagerWeb/addUser?firstName=aaaa&lastName=bbb&employeeID=1111" );
		 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void updateUserTest() throws Exception {
		HttpUriRequest request = new HttpPost( "/updateUser?firstName=First1&lastName=Last&employeeID=emplid" );
		 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void viewUserTest() throws Exception {
		 HttpUriRequest request = new HttpGet( "http://localhost:8080/projectManagerWeb/viewUser" );
		 
		    // When
		    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		 
		    // Then
		    assertEquals(
		      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void deleteUserTest() throws Exception {
		 HttpUriRequest request = new HttpDelete( "http://localhost:8080/projectManagerWeb/deleteUser?employeeID=emplid" );
		 
		    // When
		    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		 
		    // Then
		    assertEquals(
		      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void addProjectTest() throws Exception {
		HttpUriRequest request = new HttpPost( "http://localhost:8080/projectManagerWeb/addProject?projectName=aaaa&priority=5" );
		 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void updateProjectTest() throws Exception {
		HttpUriRequest request = new HttpPost( "http://localhost:8080/projectManagerWeb/updateProject?projectName=bbbb&priority=5" );
		 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void viewProjectTest() throws Exception {
		HttpUriRequest request = new HttpGet( "http://localhost:8080/projectManagerWeb/viewProjects" );
		 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void deleteProjectTest() throws Exception {
		HttpUriRequest request = new HttpDelete( "http://localhost:8080/projectManagerWeb/deleteProject?projectName=bbbb" );
		 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void addTaskTest() throws Exception {
		HttpUriRequest request = new HttpPost( "http://localhost:8080/projectManagerWeb/addTask?taskName=aaaa&priority=5&projectID=1" );
		 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void updateTaskTest() throws Exception {
		HttpUriRequest request = new HttpPost( "http://localhost:8080/projectManagerWeb/updateTask?taskName=aaaa&priority=6" );
		 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	@Test
	public void viewTaskTest() throws Exception {
		HttpUriRequest request = new HttpGet( "http://localhost:8080/projectManagerWeb/viewTasks" );
		 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	
	@Test
	public void deleteTaskTest() throws Exception {
		HttpUriRequest request = new HttpDelete( "http://localhost:8080/projectManagerWeb/deleteTask?taskID=0" );
		 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then
	    assertEquals(
	      httpResponse.getStatusLine().getReasonPhrase(), HttpStatus.OK.getReasonPhrase());
	}
	
}
