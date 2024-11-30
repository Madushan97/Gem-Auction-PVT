package com.madushan.Web.Auction.useCase;

import com.madushan.Web.Auction.bean.SearchParamListBean;
import com.madushan.Web.Auction.useCase.adapter.ReportAdapter;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenerateReportUseCase {

    private final ReportAdapter reportSAdapter;

    public byte[] generatePdf(SearchParamListBean searchParamListBean) throws JRException {
        return reportSAdapter.generatePdf(searchParamListBean);
    }
}
