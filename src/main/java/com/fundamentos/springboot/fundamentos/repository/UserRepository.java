package com.fundamentos.springboot.fundamentos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.fundamentos.springboot.fundamentos.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("Select u from User u WHERE u.email=?1")
	Optional<User> findByUserEmail(String email);

	@Query("Select u from User u where u.name like ?1%")
	List<User> findAndSort(String name, Sort sort);

	List<User> findByName(String name);
	
	List<User> findByNameAndEmail(String name, String Email);
	
}
