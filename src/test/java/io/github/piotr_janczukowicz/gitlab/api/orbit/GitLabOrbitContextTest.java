package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrbitContextTest {

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabOrbitContextBuilder builder = GitLabOrbitContextBuilder.builder(OrbitCatalogFixtures.orbitContext())
                .version(null);

        final GitLabOrbitContext built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEntitiesIsNullable() {
        final GitLabOrbitContextBuilder builder = GitLabOrbitContextBuilder.builder(OrbitCatalogFixtures.orbitContext())
                .entities(null);

        final GitLabOrbitContext built = builder.build();

        assertThat(built.entities()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrbitContext value = OrbitCatalogFixtures.orbitContext();

        assertSoftly(softly -> {
            softly.assertThat(value.version()).isEqualTo("1.3.0");
            softly.assertThat(value.entities()).isEqualTo(List.of(OrbitCatalogFixtures.orbitContextEntity()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrbitContext original = OrbitCatalogFixtures.orbitContext();

        final GitLabOrbitContext rebuilt =
                GitLabOrbitContextBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrbitContext.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("version", "entities");
    }
}
