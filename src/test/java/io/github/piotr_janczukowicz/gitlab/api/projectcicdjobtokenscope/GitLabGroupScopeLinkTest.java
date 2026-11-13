package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupScopeLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenSourceProjectIdIsNullable() {
        final GitLabGroupScopeLinkBuilder builder = GitLabGroupScopeLinkBuilder.builder(
                        ProjectcicdjobtokenscopeCatalogFixtures.groupScopeLink())
                .sourceProjectId(null);

        final GitLabGroupScopeLink built = builder.build();

        assertThat(built.sourceProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetGroupIdIsNullable() {
        final GitLabGroupScopeLinkBuilder builder = GitLabGroupScopeLinkBuilder.builder(
                        ProjectcicdjobtokenscopeCatalogFixtures.groupScopeLink())
                .targetGroupId(null);

        final GitLabGroupScopeLink built = builder.build();

        assertThat(built.targetGroupId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupScopeLink value = ProjectcicdjobtokenscopeCatalogFixtures.groupScopeLink();

        assertSoftly(softly -> {
            softly.assertThat(value.sourceProjectId()).isEqualTo(1L);
            softly.assertThat(value.targetGroupId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupScopeLink original = ProjectcicdjobtokenscopeCatalogFixtures.groupScopeLink();

        final GitLabGroupScopeLink rebuilt =
                GitLabGroupScopeLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupScopeLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sourceProjectId", "targetGroupId");
    }
}
