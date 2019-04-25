package org.pierre.worter.model;

import java.util.Arrays;

public enum DerDieDas {
    Der(Genre.M), Die(Genre.F), Das((Genre.N));

    private Genre genre;

    DerDieDas(Genre n) {
        genre = n;
    }

    public static DerDieDas find(Genre g) {
        return Arrays.asList(DerDieDas.values()).stream().filter(derDieDas -> derDieDas.genre == g).findFirst().get();
    }
}
