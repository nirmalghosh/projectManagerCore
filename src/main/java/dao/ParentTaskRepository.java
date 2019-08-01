package dao;

import org.springframework.data.repository.CrudRepository;

import entity.ParentTask;
import entity.Users;
public interface ParentTaskRepository extends CrudRepository<ParentTask, Long> {
}
