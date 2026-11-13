package io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabJiraConnectSubscriptionEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabJiraConnectSubscriptionEntityBuilder builder = GitLabJiraConnectSubscriptionEntityBuilder.builder(
                        JiraforgesubscriptionsCatalogFixtures.jiraConnectSubscriptionEntity())
                .createdAt(null);

        final GitLabJiraConnectSubscriptionEntity built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnlinkPathIsNullable() {
        final GitLabJiraConnectSubscriptionEntityBuilder builder = GitLabJiraConnectSubscriptionEntityBuilder.builder(
                        JiraforgesubscriptionsCatalogFixtures.jiraConnectSubscriptionEntity())
                .unlinkPath(null);

        final GitLabJiraConnectSubscriptionEntity built = builder.build();

        assertThat(built.unlinkPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabJiraConnectSubscriptionEntityBuilder builder = GitLabJiraConnectSubscriptionEntityBuilder.builder(
                        JiraforgesubscriptionsCatalogFixtures.jiraConnectSubscriptionEntity())
                .group(null);

        final GitLabJiraConnectSubscriptionEntity built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabJiraConnectSubscriptionEntity value =
                JiraforgesubscriptionsCatalogFixtures.jiraConnectSubscriptionEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.unlinkPath()).isEqualTo("unlink_path");
            softly.assertThat(value.group()).isEqualTo(JiraforgesubscriptionsCatalogFixtures.jiraConnectGroupEntity());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabJiraConnectSubscriptionEntity original =
                JiraforgesubscriptionsCatalogFixtures.jiraConnectSubscriptionEntity();

        final GitLabJiraConnectSubscriptionEntity rebuilt =
                GitLabJiraConnectSubscriptionEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabJiraConnectSubscriptionEntityBuilder builder = GitLabJiraConnectSubscriptionEntityBuilder.builder(
                        JiraforgesubscriptionsCatalogFixtures.jiraConnectSubscriptionEntity())
                .createdAt(instant);

        final GitLabJiraConnectSubscriptionEntity built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabJiraConnectSubscriptionEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("createdAt", "unlinkPath", "group");
    }
}
