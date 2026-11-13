package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsDeleteManageResourceAccessTokenFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder builder =
                GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder.builder(
                                GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder.builder()
                                        .expiresAt(LocalDate.parse("2026-01-01"))
                                        .build())
                        .expiresAt(null);

        final GitLabGroupGroupsDeleteManageResourceAccessTokenFilter built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsDeleteManageResourceAccessTokenFilter value =
                GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder.builder()
                        .expiresAt(LocalDate.parse("2026-01-01"))
                        .build();

        assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsDeleteManageResourceAccessTokenFilter original =
                GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder.builder()
                        .expiresAt(LocalDate.parse("2026-01-01"))
                        .build();

        final GitLabGroupGroupsDeleteManageResourceAccessTokenFilter rebuilt =
                GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupsDeleteManageResourceAccessTokenFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("expiresAt");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsDeleteManageResourceAccessTokenFilter empty =
                GitLabGroupGroupsDeleteManageResourceAccessTokenFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsDeleteManageResourceAccessTokenFilter filter =
                GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder.builder()
                        .expiresAt(LocalDate.parse("2026-01-01"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("expires_at", "2026-01-01"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsDeleteManageResourceAccessTokenFilter filter =
                GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder.builder()
                        .expiresAt(LocalDate.parse("2026-01-01"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("expires_at", "2026-01-01"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsDeleteManageResourceAccessTokenFilter filter =
                GitLabGroupGroupsDeleteManageResourceAccessTokenFilterBuilder.builder()
                        .expiresAt(LocalDate.parse("2026-01-01"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
