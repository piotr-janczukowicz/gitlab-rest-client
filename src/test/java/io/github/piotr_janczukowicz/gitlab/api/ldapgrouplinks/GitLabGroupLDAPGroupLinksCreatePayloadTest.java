package io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupLDAPGroupLinksCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCnIsNullable() {
        final GitLabGroupLDAPGroupLinksCreatePayloadBuilder builder =
                GitLabGroupLDAPGroupLinksCreatePayloadBuilder.builder(
                                LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload())
                        .cn(null);

        final GitLabGroupLDAPGroupLinksCreatePayload built = builder.build();

        assertThat(built.cn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilterIsNullable() {
        final GitLabGroupLDAPGroupLinksCreatePayloadBuilder builder =
                GitLabGroupLDAPGroupLinksCreatePayloadBuilder.builder(
                                LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload())
                        .filter(null);

        final GitLabGroupLDAPGroupLinksCreatePayload built = builder.build();

        assertThat(built.filter()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenGroupAccessIsNull() {
        final GitLabGroupLDAPGroupLinksCreatePayloadBuilder builder =
                GitLabGroupLDAPGroupLinksCreatePayloadBuilder.builder(
                                LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload())
                        .groupAccess(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("groupAccess");
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderIsNullable() {
        final GitLabGroupLDAPGroupLinksCreatePayloadBuilder builder =
                GitLabGroupLDAPGroupLinksCreatePayloadBuilder.builder(
                                LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload())
                        .provider(null);

        final GitLabGroupLDAPGroupLinksCreatePayload built = builder.build();

        assertThat(built.provider()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabGroupLDAPGroupLinksCreatePayloadBuilder builder =
                GitLabGroupLDAPGroupLinksCreatePayloadBuilder.builder(
                                LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload())
                        .memberRoleId(null);

        final GitLabGroupLDAPGroupLinksCreatePayload built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupLDAPGroupLinksCreatePayload value =
                LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.cn()).isEqualTo("cn");
            softly.assertThat(value.filter()).isEqualTo("filter");
            softly.assertThat(value.groupAccess()).isEqualTo(GitLabGroupLDAPGroupLinksCreateGroupAccess.N_5);
            softly.assertThat(value.provider()).isEqualTo("provider");
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupLDAPGroupLinksCreatePayload original =
                LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload();

        final GitLabGroupLDAPGroupLinksCreatePayload rebuilt =
                GitLabGroupLDAPGroupLinksCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupLDAPGroupLinksCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("cn", "filter", "groupAccess", "provider", "memberRoleId");
    }
}
