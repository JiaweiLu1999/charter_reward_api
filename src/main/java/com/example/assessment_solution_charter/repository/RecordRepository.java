package com.example.assessment_solution_charter.repository;

import com.example.assessment_solution_charter.domain.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, String> {
    List<Record> findByCustomerId(String customerId);

}
