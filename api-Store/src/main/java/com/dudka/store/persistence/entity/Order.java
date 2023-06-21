package com.dudka.store.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonBackReference
    User users;

    @Column(name = "delivery_status")
    DeliveryStatus deliveryStatus;

    @Column(name = "payment_status")
    DeliveryStatus payment_status;


    @ManyToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    @JsonBackReference(value = "order-item")
    Set<Item> items;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setPayment_status(DeliveryStatus payment_status) {
        this.payment_status = payment_status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getId().equals(order.getId());
    }

    @Override
    public int hashCode() {
        return 1 + Long.hashCode(getId());
    }
}
