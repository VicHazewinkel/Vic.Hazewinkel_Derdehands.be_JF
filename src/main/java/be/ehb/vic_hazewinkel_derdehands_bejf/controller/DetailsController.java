package be.ehb.vic_hazewinkel_derdehands_bejf.controller;

import be.ehb.vic_hazewinkel_derdehands_bejf.Enities.Product;
import be.ehb.vic_hazewinkel_derdehands_bejf.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.Optional;

@Controller
public class DetailsController {
    ProductDAO nProductDAO;

    @Autowired
    public DetailsController(ProductDAO nProductDAO){
        this.nProductDAO = nProductDAO;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetailsForID(ModelMap modelMap, @PathVariable(value = "id") int id){
        Optional<Product> optional = nProductDAO.findById(id);
        if (optional.isPresent()){
            modelMap.addAttribute("product", optional.get());
            return "details";
        }
        return "redirect:/index";
    }
}
