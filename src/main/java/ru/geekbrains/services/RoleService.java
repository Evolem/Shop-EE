package ru.geekbrains.services;
import ru.geekbrains.persist.repositories.ejbRepositories.RoleRepository;
import ru.geekbrains.pojo.RoleRepr;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RoleService implements Serializable {

    @Inject
    private RoleRepository roleRepository;

    @TransactionAttribute
    public List<RoleRepr> getAllRoles() {
        return roleRepository.getAllRoles().stream()
                .map(RoleRepr::new)
                .collect(Collectors.toList());
    }
}
