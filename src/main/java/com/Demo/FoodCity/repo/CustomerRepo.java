package com.Demo.FoodCity.repo;

import com.Demo.FoodCity.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query(value = "SELECT COUNT(id) FROM customer WHERE name LIKE ?1 OR address LIKE ?1", nativeQuery = true)
    public long getCountWithSearchText(String text);
    @Query (value = "SELECT * FROM customer WHERE name LIKE ?1 OR address LIKE ?1", nativeQuery = true)
    public Page<Customer> findAllWithSearchText(String text, PageRequest request);

}
