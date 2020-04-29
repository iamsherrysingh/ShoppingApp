package com.sherry.ProductMicroService.controller;

import com.sherry.ProductMicroService.model.Product;
import com.sherry.ProductMicroService.service.ProductService;
import com.sherry.ProductMicroService.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = {"/products"})
public class ProductController {

    private final StorageService storageService;
    @Autowired
    ProductService productService;

    @Autowired
    public ProductController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/greaterthan/{id}")
    public List<Product> sortByPriceGreaterThan(@PathVariable("id") Double minPrice) {
        return productService.sortByPriceGreaterThan(minPrice);
    }

    @GetMapping("/lessthan/{id}")
    public List<Product> sortByPriceLessThan(@PathVariable("id") Double maxPrice) {
        return productService.sortByPriceLessThan(maxPrice);
    }

    @GetMapping(value = {"/all", ""})
    public List<Product> listProducts() {
        return productService.getProducts();
    }

    /*
     * Usage: localhost:8081/product/1
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/updatePrice")
    public void updateProduct(@RequestParam("id") Integer id, @RequestParam("newPrice") Double newPrice) {
        productService.updatePrice(id, newPrice);
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(ProductController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }


}