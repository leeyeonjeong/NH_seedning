package com.NH.seedning.Market.repository;

import com.NH.seedning.Auction.domain.Auction;
import com.NH.seedning.Auction.domain.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarketRepository extends JpaRepository<Auction, Long> {
    Optional<Auction> findById(Long id);
    List<Auction> findBySeed(Seed seed);
}
