package space.enthropy.services;

import io.smallrye.mutiny.Uni;
import space.enthropy.models.AlternativeBinocla;
import space.enthropy.models.Timeline;
import space.enthropy.models.Universe;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UniverseService {
    private final Uni<List<Universe>> universes = Uni.createFrom().item(new ArrayList<>());

    private final Uni<List<AlternativeBinocla>> binoclas = Uni.createFrom().item(new ArrayList<>());

    public UniverseService() {
        Universe theDiscoveryRealm = new Universe();
        theDiscoveryRealm.title = "The Discovery";
        theDiscoveryRealm.created = LocalDate.of(15232, Month.MARCH, 22);
        theDiscoveryRealm.interstellarIdentifier = -152521254879145L;
        theDiscoveryRealm.blackHoleEntry = "UI-51223c";
        theDiscoveryRealm.timeline = Timeline.REVERSED;

        Universe nullifiedRealm = new Universe();
        nullifiedRealm.title = "undefined";
        nullifiedRealm.created = LocalDate.of(LocalDate.MIN.getYear() + 5, Month.JANUARY, 2);
        nullifiedRealm.interstellarIdentifier = 0L;
        nullifiedRealm.blackHoleEntry = "Unreachable Horizons A";
        nullifiedRealm.timeline = Timeline.MIXED;

        Universe endOfMultiverse = new Universe();
        endOfMultiverse.title = "Great Saint Extermination";
        endOfMultiverse.created = LocalDate.of(999999, Month.NOVEMBER, 15);
        endOfMultiverse.interstellarIdentifier = 152521879145L;
        endOfMultiverse.blackHoleEntry = "UI-951235123b-D";
        endOfMultiverse.timeline = Timeline.NATURAL;

        universes.subscribe().with(x -> x.add(theDiscoveryRealm));
        universes.subscribe().with(x -> x.add(nullifiedRealm));
        universes.subscribe().with(x -> x.add(endOfMultiverse));

        AlternativeBinocla binoclaWarrior = new AlternativeBinocla();
        binoclaWarrior.name = "Hox";
        binoclaWarrior.surname = "Oswald";
        binoclaWarrior.height = 1.9;
        binoclaWarrior.mass = 80;
        binoclaWarrior.timeTravelling = Timeline.REVERSED;
        binoclaWarrior.isAlive = false;

        AlternativeBinocla binoclaSpirit = new AlternativeBinocla();
        binoclaSpirit.name = "unreachable";
        binoclaSpirit.surname = "unreachable";
        binoclaSpirit.height = Double.MAX_VALUE;
        binoclaSpirit.mass = -1;
        binoclaSpirit.timeTravelling = Timeline.MIXED;
        binoclaSpirit.isAlive = true;


        AlternativeBinocla binoclaTitan = new AlternativeBinocla();
        binoclaTitan.name = "R U Agitated?";
        binoclaTitan.surname = "";
        binoclaTitan.height = 12.3;
        binoclaTitan.mass = 5542;
        binoclaTitan.timeTravelling = Timeline.NATURAL;
        binoclaTitan.isAlive = true;

        binoclas.subscribe().with(x -> x.add(binoclaWarrior));
        binoclas.subscribe().with(x -> x.add(binoclaSpirit));
        binoclas.subscribe().with(x -> x.add(binoclaTitan));
    }

    public Uni<List<Universe>> getAllUniverses() {
        return universes;
    }

    public Uni<Universe> getUniverse(int id) {
        return universes.onItem().transform(x -> x.get(id));
    }

    public void addBinocla(AlternativeBinocla binocla) {
        binoclas.onItem().invoke(x -> x.add(binocla));
    }

    public Uni<AlternativeBinocla> deleteBinocla(int id) {
        return binoclas.onItem().transform(x -> x.remove(id));
    }

    public Uni<List<AlternativeBinocla>> getBinoclaBySurname(String surname) {
        return binoclas.onItem().transform(x -> x.stream()
                .filter(binocla -> binocla.surname.equals(surname))
                .collect(Collectors.toList()));
    }

    public Uni<List<AlternativeBinocla>> getBinoclasByUniverse(Universe universe) {
        return binoclas.onItem().transform(x -> x.stream()
                .filter(binocla -> binocla.timeTravelling == universe.timeline)
                .collect(Collectors.toList()));
    }
}
