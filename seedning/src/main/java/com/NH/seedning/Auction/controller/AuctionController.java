package com.NH.seedning.Auction.controller;

import com.NH.seedning.Auction.domain.Auction;
import com.NH.seedning.Auction.domain.Seed;
import com.NH.seedning.Auction.dto.AuctionDto;
import com.NH.seedning.Auction.dto.SeedDto;
import com.NH.seedning.Auction.repository.AuctionRepository;
import com.NH.seedning.Auction.repository.SeedRepository;
import com.NH.seedning.Auction.service.AuctionService;
import com.NH.seedning.Auction.service.SeedService;
import com.NH.seedning.User.model.SessionUser;
import com.NH.seedning.User.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@AllArgsConstructor
@Controller
public class AuctionController {

    @Autowired
    private SeedService seedService;
    @Autowired
    private SeedRepository seedRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("auction_early")
    public String auction_early() {
        return "auction/auction_early";
    }

    @GetMapping("auction_ing")
    public String auction_ing(Model model) {
        List<SeedDto> seedDto = seedService.getseedList(1L);
        model.addAttribute("seedDto", seedDto);

        return "auction/auction_ing";
    }

    @GetMapping("auction_end")
    public String auction_end(Model model) {
        List<SeedDto> seedDto = seedService.getseedList(0L);
        model.addAttribute("seedDto", seedDto);
        return "auction/auction_end";
    }

    @GetMapping("auction_detail_early")
    public String auction_detail_early() {
        return "auction/auction_detail_early";
    }

    @GetMapping("auction_detail_ing_{id}")
    public String dis_auction_detail_ing(@PathVariable(name="id") Long id, Model model) {
        Seed seed = seedRepository.findById(id).get();
        List<AuctionDto> auctionDto = auctionService.getAuctionList(seed);
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        model.addAttribute("seed", seed);
        model.addAttribute("user", user);
        model.addAttribute("auctionDto", auctionDto);
        httpSession.setAttribute("seedid", id);

        System.out.println("#############################"+auctionDto);

        return "auction/auction_detail_ing";
    }

    @PostMapping("auction_detail_ing")
    public String auction_detail_ing(AuctionDto auctionDto) {
        Seed seed = seedRepository.findById((Long) httpSession.getAttribute("seedid")).get();
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        auctionDto.setSeed(seed);
        auctionDto.setUser(userRepository.findById(user.getId()).get());
        auctionDto.setResult("낙찰");
        auctionService.saveAuction(auctionDto);

        return "redirect:/";
    }

    @GetMapping("auction_detail_end")
    public String auction_detail_end() {
        return "auction/auction_detail_end";
    }

}
