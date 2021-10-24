package main.service;

import javassist.NotFoundException;
import main.entity.AdministratorEntity;
import main.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public AdministratorEntity getAdmin(String login, String password) throws NotFoundException {
        AdministratorEntity administratorEntity = administratorRepository.findByLogin(login);
        if (administratorEntity != null) {
            if (administratorEntity.getPassword().equals(password)) {
                return administratorEntity;
            }else {
                throw new NotFoundException("Ошибка в логине или пароле");
            }
        }else {
            throw new NotFoundException("Ошибка в логине или пароле");
        }
    }
}
