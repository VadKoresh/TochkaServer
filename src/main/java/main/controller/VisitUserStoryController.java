package main.controller;

import main.modelConvert.VisitUserStoryConvertTo;
import main.service.VisitUserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/visit")
public class VisitUserStoryController {

    @Autowired
    private VisitUserStoryService visitUserStoryService;

    @PostMapping("/")
    public ResponseEntity addVisit(@RequestBody VisitUserStoryConvertTo visitUserStoryConvertTo) {
        try {
            return ResponseEntity.ok(visitUserStoryService.addVisitStory(visitUserStoryConvertTo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Сервер: " + e.getMessage());
        }
    }

    @GetMapping("/today")
    public ResponseEntity getVisitStoryToday(@RequestHeader String today){
        try {
            return ResponseEntity.ok(visitUserStoryService.getVisitStoryToday(LocalDateTime.parse(today)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Сервер: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneVisit(@PathVariable long id){
        try {
            return ResponseEntity.ok(visitUserStoryService.getOneVisit(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Сервер: " + e.getMessage());
        }
    }
}
