package com.example.aseel.Repository;

import com.example.aseel.Model.RequestOpp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestOppRepository extends JpaRepository<RequestOpp, Integer> {

    RequestOpp findRequestOppById(Integer requestId);
}
