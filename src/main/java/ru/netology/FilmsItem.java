package ru.netology;

public class FilmsItem {
    public String name;
    public int year;

    public FilmsItem(FilmsItem item) {
        this.name = item.name;
        this.year = item.year;
    }
}
