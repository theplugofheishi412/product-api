package sn.isi.l3gl.api.productapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.product_core.entity.Product;
import sn.isi.l3gl.core.product_core.service.ProductService;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des produits.
 * Délègue toute la logique métier à ProductService (product-core).
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    /**
     * Injection du service via le constructeur.
     * @param productService le service métier de product-core
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Ajoute un nouveau produit.
     * POST /api/products
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Retourne la liste de tous les produits.
     * GET /api/products
     */
    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok(productService.ListProducts());
    }

    /**
     * Met à jour la quantité d'un produit.
     * PUT /api/products/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateQuantity(
            @PathVariable Long id,
            @RequestParam Integer quantity) {
        Product updated = productService.updateQuantity(id, quantity);
        return ResponseEntity.ok(updated);
    }

    /**
     * Retourne le nombre de produits en stock faible.
     * GET /api/products/low-stock/count
     */
    @GetMapping("/low-stock/count")
    public ResponseEntity<Long> countLowStockProducts() {
        return ResponseEntity.ok(productService.countLowStockProducts());
    }
}