package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectScopeLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenSourceProjectIdIsNullable() {
        final GitLabProjectScopeLinkBuilder builder = GitLabProjectScopeLinkBuilder.builder(
                        ProjectcicdjobtokenscopeCatalogFixtures.projectScopeLink())
                .sourceProjectId(null);

        final GitLabProjectScopeLink built = builder.build();

        assertThat(built.sourceProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetProjectIdIsNullable() {
        final GitLabProjectScopeLinkBuilder builder = GitLabProjectScopeLinkBuilder.builder(
                        ProjectcicdjobtokenscopeCatalogFixtures.projectScopeLink())
                .targetProjectId(null);

        final GitLabProjectScopeLink built = builder.build();

        assertThat(built.targetProjectId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectScopeLink value = ProjectcicdjobtokenscopeCatalogFixtures.projectScopeLink();

        assertSoftly(softly -> {
            softly.assertThat(value.sourceProjectId()).isEqualTo(1L);
            softly.assertThat(value.targetProjectId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectScopeLink original = ProjectcicdjobtokenscopeCatalogFixtures.projectScopeLink();

        final GitLabProjectScopeLink rebuilt =
                GitLabProjectScopeLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectScopeLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sourceProjectId", "targetProjectId");
    }
}
