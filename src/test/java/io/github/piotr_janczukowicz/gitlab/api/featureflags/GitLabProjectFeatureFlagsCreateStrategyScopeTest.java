package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFeatureFlagsCreateStrategyScopeTest {

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabProjectFeatureFlagsCreateStrategyScopeBuilder builder =
                GitLabProjectFeatureFlagsCreateStrategyScopeBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategyScope())
                        .environmentScope(null);

        final GitLabProjectFeatureFlagsCreateStrategyScope built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagsCreateStrategyScope value =
                FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategyScope();

        assertThat(value.environmentScope()).isEqualTo("environment_scope");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagsCreateStrategyScope original =
                FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategyScope();

        final GitLabProjectFeatureFlagsCreateStrategyScope rebuilt =
                GitLabProjectFeatureFlagsCreateStrategyScopeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFeatureFlagsCreateStrategyScope.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("environmentScope");
    }
}
