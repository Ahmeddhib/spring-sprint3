package com.ahmed.miniprojet1.service;

import com.ahmed.miniprojet1.entities.Marque;
import com.ahmed.miniprojet1.repos.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarqueServiceImpl implements MarqueService{

    @Autowired
    private MarqueRepository marqueRepository;
    @Override
    public Marque saveMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    @Override
    public Marque updateMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    @Override
    public void deleteMarque(Marque marque) {
        marqueRepository.delete(marque);
    }

    @Override
    public void deleteMarqueById(Long id) {
        marqueRepository.deleteById(id);
    }

    @Override
    public Marque getMarque(Long id) {
        return marqueRepository.findById(id).get();
    }

    @Override
    public List<Marque> getAllMarque() {
        return marqueRepository.findAll();
    }

    @Override
    public Page<Marque> getAllMarqueParPage(int page, int size) {
        return marqueRepository.findAll(PageRequest.of(page, size));
    }
}
