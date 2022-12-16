package com.example.assignment5.Services;

import com.example.assignment5.Model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Service
public class MovieService {

    ArrayList<Movie> movies = new ArrayList<>();

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public boolean search(int id) {
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getId() == id)
                return true;
        }
        return false;
    }

    public void updateMovie(int i, Movie movie) {
        movies.set(i,movie);
    }

    public void deleteMovie(int i) {
        movies.remove(i);
    }

    public boolean searchName(String name) {
        for (int i = 0; i < movies.size() ; i++) {
            if(movies.get(i).getName() == name)
                return true;
        }
        return false;
    }

    public Integer movieRate(String name) {
        for (int i = 0; i < movies.size() ; i++) {
            if(movies.get(i).getName() == name)
                return movies.get(i).getRating();
        }
        return -1;
    }
}
