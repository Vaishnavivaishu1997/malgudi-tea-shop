package com.vaishnavi.malgudi.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vaishnavi.malgudi.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/reports")
    public String reports(Model model) {

        model.addAttribute(
                "totalSales",
                reportService.getTotalSales());

        model.addAttribute(
                "totalExpenses",
                reportService.getTotalExpenses());

        model.addAttribute(
                "profit",
                reportService.getProfit());

        model.addAttribute(
                "totalOrders",
                reportService.getTotalOrders());

        model.addAttribute(
                "orders",
                reportService.getAllOrders());

        model.addAttribute(
                "expenses",
                reportService.getAllExpenses());

        return "reports";
    }
    @GetMapping("/reports/download")
    public void downloadReport(
            HttpServletResponse response)
            throws Exception {

        response.setContentType(
                "text/csv");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=report.csv");

        PrintWriter writer =
                response.getWriter();

        writer.println(
                "Order ID,Amount,Date");

        writer.println(
                "1,50,30-10-2026");

        writer.println(
                "2,75,30-10-2026");

        writer.flush();
    }
}