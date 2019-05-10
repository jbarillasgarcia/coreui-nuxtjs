package com.wau.genesis.apiservice.dao;

import com.wau.genesis.apiservice.model.TransactionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {

    @Query(value = "CALL getDetailDataRewardsActivation(?1, ?2)", nativeQuery = true)
    public List getDetailDataRewardsActivation(String startDate, String endDate);

    @Query(
            value = " SELECT"
            + "       hour(activation_date) AS Hora,"
            + "       count(1) AS Conteo"
            + " FROM transaction"
            + " WHERE 1 = 1"
            + " AND cast(activation_date AS DATE) = current_date()"
            + " GROUP BY hour(activation_date)"
            + " ORDER BY hour(activation_date)",
            nativeQuery = true
    )
    public List getTransactionActivationsByHour();

    @Query(
            value = " SELECT"
            + "       date_format(activation_date, '%m/%d') AS 'Day',"
            + "       count(1) AS 'Count'"
            + " FROM transaction"
            + " WHERE activation_date BETWEEN date_sub(now(), INTERVAL 30 DAY) AND now()"
            + " GROUP BY date_format(activation_date, '%m/%d')"
            + " ORDER BY date_format(activation_date, '%m/%d')",
            nativeQuery = true
    )
    public List getTransactionActivationsByDay();

    @Query(
            value = " SELECT"
            + "       date_format(activation_date, '%Y/%m') AS 'Month',"
            + "       count(1) AS 'Count'"
            + " FROM transaction"
            + " WHERE 1 = 1"
            + " AND activation_date BETWEEN date_sub(now(), INTERVAL 11 MONTH) AND now()"
            + " GROUP BY date_format(activation_date, '%Y/%m')"
            + " ORDER BY date_format(activation_date, '%Y/%m')",
            nativeQuery = true
    )
    public List getTransactionActivationsByMonth();

}
