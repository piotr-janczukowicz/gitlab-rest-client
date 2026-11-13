package io.github.piotr_janczukowicz.gitlab.api.rollouts;

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
class GitLabRolloutsCreateDataTest {

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .position(null);

        final GitLabRolloutsCreateData built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStageNameIsNullable() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .stageName(null);

        final GitLabRolloutsCreateData built = builder.build();

        assertThat(built.stageName()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenStageNameIsTooLong() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .stageName("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenStageNameHasTheMaximumLength() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .stageName("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .environment(null);

        final GitLabRolloutsCreateData built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenEnvironmentIsTooLong() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .environment("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenEnvironmentHasTheMaximumLength() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .environment("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStepTypeIsNullable() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .stepType(null);

        final GitLabRolloutsCreateData built = builder.build();

        assertThat(built.stepType()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenStepTypeIsTooLong() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .stepType("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenStepTypeHasTheMaximumLength() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .stepType("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceIsNullable() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .service(null);

        final GitLabRolloutsCreateData built = builder.build();

        assertThat(built.service()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenServiceIsTooLong() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .service("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenServiceHasTheMaximumLength() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .service("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorIsNullable() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .error(null);

        final GitLabRolloutsCreateData built = builder.build();

        assertThat(built.error()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenErrorIsTooLong() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .error("x".repeat(2001));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenErrorHasTheMaximumLength() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .error("x".repeat(2000));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReasonIsNullable() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .reason(null);

        final GitLabRolloutsCreateData built = builder.build();

        assertThat(built.reason()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenReasonIsTooLong() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .reason("x".repeat(2001));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenReasonHasTheMaximumLength() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .reason("x".repeat(2000));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplyIsNullable() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .reply(null);

        final GitLabRolloutsCreateData built = builder.build();

        assertThat(built.reply()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenReplyIsTooLong() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .reply("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenReplyHasTheMaximumLength() {
        final GitLabRolloutsCreateDataBuilder builder = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .reply("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRolloutsCreateData value = RolloutsCatalogFixtures.rolloutsCreateData();

        assertSoftly(softly -> {
            softly.assertThat(value.position()).isEqualTo(List.of(1));
            softly.assertThat(value.stageName()).isEqualTo("stage_name");
            softly.assertThat(value.environment()).isEqualTo("environment");
            softly.assertThat(value.stepType()).isEqualTo("step_type");
            softly.assertThat(value.service()).isEqualTo("service");
            softly.assertThat(value.error()).isEqualTo("error");
            softly.assertThat(value.reason()).isEqualTo("reason");
            softly.assertThat(value.reply()).isEqualTo("reply");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRolloutsCreateData original = RolloutsCatalogFixtures.rolloutsCreateData();

        final GitLabRolloutsCreateData rebuilt =
                GitLabRolloutsCreateDataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenPositionSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabRolloutsCreateData built = GitLabRolloutsCreateDataBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateData())
                .position(source)
                .build();
        source.clear();

        assertThat(built.position()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenPositionIsRead() {
        final GitLabRolloutsCreateData built = RolloutsCatalogFixtures.rolloutsCreateData();
        final List<Integer> values = built.position();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRolloutsCreateData.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "position", "stageName", "environment", "stepType", "service", "error", "reason", "reply");
    }
}
