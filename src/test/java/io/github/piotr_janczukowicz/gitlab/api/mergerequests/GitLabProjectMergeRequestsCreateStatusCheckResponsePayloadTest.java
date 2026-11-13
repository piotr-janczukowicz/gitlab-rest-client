package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsCreateStatusCheckResponsePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExternalStatusCheckIdIsNullable() {
        final GitLabProjectMergeRequestsCreateStatusCheckResponsePayloadBuilder builder =
                GitLabProjectMergeRequestsCreateStatusCheckResponsePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload())
                        .externalStatusCheckId(null);

        final GitLabProjectMergeRequestsCreateStatusCheckResponsePayload built = builder.build();

        assertThat(built.externalStatusCheckId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabProjectMergeRequestsCreateStatusCheckResponsePayloadBuilder builder =
                GitLabProjectMergeRequestsCreateStatusCheckResponsePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload())
                        .sha(null);

        final GitLabProjectMergeRequestsCreateStatusCheckResponsePayload built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenStatusIsNull() {
        final GitLabProjectMergeRequestsCreateStatusCheckResponsePayloadBuilder builder =
                GitLabProjectMergeRequestsCreateStatusCheckResponsePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload())
                        .status(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("status");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsCreateStatusCheckResponsePayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.externalStatusCheckId()).isEqualTo(1L);
            softly.assertThat(value.sha()).isEqualTo("5957a570eee0ac4580ec027fb874ad7514d1e576");
            softly.assertThat(value.status())
                    .isEqualTo(GitLabProjectMergeRequestsCreateStatusCheckResponseStatus.PASSED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsCreateStatusCheckResponsePayload original =
                MergerequestsCatalogFixtures.projectMergeRequestsCreateStatusCheckResponsePayload();

        final GitLabProjectMergeRequestsCreateStatusCheckResponsePayload rebuilt =
                GitLabProjectMergeRequestsCreateStatusCheckResponsePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMergeRequestsCreateStatusCheckResponsePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("externalStatusCheckId", "sha", "status");
    }
}
