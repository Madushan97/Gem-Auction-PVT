package com.madushan.Web.Auction.controller;

import com.madushan.Web.Auction.bean.SearchParamListBean;
import com.madushan.Web.Auction.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/report")
@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping(path = "/pdf")
    public ResponseEntity<byte[]> generatePdfReport(@RequestBody SearchParamListBean searchParamListBean) throws Exception {
        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf; charset=UTF-8")
                .header("Content-Disposition", "inline; filename=rule_engine_report.pdf")
                .body(reportService.generateRuleEngineSampleReportPdf(searchParamListBean));
    }
}
