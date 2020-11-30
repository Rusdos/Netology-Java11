package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;


public class MovieManager {
    private MovieRepository repository;
    private int count = 10;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieManager(MovieRepository repository, int count) {
        this.repository = repository;
        this.count = count;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] getLast() {
        int length = 0;
        Movie[] items = repository.findAll();
        if (this.count > items.length) {
            length = items.length;
        } else if (this.count < items.length) {
            length = this.count;
        } else {
            length = items.length;
        }
        Movie[] result = new Movie[length];
        for (int i = 0; i < length; i++) {
            int index = length - i - 1;
            result[i] = items[index];
        }
        return result;
        /*Movie[] items = repository.findAll();
        Movie[] result = new Movie[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;*/
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
