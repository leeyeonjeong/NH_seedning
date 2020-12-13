package com.NH.seedning.Auction.service;

import com.NH.seedning.Auction.domain.Seed;
import com.NH.seedning.Auction.dto.SeedDto;
import com.NH.seedning.Auction.repository.SeedRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SeedService {

    private SeedRepository seedRepository;

    public List<SeedDto> getseedList(Long ing) {
        List<Seed> seeds = seedRepository.findByIng(ing);
        List<SeedDto> seedDtoList = new ArrayList<>();

        for (Seed seed : seeds) {
            SeedDto seedDto = SeedDto.builder()
                    .id(seed.getId())
                    .breedname(seed.getBreedname())
                    .classification(seed.getClassification())
                    .corporation(seed.getCorporation())
                    .cropname(seed.getCropname())
                    .maximum(seed.getMaximum())
                    .minimum(seed.getMinimum())
                    .start(seed.getStart())
                    .total(seed.getTotal())
                    .endDate(seed.getEndDate())
                    .build();
            seedDtoList.add(seedDto);
        }

        return seedDtoList;
    }

    public List<SeedDto> getseedMin(Long id) {
        List<Seed> seeds = seedRepository.findById(id).stream().collect(Collectors.toList());
        List<SeedDto> seedDtoList = new ArrayList<>();

        for (Seed seed : seeds) {
            SeedDto seedDto = SeedDto.builder()
                    .id(seed.getId())
                    .breedname(seed.getBreedname())
                    .classification(seed.getClassification())
                    .corporation(seed.getCorporation())
                    .cropname(seed.getCropname())
                    .maximum(seed.getMaximum())
                    .minimum(seed.getMinimum())
                    .start(seed.getStart())
                    .total(seed.getTotal())
                    .endDate(seed.getEndDate())
                    .build();
            seedDtoList.add(seedDto);
        }

        return seedDtoList;
    }

}
