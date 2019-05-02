package org.pierre.worter.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.function.Predicate;

@Data
@Builder
@ToString

@RequiredArgsConstructor(staticName="of")
public class Noun implements DictionaryItem {
    protected final String name;

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    final private Genre genre;

}
