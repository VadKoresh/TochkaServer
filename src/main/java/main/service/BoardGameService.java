package main.service;

import javassist.NotFoundException;
import main.entity.BoardGameEntity;
import main.model.BoardGameListPoint;
import main.model.BoardGameModel;
import main.repository.BoardGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardGameService {

    @Autowired
    private BoardGameRepository boardGameRepository;

    public String addNewBoardGame(BoardGameEntity boardGameEntity){
        BoardGameEntity boardGameEntityNew = boardGameRepository.findByName(boardGameEntity.getName());
        if (boardGameEntityNew != null){
            return "Данная игра уже внесена в реестр!";
        }else {
            boardGameRepository.save(boardGameEntity);
            return  boardGameEntity.getName() + " успешно сохранена!";
        }
    }

    public BoardGameEntity getOneBoardGame(int id) throws NotFoundException {
        Optional<BoardGameEntity> byId = boardGameRepository.findById(id);
        BoardGameEntity boardGameEntity = null;
        if (!byId.isPresent()){
            throw new NotFoundException("Игра не найдена");
        }
        return boardGameEntity = byId.get();
    }

    public List<BoardGameModel> getAllBoardGame(){
        Iterable<BoardGameEntity> all = boardGameRepository.findAll();
        ArrayList<BoardGameModel> boardGameArrayList = new ArrayList<>();
        for (BoardGameEntity boardGameEntity : all){
            boardGameArrayList.add(BoardGameModel.toModel(boardGameEntity));
        }
        return boardGameArrayList;
    }

    public List<BoardGameEntity> getAllBoardGameForDesktopApp(){
        Iterable<BoardGameEntity> all = boardGameRepository.findAll();
        ArrayList<BoardGameEntity> boardGameArrayList = new ArrayList<>();
        for (BoardGameEntity boardGameEntity : all){
            boardGameArrayList.add(boardGameEntity);
        }
        return boardGameArrayList;
    }

    /**
     * @return Возвращает список настольных игр со списком доступных победных очков
     */
    public List<BoardGameListPoint> getAllBoardGameWithListScore(){
        Iterable<BoardGameEntity> boardGameRepositoryAll = boardGameRepository.findAll();
        ArrayList<BoardGameListPoint> boardGameListPointArrayList = new ArrayList<>();
        for (BoardGameEntity boardGameEntity : boardGameRepositoryAll){
            boardGameListPointArrayList.add(BoardGameListPoint.toModelWithListPoint(boardGameEntity));
        }
        return boardGameListPointArrayList;
    }
}
