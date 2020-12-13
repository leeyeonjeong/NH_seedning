package com.NH.seedning.Auction.repository;

import com.NH.seedning.Auction.domain.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeedRepository extends JpaRepository<Seed, Long> {
    List<Seed> findByIng(Long ing);
}
