package org.progetti.java.spring.pizzeria_platform.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

@Entity
@Table(name = "pizzas")
public class Pizza {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 20)
    @NotBlank(message = "Name is required")
    @Size(min = 5, max = 20, message = "Name must be between 5 and 20 characters")  
    private String name;
    @Column(unique = true, length = 50)
    @Size(max = 255, message = "Description must be up to 255 characters")
    private String description;
    @Column(nullable = false)
    @NotNull(message = "Price is required")
    @Min(value = 5, message = "Price must be >= 5")
    @Max(value = 15, message = "Price must be <= 15")
    private Double price;

    //setting a default image if none is provided
    @Column(name = "image_url", length = 300)
    private String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg";


    public Pizza(){};

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        if(imageUrl == null || imageUrl.isBlank()) {
            this.imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg";
        } else{
            this.imageUrl = imageUrl;
        }

    }

}
