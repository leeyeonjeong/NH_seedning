package com.NH.seedning.Auction.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
public class Seed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public Seed (Long id, String classification, String breedname, String cropname, String corporation, Long maximum, Long minimum,
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
