package com.management.elder.elements;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OldRepository extends JpaRepository<Old, Long> {
    //List<Old> findAllByOldUserNoEquals(Long userNo);
    //List<Old> findAllByOldUserNoAndOldRegionAndOldGenderAndOldNameEquals(
    //        Long userNo,String oldRegion,Boolean oldGender,String oldName);
    List<Old> findAllByOldUser_UserNo(Long id);
    List<Old> findAllByOldUser_UserNoAndOldRegionAndOldGenderAndOldNameEquals(
            Long userNo,String oldRegion,Boolean oldGender,String oldName);

}
