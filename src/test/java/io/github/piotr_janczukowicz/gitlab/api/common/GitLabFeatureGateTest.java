package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabFeatureGateTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabFeatureGateBuilder builder = GitLabFeatureGateBuilder.builder(CommonCatalogFixtures.featureGate())
                .key(null);

        final GitLabFeatureGate built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabFeatureGateBuilder builder = GitLabFeatureGateBuilder.builder(CommonCatalogFixtures.featureGate())
                .value(null);

        final GitLabFeatureGate built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabFeatureGate value = CommonCatalogFixtures.featureGate();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("percentage_of_actors");
            softly.assertThat(value.value()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabFeatureGate original = CommonCatalogFixtures.featureGate();

        final GitLabFeatureGate rebuilt =
                GitLabFeatureGateBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabFeatureGate.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
