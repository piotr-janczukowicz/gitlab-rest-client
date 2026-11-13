package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFeatureFlagsUpdateStrategyScopeTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectFeatureFlagsUpdateStrategyScopeBuilder builder =
                GitLabProjectFeatureFlagsUpdateStrategyScopeBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategyScope())
                        .id(null);

        final GitLabProjectFeatureFlagsUpdateStrategyScope built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabProjectFeatureFlagsUpdateStrategyScopeBuilder builder =
                GitLabProjectFeatureFlagsUpdateStrategyScopeBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategyScope())
                        .environmentScope(null);

        final GitLabProjectFeatureFlagsUpdateStrategyScope built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyIsNullable() {
        final GitLabProjectFeatureFlagsUpdateStrategyScopeBuilder builder =
                GitLabProjectFeatureFlagsUpdateStrategyScopeBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategyScope())
                        .destroy(null);

        final GitLabProjectFeatureFlagsUpdateStrategyScope built = builder.build();

        assertThat(built.destroy()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagsUpdateStrategyScope value =
                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategyScope();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.destroy()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagsUpdateStrategyScope original =
                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategyScope();

        final GitLabProjectFeatureFlagsUpdateStrategyScope rebuilt =
                GitLabProjectFeatureFlagsUpdateStrategyScopeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFeatureFlagsUpdateStrategyScope.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "environmentScope", "destroy");
    }
}
