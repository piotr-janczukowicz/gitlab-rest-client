package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiPipelineMergeRequestTest {

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabCiPipelineMergeRequestBuilder builder = GitLabCiPipelineMergeRequestBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineMergeRequest())
                .iid(null);

        final GitLabCiPipelineMergeRequest built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabCiPipelineMergeRequestBuilder builder = GitLabCiPipelineMergeRequestBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineMergeRequest())
                .title(null);

        final GitLabCiPipelineMergeRequest built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCiPipelineMergeRequestBuilder builder = GitLabCiPipelineMergeRequestBuilder.builder(
                        PipelinesCatalogFixtures.ciPipelineMergeRequest())
                .webUrl(null);

        final GitLabCiPipelineMergeRequest built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiPipelineMergeRequest value = PipelinesCatalogFixtures.ciPipelineMergeRequest();

        assertSoftly(softly -> {
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Add rate limiting to the public API");
            softly.assertThat(value.webUrl()).isEqualTo("https://gitlab.example.com/foo/bar/-/merge_requests/14");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiPipelineMergeRequest original = PipelinesCatalogFixtures.ciPipelineMergeRequest();

        final GitLabCiPipelineMergeRequest rebuilt =
                GitLabCiPipelineMergeRequestBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiPipelineMergeRequest.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("iid", "title", "webUrl");
    }
}
