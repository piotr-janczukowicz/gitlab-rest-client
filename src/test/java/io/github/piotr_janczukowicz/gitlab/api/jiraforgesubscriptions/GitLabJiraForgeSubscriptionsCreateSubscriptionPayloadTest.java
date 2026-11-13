package io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabJiraForgeSubscriptionsCreateSubscriptionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNamespacePathIsNullable() {
        final GitLabJiraForgeSubscriptionsCreateSubscriptionPayloadBuilder builder =
                GitLabJiraForgeSubscriptionsCreateSubscriptionPayloadBuilder.builder(
                                JiraforgesubscriptionsCatalogFixtures.jiraForgeSubscriptionsCreateSubscriptionPayload())
                        .namespacePath(null);

        final GitLabJiraForgeSubscriptionsCreateSubscriptionPayload built = builder.build();

        assertThat(built.namespacePath()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenNamespacePathIsTooLong() {
        final GitLabJiraForgeSubscriptionsCreateSubscriptionPayloadBuilder builder =
                GitLabJiraForgeSubscriptionsCreateSubscriptionPayloadBuilder.builder(
                                JiraforgesubscriptionsCatalogFixtures.jiraForgeSubscriptionsCreateSubscriptionPayload())
                        .namespacePath("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenNamespacePathHasTheMaximumLength() {
        final GitLabJiraForgeSubscriptionsCreateSubscriptionPayloadBuilder builder =
                GitLabJiraForgeSubscriptionsCreateSubscriptionPayloadBuilder.builder(
                                JiraforgesubscriptionsCatalogFixtures.jiraForgeSubscriptionsCreateSubscriptionPayload())
                        .namespacePath("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabJiraForgeSubscriptionsCreateSubscriptionPayload value =
                JiraforgesubscriptionsCatalogFixtures.jiraForgeSubscriptionsCreateSubscriptionPayload();

        assertThat(value.namespacePath()).isEqualTo("namespace_path");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabJiraForgeSubscriptionsCreateSubscriptionPayload original =
                JiraforgesubscriptionsCatalogFixtures.jiraForgeSubscriptionsCreateSubscriptionPayload();

        final GitLabJiraForgeSubscriptionsCreateSubscriptionPayload rebuilt =
                GitLabJiraForgeSubscriptionsCreateSubscriptionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabJiraForgeSubscriptionsCreateSubscriptionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("namespacePath");
    }
}
