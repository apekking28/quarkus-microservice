package org.king.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.king.entity.Person;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<Person, Long> {

}
