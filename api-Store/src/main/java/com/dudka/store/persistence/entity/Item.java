package com.dudka.store.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "item")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name_of_item")
    String nameOfItem;

    @Column(name = "price")
    Double price;

    @Column(name = "description")
    String description;

    @Column(name = "SKUCode")
    String SKUCode;

    @Column(name = "quantity")
    String quantity;

    @Column(name = "availability")
    String availability;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference(value = "category-item")
    Category category;

    @OneToMany(mappedBy = "item",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    List<Feedback> feedbacks;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "Order_id"))
    Set<Order> orders;

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSKUCode(String SKUCode) {
        this.SKUCode = SKUCode;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return 1 + Long.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nameOfItem='" + nameOfItem + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", SKUCode='" + SKUCode + '\'' +
                ", quantity='" + quantity + '\'' +
                ", availability='" + availability + '\'' +
                ", category=" + category +
                ", feedback=" + feedbacks +
                '}';
    }
}
