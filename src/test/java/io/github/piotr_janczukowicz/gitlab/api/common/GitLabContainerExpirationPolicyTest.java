package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabContainerExpirationPolicyTest {

    @Test
    void constructor_shouldAcceptNull_whenCadenceIsNullable() {
        final GitLabContainerExpirationPolicyBuilder builder = GitLabContainerExpirationPolicyBuilder.builder(
                        CommonCatalogFixtures.containerExpirationPolicy())
                .cadence(null);

        final GitLabContainerExpirationPolicy built = builder.build();

        assertThat(built.cadence()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabContainerExpirationPolicyBuilder builder = GitLabContainerExpirationPolicyBuilder.builder(
                        CommonCatalogFixtures.containerExpirationPolicy())
                .enabled(null);

        final GitLabContainerExpirationPolicy built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepNIsNullable() {
        final GitLabContainerExpirationPolicyBuilder builder = GitLabContainerExpirationPolicyBuilder.builder(
                        CommonCatalogFixtures.containerExpirationPolicy())
                .keepN(null);

        final GitLabContainerExpirationPolicy built = builder.build();

        assertThat(built.keepN()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOlderThanIsNullable() {
        final GitLabContainerExpirationPolicyBuilder builder = GitLabContainerExpirationPolicyBuilder.builder(
                        CommonCatalogFixtures.containerExpirationPolicy())
                .olderThan(null);

        final GitLabContainerExpirationPolicy built = builder.build();

        assertThat(built.olderThan()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameRegexIsNullable() {
        final GitLabContainerExpirationPolicyBuilder builder = GitLabContainerExpirationPolicyBuilder.builder(
                        CommonCatalogFixtures.containerExpirationPolicy())
                .nameRegex(null);

        final GitLabContainerExpirationPolicy built = builder.build();

        assertThat(built.nameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameRegexKeepIsNullable() {
        final GitLabContainerExpirationPolicyBuilder builder = GitLabContainerExpirationPolicyBuilder.builder(
                        CommonCatalogFixtures.containerExpirationPolicy())
                .nameRegexKeep(null);

        final GitLabContainerExpirationPolicy built = builder.build();

        assertThat(built.nameRegexKeep()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNextRunAtIsNullable() {
        final GitLabContainerExpirationPolicyBuilder builder = GitLabContainerExpirationPolicyBuilder.builder(
                        CommonCatalogFixtures.containerExpirationPolicy())
                .nextRunAt(null);

        final GitLabContainerExpirationPolicy built = builder.build();

        assertThat(built.nextRunAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabContainerExpirationPolicy value = CommonCatalogFixtures.containerExpirationPolicy();

        assertSoftly(softly -> {
            softly.assertThat(value.cadence()).isEqualTo("7d");
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.keepN()).isEqualTo(1);
            softly.assertThat(value.olderThan()).isEqualTo("90d");
            softly.assertThat(value.nameRegex()).isEqualTo(".*");
            softly.assertThat(value.nameRegexKeep()).isEqualTo("name_regex_keep");
            softly.assertThat(value.nextRunAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabContainerExpirationPolicy original = CommonCatalogFixtures.containerExpirationPolicy();

        final GitLabContainerExpirationPolicy rebuilt =
                GitLabContainerExpirationPolicyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabContainerExpirationPolicy.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("cadence", "enabled", "keepN", "olderThan", "nameRegex", "nameRegexKeep", "nextRunAt");
    }
}
