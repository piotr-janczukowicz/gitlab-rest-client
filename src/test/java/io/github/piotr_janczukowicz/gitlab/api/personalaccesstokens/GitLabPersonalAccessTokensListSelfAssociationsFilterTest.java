package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPersonalAccessTokensListSelfAssociationsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenMinAccessLevelIsNullable() {
        final GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder builder =
                GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder(
                                GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder()
                                        .minAccessLevel(
                                                GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.GUEST)
                                        .build())
                        .minAccessLevel(null);

        final GitLabPersonalAccessTokensListSelfAssociationsFilter built = builder.build();

        assertThat(built.minAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPersonalAccessTokensListSelfAssociationsFilter value =
                GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder()
                        .minAccessLevel(GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.GUEST)
                        .build();

        assertThat(value.minAccessLevel())
                .isEqualTo(GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.GUEST);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPersonalAccessTokensListSelfAssociationsFilter original =
                GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder()
                        .minAccessLevel(GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.GUEST)
                        .build();

        final GitLabPersonalAccessTokensListSelfAssociationsFilter rebuilt =
                GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabPersonalAccessTokensListSelfAssociationsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("minAccessLevel");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabPersonalAccessTokensListSelfAssociationsFilter empty =
                GitLabPersonalAccessTokensListSelfAssociationsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabPersonalAccessTokensListSelfAssociationsFilter filter =
                GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder()
                        .minAccessLevel(GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.GUEST)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("min_access_level", "10"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabPersonalAccessTokensListSelfAssociationsFilter filter =
                GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder()
                        .minAccessLevel(GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.GUEST)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("min_access_level", "10"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabPersonalAccessTokensListSelfAssociationsFilter filter =
                GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder()
                        .minAccessLevel(GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.GUEST)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
