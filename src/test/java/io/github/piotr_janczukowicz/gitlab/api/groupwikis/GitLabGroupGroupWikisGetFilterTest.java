package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWikisGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabGroupGroupWikisGetFilterBuilder builder = GitLabGroupGroupWikisGetFilterBuilder.builder(
                        GitLabGroupGroupWikisGetFilterBuilder.builder()
                                .version("version")
                                .renderHtml(true)
                                .build())
                .version(null);

        final GitLabGroupGroupWikisGetFilter built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRenderHtmlIsNullable() {
        final GitLabGroupGroupWikisGetFilterBuilder builder = GitLabGroupGroupWikisGetFilterBuilder.builder(
                        GitLabGroupGroupWikisGetFilterBuilder.builder()
                                .version("version")
                                .renderHtml(true)
                                .build())
                .renderHtml(null);

        final GitLabGroupGroupWikisGetFilter built = builder.build();

        assertThat(built.renderHtml()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWikisGetFilter value = GitLabGroupGroupWikisGetFilterBuilder.builder()
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
        final GitLabGroupGroupWikisGetFilter original = GitLabGroupGroupWikisGetFilterBuilder.builder()
                .version("version")
                .renderHtml(true)
                .build();

        final GitLabGroupGroupWikisGetFilter rebuilt =
                GitLabGroupGroupWikisGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWikisGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("version", "renderHtml");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupWikisGetFilter empty = GitLabGroupGroupWikisGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupWikisGetFilter filter = GitLabGroupGroupWikisGetFilterBuilder.builder()
                .version("version")
                .renderHtml(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("version", "version"), Map.entry("render_html", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupWikisGetFilter filter = GitLabGroupGroupWikisGetFilterBuilder.builder()
                .version("version")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("version", "version"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupWikisGetFilter filter = GitLabGroupGroupWikisGetFilterBuilder.builder()
                .version("version")
                .renderHtml(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
