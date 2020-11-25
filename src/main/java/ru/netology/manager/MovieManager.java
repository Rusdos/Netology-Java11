package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;


public class MovieManager {
    private MovieRepository repository;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] getLast() {
       return repository.getLast();
    }


    public void removeById(int id) {
        repository.removeById(id);
    }
}
