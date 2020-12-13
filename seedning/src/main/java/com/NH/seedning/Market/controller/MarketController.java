package com.NH.seedning.Market.controller;

import com.NH.seedning.Auction.domain.Seed;
import com.NH.seedning.Auction.repository.SeedRepository;
import com.NH.seedning.Market.dto.MarketDto;
import com.NH.seedning.Market.service.MarketService;
import com.NH.seedning.User.model.SessionUser;
import com.NH.seedning.User.model.User;
import com.NH.seedning.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MarketController {

    @Autowired
    private SeedRepository seedRepository;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private MarketService marketService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("market_detail")
    public String dis_market_detail() {
        return "market/market_detail";
    }

    @GetMapping("market_detail_1")
    public String market_detail_1() {
        return "market/market_detail_1";
    }

//    @PostMapping("market_detail")
//    public String market_detail(MarketDto marketDto) {
//        Seed seed = seedRepository.findById((Long) httpSession.getAttribute("seedid")).get();
//        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
//        User user = userRepository.findById(sessionUser.getId()).get();
//        marketDto.setSeed(seed);
//        marketDto.setUser(user);
//        marketDto.setResult("낙찰");
//        //marketService.saveAuction(marketDto);
//        return "redirect:/";
//    }

    @GetMapping("market_home")
    public String dis_market_home() {
        return "market/marcket_home";
    }

}
