package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestDependencyTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestDependencyBuilder builder = GitLabMergeRequestDependencyBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDependency())
                .id(null);

        final GitLabMergeRequestDependency built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockingMergeRequestIsNullable() {
        final GitLabMergeRequestDependencyBuilder builder = GitLabMergeRequestDependencyBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDependency())
                .blockingMergeRequest(null);

        final GitLabMergeRequestDependency built = builder.build();

        assertThat(built.blockingMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockedMergeRequestIsNullable() {
        final GitLabMergeRequestDependencyBuilder builder = GitLabMergeRequestDependencyBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDependency())
                .blockedMergeRequest(null);

        final GitLabMergeRequestDependency built = builder.build();

        assertThat(built.blockedMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabMergeRequestDependencyBuilder builder = GitLabMergeRequestDependencyBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDependency())
                .projectId(null);

        final GitLabMergeRequestDependency built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestDependency value = MergerequestsCatalogFixtures.mergeRequestDependency();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.blockingMergeRequest()).isEqualTo(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(value.blockedMergeRequest()).isEqualTo(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(value.projectId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestDependency original = MergerequestsCatalogFixtures.mergeRequestDependency();

        final GitLabMergeRequestDependency rebuilt =
                GitLabMergeRequestDependencyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestDependency.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "blockingMergeRequest", "blockedMergeRequest", "projectId");
    }
}
