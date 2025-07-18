package com.example.algorithmvisualizer.Controller;

import com.example.algorithmvisualizer.RequestDTO.SearchRequest;
import com.example.algorithmvisualizer.Services.SearchingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchingService searchingService;

    @PostMapping("/linear")
    public List<Map<String, Object>> linearSearch(@RequestBody SearchRequest request) {
        return searchingService.linearSearch(request.getArray(), request.getTarget());
    }
        @PostMapping("/binary")
        public List<Map<String, Object>> binarySearch(@RequestBody SearchRequest request) {
            if (request.getArray() == null || request.getArray().length == 0) {
                throw new IllegalArgumentException("Array must not be empty");
            }
            return searchingService.binarySearch(request.getArray(), request.getTarget());
        }

    }
