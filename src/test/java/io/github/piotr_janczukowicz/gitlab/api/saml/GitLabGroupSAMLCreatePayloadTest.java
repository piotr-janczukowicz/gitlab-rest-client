package io.github.piotr_janczukowicz.gitlab.api.saml;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupSAMLCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSamlGroupNameIsNullable() {
        final GitLabGroupSAMLCreatePayloadBuilder builder = GitLabGroupSAMLCreatePayloadBuilder.builder(
                        SamlCatalogFixtures.groupSAMLCreatePayload())
                .samlGroupName(null);

        final GitLabGroupSAMLCreatePayload built = builder.build();

        assertThat(built.samlGroupName()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenAccessLevelIsNull() {
        final GitLabGroupSAMLCreatePayloadBuilder builder = GitLabGroupSAMLCreatePayloadBuilder.builder(
                        SamlCatalogFixtures.groupSAMLCreatePayload())
                .accessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("accessLevel");
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabGroupSAMLCreatePayloadBuilder builder = GitLabGroupSAMLCreatePayloadBuilder.builder(
                        SamlCatalogFixtures.groupSAMLCreatePayload())
                .memberRoleId(null);

        final GitLabGroupSAMLCreatePayload built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderIsNullable() {
        final GitLabGroupSAMLCreatePayloadBuilder builder = GitLabGroupSAMLCreatePayloadBuilder.builder(
                        SamlCatalogFixtures.groupSAMLCreatePayload())
                .provider(null);

        final GitLabGroupSAMLCreatePayload built = builder.build();

        assertThat(built.provider()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupSAMLCreatePayload value = SamlCatalogFixtures.groupSAMLCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.samlGroupName()).isEqualTo("saml_group_name");
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabGroupSAMLCreateAccessLevel.MINIMAL_ACCESS);
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
            softly.assertThat(value.provider()).isEqualTo("provider");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupSAMLCreatePayload original = SamlCatalogFixtures.groupSAMLCreatePayload();

        final GitLabGroupSAMLCreatePayload rebuilt =
                GitLabGroupSAMLCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupSAMLCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("samlGroupName", "accessLevel", "memberRoleId", "provider");
    }
}
