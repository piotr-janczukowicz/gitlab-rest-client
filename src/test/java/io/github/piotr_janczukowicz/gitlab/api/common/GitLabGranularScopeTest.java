package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGranularScopeTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessIsNullable() {
        final GitLabGranularScopeBuilder builder = GitLabGranularScopeBuilder.builder(
                        CommonCatalogFixtures.granularScope())
                .access(null);

        final GitLabGranularScope built = builder.build();

        assertThat(built.access()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPermissionsIsNullable() {
        final GitLabGranularScopeBuilder builder = GitLabGranularScopeBuilder.builder(
                        CommonCatalogFixtures.granularScope())
                .permissions(null);

        final GitLabGranularScope built = builder.build();

        assertThat(built.permissions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabGranularScopeBuilder builder = GitLabGranularScopeBuilder.builder(
                        CommonCatalogFixtures.granularScope())
                .projectId(null);

        final GitLabGranularScope built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabGranularScopeBuilder builder = GitLabGranularScopeBuilder.builder(
                        CommonCatalogFixtures.granularScope())
                .groupId(null);

        final GitLabGranularScope built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGranularScope value = CommonCatalogFixtures.granularScope();

        assertSoftly(softly -> {
            softly.assertThat(value.access()).isEqualTo("personal_projects");
            softly.assertThat(value.permissions()).isEqualTo(List.of("read_job"));
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGranularScope original = CommonCatalogFixtures.granularScope();

        final GitLabGranularScope rebuilt =
                GitLabGranularScopeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGranularScope.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("access", "permissions", "projectId", "groupId");
    }
}
