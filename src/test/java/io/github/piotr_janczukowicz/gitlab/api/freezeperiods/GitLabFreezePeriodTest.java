package io.github.piotr_janczukowicz.gitlab.api.freezeperiods;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabFreezePeriodTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabFreezePeriodBuilder builder = GitLabFreezePeriodBuilder.builder(
                        FreezeperiodsCatalogFixtures.freezePeriod())
                .id(null);

        final GitLabFreezePeriod built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFreezeStartIsNullable() {
        final GitLabFreezePeriodBuilder builder = GitLabFreezePeriodBuilder.builder(
                        FreezeperiodsCatalogFixtures.freezePeriod())
                .freezeStart(null);

        final GitLabFreezePeriod built = builder.build();

        assertThat(built.freezeStart()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFreezeEndIsNullable() {
        final GitLabFreezePeriodBuilder builder = GitLabFreezePeriodBuilder.builder(
                        FreezeperiodsCatalogFixtures.freezePeriod())
                .freezeEnd(null);

        final GitLabFreezePeriod built = builder.build();

        assertThat(built.freezeEnd()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronTimezoneIsNullable() {
        final GitLabFreezePeriodBuilder builder = GitLabFreezePeriodBuilder.builder(
                        FreezeperiodsCatalogFixtures.freezePeriod())
                .cronTimezone(null);

        final GitLabFreezePeriod built = builder.build();

        assertThat(built.cronTimezone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabFreezePeriodBuilder builder = GitLabFreezePeriodBuilder.builder(
                        FreezeperiodsCatalogFixtures.freezePeriod())
                .createdAt(null);

        final GitLabFreezePeriod built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabFreezePeriodBuilder builder = GitLabFreezePeriodBuilder.builder(
                        FreezeperiodsCatalogFixtures.freezePeriod())
                .updatedAt(null);

        final GitLabFreezePeriod built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabFreezePeriod value = FreezeperiodsCatalogFixtures.freezePeriod();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.freezeStart()).isEqualTo("0 23 * * 5");
            softly.assertThat(value.freezeEnd()).isEqualTo("0 8 * * 1");
            softly.assertThat(value.cronTimezone()).isEqualTo("UTC");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabFreezePeriod original = FreezeperiodsCatalogFixtures.freezePeriod();

        final GitLabFreezePeriod rebuilt =
                GitLabFreezePeriodBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabFreezePeriod.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "freezeStart", "freezeEnd", "cronTimezone", "createdAt", "updatedAt");
    }
}
