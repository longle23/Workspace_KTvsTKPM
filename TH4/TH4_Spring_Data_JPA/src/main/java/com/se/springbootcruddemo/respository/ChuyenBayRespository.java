package com.se.springbootcruddemo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.springbootcruddemo.entity.ChuyenBay;

public interface ChuyenBayRespository extends JpaRepository<ChuyenBay, String> {

//	1.Cho biết các chuyến bay đi Đà Lạt (DAD)
	public List<ChuyenBay> findByGaDen(String gaDen);

//  4.Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
	@Query(value = "select * from chuyenbay where dodai < 10000 and dodai > 8000", nativeQuery = true)
	public List<ChuyenBay> findByDoDaiDBNhoHon10000VaLoHon8000();

//  5.Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
	@Query(value = "select * from chuyenbay where GaDi = 'SGN' and GaDen = 'BMV'", nativeQuery = true)
	public List<ChuyenBay> findBySGtoBMT();

//	6.Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
	@Query(value = "select count(*) from chuyenbay where GaDi = 'SGN'", nativeQuery = true)
	public int sumCBFromSG();

//	14. Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320
	@Query(value = "SELECT * from chuyenbay where DoDai < ( select TamBay from [dbo].[maybay] where Loai =N'Airbus A320')", nativeQuery = true)
	public List<ChuyenBay> findCBByMBAirbusA320();

//	17. Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A. Cho biết các
//	đường bay nào có thể đáp ứng yêu cầu này.
	@Query(value = "select * from [dbo].[chuyenbay] where [GaDi] in"
			+ "(select [GaDen] from [dbo].[chuyenbay]) and [GaDen] in (select [GaDi] from [dbo].[chuyenbay])", nativeQuery = true)
	public List<ChuyenBay> findDBFromAtoBAndToA();

}
