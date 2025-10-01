package org.example.baitap5.repository;


import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.baitap5.entity.CauThu;
import org.example.baitap5.utils.ConnectionUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CauThuRepository implements ICauThuRepository{


    @Override
    public List<CauThu> findAll() {
        List<CauThu> list = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<CauThu> query = session.createNativeQuery("select * from CauThu",CauThu.class);
        list=query.getResultList();
        session.close();
        return list;
    }

    @Override
    public CauThu findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        CauThu cauThu = session.find(CauThu.class,id);
        session.close();
        return cauThu;
    }

    @Override
    public Boolean addCauThu(CauThu cauThu) {
        Session session =ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.persist(cauThu);
            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public void deleteCauThu(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            CauThu cauThu = session.get(CauThu.class, id);
            if (cauThu != null) {
                session.remove(cauThu);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateCauThu(CauThu cauThu) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {

            session.merge(cauThu);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }
    }
}
