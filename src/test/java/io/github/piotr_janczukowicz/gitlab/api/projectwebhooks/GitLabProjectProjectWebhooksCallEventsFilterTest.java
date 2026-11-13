package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

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
class GitLabProjectProjectWebhooksCallEventsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectProjectWebhooksCallEventsFilterBuilder builder =
                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder(
                                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder()
                                        .status(List.of(GitLabProjectProjectWebhooksCallEventsStatus.N_100))
                                        .build())
                        .status(null);

        final GitLabProjectProjectWebhooksCallEventsFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWebhooksCallEventsFilter value =
                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder()
                        .status(List.of(GitLabProjectProjectWebhooksCallEventsStatus.N_100))
                        .build();

        assertThat(value.status()).isEqualTo(List.of(GitLabProjectProjectWebhooksCallEventsStatus.N_100));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWebhooksCallEventsFilter original =
                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder()
                        .status(List.of(GitLabProjectProjectWebhooksCallEventsStatus.N_100))
                        .build();

        final GitLabProjectProjectWebhooksCallEventsFilter rebuilt =
                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenStatusSourceChangesLater() {
        final List<GitLabProjectProjectWebhooksCallEventsStatus> source =
                new ArrayList<>(List.of(GitLabProjectProjectWebhooksCallEventsStatus.N_100));
        final GitLabProjectProjectWebhooksCallEventsFilter built =
                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder(
                                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder()
                                        .status(List.of(GitLabProjectProjectWebhooksCallEventsStatus.N_100))
                                        .build())
                        .status(source)
                        .build();
        source.clear();

        assertThat(built.status()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenStatusIsRead() {
        final GitLabProjectProjectWebhooksCallEventsFilter built =
                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder()
                        .status(List.of(GitLabProjectProjectWebhooksCallEventsStatus.N_100))
                        .build();
        final List<GitLabProjectProjectWebhooksCallEventsStatus> values = built.status();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWebhooksCallEventsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectWebhooksCallEventsFilter empty = GitLabProjectProjectWebhooksCallEventsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectWebhooksCallEventsFilter filter =
                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder()
                        .status(List.of(GitLabProjectProjectWebhooksCallEventsStatus.N_100))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("status", "100"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectWebhooksCallEventsFilter filter =
                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder()
                        .status(List.of(GitLabProjectProjectWebhooksCallEventsStatus.N_100))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("status", "100"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectWebhooksCallEventsFilter filter =
                GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder()
                        .status(List.of(GitLabProjectProjectWebhooksCallEventsStatus.N_100))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
