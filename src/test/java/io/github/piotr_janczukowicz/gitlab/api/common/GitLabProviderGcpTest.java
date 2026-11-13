package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProviderGcpTest {

    @Test
    void constructor_shouldAcceptNull_whenClusterIdIsNullable() {
        final GitLabProviderGcpBuilder builder = GitLabProviderGcpBuilder.builder(CommonCatalogFixtures.providerGcp())
                .clusterId(null);

        final GitLabProviderGcp built = builder.build();

        assertThat(built.clusterId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusNameIsNullable() {
        final GitLabProviderGcpBuilder builder = GitLabProviderGcpBuilder.builder(CommonCatalogFixtures.providerGcp())
                .statusName(null);

        final GitLabProviderGcp built = builder.build();

        assertThat(built.statusName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGcpProjectIdIsNullable() {
        final GitLabProviderGcpBuilder builder = GitLabProviderGcpBuilder.builder(CommonCatalogFixtures.providerGcp())
                .gcpProjectId(null);

        final GitLabProviderGcp built = builder.build();

        assertThat(built.gcpProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoneIsNullable() {
        final GitLabProviderGcpBuilder builder = GitLabProviderGcpBuilder.builder(CommonCatalogFixtures.providerGcp())
                .zone(null);

        final GitLabProviderGcp built = builder.build();

        assertThat(built.zone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMachineTypeIsNullable() {
        final GitLabProviderGcpBuilder builder = GitLabProviderGcpBuilder.builder(CommonCatalogFixtures.providerGcp())
                .machineType(null);

        final GitLabProviderGcp built = builder.build();

        assertThat(built.machineType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNumNodesIsNullable() {
        final GitLabProviderGcpBuilder builder = GitLabProviderGcpBuilder.builder(CommonCatalogFixtures.providerGcp())
                .numNodes(null);

        final GitLabProviderGcp built = builder.build();

        assertThat(built.numNodes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndpointIsNullable() {
        final GitLabProviderGcpBuilder builder = GitLabProviderGcpBuilder.builder(CommonCatalogFixtures.providerGcp())
                .endpoint(null);

        final GitLabProviderGcp built = builder.build();

        assertThat(built.endpoint()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProviderGcp value = CommonCatalogFixtures.providerGcp();

        assertSoftly(softly -> {
            softly.assertThat(value.clusterId()).isEqualTo("cluster_id");
            softly.assertThat(value.statusName()).isEqualTo("status_name");
            softly.assertThat(value.gcpProjectId()).isEqualTo("gcp_project_id");
            softly.assertThat(value.zone()).isEqualTo("zone");
            softly.assertThat(value.machineType()).isEqualTo("machine_type");
            softly.assertThat(value.numNodes()).isEqualTo("num_nodes");
            softly.assertThat(value.endpoint()).isEqualTo("endpoint");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProviderGcp original = CommonCatalogFixtures.providerGcp();

        final GitLabProviderGcp rebuilt =
                GitLabProviderGcpBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProviderGcp.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "clusterId", "statusName", "gcpProjectId", "zone", "machineType", "numNodes", "endpoint");
    }
}
