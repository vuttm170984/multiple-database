package vn.com.payment.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.payment.model.primary.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
