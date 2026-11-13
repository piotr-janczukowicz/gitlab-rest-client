package io.github.piotr_janczukowicz.gitlab.api.projectwikis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWikisGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabProjectProjectWikisGetFilterBuilder builder = GitLabProjectProjectWikisGetFilterBuilder.builder(
                        GitLabProjectProjectWikisGetFilterBuilder.builder()
                                .version("version")
                                .renderHtml(true)
                                .build())
                .version(null);

        final GitLabProjectProjectWikisGetFilter built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRenderHtmlIsNullable() {
        final GitLabProjectProjectWikisGetFilterBuilder builder = GitLabProjectProjectWikisGetFilterBuilder.builder(
                        GitLabProjectProjectWikisGetFilterBuilder.builder()
                                .version("version")
                                .renderHtml(true)
                                .build())
                .renderHtml(null);

        final GitLabProjectProjectWikisGetFilter built = builder.build();

        assertThat(built.renderHtml()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWikisGetFilter value = GitLabProjectProjectWikisGetFilterBuilder.builder()
                .version("version")
                .renderHtml(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.renderHtml()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWikisGetFilter original = GitLabProjectProjectWikisGetFilterBuilder.builder()
                .version("version")
                .renderHtml(true)
                .build();

        final GitLabProjectProjectWikisGetFilter rebuilt =
                GitLabProjectProjectWikisGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWikisGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("version", "renderHtml");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectWikisGetFilter empty = GitLabProjectProjectWikisGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectWikisGetFilter filter = GitLabProjectProjectWikisGetFilterBuilder.builder()
                .version("version")
                .renderHtml(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("version", "version"), Map.entry("render_html", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectWikisGetFilter filter = GitLabProjectProjectWikisGetFilterBuilder.builder()
                .version("version")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("version", "version"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectWikisGetFilter filter = GitLabProjectProjectWikisGetFilterBuilder.builder()
                .version("version")
                .renderHtml(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
