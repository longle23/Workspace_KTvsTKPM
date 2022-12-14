package com.se.springbootcruddemo.service;

import java.util.List;

import com.se.springbootcruddemo.entity.NhanVien;

public interface NhanVienService {
	public List<NhanVien> findByLuongNhoHon10000();

	public int sumLuong();

	public List<NhanVien> findBymaMB747();

	public List<String> findMaByNVLaiBoeingVaAirbus();

	public List<String> findTenByNVLaiBoeing();

}
