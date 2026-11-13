package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGitlabSubscriptionUsageTest {

    @Test
    void constructor_shouldAcceptNull_whenSeatsInSubscriptionIsNullable() {
        final GitLabGitlabSubscriptionUsageBuilder builder = GitLabGitlabSubscriptionUsageBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionUsage())
                .seatsInSubscription(null);

        final GitLabGitlabSubscriptionUsage built = builder.build();

        assertThat(built.seatsInSubscription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeatsInUseIsNullable() {
        final GitLabGitlabSubscriptionUsageBuilder builder = GitLabGitlabSubscriptionUsageBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionUsage())
                .seatsInUse(null);

        final GitLabGitlabSubscriptionUsage built = builder.build();

        assertThat(built.seatsInUse()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxSeatsUsedIsNullable() {
        final GitLabGitlabSubscriptionUsageBuilder builder = GitLabGitlabSubscriptionUsageBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionUsage())
                .maxSeatsUsed(null);

        final GitLabGitlabSubscriptionUsage built = builder.build();

        assertThat(built.maxSeatsUsed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeatsOwedIsNullable() {
        final GitLabGitlabSubscriptionUsageBuilder builder = GitLabGitlabSubscriptionUsageBuilder.builder(
                        NamespacesCatalogFixtures.gitlabSubscriptionUsage())
                .seatsOwed(null);

        final GitLabGitlabSubscriptionUsage built = builder.build();

        assertThat(built.seatsOwed()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGitlabSubscriptionUsage value = NamespacesCatalogFixtures.gitlabSubscriptionUsage();

        assertSoftly(softly -> {
            softly.assertThat(value.seatsInSubscription()).isEqualTo(1);
            softly.assertThat(value.seatsInUse()).isEqualTo(1);
            softly.assertThat(value.maxSeatsUsed()).isEqualTo(1);
            softly.assertThat(value.seatsOwed()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGitlabSubscriptionUsage original = NamespacesCatalogFixtures.gitlabSubscriptionUsage();

        final GitLabGitlabSubscriptionUsage rebuilt =
                GitLabGitlabSubscriptionUsageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGitlabSubscriptionUsage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("seatsInSubscription", "seatsInUse", "maxSeatsUsed", "seatsOwed");
    }
}
