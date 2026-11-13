package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserStatusTest {

    @Test
    void constructor_shouldAcceptNull_whenEmojiIsNullable() {
        final GitLabUserStatusBuilder builder = GitLabUserStatusBuilder.builder(UsersCatalogFixtures.userStatus())
                .emoji(null);

        final GitLabUserStatus built = builder.build();

        assertThat(built.emoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabUserStatusBuilder builder = GitLabUserStatusBuilder.builder(UsersCatalogFixtures.userStatus())
                .message(null);

        final GitLabUserStatus built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvailabilityIsNullable() {
        final GitLabUserStatusBuilder builder = GitLabUserStatusBuilder.builder(UsersCatalogFixtures.userStatus())
                .availability(null);

        final GitLabUserStatus built = builder.build();

        assertThat(built.availability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageHtmlIsNullable() {
        final GitLabUserStatusBuilder builder = GitLabUserStatusBuilder.builder(UsersCatalogFixtures.userStatus())
                .messageHtml(null);

        final GitLabUserStatus built = builder.build();

        assertThat(built.messageHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClearStatusAtIsNullable() {
        final GitLabUserStatusBuilder builder = GitLabUserStatusBuilder.builder(UsersCatalogFixtures.userStatus())
                .clearStatusAt(null);

        final GitLabUserStatus built = builder.build();

        assertThat(built.clearStatusAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserStatus value = UsersCatalogFixtures.userStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.emoji()).isEqualTo("coffee");
            softly.assertThat(value.message()).isEqualTo("I crave coffee");
            softly.assertThat(value.availability()).isEqualTo("busy");
            softly.assertThat(value.messageHtml()).isEqualTo("<p dir=\"auto\">I crave coffee</p>");
            softly.assertThat(value.clearStatusAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserStatus original = UsersCatalogFixtures.userStatus();

        final GitLabUserStatus rebuilt =
                GitLabUserStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserStatus.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("emoji", "message", "availability", "messageHtml", "clearStatusAt");
    }
}
