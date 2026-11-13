package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabFeatureFlagScopeTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabFeatureFlagScopeBuilder builder = GitLabFeatureFlagScopeBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagScope())
                .id(null);

        final GitLabFeatureFlagScope built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabFeatureFlagScopeBuilder builder = GitLabFeatureFlagScopeBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagScope())
                .environmentScope(null);

        final GitLabFeatureFlagScope built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabFeatureFlagScope value = FeatureflagsCatalogFixtures.featureFlagScope();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.environmentScope()).isEqualTo("production");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabFeatureFlagScope original = FeatureflagsCatalogFixtures.featureFlagScope();

        final GitLabFeatureFlagScope rebuilt =
                GitLabFeatureFlagScopeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabFeatureFlagScope.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "environmentScope");
    }
}
