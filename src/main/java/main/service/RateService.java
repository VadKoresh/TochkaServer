package main.service;

import main.entity.RateEntity;
import main.modelConvert.RateConvertTo;
import main.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RateService {

    @Autowired
    private RateRepository rateRepository;

    public ArrayList<RateConvertTo> getAllRate(){
        List<RateEntity> all = rateRepository.findAll();
        ArrayList<RateConvertTo> rateConvertTos = new ArrayList<>();
        for (RateEntity rateEntity : all){
            rateConvertTos.add(RateConvertTo.toJson(rateEntity));
        }
        return rateConvertTos;
    }
}
