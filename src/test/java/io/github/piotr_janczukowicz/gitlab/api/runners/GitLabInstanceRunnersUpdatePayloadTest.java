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
class GitLabInstanceRunnersUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabInstanceRunnersUpdatePayloadBuilder builder = GitLabInstanceRunnersUpdatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersUpdatePayload())
                .description(null);

        final GitLabInstanceRunnersUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabInstanceRunnersUpdatePayloadBuilder builder = GitLabInstanceRunnersUpdatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersUpdatePayload())
                .active(null);

        final GitLabInstanceRunnersUpdatePayload built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPausedIsNullable() {
        final GitLabInstanceRunnersUpdatePayloadBuilder builder = GitLabInstanceRunnersUpdatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersUpdatePayload())
                .paused(null);

        final GitLabInstanceRunnersUpdatePayload built = builder.build();

        assertThat(built.paused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabInstanceRunnersUpdatePayloadBuilder builder = GitLabInstanceRunnersUpdatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersUpdatePayload())
                .tagList(null);

        final GitLabInstanceRunnersUpdatePayload built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunUntaggedIsNullable() {
        final GitLabInstanceRunnersUpdatePayloadBuilder builder = GitLabInstanceRunnersUpdatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersUpdatePayload())
                .runUntagged(null);

        final GitLabInstanceRunnersUpdatePayload built = builder.build();

        assertThat(built.runUntagged()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabInstanceRunnersUpdatePayloadBuilder builder = GitLabInstanceRunnersUpdatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersUpdatePayload())
                .locked(null);

        final GitLabInstanceRunnersUpdatePayload built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabInstanceRunnersUpdatePayloadBuilder builder = GitLabInstanceRunnersUpdatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersUpdatePayload())
                .accessLevel(null);

        final GitLabInstanceRunnersUpdatePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaximumTimeoutIsNullable() {
        final GitLabInstanceRunnersUpdatePayloadBuilder builder = GitLabInstanceRunnersUpdatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersUpdatePayload())
                .maximumTimeout(null);

        final GitLabInstanceRunnersUpdatePayload built = builder.build();

        assertThat(built.maximumTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaintenanceNoteIsNullable() {
        final GitLabInstanceRunnersUpdatePayloadBuilder builder = GitLabInstanceRunnersUpdatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersUpdatePayload())
                .maintenanceNote(null);

        final GitLabInstanceRunnersUpdatePayload built = builder.build();

        assertThat(built.maintenanceNote()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceRunnersUpdatePayload value = RunnersCatalogFixtures.instanceRunnersUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.paused()).isEqualTo(true);
            softly.assertThat(value.tagList()).isEqualTo(List.of("tag_list"));
            softly.assertThat(value.runUntagged()).isEqualTo(true);
            softly.assertThat(value.locked()).isEqualTo(true);
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabInstanceRunnersUpdateAccessLevel.NOT_PROTECTED);
            softly.assertThat(value.maximumTimeout()).isEqualTo(1);
            softly.assertThat(value.maintenanceNote()).isEqualTo("maintenance_note");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceRunnersUpdatePayload original = RunnersCatalogFixtures.instanceRunnersUpdatePayload();

        final GitLabInstanceRunnersUpdatePayload rebuilt =
                GitLabInstanceRunnersUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagListSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("tag_list"));
        final GitLabInstanceRunnersUpdatePayload built = GitLabInstanceRunnersUpdatePayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersUpdatePayload())
                .tagList(source)
                .build();
        source.clear();

        assertThat(built.tagList()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTagListIsRead() {
        final GitLabInstanceRunnersUpdatePayload built = RunnersCatalogFixtures.instanceRunnersUpdatePayload();
        final List<String> values = built.tagList();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceRunnersUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "description",
                        "active",
                        "paused",
                        "tagList",
                        "runUntagged",
                        "locked",
                        "accessLevel",
                        "maximumTimeout",
                        "maintenanceNote");
    }
}
