package be.ehb.vic_hazewinkel_derdehands_bejf.dao;

import be.ehb.vic_hazewinkel_derdehands_bejf.Enities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer> {
}
