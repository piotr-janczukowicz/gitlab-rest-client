package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiMinutesUsageTest {

    @Test
    void constructor_shouldAcceptNull_whenTotalMinutesUsedIsNullable() {
        final GitLabCiMinutesUsageBuilder builder = GitLabCiMinutesUsageBuilder.builder(
                        NamespacesCatalogFixtures.ciMinutesUsage())
                .totalMinutesUsed(null);

        final GitLabCiMinutesUsage built = builder.build();

        assertThat(built.totalMinutesUsed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMonthlyMinutesUsedIsNullable() {
        final GitLabCiMinutesUsageBuilder builder = GitLabCiMinutesUsageBuilder.builder(
                        NamespacesCatalogFixtures.ciMinutesUsage())
                .monthlyMinutesUsed(null);

        final GitLabCiMinutesUsage built = builder.build();

        assertThat(built.monthlyMinutesUsed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPurchasedMinutesUsedIsNullable() {
        final GitLabCiMinutesUsageBuilder builder = GitLabCiMinutesUsageBuilder.builder(
                        NamespacesCatalogFixtures.ciMinutesUsage())
                .purchasedMinutesUsed(null);

        final GitLabCiMinutesUsage built = builder.build();

        assertThat(built.purchasedMinutesUsed()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiMinutesUsage value = NamespacesCatalogFixtures.ciMinutesUsage();

        assertSoftly(softly -> {
            softly.assertThat(value.totalMinutesUsed()).isEqualTo(1);
            softly.assertThat(value.monthlyMinutesUsed()).isEqualTo(1);
            softly.assertThat(value.purchasedMinutesUsed()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiMinutesUsage original = NamespacesCatalogFixtures.ciMinutesUsage();

        final GitLabCiMinutesUsage rebuilt =
                GitLabCiMinutesUsageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiMinutesUsage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("totalMinutesUsed", "monthlyMinutesUsed", "purchasedMinutesUsed");
    }
}
