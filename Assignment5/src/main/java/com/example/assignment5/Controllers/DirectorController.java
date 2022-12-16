package com.example.assignment5.Controllers;

import com.example.assignment5.Model.Director;
import com.example.assignment5.Model.Movie;
import com.example.assignment5.Services.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/get")
    public ResponseEntity getDirectors()
    {
        ArrayList<Director> dircs = directorService.getDirectors();
        return ResponseEntity.status(201).body(dircs);
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@RequestBody @Valid Director director , Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        directorService.addDirector(director);
        return ResponseEntity.status(201).body("Director Added!!");
    }

    @PutMapping("/update/{i}")
    public ResponseEntity updateDirector(@PathVariable int i , @RequestBody @Valid Director director , Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        if(directorService.search(director))
        {
            directorService.updateDirector(i,director);
            return ResponseEntity.status(201).body("Director updated!!");
        }
        return ResponseEntity.status(400).body("Dieector NOT FOUND!!");
    }

    @DeleteMapping("/delete/{i}")
    public ResponseEntity deleteDirector(@PathVariable int i ,@RequestBody @Valid Director director, Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        if(directorService.search(director))
        {
            directorService.directorDelete(i);
            return ResponseEntity.status(201).body("Director Deleted!!");
        }
        return ResponseEntity.status(400).body("Director NOT FOUND!!");
    }


    @PostMapping("/movies")
    public ResponseEntity movieDirector(@RequestBody @Valid Director director , Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        if(directorService.search(director))
        {
            ArrayList<Director> dircMovies=  directorService.directorMovies(director);
            return ResponseEntity.status(201).body(dircMovies);
        }
        return ResponseEntity.status(400).body("NO MOVIES for this director!!");
    }


}
