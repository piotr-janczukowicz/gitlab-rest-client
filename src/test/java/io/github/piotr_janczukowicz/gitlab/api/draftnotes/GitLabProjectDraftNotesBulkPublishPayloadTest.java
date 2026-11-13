package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesBulkPublishPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenReviewerStateIsNullable() {
        final GitLabProjectDraftNotesBulkPublishPayloadBuilder builder =
                GitLabProjectDraftNotesBulkPublishPayloadBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesBulkPublishPayload())
                        .reviewerState(null);

        final GitLabProjectDraftNotesBulkPublishPayload built = builder.build();

        assertThat(built.reviewerState()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteIsNullable() {
        final GitLabProjectDraftNotesBulkPublishPayloadBuilder builder =
                GitLabProjectDraftNotesBulkPublishPayloadBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesBulkPublishPayload())
                        .note(null);

        final GitLabProjectDraftNotesBulkPublishPayload built = builder.build();

        assertThat(built.note()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalIsNullable() {
        final GitLabProjectDraftNotesBulkPublishPayloadBuilder builder =
                GitLabProjectDraftNotesBulkPublishPayloadBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesBulkPublishPayload())
                        .internal(null);

        final GitLabProjectDraftNotesBulkPublishPayload built = builder.build();

        assertThat(built.internal()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesBulkPublishPayload value =
                DraftnotesCatalogFixtures.projectDraftNotesBulkPublishPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.reviewerState())
                    .isEqualTo(GitLabProjectDraftNotesBulkPublishReviewerState.REQUESTED_CHANGES);
            softly.assertThat(value.note()).isEqualTo("note");
            softly.assertThat(value.internal()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesBulkPublishPayload original =
                DraftnotesCatalogFixtures.projectDraftNotesBulkPublishPayload();

        final GitLabProjectDraftNotesBulkPublishPayload rebuilt =
                GitLabProjectDraftNotesBulkPublishPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDraftNotesBulkPublishPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("reviewerState", "note", "internal");
    }
}
