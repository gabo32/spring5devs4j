package com.gabo32.dev4j.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gabo32.dev4j.users.entities.Address;

@Repository
public interface AddressRespository extends CrudRepository<Address, Integer>{

}
