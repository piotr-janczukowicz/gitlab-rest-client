package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsRebasePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSkipCiIsNullable() {
        final GitLabProjectMergeRequestsRebasePayloadBuilder builder =
                GitLabProjectMergeRequestsRebasePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsRebasePayload())
                        .skipCi(null);

        final GitLabProjectMergeRequestsRebasePayload built = builder.build();

        assertThat(built.skipCi()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsRebasePayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsRebasePayload();

        assertThat(value.skipCi()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsRebasePayload original =
                MergerequestsCatalogFixtures.projectMergeRequestsRebasePayload();

        final GitLabProjectMergeRequestsRebasePayload rebuilt =
                GitLabProjectMergeRequestsRebasePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsRebasePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("skipCi");
    }
}
