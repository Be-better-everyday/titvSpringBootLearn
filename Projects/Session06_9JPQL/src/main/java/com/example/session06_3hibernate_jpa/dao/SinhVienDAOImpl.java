package com.example.session06_3hibernate_jpa.dao;

import com.example.session06_3hibernate_jpa.entity.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //This annotation mark where using to interact with database
@Transactional
public class SinhVienDAOImpl implements SinhVienDAO{
    private EntityManager entityManager;

    @Autowired
    public SinhVienDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(SinhVien sinhVien) {
        this.entityManager.persist(sinhVien);
    }

    @Override
    public SinhVien getById(int id) {
        return this.entityManager.find(SinhVien.class, id);
    }

    @Override
    public List<SinhVien> getAll() {
        String jpql = "select s from SinhVien s";
        return this.entityManager.createQuery(jpql, SinhVien.class).getResultList();
    }

    @Override
    public List<SinhVien> getByName(String name) {
        String jpql = "select s from SinhVien s where  s.ten = :t";
        TypedQuery<SinhVien> query = this.entityManager.createQuery(jpql, SinhVien.class);
        query.setParameter("t", name);
        return query.getResultList();
    }

    //___________---6.10 Update Object
    @Override
    public SinhVien update(SinhVien sinhVien) {
        return this.entityManager.merge(sinhVien);
    }
    @Override
    public int updateAllName(String name) {
        String jpql = "Update SinhVien  s Set s.ten = :t";
        Query query = this.entityManager.createQuery(jpql);
        query.setParameter("t", name);
        return query.executeUpdate();
    }

    //___________---6.11 Delete Object
    @Override
    public void deleteById(int id) {
        SinhVien sinhVien = getById(id);
        System.out.println("Removing " + sinhVien);
        entityManager.remove(sinhVien);
    }

    @Override
    public void deleteByName(String name) {
        String jpql = "delete from SinhVien s where s.ten like '%'||:name";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("name", name);
        int i = query.executeUpdate();
        System.out.printf("There are %d records deleted!", i);
    }
}


