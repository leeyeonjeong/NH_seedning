package com.NH.seedning.Market.dto;

import com.NH.seedning.Auction.domain.Auction;
import com.NH.seedning.Auction.domain.Seed;
import com.NH.seedning.Market.domain.Market;
import com.NH.seedning.User.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class MarketDto {

    private Long id;
    private String price;
    private String quantity;
    private String result;
    private Seed seed;
    private User user;

    public Market toEntity() {
        return Market.builder()
                .id(id)
                .price(price)
                .quantity(quantity)
                .result(result)
                .seed(seed)
                .user(user)
                .build();
    }

    @Builder
    private MarketDto(Long id, String price, String quantity, String result, Seed seed, User user) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.result = result;
        this.seed = seed;
        this.user = user;
    }

}
