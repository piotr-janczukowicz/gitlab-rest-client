package io.github.piotr_janczukowicz.gitlab.api.projectaliases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectAliasesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabProjectAliasesCreatePayloadBuilder builder = GitLabProjectAliasesCreatePayloadBuilder.builder(
                        ProjectaliasesCatalogFixtures.projectAliasesCreatePayload())
                .projectId(null);

        final GitLabProjectAliasesCreatePayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectAliasesCreatePayloadBuilder builder = GitLabProjectAliasesCreatePayloadBuilder.builder(
                        ProjectaliasesCatalogFixtures.projectAliasesCreatePayload())
                .name(null);

        final GitLabProjectAliasesCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectAliasesCreatePayload value = ProjectaliasesCatalogFixtures.projectAliasesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectId()).isEqualTo("gitlab-org/gitlab");
            softly.assertThat(value.name()).isEqualTo("gitlab");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectAliasesCreatePayload original = ProjectaliasesCatalogFixtures.projectAliasesCreatePayload();

        final GitLabProjectAliasesCreatePayload rebuilt =
                GitLabProjectAliasesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectAliasesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectId", "name");
    }
}
