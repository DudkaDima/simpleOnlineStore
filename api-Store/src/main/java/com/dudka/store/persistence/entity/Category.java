package com.dudka.store.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "category")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;


    @Column(name = "name_of_category")
    String nameOfCategory;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    @JsonManagedReference(value = "category-item")
    Set<Item> items;

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return id.equals(category.id);
    }

    @Override
    public int hashCode() {
        return 1 + Long.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nameOfCategory='" + nameOfCategory + '\'' +
                ", items=" + items +
                '}';
    }
}
