package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRouterDiscoveryInformationTest {

    @Test
    void constructor_shouldAcceptNull_whenServerUrlIsNullable() {
        final GitLabCiJobRouterDiscoveryInformationBuilder builder =
                GitLabCiJobRouterDiscoveryInformationBuilder.builder(
                                RunnersCatalogFixtures.ciJobRouterDiscoveryInformation())
                        .serverUrl(null);

        final GitLabCiJobRouterDiscoveryInformation built = builder.build();

        assertThat(built.serverUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRouterDiscoveryInformation value = RunnersCatalogFixtures.ciJobRouterDiscoveryInformation();

        assertThat(value.serverUrl()).isEqualTo("wss://kas.example.com");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRouterDiscoveryInformation original = RunnersCatalogFixtures.ciJobRouterDiscoveryInformation();

        final GitLabCiJobRouterDiscoveryInformation rebuilt =
                GitLabCiJobRouterDiscoveryInformationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRouterDiscoveryInformation.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("serverUrl");
    }
}
