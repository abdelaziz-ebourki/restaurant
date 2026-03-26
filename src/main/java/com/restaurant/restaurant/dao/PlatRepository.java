package com.restaurant.restaurant.dao;

import com.restaurant.restaurant.model.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlatRepository extends JpaRepository<Plat, Long> {
    List<Plat> findByCaloriesLessThan(int maxCalories);
}