package com.NH.seedning.Auction.domain;

import com.NH.seedning.User.model.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String price;
    private String quantity;
    private String result;

    @ManyToOne
    @JoinColumn(name = "seed_id")
    private Seed seed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    private Auction(Long id, String price, String quantity, String result, Seed seed, User user) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.result = result;
        this.seed = seed;
        this.user = user;
    }
}
