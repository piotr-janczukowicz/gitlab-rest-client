package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateRequestsApprovalsPayload())
                        .approvalsRequired(null);

        final GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayload built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayload value =
                MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateRequestsApprovalsPayload();

        assertThat(value.approvalsRequired()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayload original =
                MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateRequestsApprovalsPayload();

        final GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayload rebuilt =
                GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMergeRequestApprovalsCreateRequestsApprovalsPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("approvalsRequired");
    }
}
