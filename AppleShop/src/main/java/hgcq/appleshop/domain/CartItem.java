package hgcq.appleshop.domain;

import hgcq.appleshop.domain.id.CartItemId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(CartItemId.class)
public class CartItem {

    @Id
    @Column(name = "cart_id")
    private Long cartId;

    @Id
    @Column(name = "item_id")
    private Long itemId;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false, insertable = false, updatable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false, insertable = false, updatable = false)
    private Item item;
}
