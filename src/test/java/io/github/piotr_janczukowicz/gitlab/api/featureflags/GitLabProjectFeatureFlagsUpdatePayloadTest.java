package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFeatureFlagsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectFeatureFlagsUpdatePayloadBuilder builder =
                GitLabProjectFeatureFlagsUpdatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdatePayload())
                        .name(null);

        final GitLabProjectFeatureFlagsUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectFeatureFlagsUpdatePayloadBuilder builder =
                GitLabProjectFeatureFlagsUpdatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdatePayload())
                        .description(null);

        final GitLabProjectFeatureFlagsUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabProjectFeatureFlagsUpdatePayloadBuilder builder =
                GitLabProjectFeatureFlagsUpdatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdatePayload())
                        .active(null);

        final GitLabProjectFeatureFlagsUpdatePayload built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStrategiesIsNullable() {
        final GitLabProjectFeatureFlagsUpdatePayloadBuilder builder =
                GitLabProjectFeatureFlagsUpdatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdatePayload())
                        .strategies(null);

        final GitLabProjectFeatureFlagsUpdatePayload built = builder.build();

        assertThat(built.strategies()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagsUpdatePayload value =
                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.strategies())
                    .isEqualTo(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagsUpdatePayload original =
                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdatePayload();

        final GitLabProjectFeatureFlagsUpdatePayload rebuilt =
                GitLabProjectFeatureFlagsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenStrategiesSourceChangesLater() {
        final List<GitLabProjectFeatureFlagsUpdateStrategy> source =
                new ArrayList<>(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy()));
        final GitLabProjectFeatureFlagsUpdatePayload built = GitLabProjectFeatureFlagsUpdatePayloadBuilder.builder(
                        FeatureflagsCatalogFixtures.projectFeatureFlagsUpdatePayload())
                .strategies(source)
                .build();
        source.clear();

        assertThat(built.strategies()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenStrategiesIsRead() {
        final GitLabProjectFeatureFlagsUpdatePayload built =
                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdatePayload();
        final List<GitLabProjectFeatureFlagsUpdateStrategy> values = built.strategies();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFeatureFlagsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "active", "strategies");
    }
}
