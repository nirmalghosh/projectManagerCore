package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import entity.Project;
public interface ProjectRepository  extends JpaRepository<Project, Long> {
	List<Project> findByProject(String project);
	@Modifying
	 @Transactional
	 @Query("delete from Project b where b.project = ?1")
	void deleteProjectByName(String projectName);
}
