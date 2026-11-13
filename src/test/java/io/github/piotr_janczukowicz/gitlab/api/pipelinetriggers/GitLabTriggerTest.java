package io.github.piotr_janczukowicz.gitlab.api.pipelinetriggers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTriggerTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabTriggerBuilder builder = GitLabTriggerBuilder.builder(PipelinetriggersCatalogFixtures.trigger())
                .id(null);

        final GitLabTrigger built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabTriggerBuilder builder = GitLabTriggerBuilder.builder(PipelinetriggersCatalogFixtures.trigger())
                .token(null);

        final GitLabTrigger built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabTriggerBuilder builder = GitLabTriggerBuilder.builder(PipelinetriggersCatalogFixtures.trigger())
                .description(null);

        final GitLabTrigger built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabTriggerBuilder builder = GitLabTriggerBuilder.builder(PipelinetriggersCatalogFixtures.trigger())
                .createdAt(null);

        final GitLabTrigger built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabTriggerBuilder builder = GitLabTriggerBuilder.builder(PipelinetriggersCatalogFixtures.trigger())
                .updatedAt(null);

        final GitLabTrigger built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedIsNullable() {
        final GitLabTriggerBuilder builder = GitLabTriggerBuilder.builder(PipelinetriggersCatalogFixtures.trigger())
                .lastUsed(null);

        final GitLabTrigger built = builder.build();

        assertThat(built.lastUsed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabTriggerBuilder builder = GitLabTriggerBuilder.builder(PipelinetriggersCatalogFixtures.trigger())
                .expiresAt(null);

        final GitLabTrigger built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnerIsNullable() {
        final GitLabTriggerBuilder builder = GitLabTriggerBuilder.builder(PipelinetriggersCatalogFixtures.trigger())
                .owner(null);

        final GitLabTrigger built = builder.build();

        assertThat(built.owner()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTrigger value = PipelinetriggersCatalogFixtures.trigger();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.token()).isEqualTo("6d056f63e50fe6f8c5f8f4aa10edb7");
            softly.assertThat(value.description()).isEqualTo("test");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastUsed()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.owner()).isEqualTo(CommonCatalogFixtures.userBasic());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTrigger original = PipelinetriggersCatalogFixtures.trigger();

        final GitLabTrigger rebuilt = GitLabTriggerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabTrigger value = PipelinetriggersCatalogFixtures.trigger();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTrigger.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id", "token", "description", "createdAt", "updatedAt", "lastUsed", "expiresAt", "owner");
    }
}
