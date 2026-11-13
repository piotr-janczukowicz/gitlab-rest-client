package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSystemBroadcastMessageTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .id(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .message(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartsAtIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .startsAt(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.startsAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndsAtIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .endsAt(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.endsAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .color(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFontIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .font(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.font()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetAccessLevelsIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .targetAccessLevels(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.targetAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetPathIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .targetPath(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.targetPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBroadcastTypeIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .broadcastType(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.broadcastType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThemeIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .theme(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.theme()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDismissableIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .dismissable(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.dismissable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabSystemBroadcastMessageBuilder builder = GitLabSystemBroadcastMessageBuilder.builder(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage())
                .active(null);

        final GitLabSystemBroadcastMessage built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSystemBroadcastMessage value = BroadcastmessagesCatalogFixtures.systemBroadcastMessage();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.message()).isEqualTo("Example broadcast message");
            softly.assertThat(value.startsAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.endsAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.color()).isEqualTo("#E75E40");
            softly.assertThat(value.font()).isEqualTo("#FFFFFF");
            softly.assertThat(value.targetAccessLevels()).isEqualTo(List.of(1));
            softly.assertThat(value.targetPath()).isEqualTo("*/welcome");
            softly.assertThat(value.broadcastType()).isEqualTo("banner");
            softly.assertThat(value.theme()).isEqualTo("indigo");
            softly.assertThat(value.dismissable()).isEqualTo(true);
            softly.assertThat(value.active()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSystemBroadcastMessage original = BroadcastmessagesCatalogFixtures.systemBroadcastMessage();

        final GitLabSystemBroadcastMessage rebuilt =
                GitLabSystemBroadcastMessageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSystemBroadcastMessage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "message",
                        "startsAt",
                        "endsAt",
                        "color",
                        "font",
                        "targetAccessLevels",
                        "targetPath",
                        "broadcastType",
                        "theme",
                        "dismissable",
                        "active");
    }
}
