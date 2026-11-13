package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSearchUpdateNamespacePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNumberOfReplicasOverrideIsNullable() {
        final GitLabCodeSearchUpdateNamespacePayloadBuilder builder =
                GitLabCodeSearchUpdateNamespacePayloadBuilder.builder(
                                CodesearchCatalogFixtures.codeSearchUpdateNamespacePayload())
                        .numberOfReplicasOverride(null);

        final GitLabCodeSearchUpdateNamespacePayload built = builder.build();

        assertThat(built.numberOfReplicasOverride()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenNumberOfReplicasOverrideIsBelowTheMinimum() {
        final GitLabCodeSearchUpdateNamespacePayloadBuilder builder =
                GitLabCodeSearchUpdateNamespacePayloadBuilder.builder(
                                CodesearchCatalogFixtures.codeSearchUpdateNamespacePayload())
                        .numberOfReplicasOverride(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenNumberOfReplicasOverrideIsTheMinimum() {
        final GitLabCodeSearchUpdateNamespacePayloadBuilder builder =
                GitLabCodeSearchUpdateNamespacePayloadBuilder.builder(
                                CodesearchCatalogFixtures.codeSearchUpdateNamespacePayload())
                        .numberOfReplicasOverride(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSearchUpdateNamespacePayload value =
                CodesearchCatalogFixtures.codeSearchUpdateNamespacePayload();

        assertThat(value.numberOfReplicasOverride()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSearchUpdateNamespacePayload original =
                CodesearchCatalogFixtures.codeSearchUpdateNamespacePayload();

        final GitLabCodeSearchUpdateNamespacePayload rebuilt =
                GitLabCodeSearchUpdateNamespacePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeSearchUpdateNamespacePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("numberOfReplicasOverride");
    }
}
