package com.vaishnavi.malgudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vaishnavi.malgudi.service.DashboardService;

@Controller
public class HomeController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute(
                "productCount",
                dashboardService.getProductCount());

        model.addAttribute(
                "orderCount",
                dashboardService.getOrderCount());

        model.addAttribute(
                "totalSales",
                dashboardService.getTotalSales());

        model.addAttribute(
                "totalExpenses",
                dashboardService.getTotalExpenses());

        model.addAttribute(
                "profit",
                dashboardService.getProfit());

        model.addAttribute(
                "lowStockCount",
                dashboardService.getLowStockCount());

        return "dashboard";
    }
}