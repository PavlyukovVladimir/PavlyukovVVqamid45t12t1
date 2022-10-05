package ru.netology;

import java.util.Arrays;

public class FilmsManager {
    private FilmsItem[] repo;
    private final int lastFilmsCount;

    public FilmsManager() {
        this.lastFilmsCount = 10;
    }

    public FilmsManager(int lastFilmsCount) throws IllegalArgumentException {
        if (lastFilmsCount < 0) {
            throw new IllegalArgumentException("Нельзя присвоить отрицательное количество выводимых фильмов");
        }
        this.lastFilmsCount = lastFilmsCount;
    }

    public void add(FilmsItem item) {
        if (this.repo != null) {
            FilmsItem[] tmp = Arrays.copyOf(this.repo, this.repo.length + 1);
            tmp[this.repo.length] = item;
            this.repo = tmp;
        }
        this.repo = new FilmsItem[]{item};
    }

    public FilmsItem[] findAll() {
        return this.repo.clone();
    }

    public FilmsItem[] findLast() {
        if (this.repo == null) {
            return new FilmsItem[0];
        }
        int count = Math.min(this.lastFilmsCount, this.repo.length);
        FilmsItem[] tmp = new FilmsItem[count];
        for (int i = 0; i < count; i++) {
            tmp[i] = this.repo[this.repo.length - 1 - i];
        }
        return tmp;
    }
}