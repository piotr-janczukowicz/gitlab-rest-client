package io.github.piotr_janczukowicz.gitlab.api.avatar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAvatarGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabAvatarGetFilterBuilder builder = GitLabAvatarGetFilterBuilder.builder(
                        GitLabAvatarGetFilterBuilder.builder().size(1L).build())
                .size(null);

        final GitLabAvatarGetFilter built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAvatarGetFilter value =
                GitLabAvatarGetFilterBuilder.builder().size(1L).build();

        assertThat(value.size()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAvatarGetFilter original =
                GitLabAvatarGetFilterBuilder.builder().size(1L).build();

        final GitLabAvatarGetFilter rebuilt =
                GitLabAvatarGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAvatarGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("size");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabAvatarGetFilter empty = GitLabAvatarGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabAvatarGetFilter filter =
                GitLabAvatarGetFilterBuilder.builder().size(1L).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("size", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabAvatarGetFilter filter =
                GitLabAvatarGetFilterBuilder.builder().size(1L).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("size", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabAvatarGetFilter filter =
                GitLabAvatarGetFilterBuilder.builder().size(1L).build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
