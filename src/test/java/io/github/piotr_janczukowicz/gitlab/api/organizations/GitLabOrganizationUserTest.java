package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrganizationUserTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabOrganizationUserBuilder builder = GitLabOrganizationUserBuilder.builder(
                        OrganizationsCatalogFixtures.organizationUser())
                .id(null);

        final GitLabOrganizationUser built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabOrganizationUserBuilder builder = GitLabOrganizationUserBuilder.builder(
                        OrganizationsCatalogFixtures.organizationUser())
                .username(null);

        final GitLabOrganizationUser built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBotIsNullable() {
        final GitLabOrganizationUserBuilder builder = GitLabOrganizationUserBuilder.builder(
                        OrganizationsCatalogFixtures.organizationUser())
                .bot(null);

        final GitLabOrganizationUser built = builder.build();

        assertThat(built.bot()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabOrganizationUserBuilder builder = GitLabOrganizationUserBuilder.builder(
                        OrganizationsCatalogFixtures.organizationUser())
                .accessLevel(null);

        final GitLabOrganizationUser built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrganizationUser value = OrganizationsCatalogFixtures.organizationUser();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.username()).isEqualTo("jane_doe");
            softly.assertThat(value.bot()).isEqualTo(true);
            softly.assertThat(value.accessLevel()).isEqualTo("owner");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrganizationUser original = OrganizationsCatalogFixtures.organizationUser();

        final GitLabOrganizationUser rebuilt =
                GitLabOrganizationUserBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrganizationUser.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "username", "bot", "accessLevel");
    }
}
