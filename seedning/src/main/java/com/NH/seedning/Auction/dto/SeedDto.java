package com.NH.seedning.Auction.dto;

import com.NH.seedning.Auction.domain.Seed;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class SeedDto {

    private Long id;
    private String classification;
    private String breedname;
    private String cropname;
    private String corporation;
    private Long maximum;
    private Long minimum;
    private Long start;
    private Long total;
    private String endDate;
    private Long ing;

    public Seed toEntity() {
        return Seed.builder()
                .id(id)
                .classification(classification)
                .breedname(breedname)
                .cropname(cropname)
                .corporation(corporation)
                .maximum(maximum)
                .minimum(minimum)
                .start(start)
                .total(total)
                .endDate(endDate)
                .ing(ing)
                .build();
    }

    @Builder
    public SeedDto (Long id, String classification, String breedname, String cropname, String corporation, Long maximum, Long minimum,
                    Long start, Long total, String endDate, Long ing) {
        this.id = id;
        this.classification = classification;
        this.breedname = breedname;
        this.cropname = cropname;
        this.corporation = corporation;
        this.maximum = maximum;
        this.minimum = minimum;
        this.start = start;
        this.total = total;
        this.endDate = endDate;
        this.ing = ing;
    }

}
