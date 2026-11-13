package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGitlabSubscriptionTest {

    @Test
    void constructor_shouldAcceptNull_whenPlanIsNullable() {
        final GitLabGitlabSubscriptionBuilder builder = GitLabGitlabSubscriptionBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscription())
                .plan(null);

        final GitLabGitlabSubscription built = builder.build();

        assertThat(built.plan()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsageIsNullable() {
        final GitLabGitlabSubscriptionBuilder builder = GitLabGitlabSubscriptionBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscription())
                .usage(null);

        final GitLabGitlabSubscription built = builder.build();

        assertThat(built.usage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBillingIsNullable() {
        final GitLabGitlabSubscriptionBuilder builder = GitLabGitlabSubscriptionBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscription())
                .billing(null);

        final GitLabGitlabSubscription built = builder.build();

        assertThat(built.billing()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGitlabSubscription value = NamespacesCatalogFixtures.gitlabSubscription();

        assertSoftly(softly -> {
            softly.assertThat(value.plan()).isEqualTo(NamespacesCatalogFixtures.gitlabSubscriptionPlan());
            softly.assertThat(value.usage()).isEqualTo(NamespacesCatalogFixtures.gitlabSubscriptionUsage());
            softly.assertThat(value.billing()).isEqualTo(NamespacesCatalogFixtures.gitlabSubscriptionBilling());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGitlabSubscription original = NamespacesCatalogFixtures.gitlabSubscription();

        final GitLabGitlabSubscription rebuilt =
                GitLabGitlabSubscriptionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGitlabSubscription.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("plan", "usage", "billing");
    }
}
