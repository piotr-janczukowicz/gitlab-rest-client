package io.github.piotr_janczukowicz.gitlab.api.labels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectLabelsDeleteFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenLabelIdIsNullable() {
        final GitLabProjectLabelsDeleteFilterBuilder builder = GitLabProjectLabelsDeleteFilterBuilder.builder(
                        GitLabProjectLabelsDeleteFilterBuilder.builder()
                                .labelId(1L)
                                .name("name")
                                .build())
                .labelId(null);

        final GitLabProjectLabelsDeleteFilter built = builder.build();

        assertThat(built.labelId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectLabelsDeleteFilterBuilder builder = GitLabProjectLabelsDeleteFilterBuilder.builder(
                        GitLabProjectLabelsDeleteFilterBuilder.builder()
                                .labelId(1L)
                                .name("name")
                                .build())
                .name(null);

        final GitLabProjectLabelsDeleteFilter built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectLabelsDeleteFilter value = GitLabProjectLabelsDeleteFilterBuilder.builder()
                .labelId(1L)
                .name("name")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.labelId()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectLabelsDeleteFilter original = GitLabProjectLabelsDeleteFilterBuilder.builder()
                .labelId(1L)
                .name("name")
                .build();

        final GitLabProjectLabelsDeleteFilter rebuilt =
                GitLabProjectLabelsDeleteFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectLabelsDeleteFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("labelId", "name");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectLabelsDeleteFilter empty = GitLabProjectLabelsDeleteFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectLabelsDeleteFilter filter = GitLabProjectLabelsDeleteFilterBuilder.builder()
                .labelId(1L)
                .name("name")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("label_id", "1"), Map.entry("name", "name"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectLabelsDeleteFilter filter =
                GitLabProjectLabelsDeleteFilterBuilder.builder().labelId(1L).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("label_id", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectLabelsDeleteFilter filter = GitLabProjectLabelsDeleteFilterBuilder.builder()
                .labelId(1L)
                .name("name")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
