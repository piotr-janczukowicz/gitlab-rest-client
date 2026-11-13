package io.github.piotr_janczukowicz.gitlab.api.experiments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabExperimentsCreateAssignmentPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenVariantIsNullable() {
        final GitLabExperimentsCreateAssignmentPayloadBuilder builder =
                GitLabExperimentsCreateAssignmentPayloadBuilder.builder(
                                ExperimentsCatalogFixtures.experimentsCreateAssignmentPayload())
                        .variant(null);

        final GitLabExperimentsCreateAssignmentPayload built = builder.build();

        assertThat(built.variant()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContextIsNullable() {
        final GitLabExperimentsCreateAssignmentPayloadBuilder builder =
                GitLabExperimentsCreateAssignmentPayloadBuilder.builder(
                                ExperimentsCatalogFixtures.experimentsCreateAssignmentPayload())
                        .context(null);

        final GitLabExperimentsCreateAssignmentPayload built = builder.build();

        assertThat(built.context()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabExperimentsCreateAssignmentPayload value =
                ExperimentsCatalogFixtures.experimentsCreateAssignmentPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.variant()).isEqualTo("variant");
            softly.assertThat(value.context()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabExperimentsCreateAssignmentPayload original =
                ExperimentsCatalogFixtures.experimentsCreateAssignmentPayload();

        final GitLabExperimentsCreateAssignmentPayload rebuilt =
                GitLabExperimentsCreateAssignmentPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenContextSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabExperimentsCreateAssignmentPayload built = GitLabExperimentsCreateAssignmentPayloadBuilder.builder(
                        ExperimentsCatalogFixtures.experimentsCreateAssignmentPayload())
                .context(source)
                .build();
        source.clear();

        assertThat(built.context()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabExperimentsCreateAssignmentPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("variant", "context");
    }
}
