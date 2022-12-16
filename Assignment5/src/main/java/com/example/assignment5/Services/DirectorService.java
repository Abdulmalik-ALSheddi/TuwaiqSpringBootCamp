package com.example.assignment5.Services;

import com.example.assignment5.Model.Director;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Service
public class DirectorService {

    ArrayList<Director> directors = new ArrayList<>();


    public boolean search(Director director) {
        for (int i = 0; i < directors.size() ; i++) {
            if(directors.get(i).getId() == director.getId())
                return true;
        }
        return false;
    }

    public ArrayList<Director> directorMovies(Director director) {
        ArrayList<Director> dircMovies = new ArrayList<>();
        for (int i = 0; i < directors.size() ; i++) {
            if(directors.get(i).getName() == director.getName())
                dircMovies.add(directors.get(i));
        }
        return dircMovies;
    }

    public void addDirector(Director director) {
        directors.add(director);
    }

    public void updateDirector(int i, Director director) {
        directors.set(i,director);
    }

    public void directorDelete(int i) {
        directors.remove(i);
    }
}
