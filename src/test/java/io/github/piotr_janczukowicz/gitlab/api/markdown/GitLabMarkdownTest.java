package io.github.piotr_janczukowicz.gitlab.api.markdown;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMarkdownTest {

    @Test
    void constructor_shouldAcceptNull_whenHtmlIsNullable() {
        final GitLabMarkdownBuilder builder = GitLabMarkdownBuilder.builder(MarkdownCatalogFixtures.markdown())
                .html(null);

        final GitLabMarkdown built = builder.build();

        assertThat(built.html()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMarkdown value = MarkdownCatalogFixtures.markdown();

        assertThat(value.html()).isEqualTo("<p dir=\\\"auto\\\">Hello world!</p>\"");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMarkdown original = MarkdownCatalogFixtures.markdown();

        final GitLabMarkdown rebuilt = GitLabMarkdownBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMarkdown.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("html");
    }
}
