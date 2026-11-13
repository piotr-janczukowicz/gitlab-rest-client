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
class GitLabBroadcastMessagesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabBroadcastMessagesUpdatePayloadBuilder builder = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .message(null);

        final GitLabBroadcastMessagesUpdatePayload built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartsAtIsNullable() {
        final GitLabBroadcastMessagesUpdatePayloadBuilder builder = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .startsAt(null);

        final GitLabBroadcastMessagesUpdatePayload built = builder.build();

        assertThat(built.startsAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndsAtIsNullable() {
        final GitLabBroadcastMessagesUpdatePayloadBuilder builder = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .endsAt(null);

        final GitLabBroadcastMessagesUpdatePayload built = builder.build();

        assertThat(built.endsAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabBroadcastMessagesUpdatePayloadBuilder builder = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .color(null);

        final GitLabBroadcastMessagesUpdatePayload built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFontIsNullable() {
        final GitLabBroadcastMessagesUpdatePayloadBuilder builder = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .font(null);

        final GitLabBroadcastMessagesUpdatePayload built = builder.build();

        assertThat(built.font()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetAccessLevelsIsNullable() {
        final GitLabBroadcastMessagesUpdatePayloadBuilder builder = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .targetAccessLevels(null);

        final GitLabBroadcastMessagesUpdatePayload built = builder.build();

        assertThat(built.targetAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetPathIsNullable() {
        final GitLabBroadcastMessagesUpdatePayloadBuilder builder = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .targetPath(null);

        final GitLabBroadcastMessagesUpdatePayload built = builder.build();

        assertThat(built.targetPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBroadcastTypeIsNullable() {
        final GitLabBroadcastMessagesUpdatePayloadBuilder builder = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .broadcastType(null);

        final GitLabBroadcastMessagesUpdatePayload built = builder.build();

        assertThat(built.broadcastType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDismissableIsNullable() {
        final GitLabBroadcastMessagesUpdatePayloadBuilder builder = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .dismissable(null);

        final GitLabBroadcastMessagesUpdatePayload built = builder.build();

        assertThat(built.dismissable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThemeIsNullable() {
        final GitLabBroadcastMessagesUpdatePayloadBuilder builder = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .theme(null);

        final GitLabBroadcastMessagesUpdatePayload built = builder.build();

        assertThat(built.theme()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBroadcastMessagesUpdatePayload value =
                BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.message()).isEqualTo("message");
            softly.assertThat(value.startsAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.endsAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.color()).isEqualTo("color");
            softly.assertThat(value.font()).isEqualTo("font");
            softly.assertThat(value.targetAccessLevels()).isEqualTo(List.of(10));
            softly.assertThat(value.targetPath()).isEqualTo("target_path");
            softly.assertThat(value.broadcastType()).isEqualTo(GitLabBroadcastMessagesUpdateBroadcastType.BANNER);
            softly.assertThat(value.dismissable()).isEqualTo(true);
            softly.assertThat(value.theme()).isEqualTo(GitLabBroadcastMessagesUpdateTheme.INDIGO);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBroadcastMessagesUpdatePayload original =
                BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload();

        final GitLabBroadcastMessagesUpdatePayload rebuilt =
                GitLabBroadcastMessagesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTargetAccessLevelsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(10));
        final GitLabBroadcastMessagesUpdatePayload built = GitLabBroadcastMessagesUpdatePayloadBuilder.builder(
                        BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload())
                .targetAccessLevels(source)
                .build();
        source.clear();

        assertThat(built.targetAccessLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTargetAccessLevelsIsRead() {
        final GitLabBroadcastMessagesUpdatePayload built =
                BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload();
        final List<Integer> values = built.targetAccessLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBroadcastMessagesUpdatePayload.class.getRecordComponents())
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
