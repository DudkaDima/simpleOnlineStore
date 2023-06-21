package com.dudka.store.persistence.entity;


import com.dudka.store.common.constants.ApplicationConstants;
import com.dudka.store.common.validator.ValidEmail;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Size(min = ApplicationConstants.Web.DataValidation.MIN_SIZE_OF_FIRSTNAME,
            max = ApplicationConstants.Web.DataValidation.MAX_SIZE_OF_FIRSTNAME)
    @Column(name = "firstname")
    @NotNull
    String firstname;

    @Column(name = "surname")
    @Size(min = ApplicationConstants.Web.DataValidation.MIN_SIZE_OF_SURNAME,
            max = ApplicationConstants.Web.DataValidation.MAX_SIZE_OF_SURNAME)
    String surname;

    @Size(min = ApplicationConstants.Web.DataValidation.MIN_SIZE_OF_EMAIL,
            max = ApplicationConstants.Web.DataValidation.MAX_SIZE_OF_EMAIL)
    @ValidEmail
    @Column(name = "email")
    String email;
    @Size(min = ApplicationConstants.Web.DataValidation.MIN_SIZE_OF_PHONE_NUMBER,
            max = ApplicationConstants.Web.DataValidation.MAX_SIZE_OF_PHONE_NUMBER)
    @Column(name = "phone")
    String phone;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference
    List<Order> orders;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference(value = "feedback-user")
    List<Feedback> feedback;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return 1 + Long.hashCode(getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", orders=" + orders +
                ", feedbacks=" + feedback +
                '}';
    }
}
