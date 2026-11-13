package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabLdapGroupLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenCnIsNullable() {
        final GitLabLdapGroupLinkBuilder builder = GitLabLdapGroupLinkBuilder.builder(
                        CommonCatalogFixtures.ldapGroupLink())
                .cn(null);

        final GitLabLdapGroupLink built = builder.build();

        assertThat(built.cn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupAccessIsNullable() {
        final GitLabLdapGroupLinkBuilder builder = GitLabLdapGroupLinkBuilder.builder(
                        CommonCatalogFixtures.ldapGroupLink())
                .groupAccess(null);

        final GitLabLdapGroupLink built = builder.build();

        assertThat(built.groupAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderIsNullable() {
        final GitLabLdapGroupLinkBuilder builder = GitLabLdapGroupLinkBuilder.builder(
                        CommonCatalogFixtures.ldapGroupLink())
                .provider(null);

        final GitLabLdapGroupLink built = builder.build();

        assertThat(built.provider()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilterIsNullable() {
        final GitLabLdapGroupLinkBuilder builder = GitLabLdapGroupLinkBuilder.builder(
                        CommonCatalogFixtures.ldapGroupLink())
                .filter(null);

        final GitLabLdapGroupLink built = builder.build();

        assertThat(built.filter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabLdapGroupLinkBuilder builder = GitLabLdapGroupLinkBuilder.builder(
                        CommonCatalogFixtures.ldapGroupLink())
                .memberRoleId(null);

        final GitLabLdapGroupLink built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabLdapGroupLink value = CommonCatalogFixtures.ldapGroupLink();

        assertSoftly(softly -> {
            softly.assertThat(value.cn()).isEqualTo("ldap-group-1");
            softly.assertThat(value.groupAccess()).isEqualTo(1);
            softly.assertThat(value.provider()).isEqualTo("ldapmain");
            softly.assertThat(value.filter()).isEqualTo("id >= 500");
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabLdapGroupLink original = CommonCatalogFixtures.ldapGroupLink();

        final GitLabLdapGroupLink rebuilt =
                GitLabLdapGroupLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabLdapGroupLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("cn", "groupAccess", "provider", "filter", "memberRoleId");
    }
}
