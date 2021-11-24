package space.enthropy.resources;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.graphql.*;
import space.enthropy.models.AlternativeBinocla;
import space.enthropy.models.Universe;
import space.enthropy.services.UniverseService;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class UniverseResource {
    @Inject
    UniverseService universeService;

    @Query("allUniverses")
    @Description("Get all realms from the eternity")
    public Uni<List<Universe>> getAllUniverses() {
        return universeService.getAllUniverses();
    }

    @Query
    @Description("Get a realm from the eternity")
    public Uni<Universe> getUniverse(@Name("universeId") int id) {
        return universeService.getUniverse(id);
    }

    public Uni<List<AlternativeBinocla>> binoclas(@Source Universe universe) {
        return universeService.getBinoclasByUniverse(universe);
    }
}
