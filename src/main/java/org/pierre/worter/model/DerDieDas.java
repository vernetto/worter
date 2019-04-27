package org.pierre.worter.model;

import java.util.*;

/**
 * IMplementing an enum with mapping between Articles and Genre
 * https://www.baeldung.com/java-enum-values
 */

public enum DerDieDas {
    der(Genre.M), die(Genre.F), das((Genre.N));

    private static final Map<Genre, DerDieDas> genreMap = new HashMap<>();
    static {
        for (DerDieDas value : values()) {
            genreMap.put(value.genre, value);
        }
    }

    private Genre genre;

    DerDieDas(Genre n) {
        genre = n;
    }

    public static DerDieDas valueOfGenre(Genre g) {
        return genreMap.get(g);
    }
}
