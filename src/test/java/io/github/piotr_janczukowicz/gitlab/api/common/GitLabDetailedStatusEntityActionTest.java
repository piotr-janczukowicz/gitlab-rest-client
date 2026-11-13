package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDetailedStatusEntityActionTest {

    @Test
    void constructor_shouldAcceptNull_whenIconIsNullable() {
        final GitLabDetailedStatusEntityActionBuilder builder = GitLabDetailedStatusEntityActionBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntityAction())
                .icon(null);

        final GitLabDetailedStatusEntityAction built = builder.build();

        assertThat(built.icon()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabDetailedStatusEntityActionBuilder builder = GitLabDetailedStatusEntityActionBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntityAction())
                .title(null);

        final GitLabDetailedStatusEntityAction built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabDetailedStatusEntityActionBuilder builder = GitLabDetailedStatusEntityActionBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntityAction())
                .path(null);

        final GitLabDetailedStatusEntityAction built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMethodIsNullable() {
        final GitLabDetailedStatusEntityActionBuilder builder = GitLabDetailedStatusEntityActionBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntityAction())
                .method(null);

        final GitLabDetailedStatusEntityAction built = builder.build();

        assertThat(built.method()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenButtonTitleIsNullable() {
        final GitLabDetailedStatusEntityActionBuilder builder = GitLabDetailedStatusEntityActionBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntityAction())
                .buttonTitle(null);

        final GitLabDetailedStatusEntityAction built = builder.build();

        assertThat(built.buttonTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfirmationMessageIsNullable() {
        final GitLabDetailedStatusEntityActionBuilder builder = GitLabDetailedStatusEntityActionBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntityAction())
                .confirmationMessage(null);

        final GitLabDetailedStatusEntityAction built = builder.build();

        assertThat(built.confirmationMessage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDetailedStatusEntityAction value = CommonCatalogFixtures.detailedStatusEntityAction();

        assertSoftly(softly -> {
            softly.assertThat(value.icon()).isEqualTo("cancel");
            softly.assertThat(value.title()).isEqualTo("Cancel");
            softly.assertThat(value.path()).isEqualTo("/namespace1/project1/-/jobs/2/cancel");
            softly.assertThat(value.method()).isEqualTo("post");
            softly.assertThat(value.buttonTitle()).isEqualTo("Cancel this job");
            softly.assertThat(value.confirmationMessage()).isEqualTo("Are you sure?");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDetailedStatusEntityAction original = CommonCatalogFixtures.detailedStatusEntityAction();

        final GitLabDetailedStatusEntityAction rebuilt =
                GitLabDetailedStatusEntityActionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDetailedStatusEntityAction.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("icon", "title", "path", "method", "buttonTitle", "confirmationMessage");
    }
}
