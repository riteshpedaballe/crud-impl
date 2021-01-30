package com.crud.dao;

import org.springframework.stereotype.Repository;
import com.crud.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}
