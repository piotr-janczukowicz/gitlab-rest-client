package io.github.piotr_janczukowicz.gitlab.api.markdown;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMarkdownCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTextIsNullable() {
        final GitLabMarkdownCreatePayloadBuilder builder = GitLabMarkdownCreatePayloadBuilder.builder(
                        MarkdownCatalogFixtures.markdownCreatePayload())
                .text(null);

        final GitLabMarkdownCreatePayload built = builder.build();

        assertThat(built.text()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGfmIsNullable() {
        final GitLabMarkdownCreatePayloadBuilder builder = GitLabMarkdownCreatePayloadBuilder.builder(
                        MarkdownCatalogFixtures.markdownCreatePayload())
                .gfm(null);

        final GitLabMarkdownCreatePayload built = builder.build();

        assertThat(built.gfm()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabMarkdownCreatePayloadBuilder builder = GitLabMarkdownCreatePayloadBuilder.builder(
                        MarkdownCatalogFixtures.markdownCreatePayload())
                .project(null);

        final GitLabMarkdownCreatePayload built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMarkdownCreatePayload value = MarkdownCatalogFixtures.markdownCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.text()).isEqualTo("text");
            softly.assertThat(value.gfm()).isEqualTo(true);
            softly.assertThat(value.project()).isEqualTo("project");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMarkdownCreatePayload original = MarkdownCatalogFixtures.markdownCreatePayload();

        final GitLabMarkdownCreatePayload rebuilt =
                GitLabMarkdownCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMarkdownCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("text", "gfm", "project");
    }
}
