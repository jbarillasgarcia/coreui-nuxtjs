package com.wau.genesis.apiservice.controller;

import com.wau.genesis.apiservice.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@RestController
@RequestMapping("/crm")
@Api("CRM services")
public class CrmController {
    
    private Logger logger = LoggerFactory.getLogger(CrmController.class);
    
    @Autowired
    private TransactionService transactionService;
    
    @ApiOperation(value = "Retrieves all Data Rewards Activaction records filtered by date range.")
    @GetMapping("/getDataRewardsActivation")
    public ResponseEntity<Object> getDataRewardsActivation(@RequestParam(required = true) String startDate, @RequestParam(required = true) String endDate) throws Exception {
        this.logger.debug(String.format("@%s::getDataRewardsActivation(%s, %s)", this.getClass().getName(), startDate, endDate));
        
        List dataRewardsActivation = this.transactionService.getDataRewardsActivation(startDate, endDate);
                
        return ResponseEntity.ok((dataRewardsActivation != null) ? dataRewardsActivation : new ArrayList<>());
    }
    
    @ApiOperation(value = "Builds a XLSX file with all Data Rewards Activation records.")
    @GetMapping("/exportDataRewardsActivationAsXLSX")
    public ModelAndView exportDataRewardsActivationAsXLSX(HttpServletRequest request, HttpServletResponse response) {
        this.logger.debug(String.format("@%s::exportDataRewardsActivationAsXLSX(HttpServletRequest, HttpServletResponse)", this.getClass().getName()));
        
        return this.transactionService.exportDataRewardsActivationAsXLSX(request, response);
    }
    
    @ApiOperation(value = "Retrieves all Transaction Activations by hour.")
    @GetMapping("/getTransactionActivationsByHour")
    public ResponseEntity<Object> getTransactionActivationsByHour() {
        this.logger.debug(String.format("%s::getTransactionActivationByHour()", this.getClass().getName()));
        
        return ResponseEntity.ok(this.transactionService.getTransactionActivationsByHour());
    }
    
    @ApiOperation(value = "Retrieves all Transaction Activations by day.")
    @GetMapping("/getTransactionActivationsByDay")
    public ResponseEntity<Object> getTransactionActivationsByDay() {
        this.logger.debug(String.format("%s::getTransactionActivationsByDay()", this.getClass().getName()));
        
        return ResponseEntity.ok(this.transactionService.getTransactionActivationsByDay());
    }
    
    @ApiOperation(value = "Retrieves all Transaction Activations by month.")
    @GetMapping("/getTransactionActivationsByMonth")
    public ResponseEntity<Object> getTransactionActivationsByMonth() {
        this.logger.debug(String.format("%s::getTransactionActivationsByMonth()", this.getClass().getName()));
        
        return ResponseEntity.ok(this.transactionService.getTransactionActivationsByMonth());
    }
}
