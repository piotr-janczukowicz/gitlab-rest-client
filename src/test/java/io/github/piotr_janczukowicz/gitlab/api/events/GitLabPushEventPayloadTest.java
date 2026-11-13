package io.github.piotr_janczukowicz.gitlab.api.events;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPushEventPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCommitCountIsNullable() {
        final GitLabPushEventPayloadBuilder builder = GitLabPushEventPayloadBuilder.builder(
                        EventsCatalogFixtures.pushEventPayload())
                .commitCount(null);

        final GitLabPushEventPayload built = builder.build();

        assertThat(built.commitCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActionIsNullable() {
        final GitLabPushEventPayloadBuilder builder = GitLabPushEventPayloadBuilder.builder(
                        EventsCatalogFixtures.pushEventPayload())
                .action(null);

        final GitLabPushEventPayload built = builder.build();

        assertThat(built.action()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefTypeIsNullable() {
        final GitLabPushEventPayloadBuilder builder = GitLabPushEventPayloadBuilder.builder(
                        EventsCatalogFixtures.pushEventPayload())
                .refType(null);

        final GitLabPushEventPayload built = builder.build();

        assertThat(built.refType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitFromIsNullable() {
        final GitLabPushEventPayloadBuilder builder = GitLabPushEventPayloadBuilder.builder(
                        EventsCatalogFixtures.pushEventPayload())
                .commitFrom(null);

        final GitLabPushEventPayload built = builder.build();

        assertThat(built.commitFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitToIsNullable() {
        final GitLabPushEventPayloadBuilder builder = GitLabPushEventPayloadBuilder.builder(
                        EventsCatalogFixtures.pushEventPayload())
                .commitTo(null);

        final GitLabPushEventPayload built = builder.build();

        assertThat(built.commitTo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabPushEventPayloadBuilder builder = GitLabPushEventPayloadBuilder.builder(
                        EventsCatalogFixtures.pushEventPayload())
                .ref(null);

        final GitLabPushEventPayload built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitTitleIsNullable() {
        final GitLabPushEventPayloadBuilder builder = GitLabPushEventPayloadBuilder.builder(
                        EventsCatalogFixtures.pushEventPayload())
                .commitTitle(null);

        final GitLabPushEventPayload built = builder.build();

        assertThat(built.commitTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefCountIsNullable() {
        final GitLabPushEventPayloadBuilder builder = GitLabPushEventPayloadBuilder.builder(
                        EventsCatalogFixtures.pushEventPayload())
                .refCount(null);

        final GitLabPushEventPayload built = builder.build();

        assertThat(built.refCount()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPushEventPayload value = EventsCatalogFixtures.pushEventPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.commitCount()).isEqualTo(1);
            softly.assertThat(value.action()).isEqualTo("pushed");
            softly.assertThat(value.refType()).isEqualTo("branch");
            softly.assertThat(value.commitFrom()).isEqualTo("50d4420237a9de7be1304607147aec22e4a14af7");
            softly.assertThat(value.commitTo()).isEqualTo("c5feabde2d8cd023215af4d2ceeb7a64839fc428");
            softly.assertThat(value.ref()).isEqualTo("master");
            softly.assertThat(value.commitTitle()).isEqualTo("Add simple search to projects in public area");
            softly.assertThat(value.refCount()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPushEventPayload original = EventsCatalogFixtures.pushEventPayload();

        final GitLabPushEventPayload rebuilt =
                GitLabPushEventPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPushEventPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "commitCount", "action", "refType", "commitFrom", "commitTo", "ref", "commitTitle", "refCount");
    }
}
