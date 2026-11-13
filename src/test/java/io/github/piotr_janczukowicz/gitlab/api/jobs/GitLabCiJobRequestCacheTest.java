package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestCacheTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabCiJobRequestCacheBuilder builder = GitLabCiJobRequestCacheBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestCache())
                .key(null);

        final GitLabCiJobRequestCache built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUntrackedIsNullable() {
        final GitLabCiJobRequestCacheBuilder builder = GitLabCiJobRequestCacheBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestCache())
                .untracked(null);

        final GitLabCiJobRequestCache built = builder.build();

        assertThat(built.untracked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathsIsNullable() {
        final GitLabCiJobRequestCacheBuilder builder = GitLabCiJobRequestCacheBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestCache())
                .paths(null);

        final GitLabCiJobRequestCache built = builder.build();

        assertThat(built.paths()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPolicyIsNullable() {
        final GitLabCiJobRequestCacheBuilder builder = GitLabCiJobRequestCacheBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestCache())
                .policy(null);

        final GitLabCiJobRequestCache built = builder.build();

        assertThat(built.policy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWhenIsNullable() {
        final GitLabCiJobRequestCacheBuilder builder = GitLabCiJobRequestCacheBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestCache())
                .when(null);

        final GitLabCiJobRequestCache built = builder.build();

        assertThat(built.when()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFallbackKeysIsNullable() {
        final GitLabCiJobRequestCacheBuilder builder = GitLabCiJobRequestCacheBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestCache())
                .fallbackKeys(null);

        final GitLabCiJobRequestCache built = builder.build();

        assertThat(built.fallbackKeys()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestCache value = JobsCatalogFixtures.ciJobRequestCache();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.untracked()).isEqualTo(true);
            softly.assertThat(value.paths()).isEqualTo(List.of("paths"));
            softly.assertThat(value.policy()).isEqualTo("policy");
            softly.assertThat(value.when()).isEqualTo("when");
            softly.assertThat(value.fallbackKeys()).isEqualTo(List.of("fallback_keys"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestCache original = JobsCatalogFixtures.ciJobRequestCache();

        final GitLabCiJobRequestCache rebuilt =
                GitLabCiJobRequestCacheBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestCache.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "untracked", "paths", "policy", "when", "fallbackKeys");
    }
}
