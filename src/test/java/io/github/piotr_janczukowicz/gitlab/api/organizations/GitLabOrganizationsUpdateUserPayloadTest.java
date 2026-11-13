package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrganizationsUpdateUserPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessLevelIsNull() {
        final GitLabOrganizationsUpdateUserPayloadBuilder builder = GitLabOrganizationsUpdateUserPayloadBuilder.builder(
                        OrganizationsCatalogFixtures.organizationsUpdateUserPayload())
                .accessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("accessLevel");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrganizationsUpdateUserPayload value =
                OrganizationsCatalogFixtures.organizationsUpdateUserPayload();

        assertThat(value.accessLevel()).isEqualTo(GitLabOrganizationsUpdateUserAccessLevel.DEFAULT);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrganizationsUpdateUserPayload original =
                OrganizationsCatalogFixtures.organizationsUpdateUserPayload();

        final GitLabOrganizationsUpdateUserPayload rebuilt =
                GitLabOrganizationsUpdateUserPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrganizationsUpdateUserPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel");
    }
}
