package com.ahmed.miniprojet1;

import com.ahmed.miniprojet1.entities.Bus;
import com.ahmed.miniprojet1.entities.Marque;
import com.ahmed.miniprojet1.repos.BusRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MiniProjet1ApplicationTests {

    @Autowired
    BusRepository busRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testFindByTypeBus()
    {
        List<Bus> bus = busRepository.findByTypeBus("standard");
        for (Bus b : bus)
        {
            System.out.println(b);
        }
    }
    @Test
    public void testFindByNomProduitContains ()
    {
        List<Bus> bus= busRepository.findByTypeBusContains("standard");
        for (Bus b : bus)
        {
            System.out.println(b);
        } }

    @Test
    public void testfindByTypeBusCouleur()
    {
        List<Bus> bus = busRepository.findByTypeBusCouleur("standard", "jaune");
        for (Bus b : bus)
        {
            System.out.println(b);
        }
    }

    @Test
    public void testfindByMarque()
    {
        Marque mar = new Marque();
        mar.setIdMarque(1L);
        List<Bus> bus = busRepository.findByMarque(mar);
        for (Bus b : bus)
        {
            System.out.println(b);
        }
    }

    @Test
    public void findByMarqueIdMarque()
    {
        List<Bus> bus = busRepository.findByMarqueIdMarque(1L);
        for (Bus b : bus)
        {
            System.out.println(b);
        }
    }

    @Test
    public void testfindByOrderByTypeBusAsc()
    {
        List<Bus> bus =
                busRepository.findByOrderByTypeBusAsc();
        for (Bus b : bus)
        {
            System.out.println(b);
        }
    }

    @Test
    public void testTrierProduitsNomsPrix()
    {
        List<Bus> bus =
                busRepository.trierBusTypeBusCouleur();
        for (Bus b : bus)
        {
            System.out.println(b);
        }
    }

}
