package org.king.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.king.entity.Address;

@ApplicationScoped
public class AddressRepository implements PanacheRepository<Address> {
}
