package org.pierre.worter.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString

@RequiredArgsConstructor(staticName="of")
public class Word {
    final private String name;
    final private Genre genre;
    final private Type type;
}
