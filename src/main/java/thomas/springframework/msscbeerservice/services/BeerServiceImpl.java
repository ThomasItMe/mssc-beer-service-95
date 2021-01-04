package thomas.springframework.msscbeerservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thomas.springframework.msscbeerservice.domain.Beer;
import thomas.springframework.msscbeerservice.repositories.BeerRepository;
import thomas.springframework.msscbeerservice.web.controller.NotFoundException;
import thomas.springframework.msscbeerservice.web.mappers.BeerMapper;
import thomas.springframework.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * @author vvthuy on 1/4/2021
 * @project mssc-beer-service
 */
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto((beerRepository.save(beerMapper.beerDtoToBeer(beerDto))));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {

        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyleEnum().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
