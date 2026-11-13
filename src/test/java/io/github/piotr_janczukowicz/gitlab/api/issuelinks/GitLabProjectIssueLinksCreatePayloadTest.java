package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssueLinksCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTargetProjectIdIsNullable() {
        final GitLabProjectIssueLinksCreatePayloadBuilder builder = GitLabProjectIssueLinksCreatePayloadBuilder.builder(
                        IssuelinksCatalogFixtures.projectIssueLinksCreatePayload())
                .targetProjectId(null);

        final GitLabProjectIssueLinksCreatePayload built = builder.build();

        assertThat(built.targetProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetIssueIidIsNullable() {
        final GitLabProjectIssueLinksCreatePayloadBuilder builder = GitLabProjectIssueLinksCreatePayloadBuilder.builder(
                        IssuelinksCatalogFixtures.projectIssueLinksCreatePayload())
                .targetIssueIid(null);

        final GitLabProjectIssueLinksCreatePayload built = builder.build();

        assertThat(built.targetIssueIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabProjectIssueLinksCreatePayloadBuilder builder = GitLabProjectIssueLinksCreatePayloadBuilder.builder(
                        IssuelinksCatalogFixtures.projectIssueLinksCreatePayload())
                .linkType(null);

        final GitLabProjectIssueLinksCreatePayload built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssueLinksCreatePayload value = IssuelinksCatalogFixtures.projectIssueLinksCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.targetProjectId()).isEqualTo("text");
            softly.assertThat(value.targetIssueIid()).isEqualTo("text");
            softly.assertThat(value.linkType()).isEqualTo(GitLabProjectIssueLinksCreateLinkType.RELATES_TO);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssueLinksCreatePayload original =
                IssuelinksCatalogFixtures.projectIssueLinksCreatePayload();

        final GitLabProjectIssueLinksCreatePayload rebuilt =
                GitLabProjectIssueLinksCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssueLinksCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("targetProjectId", "targetIssueIid", "linkType");
    }
}
