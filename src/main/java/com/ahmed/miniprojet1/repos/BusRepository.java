package com.ahmed.miniprojet1.repos;

import com.ahmed.miniprojet1.entities.Bus;
import com.ahmed.miniprojet1.entities.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface BusRepository extends JpaRepository<Bus, Long> {

    List<Bus> findByTypeBus(String typeBus);
    List<Bus> findByTypeBusContains(String typeBus);

    @Query("select b from Bus b where b.typeBus like %?1 and b.couleur > ?2")
    List<Bus> findByTypeBusCouleur (String typeBus, String couleur);

    @Query("select b from Bus b where b.marque = ?1")
    List<Bus> findByMarque (Marque marque);

    List<Bus> findByMarqueIdMarque(Long id);

    List<Bus> findByOrderByTypeBusAsc();

    @Query("select b from Bus b order by b.typeBus ASC, b.couleur DESC")
    List<Bus> trierBusTypeBusCouleur ();

}
