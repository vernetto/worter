package org.pierre.worter.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DerDieDasTest {
    @org.junit.jupiter.api.Test
    void valueOfGenre() {
        assertEquals(DerDieDas.das, DerDieDas.valueOfGenre(Genre.N));
        assertEquals(DerDieDas.der, DerDieDas.valueOfGenre(Genre.M));
        assertEquals(DerDieDas.die, DerDieDas.valueOfGenre(Genre.F));
    }



}
