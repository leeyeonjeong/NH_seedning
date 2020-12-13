package com.NH.seedning.Auction.dto;

import com.NH.seedning.Auction.domain.Auction;
import com.NH.seedning.Auction.domain.Seed;
import com.NH.seedning.User.model.User;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Data
@ToString
public class AuctionDto {

    private Long id;
    private String money;
    private String week;
    private String result;
    private Seed seed;
    private User user;

    public Auction toEntity() {
        return Auction.builder()
                .id(id)
                .money(money)
                .week(week)
                .result(result)
                .seed(seed)
                .user(user)
                .build();
    }

    @Builder
    private AuctionDto(Long id, String money, String week, String result, Seed seed, User user) {
        this.id = id;
        this.money = money;
        this.week = week;
        this.result = result;
        this.seed = seed;
        this.user = user;
    }

}
