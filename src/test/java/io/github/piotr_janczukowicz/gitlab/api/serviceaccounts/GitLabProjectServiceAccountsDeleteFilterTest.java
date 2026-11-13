package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectServiceAccountsDeleteFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenHardDeleteIsNullable() {
        final GitLabProjectServiceAccountsDeleteFilterBuilder builder =
                GitLabProjectServiceAccountsDeleteFilterBuilder.builder(
                                GitLabProjectServiceAccountsDeleteFilterBuilder.builder()
                                        .hardDelete(true)
                                        .build())
                        .hardDelete(null);

        final GitLabProjectServiceAccountsDeleteFilter built = builder.build();

        assertThat(built.hardDelete()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectServiceAccountsDeleteFilter value = GitLabProjectServiceAccountsDeleteFilterBuilder.builder()
                .hardDelete(true)
                .build();

        assertThat(value.hardDelete()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectServiceAccountsDeleteFilter original =
                GitLabProjectServiceAccountsDeleteFilterBuilder.builder()
                        .hardDelete(true)
                        .build();

        final GitLabProjectServiceAccountsDeleteFilter rebuilt =
                GitLabProjectServiceAccountsDeleteFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectServiceAccountsDeleteFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("hardDelete");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectServiceAccountsDeleteFilter empty = GitLabProjectServiceAccountsDeleteFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectServiceAccountsDeleteFilter filter =
                GitLabProjectServiceAccountsDeleteFilterBuilder.builder()
                        .hardDelete(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("hard_delete", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectServiceAccountsDeleteFilter filter =
                GitLabProjectServiceAccountsDeleteFilterBuilder.builder()
                        .hardDelete(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("hard_delete", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectServiceAccountsDeleteFilter filter =
                GitLabProjectServiceAccountsDeleteFilterBuilder.builder()
                        .hardDelete(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
