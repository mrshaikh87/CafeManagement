package com.demo.dao;
import java.util.List;

import org.springframework.*;

public interface BillDao extends JpaRepository<Bill, Integer> {
    List<Bill> getBills();

    List<Bill> getBillByUsername(@Param("username") String username);
}
