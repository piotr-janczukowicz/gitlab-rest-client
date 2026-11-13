package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenCiJobTokenScopeEnabledIsNullable() {
        final GitLabCiJobProjectBuilder builder = GitLabCiJobProjectBuilder.builder(
                        CommonCatalogFixtures.ciJobProject())
                .ciJobTokenScopeEnabled(null);

        final GitLabCiJobProject built = builder.build();

        assertThat(built.ciJobTokenScopeEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobProject value = CommonCatalogFixtures.ciJobProject();

        assertThat(value.ciJobTokenScopeEnabled()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobProject original = CommonCatalogFixtures.ciJobProject();

        final GitLabCiJobProject rebuilt =
                GitLabCiJobProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobProject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ciJobTokenScopeEnabled");
    }
}
