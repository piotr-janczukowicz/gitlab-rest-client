package io.github.piotr_janczukowicz.gitlab.api.jiraconnectsubscriptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabJiraConnectSubscriptionsCreateSubscriptionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenJwtIsNullable() {
        final GitLabJiraConnectSubscriptionsCreateSubscriptionPayloadBuilder builder =
                GitLabJiraConnectSubscriptionsCreateSubscriptionPayloadBuilder.builder(
                                JiraconnectsubscriptionsCatalogFixtures
                                        .jiraConnectSubscriptionsCreateSubscriptionPayload())
                        .jwt(null);

        final GitLabJiraConnectSubscriptionsCreateSubscriptionPayload built = builder.build();

        assertThat(built.jwt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePathIsNullable() {
        final GitLabJiraConnectSubscriptionsCreateSubscriptionPayloadBuilder builder =
                GitLabJiraConnectSubscriptionsCreateSubscriptionPayloadBuilder.builder(
                                JiraconnectsubscriptionsCatalogFixtures
                                        .jiraConnectSubscriptionsCreateSubscriptionPayload())
                        .namespacePath(null);

        final GitLabJiraConnectSubscriptionsCreateSubscriptionPayload built = builder.build();

        assertThat(built.namespacePath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabJiraConnectSubscriptionsCreateSubscriptionPayload value =
                JiraconnectsubscriptionsCatalogFixtures.jiraConnectSubscriptionsCreateSubscriptionPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.jwt()).isEqualTo("jwt");
            softly.assertThat(value.namespacePath()).isEqualTo("namespace_path");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabJiraConnectSubscriptionsCreateSubscriptionPayload original =
                JiraconnectsubscriptionsCatalogFixtures.jiraConnectSubscriptionsCreateSubscriptionPayload();

        final GitLabJiraConnectSubscriptionsCreateSubscriptionPayload rebuilt =
                GitLabJiraConnectSubscriptionsCreateSubscriptionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabJiraConnectSubscriptionsCreateSubscriptionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("jwt", "namespacePath");
    }
}
