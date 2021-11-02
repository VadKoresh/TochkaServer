package main.controller;

import main.service.IntentVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;

@RestController
@RequestMapping("/intent")
public class IntentVisitController {

    @Autowired
    private IntentVisitService intentVisitService;

    @GetMapping("/")
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(intentVisitService.getAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Сервер: " + e.getMessage());
        }
    }
}
