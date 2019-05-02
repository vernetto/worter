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
    final private Type type = Type.NOUN;

    public boolean hasType(Type type) {
        return this.getType().equals(type);
    }

    public static Predicate<Noun> isNoun = (word) -> word.hasType(Type.NOUN);
    public static Predicate<Noun> isAdjective = (word) -> word.hasType(Type.ADJ);
}
