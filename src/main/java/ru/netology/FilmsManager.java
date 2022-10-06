package ru.netology;

public class FilmsManager {
    private FilmsRepo repo;
    private final int lastFilmsCount;

    public FilmsManager(FilmsRepo repo) {
        if(repo == null){
            throw new IllegalArgumentException("Нельзя присвоить null вместо репозитория");
        }
        this.repo = repo;
        this.lastFilmsCount = 10;
    }

    public FilmsManager(FilmsRepo repo, int lastFilmsCount) throws IllegalArgumentException {
        if(repo == null){
            throw new IllegalArgumentException("Нельзя присвоить null вместо репозитория");
        }
        this.repo = repo;
        if (lastFilmsCount < 0) {
            throw new IllegalArgumentException("Нельзя присвоить отрицательное количество выводимых фильмов");
        }
        this.lastFilmsCount = lastFilmsCount;
    }

    public void add(FilmsItem item) {
        repo.save(item);
    }

    public FilmsItem[] findAll() {
        return this.repo.findAll();
    }

    public FilmsItem[] findLast() {
        FilmsItem[] ascRepo = repo.findAll();
        int count = Math.min(this.lastFilmsCount, ascRepo.length);
        FilmsItem[] tmp = new FilmsItem[count];
        for (int i = 0; i < count; i++) {
            tmp[i] = ascRepo[ascRepo.length - 1 - i];
        }
        return tmp;
    }
}