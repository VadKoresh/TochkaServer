package main.controller;

import main.entity.VictoryStoryEntity;
import main.exception.BoardGameAlreadyExistEx;
import main.exception.PlayerAlreadyExistEx;
import main.exception.PlayerNotFoundException;
import main.model.VictoryStory;
import main.modelConvert.VictoryStoryConvert;
import main.service.VictoryStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/story")
public class VictoryStoryController {

    @Autowired
    private VictoryStoryService victoryStoryService;

    @PostMapping("/")
    public ResponseEntity addStory(@RequestBody List<VictoryStoryEntity> victoryStoryEntityList){
        try {
            LocalDateTime dateTime = LocalDateTime.now();
            victoryStoryService.addStory(victoryStoryEntityList, dateTime);
            return ResponseEntity.ok("Победные очки записаны!");
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка #1070");
        }
    }

    @PostMapping("/4one")
    public ResponseEntity addStory4One(@RequestBody VictoryStoryConvert victoryStoryEntity){
        try {
            victoryStoryService.addStory4One(victoryStoryEntity);
            return ResponseEntity.ok("Победные очки записаны!");
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка #1071");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getStoryPlayer(@PathVariable int id){
        try {
            return ResponseEntity.ok(victoryStoryService.getStoryPlayer(id));
        } catch (PlayerNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body("Ошибка № 12");
        }
    }
}
