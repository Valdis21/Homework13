package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] data;
    private int currentIndex = 0;

    public SearchEngine(int size) {
        data = new Searchable[size];
    }

    public void add(Searchable searchable) {
        if (currentIndex >= data.length) {
            throw new IllegalStateException("Достигнут максимальный размер хранилища");
        }
        data[currentIndex++] = searchable;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int index = 0;
        for (Searchable element : data) {
            if (element != null && element.getSearchTerm().contains(query)) {
                results[index++] = element;
            }
        }
        return results;
    }
}
