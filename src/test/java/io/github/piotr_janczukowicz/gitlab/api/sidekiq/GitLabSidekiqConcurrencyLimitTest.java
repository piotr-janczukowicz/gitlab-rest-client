package io.github.piotr_janczukowicz.gitlab.api.sidekiq;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSidekiqConcurrencyLimitTest {

    @Test
    void constructor_shouldAcceptNull_whenWorkerClassIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .workerClass(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.workerClass()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClassLimitIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .classLimit(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.classLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEffectiveLimitIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .effectiveLimit(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.effectiveLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdaptiveLimitIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .adaptiveLimit(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.adaptiveLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultLimitRequiresShardContextIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .defaultLimitRequiresShardContext(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.defaultLimitRequiresShardContext()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMiddlewareEnabledIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .middlewareEnabled(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.middlewareEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisabledForWorkerIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .disabledForWorker(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.disabledForWorker()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOverrideLimitIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .overrideLimit(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.overrideLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOverrideTtlIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .overrideTtl(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.overrideTtl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunningJobsIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .runningJobs(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.runningJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeferredJobsIsNullable() {
        final GitLabSidekiqConcurrencyLimitBuilder builder = GitLabSidekiqConcurrencyLimitBuilder.builder(
                        SidekiqCatalogFixtures.sidekiqConcurrencyLimit())
                .deferredJobs(null);

        final GitLabSidekiqConcurrencyLimit built = builder.build();

        assertThat(built.deferredJobs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSidekiqConcurrencyLimit value = SidekiqCatalogFixtures.sidekiqConcurrencyLimit();

        assertSoftly(softly -> {
            softly.assertThat(value.workerClass()).isEqualTo("AuthorizedProjectsWorker");
            softly.assertThat(value.classLimit()).isEqualTo(1);
            softly.assertThat(value.effectiveLimit()).isEqualTo(1);
            softly.assertThat(value.adaptiveLimit()).isEqualTo(1);
            softly.assertThat(value.defaultLimitRequiresShardContext()).isEqualTo(true);
            softly.assertThat(value.middlewareEnabled()).isEqualTo(true);
            softly.assertThat(value.disabledForWorker()).isEqualTo(true);
            softly.assertThat(value.overrideLimit()).isEqualTo(1);
            softly.assertThat(value.overrideTtl()).isEqualTo(1);
            softly.assertThat(value.runningJobs()).isEqualTo(1);
            softly.assertThat(value.deferredJobs()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSidekiqConcurrencyLimit original = SidekiqCatalogFixtures.sidekiqConcurrencyLimit();

        final GitLabSidekiqConcurrencyLimit rebuilt =
                GitLabSidekiqConcurrencyLimitBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSidekiqConcurrencyLimit.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "workerClass",
                        "classLimit",
                        "effectiveLimit",
                        "adaptiveLimit",
                        "defaultLimitRequiresShardContext",
                        "middlewareEnabled",
                        "disabledForWorker",
                        "overrideLimit",
                        "overrideTtl",
                        "runningJobs",
                        "deferredJobs");
    }
}
