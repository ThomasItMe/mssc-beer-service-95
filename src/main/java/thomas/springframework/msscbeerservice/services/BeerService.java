package thomas.springframework.msscbeerservice.services;

import thomas.springframework.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * @author vvthuy on 1/4/2021
 * @project mssc-beer-service
 */
public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
