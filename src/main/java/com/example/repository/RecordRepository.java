package com.example.repository;

import com.example.models.Record;
import com.sun.istack.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, String> {


//    Record findByZip(String zipCode);
Optional<Record> findById(@NotNull String String);

}
