package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectLevelVariablesUpdateFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabProjectProjectLevelVariablesUpdateFilterBuilder builder =
                GitLabProjectProjectLevelVariablesUpdateFilterBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdateFilter())
                        .environmentScope(null);

        final GitLabProjectProjectLevelVariablesUpdateFilter built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectLevelVariablesUpdateFilter value =
                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdateFilter();

        assertThat(value.environmentScope()).isEqualTo("environment_scope");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectLevelVariablesUpdateFilter original =
                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdateFilter();

        final GitLabProjectProjectLevelVariablesUpdateFilter rebuilt =
                GitLabProjectProjectLevelVariablesUpdateFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectLevelVariablesUpdateFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("environmentScope");
    }
}
