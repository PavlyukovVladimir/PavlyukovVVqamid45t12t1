package ru.netology;

import java.util.Arrays;

public class Repo {
    private FilmsItem[] repo = new FilmsItem[0];

    public FilmsItem[] findAll() {
        return repo.clone();
    }

    public void save(FilmsItem item) {
        if (item == null) {
            return;
        }
        FilmsItem[] tmp = Arrays.copyOf(repo, repo.length + 1);
        tmp[repo.length] = item;
        repo = tmp;
    }

    public FilmsItem findById(long itemId) {
        for (FilmsItem item : repo) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        return null;
    }

    public void removeById(long itemId) throws NullPointerException {
        for (int i = 0; i < repo.length; i++) {
            if (repo[i].getId() == itemId) {
                remove(i);
                return;
            }
        }
        throw new NullPointerException("Объекта с id: " + itemId + " нет");
    }

    private void remove(int index) throws NullPointerException {
        if (index >= 0 && repo.length > index) {
            FilmsItem[] tmp = new FilmsItem[repo.length - 1];
            int i = 0;
            for (; i < index; i++) {
                tmp[i] = repo[i];
            }
            i++;
            for (; i < repo.length; i++) {
                tmp[i - 1] = repo[i];
            }
            repo = tmp;
        } else {
            throw new NullPointerException("Объекта с index: " + index + " нет");
        }
    }

    private void removeAll() {
        repo = new FilmsItem[0];
    }
}
