package com.example.session06_3hibernate_jpa.dao;

import com.example.session06_3hibernate_jpa.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);
    public SinhVien getById(int id);
    public List<SinhVien> getAll();
    public List<SinhVien> getByName(String name);
    public SinhVien update(SinhVien sinhVien);
    public int updateAllName(String name);
    public void deleteById(int id);
    public void deleteByName(String name);
}
