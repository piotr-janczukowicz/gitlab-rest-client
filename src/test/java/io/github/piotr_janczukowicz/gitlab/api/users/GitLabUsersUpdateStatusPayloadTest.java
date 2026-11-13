package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersUpdateStatusPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEmojiIsNullable() {
        final GitLabUsersUpdateStatusPayloadBuilder builder = GitLabUsersUpdateStatusPayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdateStatusPayload())
                .emoji(null);

        final GitLabUsersUpdateStatusPayload built = builder.build();

        assertThat(built.emoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabUsersUpdateStatusPayloadBuilder builder = GitLabUsersUpdateStatusPayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdateStatusPayload())
                .message(null);

        final GitLabUsersUpdateStatusPayload built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvailabilityIsNullable() {
        final GitLabUsersUpdateStatusPayloadBuilder builder = GitLabUsersUpdateStatusPayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdateStatusPayload())
                .availability(null);

        final GitLabUsersUpdateStatusPayload built = builder.build();

        assertThat(built.availability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClearStatusAfterIsNullable() {
        final GitLabUsersUpdateStatusPayloadBuilder builder = GitLabUsersUpdateStatusPayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdateStatusPayload())
                .clearStatusAfter(null);

        final GitLabUsersUpdateStatusPayload built = builder.build();

        assertThat(built.clearStatusAfter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersUpdateStatusPayload value = UsersCatalogFixtures.usersUpdateStatusPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.emoji()).isEqualTo("emoji");
            softly.assertThat(value.message()).isEqualTo("message");
            softly.assertThat(value.availability()).isEqualTo("availability");
            softly.assertThat(value.clearStatusAfter()).isEqualTo(GitLabUsersUpdateStatusClearStatusAfter.N_30_MINUTES);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersUpdateStatusPayload original = UsersCatalogFixtures.usersUpdateStatusPayload();

        final GitLabUsersUpdateStatusPayload rebuilt =
                GitLabUsersUpdateStatusPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersUpdateStatusPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("emoji", "message", "availability", "clearStatusAfter");
    }
}
