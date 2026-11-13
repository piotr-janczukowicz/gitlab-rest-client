package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsCreateBlockPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBlockingMergeRequestIdIsNullable() {
        final GitLabProjectMergeRequestsCreateBlockPayloadBuilder builder =
                GitLabProjectMergeRequestsCreateBlockPayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreateBlockPayload())
                        .blockingMergeRequestId(null);

        final GitLabProjectMergeRequestsCreateBlockPayload built = builder.build();

        assertThat(built.blockingMergeRequestId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockingMergeRequestIidIsNullable() {
        final GitLabProjectMergeRequestsCreateBlockPayloadBuilder builder =
                GitLabProjectMergeRequestsCreateBlockPayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreateBlockPayload())
                        .blockingMergeRequestIid(null);

        final GitLabProjectMergeRequestsCreateBlockPayload built = builder.build();

        assertThat(built.blockingMergeRequestIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockingProjectIdIsNullable() {
        final GitLabProjectMergeRequestsCreateBlockPayloadBuilder builder =
                GitLabProjectMergeRequestsCreateBlockPayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreateBlockPayload())
                        .blockingProjectId(null);

        final GitLabProjectMergeRequestsCreateBlockPayload built = builder.build();

        assertThat(built.blockingProjectId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsCreateBlockPayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsCreateBlockPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.blockingMergeRequestId()).isEqualTo(1L);
            softly.assertThat(value.blockingMergeRequestIid()).isEqualTo(1L);
            softly.assertThat(value.blockingProjectId()).isEqualTo("text");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsCreateBlockPayload original =
                MergerequestsCatalogFixtures.projectMergeRequestsCreateBlockPayload();

        final GitLabProjectMergeRequestsCreateBlockPayload rebuilt =
                GitLabProjectMergeRequestsCreateBlockPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsCreateBlockPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("blockingMergeRequestId", "blockingMergeRequestIid", "blockingProjectId");
    }
}
