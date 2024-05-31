package com.iset.produits;
 
import java.util.List; 
import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.context.SpringBootTest; 
import com.iset.produits.dao.ProduitRepository;
import com.iset.produits.entities.Categorie;
import com.iset.produits.entities.Produit; 
@SpringBootTest

public class ProduitsApplicatonTests  {
	 @Autowired
	    private ProduitRepository produitRepository;
	 
	 @Test
	public void testFindByNomProduit() { 
		 List<Produit> prods = produitRepository.findByNomProduit("iphone X"); 
		 for (Produit p : prods) {
			 System.out.println("testFindByNomProduit --------------->" + 	 p.getNomProduit()); 
					  } 
					  } 
	 
	 @Test
	 public void testFindByNomProduitContains() { 
		 List<Produit> prods =  produitRepository.findByNomProduitContains("Asus"); 
		    for (Produit p : prods) { 
			   System.out.println("+++++++++++++++>"+p.getNomProduit()); 
					  } 
					  }
	 
	 @Test
	 public void testfindByNomPrix() { 
	  List<Produit> prods = produitRepository.findByNomPrix("iphone X", 
	 1000.0); 
	  for (Produit p : prods) { 
	  System.out.println(p); 
	  } 
	  }
	 
	 @Test
	 public void testfindByCategorie() { 
		 Categorie cat = new Categorie(); 
	 cat.setIdCat(1L); 
	  List<Produit> prods = produitRepository.findByCategorie(cat); 
	 for (Produit p : prods) { 
	  System.out.println(p); 
	  } 
	 }

	 @Test
	 public void testfindByOrderByNomProduitAsc() { 
	  List<Produit> prods = 
	 produitRepository.findByOrderByNomProduitAsc(); 
	  for (Produit p : prods) { 
	  System.out.println(p); 
	  } 
	  }
	 @Test
	 public void testTrierProduitsNomsPrix() { 
	  List<Produit> prods = produitRepository.trierProduitsNomsPrix(); 
	  for (Produit p : prods) { 
	  System.out.println(p); 
	  } 
	 }
		 }

