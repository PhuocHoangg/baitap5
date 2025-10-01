package org.example.baitap5.repository;



import org.example.baitap5.entity.CauThu;

import java.util.List;

public interface ICauThuRepository {
    List<CauThu> findAll();
    CauThu findById(int id);
    Boolean addCauThu(CauThu cauThu);
    void deleteCauThu(int id);
    void updateCauThu(CauThu cauThu);

}
