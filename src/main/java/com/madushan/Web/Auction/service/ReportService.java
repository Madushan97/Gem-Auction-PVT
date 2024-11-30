package com.madushan.Web.Auction.service;

import com.madushan.Web.Auction.bean.SearchParamListBean;
import com.madushan.Web.Auction.useCase.GenerateReportUseCase;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final GenerateReportUseCase reportUseCase;

    public byte[] generateRuleEngineSampleReportPdf(SearchParamListBean searchParamListBean) throws JRException {
        return reportUseCase.generatePdf(searchParamListBean);
    }
}
