package com.example.controller;

import com.example.dto.PageableResponse;
import com.example.models.Record;
import com.example.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping
    public ResponseEntity<PageableResponse<Record>> getAll(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "100", required = false) int pageSize
    ) {

        return new ResponseEntity<>(recordService.getAllRecord(pageNumber,pageSize), HttpStatus.OK);
    }

//    @GetMapping
//    public List<Record> allReport() {
//        return recordService.getAllRecords();
//    }

    //get record by zipcode.
    @GetMapping("/{zipCode}")
    public Record findRecordByZip(@PathVariable("zipCode") String zipCode) {
        return  recordService.getRecordByZip(zipCode);
    }


}
