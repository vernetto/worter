package org.pierre.worter.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DerDieDasTest {
    @org.junit.jupiter.api.Test
    void valueOfGenre() {
        assertEquals(DerDieDas.Das, DerDieDas.valueOfGenre(Genre.N));
        assertEquals(DerDieDas.Der, DerDieDas.valueOfGenre(Genre.M));
        assertEquals(DerDieDas.Die, DerDieDas.valueOfGenre(Genre.F));
    }



}
