package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import entity.Project;
import entity.Users;
public interface UserRepository extends JpaRepository<Users, Long> {
	List<Users> findByEmployeeID(String emplid);
	@Modifying
	 @Transactional
	 @Query("delete from Users b where b.employeeID = ?1")
	void deleteUserByEmployeeID(String employeeID);
}
