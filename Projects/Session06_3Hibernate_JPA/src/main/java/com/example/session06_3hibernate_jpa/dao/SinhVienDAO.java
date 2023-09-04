package com.example.session06_3hibernate_jpa.dao;

import com.example.session06_3hibernate_jpa.entity.SinhVien;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);
    public SinhVien getById(int id);
}
