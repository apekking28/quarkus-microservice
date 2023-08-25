package org.king.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.king.entity.Person;


@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
}
