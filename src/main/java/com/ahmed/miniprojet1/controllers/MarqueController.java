package com.ahmed.miniprojet1.controllers;

import com.ahmed.miniprojet1.entities.Marque;
import com.ahmed.miniprojet1.service.BusService;
import com.ahmed.miniprojet1.service.MarqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MarqueController {
    @Autowired
    BusService busService;

    @Autowired
    MarqueService marqueService;

    @RequestMapping("/supprimerMarque")
    public String supprimerMarque(@RequestParam("id") Long id,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "5") int size) {
        marqueService.deleteMarqueById(id);
        return "redirect:/ListeMarque?page=" + page + "&size=" + size;
    }

    @RequestMapping("/modifierMarque")
    public String editerMarque(@RequestParam("id") Long id, ModelMap modelMap) {
        Marque m = marqueService.getMarque(id);
        modelMap.addAttribute("marque", m);
        modelMap.addAttribute("mode", "edit");
        return "formMarque";
    }

    @RequestMapping("/updateMarque")
    public String updateMarque(@Valid Marque marque, BindingResult bidingResult) {
        if (bidingResult.hasErrors()) return "formMarque";
        marqueService.updateMarque(marque);
        return "redirect:/ListeMarque";
    }

    @RequestMapping("/showCreateMarque")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("marque", new Marque());
        modelMap.addAttribute("mode", "new");
        return "formMarque";
    }

    @RequestMapping("/saveMarque")
    public String saveMarque(@Valid Marque marque, BindingResult bidingResult) {
        if (bidingResult.hasErrors()) return "formMarque";
        marqueService.saveMarque(marque);
        return "redirect:/ListeMarque";
    }

    @RequestMapping("/ListeMarque")
    public String listeMarques(ModelMap modelMap,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "5") int size) {
        modelMap.addAttribute("marque", marqueService.getAllMarqueParPage(page, size));
        modelMap.addAttribute("pages", new int[marqueService.getAllMarqueParPage(page, size).getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeMarque";
    }

}
