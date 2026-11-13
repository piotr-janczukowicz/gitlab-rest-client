package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespacesUpdateGitlabSubscriptionAttributesTest {

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder builder =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(
                                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                        .startDate(null);

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeatsIsNullable() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder builder =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(
                                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                        .seats(null);

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes built = builder.build();

        assertThat(built.seats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxSeatsUsedIsNullable() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder builder =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(
                                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                        .maxSeatsUsed(null);

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes built = builder.build();

        assertThat(built.maxSeatsUsed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlanCodeIsNullable() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder builder =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(
                                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                        .planCode(null);

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes built = builder.build();

        assertThat(built.planCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndDateIsNullable() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder builder =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(
                                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                        .endDate(null);

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes built = builder.build();

        assertThat(built.endDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoRenewIsNullable() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder builder =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(
                                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                        .autoRenew(null);

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes built = builder.build();

        assertThat(built.autoRenew()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrialIsNullable() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder builder =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(
                                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                        .trial(null);

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes built = builder.build();

        assertThat(built.trial()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrialEndsOnIsNullable() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder builder =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(
                                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                        .trialEndsOn(null);

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes built = builder.build();

        assertThat(built.trialEndsOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrialStartsOnIsNullable() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder builder =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(
                                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                        .trialStartsOn(null);

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes built = builder.build();

        assertThat(built.trialStartsOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrialExtensionTypeIsNullable() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder builder =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(
                                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                        .trialExtensionType(null);

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes built = builder.build();

        assertThat(built.trialExtensionType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributes value =
                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes();

        assertSoftly(softly -> {
            softly.assertThat(value.startDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.seats()).isEqualTo(1);
            softly.assertThat(value.maxSeatsUsed()).isEqualTo(1);
            softly.assertThat(value.planCode()).isEqualTo("plan_code");
            softly.assertThat(value.endDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.autoRenew()).isEqualTo(true);
            softly.assertThat(value.trial()).isEqualTo(true);
            softly.assertThat(value.trialEndsOn()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.trialStartsOn()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.trialExtensionType()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNamespacesUpdateGitlabSubscriptionAttributes original =
                NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes();

        final GitLabNamespacesUpdateGitlabSubscriptionAttributes rebuilt =
                GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabNamespacesUpdateGitlabSubscriptionAttributes.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "startDate",
                        "seats",
                        "maxSeatsUsed",
                        "planCode",
                        "endDate",
                        "autoRenew",
                        "trial",
                        "trialEndsOn",
                        "trialStartsOn",
                        "trialExtensionType");
    }
}
