package com.NH.seedning.Auction.service;

import com.NH.seedning.Auction.domain.Auction;
import com.NH.seedning.Auction.domain.Seed;
import com.NH.seedning.Auction.dto.AuctionDto;
import com.NH.seedning.Auction.dto.SeedDto;
import com.NH.seedning.Auction.repository.AuctionRepository;
import com.NH.seedning.Auction.repository.SeedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AuctionService {

    private AuctionRepository auctionRepository;

    public List<AuctionDto> getAuctionList(Seed seed) {
        List<Auction> auctions = auctionRepository.findBySeed(seed);
        List<AuctionDto> auctionDtoList = new ArrayList<>();

        for (Auction auction : auctions) {
            AuctionDto auctionDto = AuctionDto.builder()
                    .id(auction.getId())
                    .money(auction.getMoney())
                    .week(auction.getWeek())
                    .result(auction.getResult())
                    .seed(auction.getSeed())
                    .user(auction.getUser())
                    .build();
            auctionDtoList.add(auctionDto);
        }

        return auctionDtoList;
    }

    public Long saveAuction(AuctionDto auctionDto) {
        return auctionRepository.save(auctionDto.toEntity()).getId();
    }
}
