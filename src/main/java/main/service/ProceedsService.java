package main.service;

import main.entity.ProceedsEntity;
import main.modelConvert.ProceedsConvert;
import main.repository.ProceedsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class ProceedsService {

    @Autowired
    private ProceedsRepository proceedsRepository;

    public ProceedsConvert getCreateOneProceeds(String localDate){
        LocalDate localDate1 = LocalDate.parse(localDate);
        ProceedsEntity proceedsEntity = null;
        if (LocalTime.now().getHour() < 3){
            proceedsEntity = proceedsRepository.findByDate(localDate1.minusDays(1));
            if (proceedsEntity == null){
                proceedsEntity = new ProceedsEntity();
                proceedsEntity.setDate(localDate1.minusDays(1));
            }
        }else {
            proceedsEntity = proceedsRepository.findByDate(localDate1);
            if (proceedsEntity == null){
                proceedsEntity = new ProceedsEntity();
                proceedsEntity.setDate(localDate1);
            }
        }
        return ProceedsConvert.fromJsonToEntity(proceedsEntity);
    }

    public String addSaveProceeds(ProceedsConvert proceedsConvert) throws Exception{
            proceedsRepository.save(ProceedsEntity.fromJsonToEntity(proceedsConvert));
            return "Запись прошла!";
    }

    public ArrayList<ProceedsConvert> getAll() throws Exception{
        ArrayList<ProceedsConvert> proceedsConvertArrayList = new ArrayList<>();
        for (ProceedsEntity proceedsEntity : proceedsRepository.findAll()){
            proceedsConvertArrayList.add(ProceedsConvert.fromJsonToEntity(proceedsEntity));
        }
        return proceedsConvertArrayList;
    }
}
