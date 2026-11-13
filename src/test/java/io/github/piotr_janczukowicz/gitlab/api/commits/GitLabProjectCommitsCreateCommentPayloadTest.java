package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsCreateCommentPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNoteIsNullable() {
        final GitLabProjectCommitsCreateCommentPayloadBuilder builder =
                GitLabProjectCommitsCreateCommentPayloadBuilder.builder(
                                CommitsCatalogFixtures.projectCommitsCreateCommentPayload())
                        .note(null);

        final GitLabProjectCommitsCreateCommentPayload built = builder.build();

        assertThat(built.note()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectCommitsCreateCommentPayloadBuilder builder =
                GitLabProjectCommitsCreateCommentPayloadBuilder.builder(
                                CommitsCatalogFixtures.projectCommitsCreateCommentPayload())
                        .path(null);

        final GitLabProjectCommitsCreateCommentPayload built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLineIsNullable() {
        final GitLabProjectCommitsCreateCommentPayloadBuilder builder =
                GitLabProjectCommitsCreateCommentPayloadBuilder.builder(
                                CommitsCatalogFixtures.projectCommitsCreateCommentPayload())
                        .line(null);

        final GitLabProjectCommitsCreateCommentPayload built = builder.build();

        assertThat(built.line()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenLineTypeIsNull() {
        final GitLabProjectCommitsCreateCommentPayloadBuilder builder =
                GitLabProjectCommitsCreateCommentPayloadBuilder.builder(
                                CommitsCatalogFixtures.projectCommitsCreateCommentPayload())
                        .lineType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("lineType");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsCreateCommentPayload value =
                CommitsCatalogFixtures.projectCommitsCreateCommentPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.note()).isEqualTo("Nice code!");
            softly.assertThat(value.path()).isEqualTo("doc/update/5.4-to-6.0.md");
            softly.assertThat(value.line()).isEqualTo(1);
            softly.assertThat(value.lineType()).isEqualTo(GitLabProjectCommitsCreateCommentLineType.NEW);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsCreateCommentPayload original =
                CommitsCatalogFixtures.projectCommitsCreateCommentPayload();

        final GitLabProjectCommitsCreateCommentPayload rebuilt =
                GitLabProjectCommitsCreateCommentPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsCreateCommentPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("note", "path", "line", "lineType");
    }
}
