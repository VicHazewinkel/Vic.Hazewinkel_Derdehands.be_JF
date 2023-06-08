package be.ehb.vic_hazewinkel_derdehands_bejf.controller;

import be.ehb.vic_hazewinkel_derdehands_bejf.Enities.Product;
import be.ehb.vic_hazewinkel_derdehands_bejf.dao.ProductDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class productController {

    private ProductDAO mProductDAO;


    @Autowired
    public productController(ProductDAO mProductDAO){
        this.mProductDAO = mProductDAO;
    }

    //
    // Show all products
    //
    @ModelAttribute("products")
    public Iterable<Product> getAllProducts(){
        return mProductDAO.findAll();
    }

    //
    // Show 1 product by ID
    //

    //
    // Form Fill in New Product
    //
    @ModelAttribute("productToSave")
    private Product productForForm(){
        return new Product();
    }

    @PostMapping("/newProduct")
    public String insertProduct(@Valid @ModelAttribute("productToSave") Product product,
                                BindingResult result){
        if(result.hasErrors()){
            return "/new";
        }
        mProductDAO.save(product);
        return "redirect:/index";
    }

    //
    // Details Routes in detailscontroller
    //


    //
    // View Routes
    //
    @GetMapping({"/", "/index"})
    public String showIndex(){
        return "index";
    }

    @GetMapping({"/about"})
    public String showAbout(){
        return "about";
    }

    @GetMapping({"/new"})
    public String showNew(ModelMap modelMap){
        return "new";
    }

    @GetMapping({"/details"})
    public String showDetails(){
        return "details";
    }

}
