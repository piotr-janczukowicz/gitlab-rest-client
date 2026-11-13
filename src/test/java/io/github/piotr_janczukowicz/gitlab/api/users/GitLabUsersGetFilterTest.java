package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabUsersGetFilterBuilder builder = GitLabUsersGetFilterBuilder.builder(
                        GitLabUsersGetFilterBuilder.builder()
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .withCustomAttributes(null);

        final GitLabUsersGetFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabUsersGetFilterBuilder builder = GitLabUsersGetFilterBuilder.builder(
                        GitLabUsersGetFilterBuilder.builder()
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .customAttributes(null);

        final GitLabUsersGetFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersGetFilter value = GitLabUsersGetFilterBuilder.builder()
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.withCustomAttributes()).isEqualTo(true);
            softly.assertThat(value.customAttributes()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersGetFilter original = GitLabUsersGetFilterBuilder.builder()
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();

        final GitLabUsersGetFilter rebuilt =
                GitLabUsersGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCustomAttributesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabUsersGetFilter built = GitLabUsersGetFilterBuilder.builder(GitLabUsersGetFilterBuilder.builder()
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build())
                .customAttributes(source)
                .build();
        source.clear();

        assertThat(built.customAttributes()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("withCustomAttributes", "customAttributes");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabUsersGetFilter empty = GitLabUsersGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabUsersGetFilter filter = GitLabUsersGetFilterBuilder.builder()
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("with_custom_attributes", "true"), Map.entry("custom_attributes[key]", "value"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabUsersGetFilter filter =
                GitLabUsersGetFilterBuilder.builder().withCustomAttributes(true).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("with_custom_attributes", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabUsersGetFilter filter = GitLabUsersGetFilterBuilder.builder()
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
