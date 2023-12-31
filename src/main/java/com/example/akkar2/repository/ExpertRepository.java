package com.example.akkar2.repository;

import com.example.akkar2.entities.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {
    public Expert findById(Long id);
    public Expert deleteById(Long id);
    public Expert deleteByCinLike(Long cin);
    @Query("select count(e) from Expert e where e.status=true ")
    int nombreExpertValide();
    @Modifying
    @Transactional
    @Query(value ="update expert set expert.status= true where driver.iduser= :id",nativeQuery = true)
    void updatestatusexpert(int id);
}
