package com.madushan.Web.Auction.useCase.adapter;

import com.madushan.Web.Auction.bean.SearchParamListBean;
import net.sf.jasperreports.engine.JRException;

public interface ReportAdapter {

    byte[] generatePdf(SearchParamListBean searchParamListBean) throws JRException;
}
