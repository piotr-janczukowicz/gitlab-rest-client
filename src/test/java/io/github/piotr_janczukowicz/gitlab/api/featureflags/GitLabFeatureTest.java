package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabFeatureTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabFeatureBuilder builder = GitLabFeatureBuilder.builder(FeatureflagsCatalogFixtures.feature())
                .name(null);

        final GitLabFeature built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabFeatureBuilder builder = GitLabFeatureBuilder.builder(FeatureflagsCatalogFixtures.feature())
                .state(null);

        final GitLabFeature built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGatesIsNullable() {
        final GitLabFeatureBuilder builder = GitLabFeatureBuilder.builder(FeatureflagsCatalogFixtures.feature())
                .gates(null);

        final GitLabFeature built = builder.build();

        assertThat(built.gates()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefinitionIsNullable() {
        final GitLabFeatureBuilder builder = GitLabFeatureBuilder.builder(FeatureflagsCatalogFixtures.feature())
                .definition(null);

        final GitLabFeature built = builder.build();

        assertThat(built.definition()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabFeature value = FeatureflagsCatalogFixtures.feature();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("experimental_feature");
            softly.assertThat(value.state()).isEqualTo("off");
            softly.assertThat(value.gates()).isEqualTo(List.of(CommonCatalogFixtures.featureGate()));
            softly.assertThat(value.definition()).isEqualTo(CommonCatalogFixtures.featureDefinition());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabFeature original = FeatureflagsCatalogFixtures.feature();

        final GitLabFeature rebuilt = GitLabFeatureBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabFeature.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "state", "gates", "definition");
    }
}
