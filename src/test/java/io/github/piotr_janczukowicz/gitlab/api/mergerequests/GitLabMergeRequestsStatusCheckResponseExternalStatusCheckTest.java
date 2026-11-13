package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestsStatusCheckResponseExternalStatusCheckTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestsStatusCheckResponseExternalStatusCheckBuilder builder =
                GitLabMergeRequestsStatusCheckResponseExternalStatusCheckBuilder.builder(
                                MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponseExternalStatusCheck())
                        .id(null);

        final GitLabMergeRequestsStatusCheckResponseExternalStatusCheck built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabMergeRequestsStatusCheckResponseExternalStatusCheckBuilder builder =
                GitLabMergeRequestsStatusCheckResponseExternalStatusCheckBuilder.builder(
                                MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponseExternalStatusCheck())
                        .name(null);

        final GitLabMergeRequestsStatusCheckResponseExternalStatusCheck built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalUrlIsNullable() {
        final GitLabMergeRequestsStatusCheckResponseExternalStatusCheckBuilder builder =
                GitLabMergeRequestsStatusCheckResponseExternalStatusCheckBuilder.builder(
                                MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponseExternalStatusCheck())
                        .externalUrl(null);

        final GitLabMergeRequestsStatusCheckResponseExternalStatusCheck built = builder.build();

        assertThat(built.externalUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestsStatusCheckResponseExternalStatusCheck value =
                MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponseExternalStatusCheck();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("QA");
            softly.assertThat(value.externalUrl()).isEqualTo("https://www.example.com");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestsStatusCheckResponseExternalStatusCheck original =
                MergerequestsCatalogFixtures.mergeRequestsStatusCheckResponseExternalStatusCheck();

        final GitLabMergeRequestsStatusCheckResponseExternalStatusCheck rebuilt =
                GitLabMergeRequestsStatusCheckResponseExternalStatusCheckBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabMergeRequestsStatusCheckResponseExternalStatusCheck.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "externalUrl");
    }
}
