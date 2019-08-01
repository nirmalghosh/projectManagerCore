package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import entity.Task;
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	List<Task> findByTask(String task);
	
		@Modifying
	 @Transactional
	 @Query("delete from Task b where b.taskID = ?1")
	void deleteTaskByTaskID(long taskID);
}
