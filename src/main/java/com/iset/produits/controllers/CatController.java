package com.iset.produits.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List; 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iset.produits.entities.Produit;
import com.iset.produits.service.ProduitService;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller
public class CatController {

	@Autowired
	 ProduitService produitService;

	
	@GetMapping("/")
	public String index(Model model) {
		return "produit/template";
	}
	
	@GetMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	 {
		modelMap.addAttribute("produit",new Produit());
	 return "produit/createProduit";
	 }
	
	@RequestMapping("/saveProduit")
	public String saveProduit(@Valid Produit produit,
	                          BindingResult bindingResult,
	                          ModelMap modelMap) {
	    if (bindingResult.hasErrors()) {
	        return "produit/createProduit";
	    }
	    Produit saveProduit = produitService.saveProduit(produit);
	    String msg = "Produit enregistré avec l'ID " + saveProduit.getIdProduit();
	    modelMap.addAttribute("msg", msg);
	    return "produit/createProduit";
	}

	
	@RequestMapping("/ListeProduits")
	public String listeProduits(ModelMap modelMap,
	                             @RequestParam(name = "page", defaultValue = "0") int page,
	                             @RequestParam(name = "size", defaultValue = "4") int size) {
	    Page<Produit> prods = produitService.getAllProduitsParPage(page, size);
	    modelMap.addAttribute("produits", prods.getContent());
	    modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	    modelMap.addAttribute("currentPage", page);
	    return "produit/listeProduits";
	}
 
	
	@RequestMapping("/supprimerProduit")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap
	modelMap,
	@RequestParam(name = "page", defaultValue = "0") int page,
	@RequestParam(name = "size", defaultValue = "2") int size) {
	produitService.deleteProduitById(id);
	Page<Produit> prods = produitService.getAllProduitsParPage(page,size);
	modelMap.addAttribute("produits", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "produit/listeProduits";
	}
	
	@RequestMapping("/modifierProduit")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Produit p= produitService.getProduit(id);
		modelMap.addAttribute("produit", p);
		return "produit/editProduit";
	}
	@RequestMapping("/updateProduit")
	public String updateProduit(@ModelAttribute("produit") Produit produit,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
	//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		produit.setDateCreation(dateCreation);
		produitService.updateProduit(produit);
		List<Produit> prods = produitService.getAllProduits();
		modelMap.addAttribute("produits", prods);
		return "produit/listeProduits";
	}
	 
}
