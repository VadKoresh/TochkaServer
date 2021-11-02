package main.controller;

import main.modelConvert.ProceedsConvert;
import main.service.ProceedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proceeds")
public class ProceedsController {

    @Autowired
    private ProceedsService proceedsService;

    @GetMapping("/getcreateone")
    public ResponseEntity getCreateOneProceeds(@RequestHeader String localDate){
        try {
            return ResponseEntity.ok(proceedsService.getCreateOneProceeds(localDate));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Сервер: " + e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity addSaveProceeds(@RequestBody ProceedsConvert proceedsConvert){
        try {
            return ResponseEntity.ok(proceedsService.addSaveProceeds(proceedsConvert));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Сервер: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(proceedsService.getAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Сервер: " + e.getMessage());
        }
    }
}
