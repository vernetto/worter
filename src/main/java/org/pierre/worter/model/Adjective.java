package org.pierre.worter.model;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
public class Adjective  implements DictionaryItem {
    protected final String name;

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

}
