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
class GitLabProjectFeatureFlagsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectFeatureFlagsCreatePayloadBuilder builder =
                GitLabProjectFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsCreatePayload())
                        .name(null);

        final GitLabProjectFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectFeatureFlagsCreatePayloadBuilder builder =
                GitLabProjectFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsCreatePayload())
                        .description(null);

        final GitLabProjectFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabProjectFeatureFlagsCreatePayloadBuilder builder =
                GitLabProjectFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsCreatePayload())
                        .active(null);

        final GitLabProjectFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStrategiesIsNullable() {
        final GitLabProjectFeatureFlagsCreatePayloadBuilder builder =
                GitLabProjectFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsCreatePayload())
                        .strategies(null);

        final GitLabProjectFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.strategies()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagsCreatePayload value =
                FeatureflagsCatalogFixtures.projectFeatureFlagsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.strategies())
                    .isEqualTo(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagsCreatePayload original =
                FeatureflagsCatalogFixtures.projectFeatureFlagsCreatePayload();

        final GitLabProjectFeatureFlagsCreatePayload rebuilt =
                GitLabProjectFeatureFlagsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenStrategiesSourceChangesLater() {
        final List<GitLabProjectFeatureFlagsCreateStrategy> source =
                new ArrayList<>(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy()));
        final GitLabProjectFeatureFlagsCreatePayload built = GitLabProjectFeatureFlagsCreatePayloadBuilder.builder(
                        FeatureflagsCatalogFixtures.projectFeatureFlagsCreatePayload())
                .strategies(source)
                .build();
        source.clear();

        assertThat(built.strategies()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenStrategiesIsRead() {
        final GitLabProjectFeatureFlagsCreatePayload built =
                FeatureflagsCatalogFixtures.projectFeatureFlagsCreatePayload();
        final List<GitLabProjectFeatureFlagsCreateStrategy> values = built.strategies();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFeatureFlagsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "active", "strategies");
    }
}
