package thomas.springframework.msscbeerservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import thomas.springframework.msscbeerservice.domain.Beer;

import java.util.UUID;

/**
 * @author vvthuy on 12/24/2020
 * @project mssc-beer-service
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
