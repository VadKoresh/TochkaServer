package main.controller;

import javassist.NotFoundException;
import main.entity.AdministratorEntity;
import main.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/")
    public ResponseEntity getAdministrator(@RequestParam String login,
                                           @RequestParam String password){
        try {
                return ResponseEntity.ok(administratorService.getAdmin(login, password));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
