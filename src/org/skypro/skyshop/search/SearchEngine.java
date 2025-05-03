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

    public Searchable bestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable element : data) {
            if (element != null) {
                int count = countOccurrences(element.getSearchTerm(), search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = element;
                }
            }
        }
        if (bestMatch == null){
            throw new BestResultNotFound("Не найдена статья по запросу " + search);
        }
        return bestMatch;
    }

    private int countOccurrences(String text, String subStr) {
        int count = 0;
        int startFrom = 0;
        while (startFrom < text.length()) {
            int foundAt = text.indexOf(subStr, startFrom);
            if (foundAt != -1) {
                count++;
                startFrom = foundAt + subStr.length();
            } else {
                break;
            }
        }
        return count;
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