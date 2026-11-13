package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiBridgeProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenCiJobTokenScopeEnabledIsNullable() {
        final GitLabCiBridgeProjectBuilder builder = GitLabCiBridgeProjectBuilder.builder(
                        PipelinesCatalogFixtures.ciBridgeProject())
                .ciJobTokenScopeEnabled(null);

        final GitLabCiBridgeProject built = builder.build();

        assertThat(built.ciJobTokenScopeEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiBridgeProject value = PipelinesCatalogFixtures.ciBridgeProject();

        assertThat(value.ciJobTokenScopeEnabled()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiBridgeProject original = PipelinesCatalogFixtures.ciBridgeProject();

        final GitLabCiBridgeProject rebuilt =
                GitLabCiBridgeProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiBridgeProject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ciJobTokenScopeEnabled");
    }
}
