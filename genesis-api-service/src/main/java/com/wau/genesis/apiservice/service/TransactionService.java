package com.wau.genesis.apiservice.service;

import com.wau.genesis.apiservice.dao.TransactionRepository;
import com.wau.genesis.apiservice.view.DataRewardsActivationXlsxView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List getDataRewardsActivation(String startDate, String endDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date formattedStartDate;
        Date formattedEndDate;
        
        try {
            formattedStartDate = sdf.parse(startDate);            
        } catch (ParseException pe) {
            throw new Exception("Fecha inválida|La fecha de inicio proporcionada no es una fecha válida.");
        }
        
        try {
            formattedEndDate = sdf.parse(endDate);            
        } catch (ParseException pe) {
            throw new Exception("Fecha inválida|La fecha de fin proporcionada no es una fecha válida.");
        }
        
        if (formattedStartDate.compareTo(formattedEndDate) > 0) {
            throw new Exception("Fecha inválida|La fecha de inicio debe ser menor a la fecha de fin.");
        }
        
        List dataRewardsActivations = this.transactionRepository.getDetailDataRewardsActivation(startDate, endDate);

        if (dataRewardsActivations.size() >= 10000) {
            throw new Exception("Tiempo de espera caducado|Por favor intente nuevamente o intente cambiar sus parámetros de búsqueda.");
        }

        return dataRewardsActivations;
    }

    public ModelAndView exportDataRewardsActivationAsXLSX(HttpServletRequest request, HttpServletResponse response) {
        String[] columns = {
            "Transacción",
            "Activación",
            "DN",
            "Cliente",
            "Código Bono",
            "Descripción",
            "Estado Carrier",
            "Estado Magus"
        };

        Map<String, Object> data = new HashMap<>();
        data.put("filename", "DataRewardsActivation.xlsx");
        data.put("columns", Arrays.asList(columns));
        data.put("rows", this.transactionRepository.getDetailDataRewardsActivation(request.getParameter("startDate"), request.getParameter("endDate")));

        return new ModelAndView(new DataRewardsActivationXlsxView(), data);
    }

    public List getTransactionActivationsByHour() {
        List activations = this.transactionRepository.getTransactionActivationsByHour();
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < 24; i++) {
            map.put(i, 0);
        }
        
        for (Object[] activation : (List<Object[]>) activations) {
            int hour = Integer.parseInt(activation[0].toString());
            int activationsCount = Integer.parseInt(activation[1].toString());
            
            map.put(hour, activationsCount);
        }

        List<Object[]> newActivations = new ArrayList();
        
        for (Integer key : map.keySet()) {
            newActivations.add(new Object[] { String.valueOf(key), String.valueOf(map.get(key)) });
        }
        
        return newActivations;
    }

    public List getTransactionActivationsByDay() {
        return this.transactionRepository.getTransactionActivationsByDay();
    }

    public List getTransactionActivationsByMonth() {
        return this.transactionRepository.getTransactionActivationsByMonth();
    }

}
