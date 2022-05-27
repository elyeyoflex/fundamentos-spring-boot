package com.fundamentos.springboot.fundamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundamentos.springboot.fundamentos.entity.Post;

@Repository
public interface PostRespository extends JpaRepository<Post, Long>{

}
