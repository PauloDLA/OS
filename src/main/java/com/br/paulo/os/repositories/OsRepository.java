package com.br.paulo.os.repositories;

import com.br.paulo.os.domain.Os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsRepository extends JpaRepository<Os, Integer>{

}
