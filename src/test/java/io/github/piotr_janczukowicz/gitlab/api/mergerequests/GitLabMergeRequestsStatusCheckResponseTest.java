package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestsStatusCheckResponseTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestsStatusCheckResponseBuilder builder =
                GitLabMergeRequestsStatusCheckResponseBuilder.builder(
                                MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponse())
                        .id(null);

        final GitLabMergeRequestsStatusCheckResponse built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestIsNullable() {
        final GitLabMergeRequestsStatusCheckResponseBuilder builder =
                GitLabMergeRequestsStatusCheckResponseBuilder.builder(
                                MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponse())
                        .mergeRequest(null);

        final GitLabMergeRequestsStatusCheckResponse built = builder.build();

        assertThat(built.mergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalStatusCheckIsNullable() {
        final GitLabMergeRequestsStatusCheckResponseBuilder builder =
                GitLabMergeRequestsStatusCheckResponseBuilder.builder(
                                MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponse())
                        .externalStatusCheck(null);

        final GitLabMergeRequestsStatusCheckResponse built = builder.build();

        assertThat(built.externalStatusCheck()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestsStatusCheckResponse value =
                MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponse();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.mergeRequest()).isEqualTo(CommonCatalogFixtures.mergeRequest());
            softly.assertThat(value.externalStatusCheck())
                    .isEqualTo(MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponseExternalStatusCheck());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestsStatusCheckResponse original =
                MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponse();

        final GitLabMergeRequestsStatusCheckResponse rebuilt =
                GitLabMergeRequestsStatusCheckResponseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestsStatusCheckResponse.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "mergeRequest", "externalStatusCheck");
    }
}
