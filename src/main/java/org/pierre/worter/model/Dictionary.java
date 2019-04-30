package org.pierre.worter.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@RequiredArgsConstructor(staticName="of")
public class Dictionary {
    final private Noun[] nouns;
    final private Noun[] adjectives;
}
