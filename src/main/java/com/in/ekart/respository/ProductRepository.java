package com.in.ekart.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.ekart.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>{

}
