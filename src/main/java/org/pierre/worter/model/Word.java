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
public class Word {
    final private String name;
    final private Genre genre;
    final private Type type;

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public boolean hasType(Type type) {
        return this.getType().equals(type);
    }

    public static Predicate<Word> isNoun = (word) -> word.hasType(Type.NOUN);
    public static Predicate<Word> isAdjective = (word) -> word.hasType(Type.ADJ);
}
