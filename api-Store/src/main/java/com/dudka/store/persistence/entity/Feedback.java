package com.dudka.store.persistence.entity;

import com.dudka.store.common.constants.ApplicationConstants;
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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "feedbacks")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "feedback_text")
    @Size(min = ApplicationConstants.Web.DataValidation.MIN_SIZE_OF_FEEDBACK,
            max = ApplicationConstants.Web.DataValidation.MAX_SIZE_OF_FEEDBACK)
    String feedbackText;

    @Size(max = ApplicationConstants.Web.DataValidation.MAX_SIZE_OF_RATING)
    @Column(name = "rating")
    String rating;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonBackReference(value = "feedback-item")
    Item item;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonBackReference(value = "feedback-user")
    User user;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback feedback)) return false;
        return getId().equals(feedback.getId());
    }

    @Override
    public int hashCode() {
        return 1 + Long.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", feedbackText='" + feedbackText + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
