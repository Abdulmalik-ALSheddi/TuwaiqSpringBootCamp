package com.example.assignment5.Controllers;

import com.example.assignment5.Model.Director;
import com.example.assignment5.Model.Movie;
import com.example.assignment5.Services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getMovie()
    {
        ArrayList<Movie> movies = movieService.getMovies();
        return ResponseEntity.status(201).body(movies);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie , Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        movieService.addMovie(movie);
        return ResponseEntity.status(201).body("MOVIE added!!");
    }

    @PutMapping("/update/{i}")
    public ResponseEntity updateMovie(@PathVariable int i , @RequestBody @Valid Movie movie , Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        if(movieService.search(i))
        {
            movieService.updateMovie(i,movie);
            return ResponseEntity.status(201).body("MOVIE updated!!");
        }
        return ResponseEntity.status(400).body("MOVIE NOT FOUND!!");
    }

    @DeleteMapping("/delete/{i}")
    public ResponseEntity deleteMovie(@PathVariable int i, Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        if(movieService.search(i))
        {
            movieService.deleteMovie(i);
            return ResponseEntity.status(201).body("Movie deleted!!");
        }
        return ResponseEntity.status(400).body("MOVIE NOT FOUND!!");
    }

    @PostMapping("/movie/name")
    public ResponseEntity movieRate(@RequestBody @Valid String name , Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        if(movieService.searchName(name))
        {
            return ResponseEntity.status(201).body(movieService.movieRate(name));

        }
        return ResponseEntity.status(400).body("MOVIE NOT FOUND!!");
    }



}
