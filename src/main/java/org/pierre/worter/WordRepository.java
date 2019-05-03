package org.pierre.worter;

import org.pierre.worter.model.Noun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Noun, Long> {
}
