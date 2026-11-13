package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrganizationTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabOrganizationBuilder builder = GitLabOrganizationBuilder.builder(
                        OrganizationsCatalogFixtures.organization())
                .id(null);

        final GitLabOrganization built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUuidIsNullable() {
        final GitLabOrganizationBuilder builder = GitLabOrganizationBuilder.builder(
                        OrganizationsCatalogFixtures.organization())
                .uuid(null);

        final GitLabOrganization built = builder.build();

        assertThat(built.uuid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabOrganizationBuilder builder = GitLabOrganizationBuilder.builder(
                        OrganizationsCatalogFixtures.organization())
                .name(null);

        final GitLabOrganization built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabOrganizationBuilder builder = GitLabOrganizationBuilder.builder(
                        OrganizationsCatalogFixtures.organization())
                .path(null);

        final GitLabOrganization built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabOrganizationBuilder builder = GitLabOrganizationBuilder.builder(
                        OrganizationsCatalogFixtures.organization())
                .description(null);

        final GitLabOrganization built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabOrganizationBuilder builder = GitLabOrganizationBuilder.builder(
                        OrganizationsCatalogFixtures.organization())
                .visibility(null);

        final GitLabOrganization built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabOrganizationBuilder builder = GitLabOrganizationBuilder.builder(
                        OrganizationsCatalogFixtures.organization())
                .createdAt(null);

        final GitLabOrganization built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabOrganizationBuilder builder = GitLabOrganizationBuilder.builder(
                        OrganizationsCatalogFixtures.organization())
                .updatedAt(null);

        final GitLabOrganization built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabOrganizationBuilder builder = GitLabOrganizationBuilder.builder(
                        OrganizationsCatalogFixtures.organization())
                .webUrl(null);

        final GitLabOrganization built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabOrganizationBuilder builder = GitLabOrganizationBuilder.builder(
                        OrganizationsCatalogFixtures.organization())
                .avatarUrl(null);

        final GitLabOrganization built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrganization value = OrganizationsCatalogFixtures.organization();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.uuid()).isEqualTo("0192f8c2-1a2b-7cde-89ab-0123456789ab");
            softly.assertThat(value.name()).isEqualTo("GitLab");
            softly.assertThat(value.path()).isEqualTo("gitlab");
            softly.assertThat(value.description()).isEqualTo("My description");
            softly.assertThat(value.visibility()).isEqualTo("public");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.webUrl()).isEqualTo("https://example.com/o/gitlab/-/overview");
            softly.assertThat(value.avatarUrl())
                    .isEqualTo(
                            "https://example.com/uploads/-/system/organizations/organization_detail/avatar/1/avatar.png");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrganization original = OrganizationsCatalogFixtures.organization();

        final GitLabOrganization rebuilt =
                GitLabOrganizationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrganization.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "uuid",
                        "name",
                        "path",
                        "description",
                        "visibility",
                        "createdAt",
                        "updatedAt",
                        "webUrl",
                        "avatarUrl");
    }
}
