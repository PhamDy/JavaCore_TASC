package net.DyPham.springboot.repository;

import net.DyPham.springboot.enitity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}
