package io.github.piotr_janczukowicz.gitlab.api.clusterdiscoverycertificatebaseddeprecated;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDiscoveredClustersTest {

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabDiscoveredClustersBuilder builder = GitLabDiscoveredClustersBuilder.builder(
                        ClusterdiscoverycertificatebaseddeprecatedCatalogFixtures.discoveredClusters())
                .groups(null);

        final GitLabDiscoveredClusters built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsIsNullable() {
        final GitLabDiscoveredClustersBuilder builder = GitLabDiscoveredClustersBuilder.builder(
                        ClusterdiscoverycertificatebaseddeprecatedCatalogFixtures.discoveredClusters())
                .projects(null);

        final GitLabDiscoveredClusters built = builder.build();

        assertThat(built.projects()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDiscoveredClusters value =
                ClusterdiscoverycertificatebaseddeprecatedCatalogFixtures.discoveredClusters();

        assertSoftly(softly -> {
            softly.assertThat(value.groups()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.projects()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDiscoveredClusters original =
                ClusterdiscoverycertificatebaseddeprecatedCatalogFixtures.discoveredClusters();

        final GitLabDiscoveredClusters rebuilt =
                GitLabDiscoveredClustersBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDiscoveredClusters.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("groups", "projects");
    }
}
