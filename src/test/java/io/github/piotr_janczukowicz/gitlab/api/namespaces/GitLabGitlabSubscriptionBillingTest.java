package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGitlabSubscriptionBillingTest {

    @Test
    void constructor_shouldAcceptNull_whenSubscriptionStartDateIsNullable() {
        final GitLabGitlabSubscriptionBillingBuilder builder = GitLabGitlabSubscriptionBillingBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionBilling())
                .subscriptionStartDate(null);

        final GitLabGitlabSubscriptionBilling built = builder.build();

        assertThat(built.subscriptionStartDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscriptionEndDateIsNullable() {
        final GitLabGitlabSubscriptionBillingBuilder builder = GitLabGitlabSubscriptionBillingBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionBilling())
                .subscriptionEndDate(null);

        final GitLabGitlabSubscriptionBilling built = builder.build();

        assertThat(built.subscriptionEndDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrialEndsOnIsNullable() {
        final GitLabGitlabSubscriptionBillingBuilder builder = GitLabGitlabSubscriptionBillingBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionBilling())
                .trialEndsOn(null);

        final GitLabGitlabSubscriptionBilling built = builder.build();

        assertThat(built.trialEndsOn()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGitlabSubscriptionBilling value = NamespacesCatalogFixtures.gitlabSubscriptionBilling();

        assertSoftly(softly -> {
            softly.assertThat(value.subscriptionStartDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.subscriptionEndDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.trialEndsOn()).isEqualTo(LocalDate.parse("2026-01-01"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGitlabSubscriptionBilling original = NamespacesCatalogFixtures.gitlabSubscriptionBilling();

        final GitLabGitlabSubscriptionBilling rebuilt =
                GitLabGitlabSubscriptionBillingBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGitlabSubscriptionBilling.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("subscriptionStartDate", "subscriptionEndDate", "trialEndsOn");
    }
}
