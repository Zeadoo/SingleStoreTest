package com.example.singlestoretest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/content")
public class ContentController {
    private final ContentRepository contentRepository;

    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contents>> getContents(){
        List<Contents> list = contentRepository.findAll();
        return new ResponseEntity<List<Contents>>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Contents> saveContent(@RequestBody Contents content){
        return new ResponseEntity<>(contentRepository.save(content),HttpStatus.CREATED);
    }

    @DeleteMapping("/deactivate/{id}")
    public ResponseEntity<String> deleteContent(@PathVariable UUID id){
        contentRepository.deleteById(id);
        return new ResponseEntity<String>("Content is Deleted",HttpStatus.OK);
    }

}
