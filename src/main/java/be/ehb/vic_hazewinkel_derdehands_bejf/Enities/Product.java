package be.ehb.vic_hazewinkel_derdehands_bejf.Enities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Product {
    //
    // Entity's
    // @NotBlank annotation is used to validate that the field is not empty or whitespace.
    // @Email annotation is used to validate that the email field has a valid email format.
    // @Positive annotation is used to validate that the price field is a positive number.
    //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Product name is required")
    private String productname;
    @NotBlank(message = "Category is required")
    private String category;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Contact username is required")
    private String contactusername;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    @Positive(message = "Price must be a positive number")
    private Integer price;

    //
    // Controller
    //
    public Product() {
    }

    //
    // Get / Set
    //

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactusername() {
        return contactusername;
    }

    public void setContactusername(String contactusername) {
        this.contactusername = contactusername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
