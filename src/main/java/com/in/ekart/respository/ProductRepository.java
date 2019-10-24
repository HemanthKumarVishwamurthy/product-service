package com.in.ekart.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.ekart.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>{

	//@Query(value = "Select * from PRODUCT where upper(name) like :name",nativeQuery = true) // Native query to run in SQL Developer
	@Query(value = "Select pe from ProductEntity pe where upper(pe.name) like :name") //HQL Query
	List<ProductEntity> findAllByNameIgnoreCaseLike(String name);

}
