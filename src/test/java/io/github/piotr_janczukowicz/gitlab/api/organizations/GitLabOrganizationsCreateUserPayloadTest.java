package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrganizationsCreateUserPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabOrganizationsCreateUserPayloadBuilder builder = GitLabOrganizationsCreateUserPayloadBuilder.builder(
                        OrganizationsCatalogFixtures.organizationsCreateUserPayload())
                .username(null);

        final GitLabOrganizationsCreateUserPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabOrganizationsCreateUserPayloadBuilder builder = GitLabOrganizationsCreateUserPayloadBuilder.builder(
                        OrganizationsCatalogFixtures.organizationsCreateUserPayload())
                .accessLevel(null);

        final GitLabOrganizationsCreateUserPayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrganizationsCreateUserPayload value =
                OrganizationsCatalogFixtures.organizationsCreateUserPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabOrganizationsCreateUserAccessLevel.DEFAULT);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrganizationsCreateUserPayload original =
                OrganizationsCatalogFixtures.organizationsCreateUserPayload();

        final GitLabOrganizationsCreateUserPayload rebuilt =
                GitLabOrganizationsCreateUserPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrganizationsCreateUserPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("username", "accessLevel");
    }
}
