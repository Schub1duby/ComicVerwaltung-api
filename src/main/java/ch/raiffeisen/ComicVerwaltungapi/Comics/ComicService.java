package ch.raiffeisen.ComicVerwaltungapi.Comics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicService {

    @Autowired
    ComicRepository comicRepository;

    public List<Comic> getAllComics(){
        return comicRepository.getAllComics();
    }

    public Comic getComicById(long id) {
        List<Comic> foundComics = comicRepository.getComicById(id);

        if (foundComics.size() != 1) {
            return null; //Fixme Throw Error here
        }

        return foundComics.get(0);
    }

    public void insertNewComic(Comic comic){
        comicRepository.insertNewComic(comic);
    }

    public void updateComic(Comic comic, long id){
        comicRepository.updateComic(comic, id);
    }

    public void deleteComicById(long id) {
        comicRepository.deleteComicById(id);
    }


}
