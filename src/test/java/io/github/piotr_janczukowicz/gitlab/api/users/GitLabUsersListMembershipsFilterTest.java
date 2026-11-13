package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersListMembershipsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabUsersListMembershipsFilterBuilder builder = GitLabUsersListMembershipsFilterBuilder.builder(
                        GitLabUsersListMembershipsFilterBuilder.builder()
                                .type(GitLabUsersListMembershipsType.PROJECT)
                                .build())
                .type(null);

        final GitLabUsersListMembershipsFilter built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersListMembershipsFilter value = GitLabUsersListMembershipsFilterBuilder.builder()
                .type(GitLabUsersListMembershipsType.PROJECT)
                .build();

        assertThat(value.type()).isEqualTo(GitLabUsersListMembershipsType.PROJECT);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersListMembershipsFilter original = GitLabUsersListMembershipsFilterBuilder.builder()
                .type(GitLabUsersListMembershipsType.PROJECT)
                .build();

        final GitLabUsersListMembershipsFilter rebuilt =
                GitLabUsersListMembershipsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersListMembershipsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("type");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabUsersListMembershipsFilter empty = GitLabUsersListMembershipsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabUsersListMembershipsFilter filter = GitLabUsersListMembershipsFilterBuilder.builder()
                .type(GitLabUsersListMembershipsType.PROJECT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("type", "Project"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabUsersListMembershipsFilter filter = GitLabUsersListMembershipsFilterBuilder.builder()
                .type(GitLabUsersListMembershipsType.PROJECT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("type", "Project"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabUsersListMembershipsFilter filter = GitLabUsersListMembershipsFilterBuilder.builder()
                .type(GitLabUsersListMembershipsType.PROJECT)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
