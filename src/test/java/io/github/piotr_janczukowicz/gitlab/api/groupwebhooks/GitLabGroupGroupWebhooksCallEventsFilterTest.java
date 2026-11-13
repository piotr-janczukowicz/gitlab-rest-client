package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWebhooksCallEventsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabGroupGroupWebhooksCallEventsFilterBuilder builder =
                GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder(
                                GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder()
                                        .status(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100))
                                        .build())
                        .status(null);

        final GitLabGroupGroupWebhooksCallEventsFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWebhooksCallEventsFilter value = GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder()
                .status(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100))
                .build();

        assertThat(value.status()).isEqualTo(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWebhooksCallEventsFilter original =
                GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder()
                        .status(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100))
                        .build();

        final GitLabGroupGroupWebhooksCallEventsFilter rebuilt =
                GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenStatusSourceChangesLater() {
        final List<GitLabGroupGroupWebhooksCallEventsStatus> source =
                new ArrayList<>(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100));
        final GitLabGroupGroupWebhooksCallEventsFilter built = GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder(
                        GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder()
                                .status(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100))
                                .build())
                .status(source)
                .build();
        source.clear();

        assertThat(built.status()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenStatusIsRead() {
        final GitLabGroupGroupWebhooksCallEventsFilter built = GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder()
                .status(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100))
                .build();
        final List<GitLabGroupGroupWebhooksCallEventsStatus> values = built.status();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWebhooksCallEventsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupWebhooksCallEventsFilter empty = GitLabGroupGroupWebhooksCallEventsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupWebhooksCallEventsFilter filter =
                GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder()
                        .status(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("status", "100"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupWebhooksCallEventsFilter filter =
                GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder()
                        .status(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("status", "100"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupWebhooksCallEventsFilter filter =
                GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder()
                        .status(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
