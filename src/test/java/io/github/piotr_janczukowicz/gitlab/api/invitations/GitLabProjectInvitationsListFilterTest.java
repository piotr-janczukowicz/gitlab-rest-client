package io.github.piotr_janczukowicz.gitlab.api.invitations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectInvitationsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenQueryIsNullable() {
        final GitLabProjectInvitationsListFilterBuilder builder = GitLabProjectInvitationsListFilterBuilder.builder(
                        GitLabProjectInvitationsListFilterBuilder.builder()
                                .query("query")
                                .build())
                .query(null);

        final GitLabProjectInvitationsListFilter built = builder.build();

        assertThat(built.query()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectInvitationsListFilter value = GitLabProjectInvitationsListFilterBuilder.builder()
                .query("query")
                .build();

        assertThat(value.query()).isEqualTo("query");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectInvitationsListFilter original = GitLabProjectInvitationsListFilterBuilder.builder()
                .query("query")
                .build();

        final GitLabProjectInvitationsListFilter rebuilt =
                GitLabProjectInvitationsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectInvitationsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("query");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectInvitationsListFilter empty = GitLabProjectInvitationsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectInvitationsListFilter filter = GitLabProjectInvitationsListFilterBuilder.builder()
                .query("query")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("query", "query"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectInvitationsListFilter filter = GitLabProjectInvitationsListFilterBuilder.builder()
                .query("query")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("query", "query"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectInvitationsListFilter filter = GitLabProjectInvitationsListFilterBuilder.builder()
                .query("query")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
