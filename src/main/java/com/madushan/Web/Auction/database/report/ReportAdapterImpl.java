package com.madushan.Web.Auction.database.report;

import com.madushan.Web.Auction.bean.SearchParamListBean;
import com.madushan.Web.Auction.database.user.User;
import com.madushan.Web.Auction.database.user.repository.UserRepository;
import com.madushan.Web.Auction.useCase.GetUsersGivenDateRangeUseCase;
import com.madushan.Web.Auction.useCase.adapter.ReportAdapter;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ReportAdapterImpl implements ReportAdapter {

    private final UserRepository userRepository;
    private final GetUsersGivenDateRangeUseCase getUsersGivenDateRangeUseCase;

    @Override
    public byte[] generatePdf(SearchParamListBean searchParamListBean) throws JRException {
        InputStream inputStream = this.getClass().getResourceAsStream("/report/user_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        List<User> data = getUsersGivenDateRangeUseCase.getUsersGivenDateRange(searchParamListBean.getDateRangeBean());

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(data);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("date", new Date());
        parameters.put("fromDate", searchParamListBean.getDateRangeBean().getStartDate());
        parameters.put("toDate", searchParamListBean.getDateRangeBean().getEndDate());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanCollectionDataSource);

        byte[] currentReport = JasperExportManager.exportReportToPdf(jasperPrint);
        return currentReport;
    }
}
