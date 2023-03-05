package vn.com.payment.service.mapper;

import org.springframework.stereotype.Service;

import vn.com.payment.dto.request.CountryDTO;
import vn.com.payment.model.primary.Country;

@Service
public class CountryMapper {

    public Country toCountry(CountryDTO countryDTO) {
        if (null == countryDTO) {
            return null;
        }
        Country country = new Country();
        return country;
    }
}
