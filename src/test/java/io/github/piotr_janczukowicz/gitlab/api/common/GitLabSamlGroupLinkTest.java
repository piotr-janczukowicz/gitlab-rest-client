package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSamlGroupLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabSamlGroupLinkBuilder builder = GitLabSamlGroupLinkBuilder.builder(
                        CommonCatalogFixtures.samlGroupLink())
                .name(null);

        final GitLabSamlGroupLink built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabSamlGroupLinkBuilder builder = GitLabSamlGroupLinkBuilder.builder(
                        CommonCatalogFixtures.samlGroupLink())
                .accessLevel(null);

        final GitLabSamlGroupLink built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabSamlGroupLinkBuilder builder = GitLabSamlGroupLinkBuilder.builder(
                        CommonCatalogFixtures.samlGroupLink())
                .memberRoleId(null);

        final GitLabSamlGroupLink built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderIsNullable() {
        final GitLabSamlGroupLinkBuilder builder = GitLabSamlGroupLinkBuilder.builder(
                        CommonCatalogFixtures.samlGroupLink())
                .provider(null);

        final GitLabSamlGroupLink built = builder.build();

        assertThat(built.provider()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSamlGroupLink value = CommonCatalogFixtures.samlGroupLink();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("saml-group-1");
            softly.assertThat(value.accessLevel()).isEqualTo(1);
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
            softly.assertThat(value.provider()).isEqualTo("saml");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSamlGroupLink original = CommonCatalogFixtures.samlGroupLink();

        final GitLabSamlGroupLink rebuilt =
                GitLabSamlGroupLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSamlGroupLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "accessLevel", "memberRoleId", "provider");
    }
}
