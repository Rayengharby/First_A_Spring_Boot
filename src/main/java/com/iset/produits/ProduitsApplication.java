package com.iset.produits;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iset.produits.entities.Produit;
import com.iset.produits.service.ProduitServiceImpl;
@SpringBootApplication
public class ProduitsApplication implements CommandLineRunner{
@Autowired
private ProduitServiceImpl service;
public static void main(String[] args) {
 SpringApplication.run(ProduitsApplication.class, args);
 }
@Override
public void run(String... args) throws Exception {
 //Produit prod1= new Produit ("Machine Central",145.00,new Date());
 //Produit prod2= new Produit ("machine1",110.00,new Date());
 //Produit prod3= new Produit ("machine2",120.50,new Date());
 //Produit prod4= new Produit ("machine3",500.70,new Date());
 //service.saveProduit(prod1);
 //service.saveProduit(prod2);
 //service.saveProduit(prod3);
 //service.saveProduit(prod4);
}}
