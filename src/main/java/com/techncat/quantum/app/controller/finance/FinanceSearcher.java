package com.techncat.quantum.app.controller.finance;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.model.finance.Exp;
import com.techncat.quantum.app.model.finance.SocialFund;
import com.techncat.quantum.app.model.finance.SocialInsurance;
import com.techncat.quantum.app.service.finance.FinanceExp_SearchService;
import com.techncat.quantum.app.service.finance.social.FinanceSocialFundService;
import com.techncat.quantum.app.service.finance.social.FinanceSocialInsuranceService;
import com.techncat.quantum.app.service.utils.TimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/finance")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        allowCredentials = "true",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
)
public class FinanceSearcher {

    @Autowired
    private FinanceExp_SearchService financeExp_searchService;
    @Autowired
    private FinanceSocialFundService financeSocialFundService;
    @Autowired
    private FinanceSocialInsuranceService financeSocialInsuranceService;
    @Autowired
    private TimeFormatter timeFormatter;

    @GetMapping("/exps")
    public Page<Exp> search(@ForkiAser Aser aser,
                            @RequestParam(value = "word", required = false) String word,
                            @RequestParam(value = "start", required = false) String start, // 2018-01-01
                            @RequestParam(value = "end", required = false) String end,
                            @RequestParam(value = "type", required = false) Exp.Type type,
                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "limit", defaultValue = "10") Integer size,
                            @RequestParam(value = "order", defaultValue = "desc") String order,
                            @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Date startDate = timeFormatter.formatDate(start, "2000-01-01");
        Date endDate = timeFormatter.formatDate(end, "2099-12-31");
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        if (type == null) {
            return financeExp_searchService.search(startDate, endDate, request);
//            return financeExp_searchService.search(aser.getSid(), startDate, endDate, request);
        } else {
            return financeExp_searchService.search(startDate, endDate, type, request);
//            return financeExp_searchService.search(aser.getSid(), startDate, endDate, type, request);
        }
    }


    @GetMapping("/social_funds")
    public Page<SocialFund> searchSocialFunds(@RequestParam(value = "start", required = false) String start, // 2018-01-01
                                              @RequestParam(value = "end", required = false) String end,
                                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                              @RequestParam(value = "order", defaultValue = "desc") String order,
                                              @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Date startDate = timeFormatter.formatDate(start, "2000-01-01");
        Date endDate = timeFormatter.formatDate(end, "2099-12-31");
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return financeSocialFundService.page(startDate, endDate, request);
    }

    @GetMapping("/social_insurances")
    public Page<SocialInsurance> searchSocialInsurances(@RequestParam(value = "start", required = false) String start, // 2018-01-01
                                                        @RequestParam(value = "end", required = false) String end,
                                                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                        @RequestParam(value = "limit", defaultValue = "10") Integer size,
                                                        @RequestParam(value = "order", defaultValue = "desc") String order,
                                                        @RequestParam(value = "by", defaultValue = "createdAt") String byProp) {
        Date startDate = timeFormatter.formatDate(start, "2000-01-01");
        Date endDate = timeFormatter.formatDate(end, "2099-12-31");
        Sort sort = null;
        if (order.toLowerCase().equals("desc")) {
            sort = Sort.by(byProp).descending();
        } else {
            sort = Sort.by(byProp).ascending();
        }
        PageRequest request = PageRequest.of(page - 1, size, sort);
        return financeSocialInsuranceService.page(startDate, endDate, request);
    }
}
