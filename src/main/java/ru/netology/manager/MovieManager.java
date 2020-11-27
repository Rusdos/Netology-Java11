package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] items;
    private int count;

    public MovieManager(int count) {
        this.count = count;
        this.items = new Movie[0];
    }

    public MovieManager() {
        this.count = 10;
        this.items = new Movie[0];
    }

    public void add(Movie item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getLast() {
        int length = 0;
        if (this.count > items.length) {
             length = items.length;
        } else if (this.count < items.length) {
            length = this.count;
        } else {
            length = items.length;
        }
        Movie[] result = new Movie[length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < length; i++) {
            int index = length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    // наивная реализация
    public void removeById(int id) {
        if (items.length >= id) {
            int length = items.length - 1;
            if (length >= 0) {
                Movie[] tmp = new Movie[length];
                int index = 0;
                for (Movie item : items) {
                    if (item.getId() != id) {
                        tmp[index] = item;
                        index++;
                    }
                }
                // меняем наши элементы
                items = tmp;
            }
        }
        return;
    }
}
