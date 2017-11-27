package co.edu.udea.microserviceclientregistration.microserviceudearegistrationclient;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @RestResource(path = "by-name")
    Collection<Cliente> findByReservationName(@Param("rn") String rn);
}
