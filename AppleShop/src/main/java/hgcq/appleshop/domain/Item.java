package hgcq.appleshop.domain;

import hgcq.appleshop.domain.status.ItemCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(name = "idx_price", columnList = "price"),
        @Index(name = "idx_category", columnList = "category"),
})
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemCategory category;

    @Column(nullable = false)
    private double discount;

    @Column(nullable = false)
    private int views;

    @Column(nullable = false)
    private int orders;

    @Column(nullable = false)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<Answer> answers = new ArrayList<>();
}
