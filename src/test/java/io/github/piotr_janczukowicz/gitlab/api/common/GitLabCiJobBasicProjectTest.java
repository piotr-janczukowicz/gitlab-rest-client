package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobBasicProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenCiJobTokenScopeEnabledIsNullable() {
        final GitLabCiJobBasicProjectBuilder builder = GitLabCiJobBasicProjectBuilder.builder(
                        CommonCatalogFixtures.ciJobBasicProject())
                .ciJobTokenScopeEnabled(null);

        final GitLabCiJobBasicProject built = builder.build();

        assertThat(built.ciJobTokenScopeEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobBasicProject value = CommonCatalogFixtures.ciJobBasicProject();

        assertThat(value.ciJobTokenScopeEnabled()).isEqualTo("ci_job_token_scope_enabled");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobBasicProject original = CommonCatalogFixtures.ciJobBasicProject();

        final GitLabCiJobBasicProject rebuilt =
                GitLabCiJobBasicProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobBasicProject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ciJobTokenScopeEnabled");
    }
}
