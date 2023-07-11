package ch.raiffeisen.ComicVerwaltungapi.Comics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comic")
public class ComicResource {

    @Autowired
    ComicService comicService;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comic>> getAllComics() {
        return ResponseEntity.ok(comicService.getAllComics());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comic> getComicById(@PathVariable long id){
        return ResponseEntity.ok(comicService.getComicById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertNewComic(@RequestBody Comic comic) {
        comicService.insertNewComic(comic);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateComic(@RequestBody Comic comic, @PathVariable long id) {
        comicService.updateComic(comic, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteComicById(@PathVariable long id) {
        comicService.deleteComicById(id);
        return ResponseEntity.ok().build();
    }
}
