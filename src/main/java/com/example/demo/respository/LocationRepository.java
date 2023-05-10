package com.example.demo.respository;

import com.example.demo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByLocationLike(String string);

    List<Location> findByLocationNotLike(String string);

    List<Location> findByLocationStartingWith(String string);

    List<Location> findByLocationEndingWith(String string);

    List<Location> findByLocationContaining(String string);
}
