package com.example.luluharry.repositories;

import com.example.luluharry.domain.Bread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreadRepository extends JpaRepository<Bread, Long> {

}
