package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBroadcastMessagesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabBroadcastMessagesCreatePayloadBuilder builder = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .message(null);

        final GitLabBroadcastMessagesCreatePayload built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartsAtIsNullable() {
        final GitLabBroadcastMessagesCreatePayloadBuilder builder = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .startsAt(null);

        final GitLabBroadcastMessagesCreatePayload built = builder.build();

        assertThat(built.startsAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndsAtIsNullable() {
        final GitLabBroadcastMessagesCreatePayloadBuilder builder = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .endsAt(null);

        final GitLabBroadcastMessagesCreatePayload built = builder.build();

        assertThat(built.endsAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabBroadcastMessagesCreatePayloadBuilder builder = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .color(null);

        final GitLabBroadcastMessagesCreatePayload built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFontIsNullable() {
        final GitLabBroadcastMessagesCreatePayloadBuilder builder = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .font(null);

        final GitLabBroadcastMessagesCreatePayload built = builder.build();

        assertThat(built.font()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetAccessLevelsIsNullable() {
        final GitLabBroadcastMessagesCreatePayloadBuilder builder = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .targetAccessLevels(null);

        final GitLabBroadcastMessagesCreatePayload built = builder.build();

        assertThat(built.targetAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetPathIsNullable() {
        final GitLabBroadcastMessagesCreatePayloadBuilder builder = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .targetPath(null);

        final GitLabBroadcastMessagesCreatePayload built = builder.build();

        assertThat(built.targetPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBroadcastTypeIsNullable() {
        final GitLabBroadcastMessagesCreatePayloadBuilder builder = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .broadcastType(null);

        final GitLabBroadcastMessagesCreatePayload built = builder.build();

        assertThat(built.broadcastType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDismissableIsNullable() {
        final GitLabBroadcastMessagesCreatePayloadBuilder builder = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .dismissable(null);

        final GitLabBroadcastMessagesCreatePayload built = builder.build();

        assertThat(built.dismissable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThemeIsNullable() {
        final GitLabBroadcastMessagesCreatePayloadBuilder builder = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .theme(null);

        final GitLabBroadcastMessagesCreatePayload built = builder.build();

        assertThat(built.theme()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBroadcastMessagesCreatePayload value =
                BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.message()).isEqualTo("message");
            softly.assertThat(value.startsAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.endsAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.color()).isEqualTo("color");
            softly.assertThat(value.font()).isEqualTo("font");
            softly.assertThat(value.targetAccessLevels()).isEqualTo(List.of(10));
            softly.assertThat(value.targetPath()).isEqualTo("target_path");
            softly.assertThat(value.broadcastType()).isEqualTo(GitLabBroadcastMessagesCreateBroadcastType.BANNER);
            softly.assertThat(value.dismissable()).isEqualTo(true);
            softly.assertThat(value.theme()).isEqualTo(GitLabBroadcastMessagesCreateTheme.INDIGO);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBroadcastMessagesCreatePayload original =
                BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload();

        final GitLabBroadcastMessagesCreatePayload rebuilt =
                GitLabBroadcastMessagesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTargetAccessLevelsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(10));
        final GitLabBroadcastMessagesCreatePayload built = GitLabBroadcastMessagesCreatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload())
                .targetAccessLevels(source)
                .build();
        source.clear();

        assertThat(built.targetAccessLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTargetAccessLevelsIsRead() {
        final GitLabBroadcastMessagesCreatePayload built =
                BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload();
        final List<Integer> values = built.targetAccessLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBroadcastMessagesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "message",
                        "startsAt",
                        "endsAt",
                        "color",
                        "font",
                        "targetAccessLevels",
                        "targetPath",
                        "broadcastType",
                        "dismissable",
                        "theme");
    }
}
