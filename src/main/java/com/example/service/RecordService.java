package com.example.service;

import com.example.dto.PageableResponse;
import com.example.exception.ResourceNotFoundException;
import com.example.helper.Helper;
import com.example.models.Record;
import com.example.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    public PageableResponse<Record> getAllRecord(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Record> recordPage = recordRepository.findAll(pageable);
        PageableResponse<Record> response= Helper.getPageableResponse(recordPage, Record.class);
        return response;
    }

//    public List<Record> getAllRecords() {
//        return recordRepository.findAll();
//    }

    public Record getRecordByZip(String zipCode) {
        Record record = recordRepository.findById(zipCode).orElseThrow(() -> new ResourceNotFoundException("Record Not Found With Given ZipCode"));
        return record;

    }


}
