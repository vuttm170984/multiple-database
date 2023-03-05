package vn.com.payment.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.payment.model.primary.Country;
import vn.com.payment.repository.primary.CountryRepository;
import vn.com.payment.service.CountriesService;

@Service
public class CountryServiceImpl implements CountriesService {

    private final CountryRepository countriesRepository;

    public CountryServiceImpl(CountryRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    @Override
    @Transactional
    public Country save(final Country countries) {
        if (null == countries) {
            return null;
        }

        return this.countriesRepository.save(countries);
    }
}
