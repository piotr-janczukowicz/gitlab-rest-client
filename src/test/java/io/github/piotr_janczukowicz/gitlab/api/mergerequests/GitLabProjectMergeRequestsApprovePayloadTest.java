package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsApprovePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabProjectMergeRequestsApprovePayloadBuilder builder =
                GitLabProjectMergeRequestsApprovePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsApprovePayload())
                        .sha(null);

        final GitLabProjectMergeRequestsApprovePayload built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublishReviewIsNullable() {
        final GitLabProjectMergeRequestsApprovePayloadBuilder builder =
                GitLabProjectMergeRequestsApprovePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsApprovePayload())
                        .publishReview(null);

        final GitLabProjectMergeRequestsApprovePayload built = builder.build();

        assertThat(built.publishReview()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalPasswordIsNullable() {
        final GitLabProjectMergeRequestsApprovePayloadBuilder builder =
                GitLabProjectMergeRequestsApprovePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsApprovePayload())
                        .approvalPassword(null);

        final GitLabProjectMergeRequestsApprovePayload built = builder.build();

        assertThat(built.approvalPassword()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsApprovePayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsApprovePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sha()).isEqualTo("sha");
            softly.assertThat(value.publishReview()).isEqualTo(true);
            softly.assertThat(value.approvalPassword()).isEqualTo("secret");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsApprovePayload original =
                MergerequestsCatalogFixtures.projectMergeRequestsApprovePayload();

        final GitLabProjectMergeRequestsApprovePayload rebuilt =
                GitLabProjectMergeRequestsApprovePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenApprovalPasswordIsACredential() {
        final GitLabProjectMergeRequestsApprovePayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsApprovePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsApprovePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sha", "publishReview", "approvalPassword");
    }
}
