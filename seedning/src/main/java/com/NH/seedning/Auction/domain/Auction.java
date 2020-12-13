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
    private String money;
    private String week;
    private String result;

    @ManyToOne
    @JoinColumn(name = "seed_id")
    private Seed seed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    private Auction(Long id, String money, String week, String result, Seed seed, User user) {
        this.id = id;
        this.money = money;
        this.week = week;
        this.result = result;
        this.seed = seed;
        this.user = user;
    }
}
