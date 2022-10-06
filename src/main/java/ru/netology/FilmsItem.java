package ru.netology;

import java.util.Objects;

public class FilmsItem implements Cloneable {
    private static long indexCount = 0;

    private long id;
    private String title;
    private int releaseYear;
    private String imageUrl;

    public FilmsItem(String title, int releaseYear, String imageUrl) {
        this.id = ++indexCount;
        this.title = title;
        this.releaseYear = releaseYear;
        this.imageUrl = imageUrl;
    }

}
