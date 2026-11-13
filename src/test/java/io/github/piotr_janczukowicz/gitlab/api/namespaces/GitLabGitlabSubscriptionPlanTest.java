package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGitlabSubscriptionPlanTest {

    @Test
    void constructor_shouldAcceptNull_whenCodeIsNullable() {
        final GitLabGitlabSubscriptionPlanBuilder builder = GitLabGitlabSubscriptionPlanBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionPlan())
                .code(null);

        final GitLabGitlabSubscriptionPlan built = builder.build();

        assertThat(built.code()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGitlabSubscriptionPlanBuilder builder = GitLabGitlabSubscriptionPlanBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionPlan())
                .name(null);

        final GitLabGitlabSubscriptionPlan built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrialIsNullable() {
        final GitLabGitlabSubscriptionPlanBuilder builder = GitLabGitlabSubscriptionPlanBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionPlan())
                .trial(null);

        final GitLabGitlabSubscriptionPlan built = builder.build();

        assertThat(built.trial()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoRenewIsNullable() {
        final GitLabGitlabSubscriptionPlanBuilder builder = GitLabGitlabSubscriptionPlanBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionPlan())
                .autoRenew(null);

        final GitLabGitlabSubscriptionPlan built = builder.build();

        assertThat(built.autoRenew()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpgradableIsNullable() {
        final GitLabGitlabSubscriptionPlanBuilder builder = GitLabGitlabSubscriptionPlanBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionPlan())
                .upgradable(null);

        final GitLabGitlabSubscriptionPlan built = builder.build();

        assertThat(built.upgradable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExcludeGuestsIsNullable() {
        final GitLabGitlabSubscriptionPlanBuilder builder = GitLabGitlabSubscriptionPlanBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionPlan())
                .excludeGuests(null);

        final GitLabGitlabSubscriptionPlan built = builder.build();

        assertThat(built.excludeGuests()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGitlabSubscriptionPlan value = NamespacesCatalogFixtures.gitlabSubscriptionPlan();

        assertSoftly(softly -> {
            softly.assertThat(value.code()).isEqualTo("code");
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.trial()).isEqualTo(true);
            softly.assertThat(value.autoRenew()).isEqualTo(true);
            softly.assertThat(value.upgradable()).isEqualTo(true);
            softly.assertThat(value.excludeGuests()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGitlabSubscriptionPlan original = NamespacesCatalogFixtures.gitlabSubscriptionPlan();

        final GitLabGitlabSubscriptionPlan rebuilt =
                GitLabGitlabSubscriptionPlanBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGitlabSubscriptionPlan.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("code", "name", "trial", "autoRenew", "upgradable", "excludeGuests");
    }
}
