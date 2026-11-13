package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAwardEmojiTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAwardEmojiBuilder builder = GitLabAwardEmojiBuilder.builder(CommonCatalogFixtures.awardEmoji())
                .id(null);

        final GitLabAwardEmoji built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabAwardEmojiBuilder builder = GitLabAwardEmojiBuilder.builder(CommonCatalogFixtures.awardEmoji())
                .name(null);

        final GitLabAwardEmoji built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabAwardEmojiBuilder builder = GitLabAwardEmojiBuilder.builder(CommonCatalogFixtures.awardEmoji())
                .user(null);

        final GitLabAwardEmoji built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAwardEmojiBuilder builder = GitLabAwardEmojiBuilder.builder(CommonCatalogFixtures.awardEmoji())
                .createdAt(null);

        final GitLabAwardEmoji built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabAwardEmojiBuilder builder = GitLabAwardEmojiBuilder.builder(CommonCatalogFixtures.awardEmoji())
                .updatedAt(null);

        final GitLabAwardEmoji built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAwardableIdIsNullable() {
        final GitLabAwardEmojiBuilder builder = GitLabAwardEmojiBuilder.builder(CommonCatalogFixtures.awardEmoji())
                .awardableId(null);

        final GitLabAwardEmoji built = builder.build();

        assertThat(built.awardableId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAwardableTypeIsNullable() {
        final GitLabAwardEmojiBuilder builder = GitLabAwardEmojiBuilder.builder(CommonCatalogFixtures.awardEmoji())
                .awardableType(null);

        final GitLabAwardEmoji built = builder.build();

        assertThat(built.awardableType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabAwardEmojiBuilder builder = GitLabAwardEmojiBuilder.builder(CommonCatalogFixtures.awardEmoji())
                .url(null);

        final GitLabAwardEmoji built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAwardEmoji value = CommonCatalogFixtures.awardEmoji();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("lizard");
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.awardableId()).isEqualTo(1L);
            softly.assertThat(value.awardableType()).isEqualTo("Issue");
            softly.assertThat(value.url()).isEqualTo("https://example.com/emojis/example.gif");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAwardEmoji original = CommonCatalogFixtures.awardEmoji();

        final GitLabAwardEmoji rebuilt =
                GitLabAwardEmojiBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAwardEmoji.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "name", "user", "createdAt", "updatedAt", "awardableId", "awardableType", "url");
    }
}
