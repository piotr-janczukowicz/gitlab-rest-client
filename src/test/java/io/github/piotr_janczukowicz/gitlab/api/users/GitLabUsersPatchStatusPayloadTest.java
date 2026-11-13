package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersPatchStatusPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEmojiIsNullable() {
        final GitLabUsersPatchStatusPayloadBuilder builder = GitLabUsersPatchStatusPayloadBuilder.builder(
                        UsersCatalogFixtures.usersPatchStatusPayload())
                .emoji(null);

        final GitLabUsersPatchStatusPayload built = builder.build();

        assertThat(built.emoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabUsersPatchStatusPayloadBuilder builder = GitLabUsersPatchStatusPayloadBuilder.builder(
                        UsersCatalogFixtures.usersPatchStatusPayload())
                .message(null);

        final GitLabUsersPatchStatusPayload built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvailabilityIsNullable() {
        final GitLabUsersPatchStatusPayloadBuilder builder = GitLabUsersPatchStatusPayloadBuilder.builder(
                        UsersCatalogFixtures.usersPatchStatusPayload())
                .availability(null);

        final GitLabUsersPatchStatusPayload built = builder.build();

        assertThat(built.availability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClearStatusAfterIsNullable() {
        final GitLabUsersPatchStatusPayloadBuilder builder = GitLabUsersPatchStatusPayloadBuilder.builder(
                        UsersCatalogFixtures.usersPatchStatusPayload())
                .clearStatusAfter(null);

        final GitLabUsersPatchStatusPayload built = builder.build();

        assertThat(built.clearStatusAfter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersPatchStatusPayload value = UsersCatalogFixtures.usersPatchStatusPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.emoji()).isEqualTo("emoji");
            softly.assertThat(value.message()).isEqualTo("message");
            softly.assertThat(value.availability()).isEqualTo("availability");
            softly.assertThat(value.clearStatusAfter()).isEqualTo(GitLabUsersPatchStatusClearStatusAfter.N_30_MINUTES);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersPatchStatusPayload original = UsersCatalogFixtures.usersPatchStatusPayload();

        final GitLabUsersPatchStatusPayload rebuilt =
                GitLabUsersPatchStatusPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersPatchStatusPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("emoji", "message", "availability", "clearStatusAfter");
    }
}
