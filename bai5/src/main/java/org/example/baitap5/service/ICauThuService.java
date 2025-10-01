package org.example.baitap5.service;



import org.example.baitap5.entity.CauThu;

import java.util.List;

public interface ICauThuService {
    List<CauThu> findAll();
    CauThu findById(int id);
    Boolean addCauThu(CauThu cauThu);
    void deleteCauThu(int id);
    void updateCauThu(CauThu cauThu);
}
