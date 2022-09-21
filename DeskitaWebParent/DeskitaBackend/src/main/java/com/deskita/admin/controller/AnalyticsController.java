package com.deskita.admin.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deskita.admin.dto.ChartDto;
import com.deskita.admin.service.CategoryService;
import com.deskita.admin.service.OrderService;
import com.deskita.common.entity.Order;
import com.deskita.export.ExcelOrder;

@Controller
public class AnalyticsController {

	@Autowired
	OrderService order;

	@GetMapping("/analytics")
	public String analyticsPage(Model model) {
		return "analytics/analytic";
	}
	
	@GetMapping("/analytics/chart")
	public String ChartPage(Model model, @RequestParam(name = "startDateChart", required = false) String startDateChart,
			@RequestParam(name = "endDateChart", required = false) String endDateChart) {
		System.out.println(startDateChart);
		System.out.println(endDateChart);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = formatter.parse(startDateChart);
            Date date2 = formatter.parse(endDateChart);
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
    		java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
    		List<Order> list = order.exportOrders(sqlDate1, sqlDate2);
    		List<ChartDto> chartDtos = new ArrayList<>();
    		for(int i =0; i < list.size(); i++)
    		{
    			ChartDto chartDto = new ChartDto();
    			chartDto.setId(list.get(i).getId());
    			chartDto.setTotal(list.get(i).getTotal());
    			chartDtos.add(chartDto);
    		}
    	//	System.out.println(chartDtos.toString());
    		model.addAttribute("listOrder", chartDtos);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "analytics/analytic";
	}
	
	@GetMapping("/export/excel/order")
	public void exportToExcel(HttpServletResponse response,
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate, Model model) throws IOException {
			response.setContentType("application/octet-stream");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new Date());
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=orders_" + currentDateTime + ".xlsx";
			response.setHeader(headerKey, headerValue);

			List<Order> listOrder = order.exportOrders(java.sql.Date.valueOf(startDate),
					java.sql.Date.valueOf(endDate));

			ExcelOrder excelExporter = new ExcelOrder(listOrder);
			excelExporter.export(response);
	}
	
	

}
