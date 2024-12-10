package com.example.aseel.Repository;

import com.example.aseel.Model.RealEstateDev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateDevRepository  extends JpaRepository<RealEstateDev, Integer> {

    RealEstateDev findRealEstateDevById(Integer id);


}
