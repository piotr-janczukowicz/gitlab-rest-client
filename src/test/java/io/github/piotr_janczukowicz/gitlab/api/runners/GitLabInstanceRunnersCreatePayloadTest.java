package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceRunnersCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .token(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .description(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaintainerNoteIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .maintainerNote(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.maintainerNote()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaintenanceNoteIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .maintenanceNote(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.maintenanceNote()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInfoIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .info(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.info()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .active(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPausedIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .paused(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.paused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .locked(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .accessLevel(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunUntaggedIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .runUntagged(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.runUntagged()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .tagList(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaximumTimeoutIsNullable() {
        final GitLabInstanceRunnersCreatePayloadBuilder builder = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .maximumTimeout(null);

        final GitLabInstanceRunnersCreatePayload built = builder.build();

        assertThat(built.maximumTimeout()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceRunnersCreatePayload value = RunnersCatalogFixtures.instanceRunnersCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.maintainerNote()).isEqualTo("maintainer_note");
            softly.assertThat(value.maintenanceNote()).isEqualTo("maintenance_note");
            softly.assertThat(value.info()).isEqualTo(RunnersCatalogFixtures.instanceRunnersCreateInfo());
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.paused()).isEqualTo(true);
            softly.assertThat(value.locked()).isEqualTo(true);
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabInstanceRunnersCreateAccessLevel.NOT_PROTECTED);
            softly.assertThat(value.runUntagged()).isEqualTo(true);
            softly.assertThat(value.tagList()).isEqualTo(List.of("tag_list"));
            softly.assertThat(value.maximumTimeout()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceRunnersCreatePayload original = RunnersCatalogFixtures.instanceRunnersCreatePayload();

        final GitLabInstanceRunnersCreatePayload rebuilt =
                GitLabInstanceRunnersCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagListSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("tag_list"));
        final GitLabInstanceRunnersCreatePayload built = GitLabInstanceRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreatePayload())
                .tagList(source)
                .build();
        source.clear();

        assertThat(built.tagList()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTagListIsRead() {
        final GitLabInstanceRunnersCreatePayload built = RunnersCatalogFixtures.instanceRunnersCreatePayload();
        final List<String> values = built.tagList();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceRunnersCreatePayload value = RunnersCatalogFixtures.instanceRunnersCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceRunnersCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "token",
                        "description",
                        "maintainerNote",
                        "maintenanceNote",
                        "info",
                        "active",
                        "paused",
                        "locked",
                        "accessLevel",
                        "runUntagged",
                        "tagList",
                        "maximumTimeout");
    }
}
