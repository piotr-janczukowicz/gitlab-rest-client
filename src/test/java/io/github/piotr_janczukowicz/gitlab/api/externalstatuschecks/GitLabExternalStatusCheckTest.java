package io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabExternalStatusCheckTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabExternalStatusCheckBuilder builder = GitLabExternalStatusCheckBuilder.builder(
                        ExternalstatuschecksCatalogFixtures.externalStatusCheck())
                .id(null);

        final GitLabExternalStatusCheck built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabExternalStatusCheckBuilder builder = GitLabExternalStatusCheckBuilder.builder(
                        ExternalstatuschecksCatalogFixtures.externalStatusCheck())
                .name(null);

        final GitLabExternalStatusCheck built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabExternalStatusCheckBuilder builder = GitLabExternalStatusCheckBuilder.builder(
                        ExternalstatuschecksCatalogFixtures.externalStatusCheck())
                .projectId(null);

        final GitLabExternalStatusCheck built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalUrlIsNullable() {
        final GitLabExternalStatusCheckBuilder builder = GitLabExternalStatusCheckBuilder.builder(
                        ExternalstatuschecksCatalogFixtures.externalStatusCheck())
                .externalUrl(null);

        final GitLabExternalStatusCheck built = builder.build();

        assertThat(built.externalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchesIsNullable() {
        final GitLabExternalStatusCheckBuilder builder = GitLabExternalStatusCheckBuilder.builder(
                        ExternalstatuschecksCatalogFixtures.externalStatusCheck())
                .protectedBranches(null);

        final GitLabExternalStatusCheck built = builder.build();

        assertThat(built.protectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHmacIsNullable() {
        final GitLabExternalStatusCheckBuilder builder = GitLabExternalStatusCheckBuilder.builder(
                        ExternalstatuschecksCatalogFixtures.externalStatusCheck())
                .hmac(null);

        final GitLabExternalStatusCheck built = builder.build();

        assertThat(built.hmac()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabExternalStatusCheck value = ExternalstatuschecksCatalogFixtures.externalStatusCheck();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("QA");
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.externalUrl()).isEqualTo("https://www.example.com");
            softly.assertThat(value.protectedBranches()).isEqualTo(List.of(CommonCatalogFixtures.protectedBranch()));
            softly.assertThat(value.hmac()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabExternalStatusCheck original = ExternalstatuschecksCatalogFixtures.externalStatusCheck();

        final GitLabExternalStatusCheck rebuilt =
                GitLabExternalStatusCheckBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabExternalStatusCheck.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "projectId", "externalUrl", "protectedBranches", "hmac");
    }
}
