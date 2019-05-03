package org.pierre.worter.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.function.Predicate;

@Data
@Builder
@ToString

@RequiredArgsConstructor(staticName="of")
@Entity
public class Noun implements DictionaryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    final private Long id;

    final private String name;

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    final private Genre genre;

}
