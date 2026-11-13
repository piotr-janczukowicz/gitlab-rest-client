package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoPipelineRefsTest {

    @Test
    void constructor_shouldAcceptNull_whenPipelineRefsIsNullable() {
        final GitLabGeoPipelineRefsBuilder builder = GitLabGeoPipelineRefsBuilder.builder(
                        GeoCatalogFixtures.geoPipelineRefs())
                .pipelineRefs(null);

        final GitLabGeoPipelineRefs built = builder.build();

        assertThat(built.pipelineRefs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoPipelineRefs value = GeoCatalogFixtures.geoPipelineRefs();

        assertThat(value.pipelineRefs()).isEqualTo(List.of("refs/pipelines/1"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoPipelineRefs original = GeoCatalogFixtures.geoPipelineRefs();

        final GitLabGeoPipelineRefs rebuilt =
                GitLabGeoPipelineRefsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoPipelineRefs.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("pipelineRefs");
    }
}
