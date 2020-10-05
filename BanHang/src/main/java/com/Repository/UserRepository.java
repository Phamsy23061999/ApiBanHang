package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	// Tình kiếm User theo Tên và Email
	List<User> findByUsernameAndEmail(String email, String userName);
	
	
	
	@Query(value="SELECT u.* FROM user u WHERE u.username like %:keysearch%",nativeQuery = true)
	List<User> findByUsernameLike(@Param("keysearch") String keysearch);
	
}
