package main.service;

import main.entity.UserTochkiEntity;
import main.exception.PlayerNotFoundException;
import main.model.UserTochkiModel;
import main.repository.UserTochkiRepository;
import main.repository.VictoryStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserTochkiService {

    @Autowired
    private UserTochkiRepository userTochkiRepository;
    @Autowired
    private WinnerService winnerService;

    public String addNewUserTochki(UserTochkiEntity userTochkiEntity) {
        UserTochkiEntity userWithId = userTochkiRepository.findByNumberPhone(userTochkiEntity.getNumberPhone());
        if (userWithId == null) {
            userWithId = userTochkiRepository.save(userTochkiEntity);
            if (userWithId.getNumberPhone() != null) {
                winnerService.addNewWinner(userWithId);
                return "Пользователь успешно зарегистрирован!";
            } else {
                return "Запись прошла успешно";
            }
        } else {
            return "Сервер: Данный номером телефона уже зарегистрирован пользователем: " + userWithId.getName() +
                    " " + userWithId.getSurname() + " !";
        }
    }

    public UserTochkiEntity addNullUser(UserTochkiEntity userTochkiEntity) throws PlayerNotFoundException {
        UserTochkiEntity userWithId = null;
        if (userTochkiEntity.getNumberPhone() == null) {
            return userTochkiRepository.save(userTochkiEntity);
        } else {
            userWithId = userTochkiRepository.findByNumberPhone(userTochkiEntity.getNumberPhone());
            if (userWithId != null) {
                throw new PlayerNotFoundException("Сервер: данный номер телефона уже был зарегистрирован пользователем:" +
                        " " + userWithId.getName() + " " + userWithId.getSurname() + " !");
            } else {
                userWithId = userTochkiRepository.save(userTochkiEntity);
                winnerService.addNewWinner(userWithId);
                return userWithId;
            }
        }
    }

    public List<UserTochkiModel> getAll() {
        Iterable<UserTochkiEntity> all = userTochkiRepository.findAll();
        ArrayList<UserTochkiModel> userTochkiModelArrayList = new ArrayList<>();
        for (UserTochkiEntity userTochkiEntity : all) {
            userTochkiModelArrayList.add(UserTochkiModel.toModel(userTochkiEntity));
        }
        return userTochkiModelArrayList;
    }

    public List<UserTochkiEntity> getAllNull() {
        List<UserTochkiEntity> userTochkiModelArrayList = userTochkiRepository.findAllByNumberPhoneIsNotNull();

        return userTochkiModelArrayList;
    }

    public List<UserTochkiEntity> getAllForDesktopApp() {
        Iterable<UserTochkiEntity> all = userTochkiRepository.findAll();
        ArrayList<UserTochkiEntity> userTochkiModelArrayList = new ArrayList<>();
        for (UserTochkiEntity userTochkiEntity : all) {
            userTochkiModelArrayList.add(userTochkiEntity);
        }
        return userTochkiModelArrayList;
    }

    public UserTochkiEntity getOneForPage(long id) throws PlayerNotFoundException {
        UserTochkiEntity userTochkiEntity = null;
        Optional<UserTochkiEntity> byId = userTochkiRepository.findById(id);
        if (!byId.isPresent()) {
            throw new PlayerNotFoundException("Пользователь не найден!");
        }
        userTochkiEntity = byId.get();
        return userTochkiEntity;
    }

    public UserTochkiModel getOne(long id) throws PlayerNotFoundException {
        UserTochkiEntity userTochkiEntity = null;
        Optional<UserTochkiEntity> byId = userTochkiRepository.findById(id);
        if (!byId.isPresent()) {
            throw new PlayerNotFoundException("Пользователь не найден!");
        }
        userTochkiEntity = byId.get();
        return UserTochkiModel.toModel(userTochkiEntity);
    }

    /**
     * Обработка ошибки на стороне приложения
     */
    public UserTochkiEntity findUserTochkiToNumberPhone(String numberPhone) throws PlayerNotFoundException {
        UserTochkiEntity userTochkiEntity = userTochkiRepository.findByNumberPhone(numberPhone);
        if (userTochkiEntity == null) {
            throw new PlayerNotFoundException("Пользователь не найден!");
        }
        return userTochkiEntity;
    }

    public String editUser(UserTochkiEntity userTochkiEntity) throws Exception {
        userTochkiRepository.save(userTochkiEntity);
        return "Пользователь зарегистрирован!";
    }

    public UserTochkiEntity findUserTochkiToSurname(String surnameUser) throws Exception {
        List<UserTochkiEntity> userTochkiEntityList = userTochkiRepository.findAllBySurname(surnameUser);
        if (userTochkiEntityList.size() > 1){
            throw new Exception("Найдено несколько пользователей с такой фамилией");
        } else if (userTochkiEntityList.size() == 0) {
            throw new Exception("Пользователя с таким именем не найдено");
        }else {
            return userTochkiEntityList.stream().findFirst().get();
        }
    }
}
