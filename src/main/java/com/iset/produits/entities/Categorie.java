package com.iset.produits.entities;

import java.util.List; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private long idCat;
   private String nomCat ;
   private String descriptionCat;
   @OneToMany(mappedBy = "categorie")
   private List <Produit> produits;
   
  public Categorie() {
	  
  }

public Categorie( String nomCat, String descriptionCat, List<Produit> produit) {
	super();
	
	this.nomCat = nomCat;
	this.descriptionCat = descriptionCat;
	this.produits = produit;
}

public long getIdCat() {
	return idCat;
}

public void setIdCat(long idCat) {
	this.idCat = idCat;
}

public String getNomCat() {
	return nomCat;
}

public void setNomCat(String nomCat) {
	this.nomCat = nomCat;
}

public String getDescriptionCat() {
	return descriptionCat;
}

public void setDescriptionCat(String descriptionCat) {
	this.descriptionCat = descriptionCat;
}

public List<Produit> getproduit() {
	return produits;
}

public void setproduits(List<Produit> produit) {
	this.produits = produit;
}
}
