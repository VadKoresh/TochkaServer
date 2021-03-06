package main.controller;

import main.entity.UserTochkiEntity;
import main.entity.WinnerEntity;
import main.exception.PlayerAlreadyExistEx;
import main.exception.PlayerNotFoundException;
import main.repository.UserTochkiRepository;
import main.repository.WinnerRepository;
import main.service.UserTochkiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/players")
public class UserTochkiController {

    @Autowired
    private UserTochkiService userTochkiService;
    @Autowired
    private UserTochkiRepository userTochkiRepository;
    @Autowired
    private WinnerRepository winnerRepository;

    @PostMapping("/")
    public ResponseEntity addUser(@RequestBody UserTochkiEntity userTochkiEntity){
        try {
            return ResponseEntity.ok(userTochkiService.addNewUserTochki(userTochkiEntity));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Что-то пошло не так. Ошибка №1");
        }
    }

    @PostMapping("/addwithvisit")
    public ResponseEntity addNullUser(@RequestBody UserTochkiEntity userTochkiEntity){
        try {
            return ResponseEntity.ok(userTochkiService.addNullUser(userTochkiEntity));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/4page/{id}")
    public ResponseEntity getOneForPage(@PathVariable long id){
        try {
            return ResponseEntity.ok(userTochkiService.getOne(id));
        } catch (PlayerNotFoundException notFoundException){
            return ResponseEntity.badRequest().body(notFoundException.getMessage());
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка #1051");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable long id) {
        try {
            return ResponseEntity.ok(userTochkiService.getOne(id));
        } catch (PlayerNotFoundException notFoundException){
            return ResponseEntity.badRequest().body(notFoundException.getMessage());
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка #1051");
        }
    }

    @GetMapping("/")
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(userTochkiService.getAll());
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка #1052");
        }
    }

    @GetMapping("/nullphoneall")
    public ResponseEntity getAllNull(){
        try {
            return ResponseEntity.ok(userTochkiService.getAllNull());
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка #1052");
        }
    }

    /**
     * Поиск пользователя по номеру телефона
     */
    @GetMapping("/gettophone")
    public ResponseEntity findUserTochkiToNumberPhone(@RequestHeader String numberPhone){
        try {
            return ResponseEntity.ok(userTochkiService.findUserTochkiToNumberPhone(numberPhone));
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Сервер: " + exception.getMessage());
        }
    }

    @GetMapping("/gettosurname/{surnameUser}")
    public ResponseEntity findUserTochkiToSurname(@PathVariable String surnameUser){
        try {
            return ResponseEntity.ok(userTochkiService.findUserTochkiToSurname(surnameUser));
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Сервер: " + exception.getMessage());
        }
    }

    @GetMapping("/4desktopapp")
    public ResponseEntity getAllForDesktopApp(){
        try {
            return ResponseEntity.ok(userTochkiService.getAllForDesktopApp());
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка #1052");
        }
    }

    @PutMapping("/")
    public ResponseEntity editOnePlayer(@RequestBody UserTochkiEntity userTochkiEntity){
        try {
            return ResponseEntity.ok(userTochkiService.editUser(userTochkiEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Сервер: " + e.getMessage());
        }
    }
}
